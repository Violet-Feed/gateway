package violet.gateway.common.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import violet.gateway.common.proto_gen.http.GetMessageByConversationRequest;
import violet.gateway.common.proto_gen.http.GetMessageByInitRequest;
import violet.gateway.common.proto_gen.http.MarkReadRequest;
import violet.gateway.common.proto_gen.http.SendMessageRequest;
import violet.gateway.common.service.IMService;
import violet.gateway.common.utils.CustomAuthenticationToken;

@Service
public class IMServiceImpl implements IMService {
    @Override
    public JSONObject sendMessage(SendMessageRequest req) {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        return null;
    }

    @Override
    public JSONObject getMessageByInit(GetMessageByInitRequest req) {
        return null;
    }

    @Override
    public JSONObject getMessageByConversation(GetMessageByConversationRequest req) {
        return null;
    }

    @Override
    public JSONObject markRead(MarkReadRequest req) {
        return null;
    }
}
