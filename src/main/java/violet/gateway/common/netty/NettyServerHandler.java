package violet.gateway.common.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import violet.gateway.common.proto_gen.common.BaseResp;
import violet.gateway.common.proto_gen.common.StatusCode;
import violet.gateway.common.proto_gen.push.PushRequest;
import violet.gateway.common.proto_gen.push.PushResponse;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
@ChannelHandler.Sharable
public class NettyServerHandler extends SimpleChannelInboundHandler<String> {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    // 使用ConcurrentHashMap来存储通道标识和对应的ChannelHandlerContext
    private static ConcurrentHashMap<String, ChannelHandlerContext> channelContextMap = new ConcurrentHashMap<>();

    // 当有新的客户端连接建立时，将其ChannelHandlerContext存储起来
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String channelId = ctx.channel().id().asShortText();
        log.info("Client connected: " + channelId);
        channelContextMap.put(channelId, ctx);
        super.channelActive(ctx);
    }

    // 当客户端连接断开时，从map中移除对应的ChannelHandlerContext
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("Client disconnected");
        String channelId = ctx.channel().id().asShortText();
        channelContextMap.remove(channelId);
        super.channelInactive(ctx);
    }

    // 当接收到客户端发送的消息时调用
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        log.info("Received from client: " + msg);

        ByteBuf data = Unpooled.copiedBuffer("pong", StandardCharsets.UTF_8);
        ByteBuf head = Unpooled.buffer(8).writeLong(data.readableBytes());
        ByteBuf combinedBuffer = Unpooled.wrappedBuffer(head, data);
        ctx.writeAndFlush(combinedBuffer);
    }

    // 捕获处理过程中发生的异常
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        // 关闭通道以避免资源泄漏
        ctx.close();
    }

    // 后端主动发送消息的方法，根据通道标识发送消息
    public static void sendMessageToClient(String channelId, String message) {
        ChannelHandlerContext ctx = channelContextMap.get(channelId);
        if (ctx != null && ctx.channel().isActive()) {
            message += '\n';
            log.info("Send message to client: " + message);
            ctx.writeAndFlush(message);
        }
    }

    public PushResponse push(PushRequest req) {
        PushResponse.Builder resp = PushResponse.newBuilder();
        Long userId = req.getReceiverId();
        String key=String.format("conn:%s",userId);
        Map<Object,Object> conns=redisTemplate.opsForHash().entries(key);
        for (Map.Entry<Object, Object> entry : conns.entrySet()) {
            String channelId = (String) entry.getKey();
            ChannelHandlerContext ctx = channelContextMap.get(channelId);
            if (ctx != null && ctx.channel().isActive()) {
                ByteBuf data = Unpooled.copiedBuffer(req.toString(), StandardCharsets.UTF_8);
                ByteBuf head = Unpooled.buffer(8).writeLong(data.readableBytes());
                ByteBuf combinedBuffer = Unpooled.wrappedBuffer(head, data);
                ctx.writeAndFlush(combinedBuffer);
            }
        }
        BaseResp baseResp = BaseResp.newBuilder().setStatusCode(StatusCode.Success).build();
        return resp.setBaseResp(baseResp).build();
    }
}