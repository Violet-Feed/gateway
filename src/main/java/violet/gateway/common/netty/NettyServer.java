package violet.gateway.common.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Component
public class NettyServer {

    // 服务器监听的端口号
    private static final int PORT = 3001;
    // 用于接受客户端连接请求的EventLoopGroup
    private EventLoopGroup bossGroup;
    // 用于处理已经建立的连接的I/O操作的EventLoopGroup
    private EventLoopGroup workerGroup;

    @Autowired
    private NettyServerHandler nettyServerHandler;

    // 在Bean初始化后自动调用，用于启动Netty服务器
    @PostConstruct
    public void start() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            bossGroup = new NioEventLoopGroup(1);
            workerGroup = new NioEventLoopGroup();

            try {
                // 创建ServerBootstrap实例来启动和配置服务器
                ServerBootstrap b = new ServerBootstrap();
                // 设置bossGroup和workerGroup
                b.group(bossGroup, workerGroup)
                        // 指定使用NioServerSocketChannel作为服务器通道类型
                        .channel(NioServerSocketChannel.class)
                        // 设置子处理器，用于处理每个新连接
                        .childHandler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            public void initChannel(SocketChannel ch) throws Exception {
                                // 添加字符串解码器
                                ch.pipeline().addLast(new StringDecoder());
                                // 添加字符串编码器
                                ch.pipeline().addLast(new StringEncoder());
                                // 添加自定义的处理器NettyServerHandler
                                ch.pipeline().addLast(nettyServerHandler);
                            }
                        })
                        // 设置通道选项，SO_BACKLOG用于设置积压连接队列的大小
                        .option(ChannelOption.SO_BACKLOG, 128)
                        // 设置子通道选项，SO_KEEPALIVE用于保持连接活跃
                        .childOption(ChannelOption.SO_KEEPALIVE, true);

                // 绑定服务器到指定端口，并同步等待绑定完成
                ChannelFuture f = b.bind(PORT).sync();
                log.info("Netty server started on port " + PORT);
                // 等待服务器通道关闭
                f.channel().closeFuture().sync();
            } catch (InterruptedException e) {
                log.error("Netty server startup failed", e);
            } finally {
                // 优雅地关闭workerGroup
                workerGroup.shutdownGracefully();
                // 优雅地关闭bossGroup
                bossGroup.shutdownGracefully();
            }
        });
    }

    // 在Bean销毁前调用，用于优雅地关闭服务器资源
    @PreDestroy
    public void stop() {
        if (bossGroup != null) {
            bossGroup.shutdownGracefully();
        }
        if (workerGroup != null) {
            workerGroup.shutdownGracefully();
        }
    }
}