package violet.gateway.common.service.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import violet.gateway.common.proto_gen.common.StatusCode;
import violet.gateway.common.proto_gen.creation.*;
import violet.gateway.common.service.CreationService;
import violet.gateway.common.utils.CustomAuthenticationToken;
import violet.gateway.common.utils.RpcException;

@Slf4j
@Service
public class CreationServiceImpl implements CreationService {
    @GrpcClient("creation")
    private CreationServiceGrpc.CreationServiceBlockingStub creationStub;

    @Override
    public JSONObject createMaterial(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Integer materialType = req.getInteger("material_type");
        String prompt = req.getString("prompt");
        String sourceUrl = req.getString("source_url");
        CreateMaterialRequest createMaterialRequest = CreateMaterialRequest.newBuilder().setMaterialType(materialType).setUserId(userId).setPrompt(prompt).setSourceUrl(sourceUrl).build();
        CreateMaterialResponse createMaterialResponse = creationStub.createMaterial(createMaterialRequest);
        if (createMaterialResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[createMaterial] CreateMaterial rpc err, err = {}", createMaterialResponse.getBaseResp());
            throw new RpcException(createMaterialResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        data.put("material_id", createMaterialResponse.getMaterialId());
        return data;
    }

    @Override
    public JSONObject videoMaterialCallback(JSONObject req) {
        JSONObject resp = new JSONObject();
        Object challenge = req.get("challenge");
        if (challenge != null) {
            resp.put("challenge", challenge);
            return resp;
        }
        String taskId = req.getString("task_id");
        String status = req.getString("status");
        String fileId = req.getString("file_id");
        JSONObject baseResp = req.getJSONObject("base_resp");
        if (baseResp != null) {
            int statusCode = baseResp.getIntValue("status_code");
            String statusMsg = baseResp.getString("status_msg");
            VideoMaterialCallbackRequest videoMaterialCallbackRequest = VideoMaterialCallbackRequest.newBuilder().setTaskId(taskId).setStatus(status).setFileId(fileId).setStatusCode(statusCode).setStatusMsg(statusMsg).build();
            VideoMaterialCallbackResponse videoMaterialCallbackResponse = creationStub.videoMaterialCallback(videoMaterialCallbackRequest);
            if (videoMaterialCallbackResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
                log.error("[videoMaterialCallback] VideoMaterialCallback rpc err, err = {}", videoMaterialCallbackResponse.getBaseResp());
                resp.put("status", "fail");
                return resp;
            }
        }
        resp.put("status", "success");
        return resp;
    }

    @Override
    public JSONObject createCreation(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Long materialId = req.getLong("material_id");
        Integer materialType = req.getInteger("material_type");
        String materialUrl = req.getString("material_url");
        String title = req.getString("title");
        String content = req.getString("content");
        String category = req.getString("category");
        CreateCreationRequest createCreationRequest = CreateCreationRequest.newBuilder().setMaterialId(materialId).setMaterialType(materialType).setMaterialUrl(materialUrl).setUserId(userId).setTitle(title).setContent(content).setCategory(category).build();
        CreateCreationResponse createCreationResponse = creationStub.createCreation(createCreationRequest);
        if (createCreationResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[createCreation] CreateCreation rpc err, err = {}", createCreationResponse.getBaseResp());
            throw new RpcException(createCreationResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        return data;
    }
}
