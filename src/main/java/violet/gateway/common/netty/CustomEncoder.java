package violet.gateway.common.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

// 自定义编码器类，继承自 MessageToByteEncoder<String>，表示将 String 类型的消息编码
public class CustomEncoder extends MessageToByteEncoder<Packet> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Packet packet, ByteBuf out) throws Exception {
        ByteBuf data = Unpooled.wrappedBuffer(packet.getData());
        // 创建一个长度为 5 的 ByteBuf 用于存储消息类型和数据长度
        ByteBuf head = Unpooled.buffer(5);
        // 写入消息类型
        head.writeByte(packet.getPacketType());
        // 写入数据部分的长度
        head.writeInt(data.readableBytes());
        // 将头部和数据部分组合成一个新的 ByteBuf
        ByteBuf combinedBuffer = Unpooled.wrappedBuffer(head, data);
        // 将组合后的 ByteBuf 写入输出 ByteBuf
        out.writeBytes(combinedBuffer);
        // 释放资源
        combinedBuffer.release();
    }
}