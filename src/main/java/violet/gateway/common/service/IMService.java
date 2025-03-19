package violet.gateway.common.service;

import com.alibaba.fastjson.JSONObject;
import violet.gateway.common.proto_gen.http.GetMessageByConversationRequest;
import violet.gateway.common.proto_gen.http.GetMessageByInitRequest;
import violet.gateway.common.proto_gen.http.MarkReadRequest;
import violet.gateway.common.proto_gen.http.SendMessageRequest;

public interface IMService {
    JSONObject sendMessage(SendMessageRequest req);
    JSONObject getMessageByInit(GetMessageByInitRequest req);
    JSONObject getMessageByConversation(GetMessageByConversationRequest req);
    JSONObject markRead(MarkReadRequest req);
}
