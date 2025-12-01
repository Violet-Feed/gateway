package violet.gateway.common.service;

import com.alibaba.fastjson.JSONObject;

public interface AigcService {
    JSONObject createMaterial(JSONObject req) throws Exception;

    JSONObject deleteMaterial(JSONObject req) throws Exception;

    JSONObject videoMaterialCallback(JSONObject req);

    JSONObject getMaterialByUser(JSONObject req) throws Exception;

    JSONObject createCreation(JSONObject req) throws Exception;

    JSONObject deleteCreation(JSONObject req) throws Exception;

    JSONObject getCreationById(JSONObject req) throws Exception;

    JSONObject getCreationsByUser(JSONObject req) throws Exception;

    JSONObject getCreationsByDigg(JSONObject req) throws Exception;

    JSONObject getCreationsByFriend(JSONObject req) throws Exception;

    JSONObject getCreationsByRec(JSONObject req) throws Exception;

    JSONObject getCreationsBySearch(JSONObject req) throws Exception;
}
