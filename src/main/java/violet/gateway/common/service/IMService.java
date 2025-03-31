package violet.gateway.common.service;

import com.alibaba.fastjson.JSONObject;

public interface IMService {
    JSONObject sendMessage(JSONObject req) throws Exception;

    JSONObject getMessageByInit(JSONObject req) throws Exception;

    JSONObject getMessageByConversation(JSONObject req) throws Exception;

    JSONObject markRead(JSONObject req) throws Exception;
}
