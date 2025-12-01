package violet.gateway.common.service;

import com.alibaba.fastjson.JSONObject;

public interface ActionService {
    JSONObject digg(JSONObject req) throws Exception;

    JSONObject cancelDigg(JSONObject req) throws Exception;
}
