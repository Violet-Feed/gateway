package violet.gateway.common.service;

import com.alibaba.fastjson.JSONObject;

public interface UserService {
    JSONObject login(JSONObject req) throws Exception;

    JSONObject register(JSONObject req) throws Exception;

    JSONObject getUserProfile(JSONObject req) throws Exception;

    JSONObject searchUsers(JSONObject req) throws Exception;
}
