package violet.gateway.common.service;

import com.alibaba.fastjson.JSONObject;

public interface IMService {
    JSONObject sendMessage(JSONObject req) throws Exception;

    JSONObject getMessageByUser(JSONObject req) throws Exception;

    JSONObject getCommandByUser(JSONObject req) throws Exception;

    JSONObject getMessageByConversation(JSONObject req) throws Exception;

    JSONObject markRead(JSONObject req) throws Exception;

    JSONObject getMembersReadIndex(JSONObject req) throws Exception;

    JSONObject createConversation(JSONObject req) throws Exception;

    JSONObject getConversationInfo(JSONObject req) throws Exception;
}
