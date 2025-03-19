package violet.gateway.common.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import violet.gateway.common.proto_gen.http.GetMessageByConversationRequest;
import violet.gateway.common.proto_gen.http.GetMessageByInitRequest;
import violet.gateway.common.proto_gen.http.MarkReadRequest;
import violet.gateway.common.proto_gen.http.SendMessageRequest;
import violet.gateway.common.service.IMService;

@RestController
@RequestMapping("/api/im")
public class IMController {
    @Autowired
    private IMService imService;

    @PostMapping("/send_message")
    public JSONObject sendMessage(@RequestBody SendMessageRequest req) {
        return imService.sendMessage(req);
    }

    @PostMapping("/get_message_by_init")
    public JSONObject getMessageByInit(@RequestBody GetMessageByInitRequest req) {
        return imService.getMessageByInit(req);
    }

    @PostMapping("/get_message_by_conversation")
    public JSONObject getMessageByConversation(@RequestBody GetMessageByConversationRequest req) {
        return imService.getMessageByConversation(req);
    }

    @PostMapping("/mark_read")
    public JSONObject markRead(@RequestBody MarkReadRequest req) {
        return imService.markRead(req);
    }
}
