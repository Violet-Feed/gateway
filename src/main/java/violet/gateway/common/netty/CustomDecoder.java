package violet.gateway.common.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class CustomDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        // 检查是否有足够的数据来读取消息类型和长度字段
        if (in.readableBytes() < 5) {
            return;
        }
        // 标记当前读取位置
        in.markReaderIndex();

        // 读取消息类型
        byte packetType = in.readByte();

        // 读取长度字段
        int length = in.readInt();

        // 检查是否有足够的数据来读取数据体
        if (in.readableBytes() < length) {
            // 数据不足，重置读取位置
            in.resetReaderIndex();
            return;
        }

        // 读取数据体
        byte[] data = new byte[length];
        in.readBytes(data);

        // 将解析后的数据封装成自定义对象
        Packet message = new Packet(packetType, length, data);
        out.add(message);
    }
}