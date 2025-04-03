package violet.gateway.common.service.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import violet.gateway.common.proto_gen.action.*;
import violet.gateway.common.proto_gen.common.StatusCode;
import violet.gateway.common.service.RelationService;
import violet.gateway.common.utils.CustomAuthenticationToken;
import violet.gateway.common.utils.RpcException;

import java.util.ArrayList;

@Slf4j
@Service
public class RelationServiceImpl implements RelationService {
    @GrpcClient("action")
    private ActionServiceGrpc.ActionServiceBlockingStub actionStub;


    @Override
    public JSONObject follow(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Long toUserId = req.getLong("to_user_id");
        FollowRequest followRequest = FollowRequest.newBuilder().setFromUserId(userId).setToUserId(toUserId).build();
        FollowResponse followResponse = actionStub.follow(followRequest);
        if (followResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[follow] Follow rpc err, err = {}", followResponse.getBaseResp());
            throw new RpcException(followResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        return data;
    }

    @Override
    public JSONObject unfollow(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Long toUserId = req.getLong("to_user_id");
        FollowRequest followRequest = FollowRequest.newBuilder().setFromUserId(userId).setToUserId(toUserId).build();
        FollowResponse followResponse = actionStub.unfollow(followRequest);
        if (followResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[unfollow] Unfollow rpc err, err = {}", followResponse.getBaseResp());
            throw new RpcException(followResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        return data;
    }

    @Override
    public JSONObject getFollowingList(JSONObject req) throws Exception {
        Long userId = req.getLong("user_id");
        GetFollowListRequest getFollowListRequest = GetFollowListRequest.newBuilder().setUserId(userId).build();
        GetFollowListResponse getFollowListResponse = actionStub.getFollowingList(getFollowListRequest);
        if (getFollowListResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getFollowingList] GetFollowingList rpc err, err = {}", getFollowListResponse.getBaseResp());
            throw new RpcException(getFollowListResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        if(!getFollowListResponse.getUserIdsList().isEmpty()){
            GetUserInfosRequest getUserInfosRequest = GetUserInfosRequest.newBuilder().addAllUserIds(getFollowListResponse.getUserIdsList()).build();
            GetUserInfosResponse getUserInfosResponse = actionStub.getUserInfos(getUserInfosRequest);
            if (getUserInfosResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
                log.error("[getFollowingList] GetUserInfos rpc err, err = {}", getUserInfosResponse.getBaseResp());
                throw new RpcException(getUserInfosResponse.getBaseResp());
            }
            data.put("user_infos", getUserInfosResponse.getUserInfosList());
        }else{
            data.put("user_infos", new ArrayList<>());
        }
        return data;
    }

    @Override
    public JSONObject getFollowerList(JSONObject req) throws Exception {
        Long userId = req.getLong("user_id");
        GetFollowListRequest getFollowListRequest = GetFollowListRequest.newBuilder().setUserId(userId).build();
        GetFollowListResponse getFollowListResponse = actionStub.getFollowerList(getFollowListRequest);
        if (getFollowListResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getFollowerList] GetFollowerList rpc err, err = {}", getFollowListResponse.getBaseResp());
            throw new RpcException(getFollowListResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        if(!getFollowListResponse.getUserIdsList().isEmpty()) {
            GetUserInfosRequest getUserInfosRequest = GetUserInfosRequest.newBuilder().addAllUserIds(getFollowListResponse.getUserIdsList()).build();
            GetUserInfosResponse getUserInfosResponse = actionStub.getUserInfos(getUserInfosRequest);
            if (getUserInfosResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
                log.error("[getFollowerList] GetUserInfos rpc err, err = {}", getUserInfosResponse.getBaseResp());
                throw new RpcException(getUserInfosResponse.getBaseResp());
            }
            data.put("user_infos", getUserInfosResponse.getUserInfosList());
        }else{
            data.put("user_infos", new ArrayList<>());
        }
        return data;
    }

    @Override
    public JSONObject getFriendList(JSONObject req) throws Exception {
        Long userId = req.getLong("user_id");
        GetFollowListRequest getFollowListRequest = GetFollowListRequest.newBuilder().setUserId(userId).build();
        GetFollowListResponse getFollowListResponse = actionStub.getFriendList(getFollowListRequest);
        if (getFollowListResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getFriendList] GetFriendList rpc err, err = {}", getFollowListResponse.getBaseResp());
            throw new RpcException(getFollowListResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        if(!getFollowListResponse.getUserIdsList().isEmpty()) {
            GetUserInfosRequest getUserInfosRequest = GetUserInfosRequest.newBuilder().addAllUserIds(getFollowListResponse.getUserIdsList()).build();
            GetUserInfosResponse getUserInfosResponse = actionStub.getUserInfos(getUserInfosRequest);
            if (getUserInfosResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
                log.error("[getFriendList] GetUserInfos rpc err, err = {}", getUserInfosResponse.getBaseResp());
                throw new RpcException(getUserInfosResponse.getBaseResp());
            }
            data.put("user_infos", getUserInfosResponse.getUserInfosList());
        }else{
            data.put("user_infos", new ArrayList<>());
        }
        return data;
    }
}
