package violet.gateway.common.service.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import violet.gateway.common.proto_gen.action.ActionServiceGrpc;
import violet.gateway.common.proto_gen.action.DiggRequest;
import violet.gateway.common.proto_gen.action.DiggResponse;
import violet.gateway.common.service.ActionService;
import violet.gateway.common.utils.CustomAuthenticationToken;

@Slf4j
@Service
public class ActionServiceImpl implements ActionService {
    @GrpcClient("action")
    private ActionServiceGrpc.ActionServiceBlockingStub actionStub;

    @Override
    public JSONObject digg(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        String entityType = req.getString("entity_type");
        Long entityId = req.getLong("entity_id");
        DiggRequest diggRequest = DiggRequest.newBuilder().setUserId(userId).setEntityType(entityType).setEntityId(entityId).build();
        DiggResponse diggResponse = actionStub.digg(diggRequest);
        if (diggResponse.getBaseResp().getStatusCode() != violet.gateway.common.proto_gen.common.StatusCode.Success) {
            log.error("[digg] Digg rpc err, err = {}", diggResponse.getBaseResp());
            throw new Exception("Digg rpc error");
        }
        JSONObject data = new JSONObject();
        return data;
    }

    @Override
    public JSONObject cancelDigg(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        String entityType = req.getString("entity_type");
        Long entityId = req.getLong("entity_id");
        DiggRequest diggRequest = DiggRequest.newBuilder().setUserId(userId).setEntityType(entityType).setEntityId(entityId).build();
        DiggResponse diggResponse = actionStub.cancelDigg(diggRequest);
        if (diggResponse.getBaseResp().getStatusCode() != violet.gateway.common.proto_gen.common.StatusCode.Success) {
            log.error("[cancelDigg] CancelDigg rpc err, err = {}", diggResponse.getBaseResp());
            throw new Exception("CancelDigg rpc error");
        }
        JSONObject data = new JSONObject();
        return data;
    }
}
