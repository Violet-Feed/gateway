package violet.gateway.common.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class NettyServerHandler extends SimpleChannelInboundHandler<String> {

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
        String channelId = ctx.channel().id().asShortText();
        channelContextMap.remove(channelId);
        super.channelInactive(ctx);
    }

    // 当接收到客户端发送的消息时调用
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        log.info("Received from client: " + msg);
        // 构造要发送给客户端的响应数据
        String response = "Server response\n";
        // 将响应数据写入通道并立即发送
        ctx.writeAndFlush(response);
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
}