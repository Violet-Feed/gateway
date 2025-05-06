package violet.gateway.common.service;

import com.alibaba.fastjson.JSONObject;

public interface MarketService {
    JSONObject createItem(JSONObject req) throws Exception;

    JSONObject getItemProfile(JSONObject req) throws Exception;

    JSONObject getItemsByUser(JSONObject req) throws Exception;

    JSONObject getItemsBySearch(JSONObject req) throws Exception;
}
