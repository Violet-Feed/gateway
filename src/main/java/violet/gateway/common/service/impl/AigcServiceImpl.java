package violet.gateway.common.service.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import violet.gateway.common.pojo.AgentVO;
import violet.gateway.common.pojo.CommentVO;
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
    public JSONObject updateCreation(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Long creationId = req.getLong("creation_id");
        String title = req.getString("title");
        String content = req.getString("content");
        String category = req.getString("category");
        UpdateCreationRequest updateCreationRequest = UpdateCreationRequest.newBuilder()
                .setCreationId(creationId)
                .setUserId(userId)
                .setTitle(title)
                .setContent(content)
                .setCategory(category)
                .build();
        UpdateCreationResponse updateCreationResponse = aigcStub.updateCreation(updateCreationRequest);
        if (updateCreationResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[updateCreation] UpdateCreation rpc err, err = {}", updateCreationResponse.getBaseResp());
            throw new RpcException(updateCreationResponse.getBaseResp());
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
    public JSONObject getCreationByForward(JSONObject req) throws Exception {
        Long creationId = req.getLong("creation_id");
        GetCreationByIdRequest getCreationByIdRequest = GetCreationByIdRequest.newBuilder()
                .setCreationId(creationId)
                .build();
        GetCreationByIdResponse getCreationByIdResponse = aigcStub.getCreationById(getCreationByIdRequest);
        if (getCreationByIdResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getCreationByForward] GetCreationById rpc err, err = {}", getCreationByIdResponse.getBaseResp());
            throw new RpcException(getCreationByIdResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        data.put("creation", getCreationByIdResponse.getCreation());
        Long userId = getCreationByIdResponse.getCreation().getUserId();
        GetUserInfosRequest getUserInfosRequest = GetUserInfosRequest.newBuilder()
                .addUserIds(userId)
                .build();
        GetUserInfosResponse getUserInfosResponse = actionStub.getUserInfos(getUserInfosRequest);
        if (getUserInfosResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getCreationByForward] GetUserInfos rpc err, err = {}", getUserInfosResponse.getBaseResp());
            throw new RpcException(getUserInfosResponse.getBaseResp());
        }
        data.put("user_info", getUserInfosResponse.getUserInfosList());
        MGetFollowCountRequest.Builder mGetFollowCountRequest = MGetFollowCountRequest.newBuilder()
                .addUserIds(userId)
                .setNeedFollower(true);
        MGetFollowCountResponse mGetFollowCountResponse = actionStub.mGetFollowCount(mGetFollowCountRequest.build());
        if (mGetFollowCountResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getCreationByForward] MGetFollowCount rpc err, err = {}", mGetFollowCountResponse.getBaseResp());
            throw new RpcException(mGetFollowCountResponse.getBaseResp());
        }
        data.put("follower_count", mGetFollowCountResponse.getFollowerCountMap().get(userId));
        MGetDiggCountByEntityRequest mGetDiggCountByEntityRequest = MGetDiggCountByEntityRequest.newBuilder()
                .setEntityType("creation")
                .addEntityIds(creationId)
                .build();
        MGetDiggCountByEntityResponse mGetDiggCountByEntityResponse = actionStub.mGetDiggCountByEntity(mGetDiggCountByEntityRequest);
        if (mGetDiggCountByEntityResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getCreationByForward] MGetDiggCountByEntity rpc err, err = {}", mGetDiggCountByEntityResponse.getBaseResp());
            throw new RpcException(mGetDiggCountByEntityResponse.getBaseResp());
        }
        data.put("digg_count", mGetDiggCountByEntityResponse.getEntityDiggCountMap().get(creationId));
        GetCommentCountRequest getCommentCountRequest = GetCommentCountRequest.newBuilder()
                .setEntityType("creation")
                .setEntityId(creationId)
                .build();
        GetCommentCountResponse getCommentCountResponse = actionStub.getCommentCount(getCommentCountRequest);
        if (getCommentCountResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getCreationByForward] GetCommentCount rpc err, err = {}", getCommentCountResponse.getBaseResp());
            throw new Exception("GetCommentCount rpc error");
        }
        data.put("comment_count", getCommentCountResponse.getCommentCount());
        GetForwardCountRequest getForwardCountRequest = GetForwardCountRequest.newBuilder()
                .setCreationId(creationId)
                .build();
        GetForwardCountResponse getForwardCountResponse = actionStub.getForwardCount(getForwardCountRequest);
        if (getForwardCountResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getCreationByForward] GetForwardCount rpc err, err = {}", getForwardCountResponse.getBaseResp());
            throw new Exception("GetForwardCount rpc error");
        }
        data.put("forward_count", getForwardCountResponse.getForwardCount());
        GetCommentListRequest getCommentListRequest = GetCommentListRequest.newBuilder()
                .setEntityType("creation")
                .setEntityId(creationId)
                .setPage(1)
                .setSortType("digg")
                .build();
        GetCommentListResponse getCommentListResponse = actionStub.getCommentList(getCommentListRequest);
        if (getCommentListResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getCreationByForward] GetCommentList rpc err, err = {}", getCommentListResponse.getBaseResp());
            throw new Exception("GetCommentList rpc error");
        }
        try {
            List<CommentVO> commentVOList = fillForwardCommentInfo(getCommentListResponse.getCommentsList());
            data.put("comments", commentVOList);
        } catch (RpcException e) {
            log.error("[getCreationByForward] fillCommentInfo err, err = {}", e.toString());
            throw new Exception("fillCommentInfo error");
        }
        return data;
    }

    private List<CommentVO> fillForwardCommentInfo(List<CommentData> comments) throws RpcException {
        if (comments.isEmpty()) {
            return Collections.emptyList();
        }
        List<Long> userIds = comments.stream().map(CommentData::getUserId).collect(Collectors.toList());
        List<Long> sibUserIds = comments.stream()
                .map(CommentData::getSibUserId)
                .filter(sibUserId -> sibUserId != 0)
                .collect(Collectors.toList());
        userIds.addAll(sibUserIds);
        GetUserInfosRequest getUserInfosRequest = GetUserInfosRequest.newBuilder()
                .addAllUserIds(userIds.stream().distinct().collect(Collectors.toList()))
                .build();
        GetUserInfosResponse getUserInfosResponse = actionStub.getUserInfos(getUserInfosRequest);
        if (getUserInfosResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[fillForwardCommentInfo] GetUserInfos rpc err, err = {}", getUserInfosResponse.getBaseResp());
            throw new RpcException(getUserInfosResponse.getBaseResp());
        }
        Map<Long, UserInfo> userInfosMap = getUserInfosResponse.getUserInfosList().stream().collect(Collectors.toMap(UserInfo::getUserId, userInfo -> userInfo));
        return comments.stream().map(commentData -> {
            CommentVO commentVO = new CommentVO();
            commentVO.setCommentId(commentData.getCommentId());
            commentVO.setContentType(commentData.getContentType());
            commentVO.setContent(commentData.getContent());
            commentVO.setUserId(commentData.getUserId());
            UserInfo userInfo = userInfosMap.get(commentData.getUserId());
            commentVO.setUsername(userInfo == null ? "未知用户" : userInfo.getUsername());
            commentVO.setAvatar(userInfo == null ? "" : userInfo.getAvatar());
            commentVO.setDiggCount(commentData.getDiggCount());
            commentVO.setReplyCount(commentData.getReplyCount());
            commentVO.setIsDigg(false);
            commentVO.setCreateTime(commentData.getCreateTime());
            commentVO.setSibUserId(commentData.getSibUserId());
            if (commentData.getSibUserId() != 0) {
                UserInfo sibUserInfo = userInfosMap.get(commentData.getSibUserId());
                commentVO.setSibUsername(sibUserInfo == null ? "未知用户" : sibUserInfo.getUsername());
            }
            return commentVO;
        }).collect(Collectors.toList());
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
        GetCreationsByRecRequest getCreationsByRecRequest = GetCreationsByRecRequest.newBuilder().setUserId(userId).build();
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

    @Override
    public JSONObject createAgent(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        String agentName = req.getString("agent_name");
        String avatarUri = req.getString("avatar_uri");
        String description = req.getString("description");
        String personality = req.getString("personality");
        CreateAgentRequest createAgentRequest = CreateAgentRequest.newBuilder().setUserId(userId).setAgentName(agentName).setAvatarUri(avatarUri).setDescription(description).setPersonality(personality).build();
        CreateAgentResponse createAgentResponse = aigcStub.createAgent(createAgentRequest);
        if (createAgentResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[createAgent] CreateAgent rpc err, err = {}", createAgentResponse.getBaseResp());
            throw new RpcException(createAgentResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        data.put("agent_id", createAgentResponse.getAgentId());
        return data;
    }

    @Override
    public JSONObject deleteAgent(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Long agentId = req.getLong("agent_id");
        DeleteAgentRequest deleteAgentRequest = DeleteAgentRequest.newBuilder()
                .setUserId(userId)
                .setAgentId(agentId)
                .build();
        DeleteAgentResponse deleteAgentResponse = aigcStub.deleteAgent(deleteAgentRequest);
        if (deleteAgentResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[deleteAgent] DeleteAgent rpc err, err = {}", deleteAgentResponse.getBaseResp());
            throw new RpcException(deleteAgentResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        return data;
    }

    @Override
    public JSONObject updateAgent(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Long agentId = req.getLong("agent_id");
        String agentName = req.getString("agent_name");
        String avatarUri = req.getString("avatar_uri");
        String description = req.getString("description");
        String personality = req.getString("personality");
        UpdateAgentRequest updateAgentRequest = UpdateAgentRequest.newBuilder()
                .setUserId(userId)
                .setAgentId(agentId)
                .setAgentName(agentName)
                .setAvatarUri(avatarUri)
                .setDescription(description)
                .setPersonality(personality)
                .build();
        UpdateAgentResponse updateAgentResponse = aigcStub.updateAgent(updateAgentRequest);
        if (updateAgentResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[updateAgent] UpdateAgent rpc err, err = {}", updateAgentResponse.getBaseResp());
            throw new RpcException(updateAgentResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        return data;
    }

    @Override
    public JSONObject getAgentsByIds(JSONObject req) throws Exception {
        List<Long> agentIds = req.getJSONArray("agent_ids").toJavaList(Long.class);
        GetAgentsByIdsRequest getAgentsByIdsRequest = GetAgentsByIdsRequest.newBuilder().addAllAgentIds(agentIds).build();
        GetAgentsByIdsResponse getAgentsByIdsResponse = aigcStub.getAgentsByIds(getAgentsByIdsRequest);
        if (getAgentsByIdsResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getAgentsByIds] GetAgentsByIds rpc err, err = {}", getAgentsByIdsResponse.getBaseResp());
            throw new RpcException(getAgentsByIdsResponse.getBaseResp());
        }
        List<Long> userIds = getAgentsByIdsResponse.getAgentInfosList().stream().map(AgentInfo::getOwnerId).distinct().collect(Collectors.toList());
        GetUserInfosRequest getUserInfosRequest = GetUserInfosRequest.newBuilder().addAllUserIds(userIds).build();
        GetUserInfosResponse getUserInfosResponse = actionStub.getUserInfos(getUserInfosRequest);
        if (getUserInfosResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getAgentsByIds] GetUserInfos rpc err, err = {}", getUserInfosResponse.getBaseResp());
            throw new RpcException(getUserInfosResponse.getBaseResp());
        }
        Map<Long, UserInfo> userInfoMap = getUserInfosResponse.getUserInfosList().stream().collect(Collectors.toMap(UserInfo::getUserId, userInfo -> userInfo));
        List<AgentVO> agentVOList = getAgentsByIdsResponse.getAgentInfosList().stream().map(agentInfo -> {
            AgentVO agentVO = new AgentVO();
            agentVO.setAgentId(agentInfo.getAgentId());
            agentVO.setAgentName(agentInfo.getAgentName());
            agentVO.setAvatarUri(agentInfo.getAvatarUri());
            agentVO.setDescription(agentInfo.getDescription());
            agentVO.setPersonality(agentInfo.getPersonality());
            agentVO.setOwnerId(agentInfo.getOwnerId());
            agentVO.setCreateTime(agentInfo.getCreateTime());
            agentVO.setStatus(agentInfo.getStatus());
            agentVO.setExtra(agentInfo.getExtra());
            UserInfo ownerUserInfo = userInfoMap.get(agentInfo.getOwnerId());
            agentVO.setOwnerUsername(ownerUserInfo.getUsername());
            agentVO.setOwnerAvatar(ownerUserInfo.getAvatar());
            return agentVO;
        }).collect(Collectors.toList());
        JSONObject data = new JSONObject();
        data.put("agents", agentVOList);
        return data;
    }

    @Override
    public JSONObject getAgentsByUser(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Integer page = req.getInteger("page");
        GetAgentsByUserRequest getAgentsByUserRequest = GetAgentsByUserRequest.newBuilder().setUserId(userId).setPage(page).build();
        GetAgentsByUserResponse getAgentsByUserResponse = aigcStub.getAgentsByUser(getAgentsByUserRequest);
        if (getAgentsByUserResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getAgentsByUser] GetAgentsByUser rpc err, err = {}", getAgentsByUserResponse.getBaseResp());
            throw new RpcException(getAgentsByUserResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        data.put("agents", getAgentsByUserResponse.getAgentInfosList());
        return data;
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
