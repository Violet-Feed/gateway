package violet.gateway.common.netty;

import org.springframework.stereotype.Service;

@Service
public class NettyService {

    public void sendMessageToClient(String channelId, String message) {
        NettyServerHandler.sendMessageToClient(channelId, message);
    }
}