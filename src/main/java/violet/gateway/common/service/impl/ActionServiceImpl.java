package violet.gateway.common.service.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import violet.gateway.common.proto_gen.action.*;
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
        if (createCommentResponse.getBaseResp().getStatusCode() != violet.gateway.common.proto_gen.common.StatusCode.Success) {
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
        Long sibId = req.getLong("sib_id");
        Long sibUserId = req.getLong("sib_user_id");
        Integer contentType = req.getInteger("content_type");
        String content = req.getString("content");
        CreateCommentReplyRequest createCommentReplyRequest = CreateCommentReplyRequest.newBuilder()
                .setUserId(userId)
                .setParentId(parentId)
                .setSibId(sibId)
                .setSibUserId(sibUserId)
                .setContentType(contentType)
                .setContent(content)
                .build();
        CreateCommentReplyResponse createCommentReplyResponse = actionStub.createCommentReply(createCommentReplyRequest);
        if (createCommentReplyResponse.getBaseResp().getStatusCode() != violet.gateway.common.proto_gen.common.StatusCode.Success) {
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
        GetCommentListRequest getCommentListRequest = GetCommentListRequest.newBuilder()
                .setEntityType(entityType)
                .setEntityId(entityId)
                .setPage(page)
                .build();
        GetCommentListResponse getCommentListResponse = actionStub.getCommentList(getCommentListRequest);
        if (getCommentListResponse.getBaseResp().getStatusCode() != violet.gateway.common.proto_gen.common.StatusCode.Success) {
            log.error("[getCommentList] GetCommentList rpc err, err = {}", getCommentListResponse.getBaseResp());
            throw new Exception("GetCommentList rpc error");
        }
        JSONObject data = new JSONObject();
        data.put("comments", getCommentListResponse.getCommentListList());
        return data;
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
        if (getCommentReplyListResponse.getBaseResp().getStatusCode() != violet.gateway.common.proto_gen.common.StatusCode.Success) {
            log.error("[getReplyList] GetCommentReplyList rpc err, err = {}", getCommentReplyListResponse.getBaseResp());
            throw new Exception("GetCommentReplyList rpc error");
        }
        JSONObject data = new JSONObject();
        data.put("comments", getCommentReplyListResponse.getCommentListList());
        return data;
    }

    @Override
    public JSONObject diggComment(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Long commentId = req.getLong("comment_id");
        JSONObject data = new JSONObject();
        return data;
    }

    @Override
    public JSONObject cancelDiggComment(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Long commentId = req.getLong("comment_id");
        JSONObject data = new JSONObject();
        return data;
    }

    @Override
    public JSONObject forward(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Long creationId = req.getLong("creation_id");
        Long conversationId = req.getLong("conversation_id");
        JSONObject data = new JSONObject();
        return data;
    }
}
