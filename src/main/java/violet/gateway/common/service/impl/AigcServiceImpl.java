package violet.gateway.common.service.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import violet.gateway.common.pojo.CreationHomeVO;
import violet.gateway.common.proto_gen.action.*;
import violet.gateway.common.proto_gen.aigc.*;
import violet.gateway.common.proto_gen.common.StatusCode;
import violet.gateway.common.service.AigcService;
import violet.gateway.common.utils.CustomAuthenticationToken;
import violet.gateway.common.utils.RpcException;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AigcServiceImpl implements AigcService {
    @GrpcClient("aigc")
    private AigcServiceGrpc.AigcServiceBlockingStub aigcStub;
    @GrpcClient("action")
    private ActionServiceGrpc.ActionServiceBlockingStub actionStub;

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
        Long userId = req.getLong("user_id");
        Integer page = req.getInteger("page");
        GetCreationsByUserRequest getCreationsByUserRequest = GetCreationsByUserRequest.newBuilder().setUserId(userId).setPage(page).build();
        GetCreationsByUserResponse getCreationsByUserResponse = aigcStub.getCreationsByUser(getCreationsByUserRequest);
        if (getCreationsByUserResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getCreationsByUser] GetCreationsByUser rpc err, err = {}", getCreationsByUserResponse.getBaseResp());
            throw new RpcException(getCreationsByUserResponse.getBaseResp());
        }
        try {
            List<CreationHomeVO> creationHomeVOList = fillHomeInfo(userId, getCreationsByUserResponse.getCreationsList());
            JSONObject data = new JSONObject();
            data.put("creations", creationHomeVOList);
            return data;
        } catch (RpcException e) {
            log.error("[getCreationsByUser] fillHomeInfo rpc err, err = {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public JSONObject getCreationsByDigg(JSONObject req) throws Exception {
        Long userId = req.getLong("user_id");
        ;
        Integer page = req.getInteger("page");
        GetCreationsByDiggRequest getCreationsByDiggRequest = GetCreationsByDiggRequest.newBuilder().setUserId(userId).setPage(page).build();
        GetCreationsByDiggResponse getCreationsByDiggResponse = aigcStub.getCreationsByDigg(getCreationsByDiggRequest);
        if (getCreationsByDiggResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getCreationsByDigg] GetCreationsByDigg rpc err, err = {}", getCreationsByDiggResponse.getBaseResp());
            throw new RpcException(getCreationsByDiggResponse.getBaseResp());
        }
        try {
            List<CreationHomeVO> creationHomeVOList = fillHomeInfo(userId, getCreationsByDiggResponse.getCreationsList());
            JSONObject data = new JSONObject();
            data.put("creations", creationHomeVOList);
            return data;
        } catch (RpcException e) {
            log.error("[getCreationsByDigg] fillHomeInfo rpc err, err = {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public JSONObject getCreationsByFriend(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Integer page = req.getInteger("page");
        GetCreationsByFriendRequest getCreationsByFriendRequest = GetCreationsByFriendRequest.newBuilder().setUserId(userId).setPage(page).build();
        GetCreationsByFriendResponse getCreationsByFriendResponse = aigcStub.getCreationsByFriend(getCreationsByFriendRequest);
        if (getCreationsByFriendResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getCreationsByFriend] GetCreationsByFriend rpc err, err = {}", getCreationsByFriendResponse.getBaseResp());
            throw new RpcException(getCreationsByFriendResponse.getBaseResp());
        }
        try {
            List<CreationHomeVO> creationHomeVOList = fillHomeInfo(userId, getCreationsByFriendResponse.getCreationsList());
            JSONObject data = new JSONObject();
            data.put("creations", creationHomeVOList);
            return data;
        } catch (RpcException e) {
            log.error("[getCreationsByFriend] fillHomeInfo rpc err, err = {}", e.getMessage());
            throw e;
        }
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
        try {
            List<CreationHomeVO> creationHomeVOList = fillHomeInfo(userId, getCreationsByRecResponse.getCreationsList());
            JSONObject data = new JSONObject();
            data.put("creations", creationHomeVOList);
            return data;
        } catch (RpcException e) {
            log.error("[getCreationsByRec] fillHomeInfo rpc err, err = {}", e.getMessage());
            throw e;
        }
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
        try {
            List<CreationHomeVO> creationHomeVOList = fillHomeInfo(userId, getCreationsBySearchResponse.getCreationsList());
            JSONObject data = new JSONObject();
            data.put("creations", creationHomeVOList);
            return data;
        } catch (RpcException e) {
            log.error("[getCreationsBySearch] fillHomeInfo rpc err, err = {}", e.getMessage());
            throw e;
        }
    }

    private List<CreationHomeVO> fillHomeInfo(Long userId, List<Creation> creationList) throws RpcException {
        if (creationList.isEmpty()) {
            return Collections.emptyList();
        }
        List<Long> creationIds = creationList.stream().map(Creation::getCreationId).collect(Collectors.toList());
        List<Long> userIds = creationList.stream().map(Creation::getUserId).distinct().collect(Collectors.toList());
        GetUserInfosRequest getUserInfosRequest = GetUserInfosRequest.newBuilder().addAllUserIds(userIds).build();
        GetUserInfosResponse getUserInfosResponse = actionStub.getUserInfos(getUserInfosRequest);
        if (getUserInfosResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[fillHomeInfo] GetUserInfos rpc err, err = {}", getUserInfosResponse.getBaseResp());
            throw new RpcException(getUserInfosResponse.getBaseResp());
        }
        List<UserInfo> userList = getUserInfosResponse.getUserInfosList();
        Map<Long, UserInfo> userInfoMap = userList.stream().collect(Collectors.toMap(UserInfo::getUserId, userInfo -> userInfo));
        MGetDiggCountByEntityRequest mGetDiggCountByEntityRequest = MGetDiggCountByEntityRequest.newBuilder().setEntityType("creation").addAllEntityIds(creationIds).build();
        MGetDiggCountByEntityResponse mGetDiggCountByEntityResponse = actionStub.mGetDiggCountByEntity(mGetDiggCountByEntityRequest);
        if (mGetDiggCountByEntityResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[fillHomeInfo] MGetDiggCountByEntity rpc err, err = {}", mGetDiggCountByEntityResponse.getBaseResp());
            throw new RpcException(mGetDiggCountByEntityResponse.getBaseResp());
        }
        Map<Long, Long> diggCountMap = mGetDiggCountByEntityResponse.getEntityDiggCountMap();
        MIsDiggRequest mIsDiggRequest = MIsDiggRequest.newBuilder().setUserId(userId).setEntityType("creation").addAllEntityIds(creationIds).build();
        MIsDiggResponse mIsDiggResponse = actionStub.mIsDigg(mIsDiggRequest);
        if (mIsDiggResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[fillHomeInfo] MIsDigg rpc err, err = {}", mIsDiggResponse.getBaseResp());
            throw new RpcException(mIsDiggResponse.getBaseResp());
        }
        Map<Long, Boolean> isDiggMap = mIsDiggResponse.getIsDiggMap();
        return creationList.stream().map(creation -> {
            CreationHomeVO vo = new CreationHomeVO();
            UserInfo userInfo = userInfoMap.get(creation.getUserId());
            Long diggCount = diggCountMap.getOrDefault(creation.getCreationId(), 0L);
            Boolean isDigg = isDiggMap.getOrDefault(creation.getCreationId(), false);
            vo.setCreationId(creation.getCreationId());
            vo.setMaterialType(creation.getMaterialType());
            vo.setCoverUrl(creation.getCoverUrl());
            vo.setTitle(creation.getTitle());
            vo.setCreateTime(creation.getCreateTime());
            vo.setUserId(creation.getUserId());
            vo.setUsername(userInfo.getUsername());
            vo.setAvatar(userInfo.getAvatar());
            vo.setDiggCount(diggCount);
            vo.setIsDigg(isDigg);
            return vo;
        }).collect(Collectors.toList());
    }
}
