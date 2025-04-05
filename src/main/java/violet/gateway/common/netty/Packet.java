package violet.gateway.common.netty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Packet {
    private byte packetType;
    private int length;
    private byte[] data;
}
