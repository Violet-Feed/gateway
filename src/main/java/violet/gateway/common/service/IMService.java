package violet.gateway.common.service;

import com.alibaba.fastjson.JSONObject;

public interface IMService {
    JSONObject sendMessage(JSONObject req) throws Exception;

    JSONObject getMessageByUser(JSONObject req) throws Exception;

    JSONObject getCommandByUser(JSONObject req) throws Exception;

    JSONObject getMessageByConversation(JSONObject req) throws Exception;

    JSONObject markRead(JSONObject req) throws Exception;

    JSONObject recallMessage(JSONObject req) throws Exception;

    JSONObject getMembersReadIndex(JSONObject req) throws Exception;

    JSONObject createConversation(JSONObject req) throws Exception;

    JSONObject getConversationInfo(JSONObject req) throws Exception;

    JSONObject updateConversationInfo(JSONObject req) throws Exception;

    JSONObject addConversationMembers(JSONObject req) throws Exception;

    JSONObject removeConversationMembers(JSONObject req) throws Exception;

    JSONObject getConversationMembers(JSONObject req) throws Exception;

    JSONObject addConversationAgents(JSONObject req) throws Exception;

    JSONObject removeConversationAgents(JSONObject req) throws Exception;

    JSONObject getConversationAgents(JSONObject req) throws Exception;
}
