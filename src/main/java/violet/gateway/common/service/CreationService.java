package violet.gateway.common.service;

import com.alibaba.fastjson.JSONObject;

public interface CreationService {
    JSONObject createMaterial(JSONObject req) throws Exception;

    JSONObject videoMaterialCallback(JSONObject req);

    JSONObject createCreation(JSONObject req) throws Exception;
}
