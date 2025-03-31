package violet.gateway.common.service;

import com.alibaba.fastjson.JSONObject;

public interface RelationService {
    JSONObject follow(JSONObject req) throws Exception;

    JSONObject unfollow(JSONObject req) throws Exception;

    JSONObject getFollowingList(JSONObject req) throws Exception;

    JSONObject getFollowerList(JSONObject req) throws Exception;

    JSONObject getFriendList(JSONObject req) throws Exception;
}