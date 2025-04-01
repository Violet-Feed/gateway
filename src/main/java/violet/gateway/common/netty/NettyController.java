package violet.gateway.common.netty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NettyController {

    @Autowired
    private NettyService nettyService;

    @GetMapping("/api/netty/{channelId}/{message}")
    public String sendMessage(@PathVariable String channelId, @PathVariable String message) {
        nettyService.sendMessageToClient(channelId, message);
        return "Message send successfully";
    }
}