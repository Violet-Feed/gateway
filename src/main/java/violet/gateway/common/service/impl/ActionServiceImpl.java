package violet.gateway.common.service.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import violet.gateway.common.pojo.CommentVO;
import violet.gateway.common.proto_gen.action.*;
import violet.gateway.common.proto_gen.common.StatusCode;
import violet.gateway.common.service.ActionService;
import violet.gateway.common.utils.CustomAuthenticationToken;
import violet.gateway.common.utils.RpcException;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        if (diggResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
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
        if (diggResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[cancelDigg] CancelDigg rpc err, err = {}", diggResponse.getBaseResp());
            throw new Exception("CancelDigg rpc error");
        }
        JSONObject data = new JSONObject();
        return data;
    }

    @Override
    public JSONObject createComment(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        String entityType = req.getString("entity_type");
        Long entityId = req.getLong("entity_id");
        Integer contentType = req.getInteger("content_type");
        String content = req.getString("content");
        CreateCommentRequest createCommentRequest = CreateCommentRequest.newBuilder()
                .setUserId(userId)
                .setEntityType(entityType)
                .setEntityId(entityId)
                .setContentType(contentType)
                .setContent(content)
                .build();
        CreateCommentResponse createCommentResponse = actionStub.createComment(createCommentRequest);
        if (createCommentResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[createComment] CreateComment rpc err, err = {}", createCommentResponse.getBaseResp());
            throw new Exception("CreateComment rpc error");
        }
        JSONObject data = new JSONObject();
        data.put("comment_id", createCommentResponse.getCommentId());
        return data;
    }

    @Override
    public JSONObject createReply(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Long parentId = req.getLong("parent_id");
        String entityType = req.getString("entity_type");
        Long entityId = req.getLong("entity_id");
        Long sibId = req.getLong("sib_id");
        Long sibUserId = req.getLong("sib_user_id");
        Integer contentType = req.getInteger("content_type");
        String content = req.getString("content");
        CreateCommentReplyRequest createCommentReplyRequest = CreateCommentReplyRequest.newBuilder()
                .setUserId(userId)
                .setParentId(parentId)
                .setEntityType(entityType)
                .setEntityId(entityId)
                .setSibId(sibId)
                .setSibUserId(sibUserId)
                .setContentType(contentType)
                .setContent(content)
                .build();
        CreateCommentReplyResponse createCommentReplyResponse = actionStub.createCommentReply(createCommentReplyRequest);
        if (createCommentReplyResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[createReply] CreateCommentReply rpc err, err = {}", createCommentReplyResponse.getBaseResp());
            throw new Exception("CreateCommentReply rpc error");
        }
        JSONObject data = new JSONObject();
        data.put("comment_id", createCommentReplyResponse.getCommentId());
        return data;
    }

    @Override
    public JSONObject getCommentList(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        String entityType = req.getString("entity_type");
        Long entityId = req.getLong("entity_id");
        Integer page = req.getInteger("page");
        String sortType = req.getString("sort_type");
        GetCommentListRequest getCommentListRequest = GetCommentListRequest.newBuilder()
                .setEntityType(entityType)
                .setEntityId(entityId)
                .setPage(page)
                .setSortType(sortType)
                .build();
        GetCommentListResponse getCommentListResponse = actionStub.getCommentList(getCommentListRequest);
        if (getCommentListResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getCommentList] GetCommentList rpc err, err = {}", getCommentListResponse.getBaseResp());
            throw new Exception("GetCommentList rpc error");
        }
        try {
            List<CommentVO> commentVOList = fillCommentInfo(userId, getCommentListResponse.getCommentsList());
            JSONObject data = new JSONObject();
            data.put("comments", commentVOList);
            return data;
        } catch (RpcException e) {
            log.error("[getCommentList] fillCommentInfo err, err = {}", e.toString());
            throw new Exception("fillCommentInfo error");
        }
    }

    @Override
    public JSONObject getReplyList(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Long commentId = req.getLong("comment_id");
        Integer page = req.getInteger("page");
        GetCommentReplyListRequest getCommentReplyListRequest = GetCommentReplyListRequest.newBuilder()
                .setCommentId(commentId)
                .setPage(page)
                .build();
        GetCommentReplyListResponse getCommentReplyListResponse = actionStub.getCommentReplyList(getCommentReplyListRequest);
        if (getCommentReplyListResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getReplyList] GetCommentReplyList rpc err, err = {}", getCommentReplyListResponse.getBaseResp());
            throw new Exception("GetCommentReplyList rpc error");
        }
        try {
            List<CommentVO> commentVOList = fillCommentInfo(userId, getCommentReplyListResponse.getCommentsList());
            JSONObject data = new JSONObject();
            data.put("comments", commentVOList);
            return data;
        } catch (RpcException e) {
            log.error("[getReplyList] fillCommentInfo err, err = {}", e.toString());
            throw new Exception("fillCommentInfo error");
        }
    }

    @Override
    public JSONObject getCommentCount(JSONObject req) throws Exception {
        String entityType = req.getString("entity_type");
        Long entityId = req.getLong("entity_id");
        GetCommentCountRequest getCommentCountRequest = GetCommentCountRequest.newBuilder()
                .setEntityType(entityType)
                .setEntityId(entityId)
                .build();
        GetCommentCountResponse getCommentCountResponse = actionStub.getCommentCount(getCommentCountRequest);
        if (getCommentCountResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getCommentCount] GetCommentCount rpc err, err = {}", getCommentCountResponse.getBaseResp());
            throw new Exception("GetCommentCount rpc error");
        }
        JSONObject data = new JSONObject();
        data.put("comment_count", getCommentCountResponse.getCommentCount());
        return data;
    }

    @Override
    public JSONObject diggComment(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Long commentId = req.getLong("comment_id");
        DiggCommentRequest diggCommentRequest = DiggCommentRequest.newBuilder()
                .setUserId(userId)
                .setCommentId(commentId)
                .build();
        DiggCommentResponse diggCommentResponse = actionStub.diggComment(diggCommentRequest);
        if (diggCommentResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[diggComment] DiggComment rpc err, err = {}", diggCommentResponse.getBaseResp());
            throw new Exception("DiggComment rpc error");
        }
        JSONObject data = new JSONObject();
        return data;
    }

    @Override
    public JSONObject cancelDiggComment(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Long commentId = req.getLong("comment_id");
        DiggCommentRequest diggCommentRequest = DiggCommentRequest.newBuilder()
                .setUserId(userId)
                .setCommentId(commentId)
                .build();
        DiggCommentResponse diggCommentResponse = actionStub.cancelDiggComment(diggCommentRequest);
        if (diggCommentResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[cancelDiggComment] CancelDiggComment rpc err, err = {}", diggCommentResponse.getBaseResp());
            throw new Exception("CancelDiggComment rpc error");
        }
        JSONObject data = new JSONObject();
        return data;
    }

    @Override
    public JSONObject forward(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        String entityType = req.getString("entity_type");
        Long entityId = req.getLong("entity_id");
        Long conversationId = req.getLong("conversation_id");
        ForwardRequest forwardRequest = ForwardRequest.newBuilder()
                .setUserId(userId)
                .setEntityType(entityType)
                .setEntityId(entityId)
                .setConversationId(conversationId)
                .build();
        ForwardResponse forwardResponse = actionStub.forward(forwardRequest);
        if (forwardResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[forward] Forward rpc err, err = {}", forwardResponse.getBaseResp());
            throw new Exception("Forward rpc error");
        }
        JSONObject data = new JSONObject();
        return data;
    }

    private List<CommentVO> fillCommentInfo(Long userId, List<CommentData> comments) throws RpcException {
        if (comments.isEmpty()) {
            return Collections.emptyList();
        }
        List<Long> commentIds = comments.stream().map(CommentData::getCommentId).collect(Collectors.toList());
        MIsDiggRequest miIsDiggRequest = MIsDiggRequest.newBuilder()
                .setUserId(userId)
                .setEntityType("comment")
                .addAllEntityIds(commentIds)
                .build();
        MIsDiggResponse miIsDiggResponse = actionStub.mIsDigg(miIsDiggRequest);
        if (miIsDiggResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[fillCommentInfo] MIsDigg rpc err, err = {}", miIsDiggResponse.getBaseResp());
            throw new RpcException(miIsDiggResponse.getBaseResp());
        }
        Map<Long, Boolean> isDiggMap = miIsDiggResponse.getIsDiggMap();
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
            log.error("[fillCommentInfo] GetUserInfos rpc err, err = {}", getUserInfosResponse.getBaseResp());
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
            commentVO.setIsDigg(isDiggMap.getOrDefault(commentData.getCommentId(), false));
            commentVO.setCreateTime(commentData.getCreateTime());
            commentVO.setSibUserId(commentData.getSibUserId());
            if (commentData.getSibUserId() != 0) {
                UserInfo sibUserInfo = userInfosMap.get(commentData.getSibUserId());
                commentVO.setSibUsername(sibUserInfo == null ? "未知用户" : sibUserInfo.getUsername());
            }
            return commentVO;
        }).collect(Collectors.toList());
    }
}
