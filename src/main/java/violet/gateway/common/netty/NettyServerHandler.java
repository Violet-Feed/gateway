package violet.gateway.common.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import violet.gateway.common.proto_gen.common.BaseResp;
import violet.gateway.common.proto_gen.common.StatusCode;
import violet.gateway.common.proto_gen.push.ConnectPacket;
import violet.gateway.common.proto_gen.push.PacketType;
import violet.gateway.common.proto_gen.push.PushRequest;
import violet.gateway.common.proto_gen.push.PushResponse;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // 设置为原型作用域，以便每个连接都有一个新的实例
public class NettyServerHandler extends SimpleChannelInboundHandler<Packet> {

    // 使用ConcurrentHashMap来存储通道标识和对应的ChannelHandlerContext
    private static final ConcurrentHashMap<String, ChannelHandlerContext> channelContextMap = new ConcurrentHashMap<>();
    private static RedisTemplate<String, String> redisTemplate;
    private Long userId;

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
        NettyServerHandler.redisTemplate = redisTemplate;
    }

    // 当有新的客户端连接建立时，将其ChannelHandlerContext存储起来
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String channelId = ctx.channel().id().asShortText();
        log.info("Client connected. channelId={}", channelId);
        channelContextMap.put(channelId, ctx);
        super.channelActive(ctx);
    }

    // 当客户端连接断开时，从map中移除对应的ChannelHandlerContext
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        String channelId = ctx.channel().id().asShortText();
        log.info("Client disconnected. userId={}, channelId={}", userId, channelId);
        channelContextMap.remove(channelId);
        if (userId != null) {
            String key = String.format("conn:%s", this.userId);
            try {
                redisTemplate.opsForHash().delete(key, channelId);
            } catch (Exception e) {
                log.warn("redis delete connection err. err = {}: ", e.getMessage());
            }
        }
        super.channelInactive(ctx);
    }

    // 当接收到客户端发送的消息时调用
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Packet packet) throws Exception {
        if (packet.getPacketType() == PacketType.Connect_VALUE) {
            ConnectPacket connectPacket = ConnectPacket.parseFrom(packet.getData());
            this.userId = connectPacket.getUserId();
            String key = String.format("conn:%s", this.userId);
            String channelId = ctx.channel().id().asShortText();
            redisTemplate.opsForHash().putIfAbsent(key, channelId, String.valueOf(this.userId));
            log.info("Client authenticated. userId={}, channelId={}", this.userId, channelId);
            ctx.writeAndFlush(new Packet((byte) 1, 0, new byte[0]));
        } else if (packet.getPacketType() == PacketType.Heartbeat_VALUE) {
            ctx.writeAndFlush(new Packet((byte) 2, 0, new byte[0]));
        }
    }

    // 捕获处理过程中发生的异常
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        String channelId = ctx.channel().id().asShortText();
        if (cause instanceof java.io.IOException) {
            String msg = cause.getMessage();
            if (msg != null && (msg.contains("Connection reset") || msg.contains("Connection timed out") || msg.contains("Broken pipe"))) {
                log.info("Client connection closed abnormally. userId={}, channelId={}, reason={}", userId, channelId, msg);
            } else {
                log.warn("Client IO exception. userId={}, channelId={}", userId, channelId, cause);
            }
        } else {
            log.error("Netty handler exception. userId={}, channelId={}", userId, channelId, cause);
        }
        ctx.close();
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            String channelId = ctx.channel().id().asShortText();
            log.info("Client heartbeat timeout. userId={}, channelId={}", userId, channelId);
            ctx.close();
            return;
        }
        super.userEventTriggered(ctx, evt);
    }

    public static PushResponse push(PushRequest req) {
        PushResponse.Builder resp = PushResponse.newBuilder();
        if (redisTemplate == null) {
            BaseResp baseResp = BaseResp.newBuilder().setStatusCode(StatusCode.Success).build();
            return resp.setBaseResp(baseResp).build();
        }
        Packet packet = new Packet();
        packet.setPacketType((byte) req.getPacketType().getNumber());
        if (req.getPacketType() == PacketType.Message) {
            packet.setData(req.getMessagePacket().toByteArray());
        } else if (req.getPacketType() == PacketType.Material) {
            packet.setData(req.getMaterialPacket().toByteArray());
        } else if (req.getPacketType() == PacketType.Notice) {
            packet.setData(req.getNoticePacket().toByteArray());
        }
        Long userId = req.getUserId();
        String key = String.format("conn:%s", userId);
        Map<Object, Object> conns = redisTemplate.opsForHash().entries(key);
        for (Map.Entry<Object, Object> entry : conns.entrySet()) {
            String channelId = (String) entry.getKey();
            ChannelHandlerContext ctx = channelContextMap.get(channelId);
            if (ctx != null && ctx.channel().isActive()) {
                ctx.writeAndFlush(packet);
            } else {
                redisTemplate.opsForHash().delete(key, channelId);
            }
        }
        BaseResp baseResp = BaseResp.newBuilder().setStatusCode(StatusCode.Success).build();
        return resp.setBaseResp(baseResp).build();
    }
}