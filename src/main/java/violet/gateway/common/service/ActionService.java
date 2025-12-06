package violet.gateway.common.service;

import com.alibaba.fastjson.JSONObject;

public interface ActionService {
    JSONObject digg(JSONObject req) throws Exception;

    JSONObject cancelDigg(JSONObject req) throws Exception;

    JSONObject createComment(JSONObject req) throws Exception;

    JSONObject createReply(JSONObject req) throws Exception;

    JSONObject getCommentList(JSONObject req) throws Exception;

    JSONObject getReplyList(JSONObject req) throws Exception;

    JSONObject diggComment(JSONObject req) throws Exception;

    JSONObject cancelDiggComment(JSONObject req) throws Exception;

    JSONObject forward(JSONObject req) throws Exception;
}
