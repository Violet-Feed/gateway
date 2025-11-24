package violet.gateway.common.service.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import violet.gateway.common.proto_gen.common.StatusCode;
import violet.gateway.common.proto_gen.aigc.*;
import violet.gateway.common.service.AigcService;
import violet.gateway.common.utils.CustomAuthenticationToken;
import violet.gateway.common.utils.RpcException;

@Slf4j
@Service
public class AigcServiceImpl implements AigcService {
    @GrpcClient("aigc")
    private AigcServiceGrpc.AigcServiceBlockingStub aigcStub;

    @Override
    public JSONObject createMaterial(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Integer materialType = req.getInteger("material_type");
        String prompt = req.getString("prompt");
        String sourceUrl = req.getString("source_url");
        CreateMaterialRequest createMaterialRequest = CreateMaterialRequest.newBuilder().setMaterialType(materialType).setUserId(userId).setPrompt(prompt).setSourceUrl(sourceUrl).build();
        CreateMaterialResponse createMaterialResponse = aigcStub.createMaterial(createMaterialRequest);
        if (createMaterialResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[createMaterial] CreateMaterial rpc err, err = {}", createMaterialResponse.getBaseResp());
            throw new RpcException(createMaterialResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        data.put("material_id", createMaterialResponse.getMaterialId());
        return data;
    }

    @Override
    public JSONObject deleteMaterial(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Long materialId = req.getLong("material_id");
        DeleteMaterialRequest deleteMaterialRequest = DeleteMaterialRequest.newBuilder().setUserId(userId).setMaterialId(materialId).build();
        DeleteMaterialResponse deleteMaterialResponse = aigcStub.deleteMaterial(deleteMaterialRequest);
        if (deleteMaterialResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[deleteMaterial] DeleteMaterial rpc err, err = {}", deleteMaterialResponse.getBaseResp());
            throw new RpcException(deleteMaterialResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
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
            VideoMaterialCallbackResponse videoMaterialCallbackResponse = aigcStub.videoMaterialCallback(videoMaterialCallbackRequest);
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
    public JSONObject getMaterialByUser(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Integer page = req.getInteger("page");
        GetMaterialByUserRequest getMaterialByUserRequest = GetMaterialByUserRequest.newBuilder().setUserId(userId).setPage(page).build();
        GetMaterialByUserResponse getMaterialByUserResponse = aigcStub.getMaterialByUser(getMaterialByUserRequest);
        if (getMaterialByUserResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getMaterialByUser] GetMaterialByUser rpc err, err = {}", getMaterialByUserResponse.getBaseResp());
            throw new RpcException(getMaterialByUserResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        data.put("material", getMaterialByUserResponse.getMaterialList());
        return data;
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
        CreateCreationResponse createCreationResponse = aigcStub.createCreation(createCreationRequest);
        if (createCreationResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[createCreation] CreateCreation rpc err, err = {}", createCreationResponse.getBaseResp());
            throw new RpcException(createCreationResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        return data;
    }

    @Override
    public JSONObject deleteCreation(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Long creationId = req.getLong("creation_id");
        DeleteCreationRequest deleteCreationRequest = DeleteCreationRequest.newBuilder().setUserId(userId).setCreationId(creationId).build();
        DeleteCreationResponse deleteCreationResponse = aigcStub.deleteCreation(deleteCreationRequest);
        if (deleteCreationResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[deleteCreation] DeleteCreation rpc err, err = {}", deleteCreationResponse.getBaseResp());
            throw new RpcException(deleteCreationResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        return data;
    }

    @Override
    public JSONObject getCreationById(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Long creationId = req.getLong("creation_id");
        GetCreationByIdRequest getCreationByIdRequest = GetCreationByIdRequest.newBuilder().setCreationId(creationId).build();
        GetCreationByIdResponse getCreationByIdResponse = aigcStub.getCreationById(getCreationByIdRequest);
        if (getCreationByIdResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getCreationById] GetCreationById rpc err, err = {}", getCreationByIdResponse.getBaseResp());
            throw new RpcException(getCreationByIdResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        data.put("creation", getCreationByIdResponse.getCreation());
        return data;
    }

    @Override
    public JSONObject getCreationsByUser(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Integer page = req.getInteger("page");
        GetCreationsByUserRequest getCreationsByUserRequest = GetCreationsByUserRequest.newBuilder().setUserId(userId).setPage(page).build();
        GetCreationsByUserResponse getCreationsByUserResponse = aigcStub.getCreationsByUser(getCreationsByUserRequest);
        if (getCreationsByUserResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getCreationsByUser] GetCreationsByUser rpc err, err = {}", getCreationsByUserResponse.getBaseResp());
            throw new RpcException(getCreationsByUserResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        data.put("creations", getCreationsByUserResponse.getCreationsList());
        return data;
    }

    @Override
    public JSONObject getCreationsByRec(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Integer page = req.getInteger("page");
        GetCreationsByRecRequest getCreationsByRecRequest = GetCreationsByRecRequest.newBuilder().setUserId(userId).setPage(page).build();
        GetCreationsByRecResponse getCreationsByRecResponse = aigcStub.getCreationsByRec(getCreationsByRecRequest);
        if (getCreationsByRecResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getCreationsByRec] GetCreationsByRec rpc err, err = {}", getCreationsByRecResponse.getBaseResp());
            throw new RpcException(getCreationsByRecResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        data.put("creations", getCreationsByRecResponse.getCreationsList());
        return data;
    }

    @Override
    public JSONObject getCreationsBySearch(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        String keyword = req.getString("keyword");
        Integer page = req.getInteger("page");
        GetCreationsBySearchRequest getCreationsBySearchRequest = GetCreationsBySearchRequest.newBuilder().setKeyword(keyword).setPage(page).build();
        GetCreationsBySearchResponse getCreationsBySearchResponse = aigcStub.getCreationsBySearch(getCreationsBySearchRequest);
        if (getCreationsBySearchResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getCreationsBySearch] GetCreationsBySearch rpc err, err = {}", getCreationsBySearchResponse.getBaseResp());
            throw new RpcException(getCreationsBySearchResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        data.put("creations", getCreationsBySearchResponse.getCreationsList());
        return data;
    }
}
