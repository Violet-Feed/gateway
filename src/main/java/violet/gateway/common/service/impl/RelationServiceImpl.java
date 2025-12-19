package violet.gateway.common.service.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import violet.gateway.common.pojo.UserVO;
import violet.gateway.common.proto_gen.action.*;
import violet.gateway.common.proto_gen.common.StatusCode;
import violet.gateway.common.service.RelationService;
import violet.gateway.common.utils.CustomAuthenticationToken;
import violet.gateway.common.utils.RpcException;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Long queryUserId = req.getLong("user_id");
        Integer page = req.getInteger("page");
        GetFollowListRequest getFollowListRequest = GetFollowListRequest.newBuilder().setUserId(queryUserId).setPage(page).build();
        GetFollowListResponse getFollowListResponse = actionStub.getFollowingList(getFollowListRequest);
        if (getFollowListResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getFollowingList] GetFollowingList rpc err, err = {}", getFollowListResponse.getBaseResp());
            throw new RpcException(getFollowListResponse.getBaseResp());
        }
        try {
            List<UserVO> userVOList = fillUserInfo(userId, getFollowListResponse.getUserIdsList(), false, true);
            JSONObject data = new JSONObject();
            data.put("user_infos", userVOList);
            return data;
        } catch (Exception e) {
            log.error("[getFollowingList] fillUserInfo err ", e);
            throw new Exception("fillUserInfo error");
        }
    }

    @Override
    public JSONObject getFollowerList(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Long queryUserId = req.getLong("user_id");
        Integer page = req.getInteger("page");
        GetFollowListRequest getFollowListRequest = GetFollowListRequest.newBuilder().setUserId(queryUserId).setPage(page).build();
        GetFollowListResponse getFollowListResponse = actionStub.getFollowerList(getFollowListRequest);
        if (getFollowListResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getFollowerList] GetFollowerList rpc err, err = {}", getFollowListResponse.getBaseResp());
            throw new RpcException(getFollowListResponse.getBaseResp());
        }
        try {
            List<UserVO> userVOList = fillUserInfo(userId, getFollowListResponse.getUserIdsList(), true, false);
            JSONObject data = new JSONObject();
            data.put("user_infos", userVOList);
            return data;
        } catch (Exception e) {
            log.error("[getFollowerList] fillUserInfo err ", e);
            throw new Exception("fillUserInfo error");
        }
    }

    @Override
    public JSONObject getFriendList(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Long queryUserId = req.getLong("user_id");
        Integer page = req.getInteger("page");
        GetFollowListRequest getFollowListRequest = GetFollowListRequest.newBuilder().setUserId(queryUserId).setPage(page).build();
        GetFollowListResponse getFollowListResponse = actionStub.getFriendList(getFollowListRequest);
        if (getFollowListResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getFriendList] GetFriendList rpc err, err = {}", getFollowListResponse.getBaseResp());
            throw new RpcException(getFollowListResponse.getBaseResp());
        }
        try {
            List<UserVO> userVOList = fillUserInfo(userId, getFollowListResponse.getUserIdsList(), false, false);
            JSONObject data = new JSONObject();
            data.put("user_infos", userVOList);
            return data;
        } catch (Exception e) {
            log.error("[getFriendList] fillUserInfo err ", e);
            throw new Exception("fillUserInfo error");
        }
    }

    private List<UserVO> fillUserInfo(Long userId, List<Long> userIds, Boolean needFollowing, Boolean needFollower) throws RpcException {
        if (userIds.isEmpty()) {
            return Collections.emptyList();
        }
        GetUserInfosRequest getUserInfosRequest = GetUserInfosRequest.newBuilder().addAllUserIds(userIds).build();
        GetUserInfosResponse getUserInfosResponse = actionStub.getUserInfos(getUserInfosRequest);
        if (getUserInfosResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[fillUserInfo] GetUserInfos rpc err, err = {}", getUserInfosResponse.getBaseResp());
            throw new RpcException(getUserInfosResponse.getBaseResp());
        }
        Map<Long, UserInfo> userInfosMap = getUserInfosResponse.getUserInfosList().stream().collect(Collectors.toMap(UserInfo::getUserId, userInfo -> userInfo));
        Map<Long, Boolean> isFollowingMap;
        Map<Long, Boolean> isFollowerMap;
        if (needFollowing) {
            MIsFollowRequest mIsFollowingRequest = MIsFollowRequest.newBuilder().setFromUserId(userId).addAllToUserIds(userIds).build();
            MIsFollowResponse mIsFollowingResponse = actionStub.mIsFollowing(mIsFollowingRequest);
            if (mIsFollowingResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
                log.error("[fillUserInfo] MIsFollowing rpc err, err = {}", mIsFollowingResponse.getBaseResp());
                throw new RpcException(mIsFollowingResponse.getBaseResp());
            }
            isFollowingMap = mIsFollowingResponse.getIsFollowingMap();
        } else {
            isFollowingMap = new HashMap<>();
        }
        if (needFollower) {
            MIsFollowRequest mIsFollowerRequest = MIsFollowRequest.newBuilder().setFromUserId(userId).addAllToUserIds(userIds).build();
            MIsFollowResponse mIsFollowerResponse = actionStub.mIsFollower(mIsFollowerRequest);
            if (mIsFollowerResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
                log.error("[fillUserInfo] MIsFollower rpc err, err = {}", mIsFollowerResponse.getBaseResp());
                throw new RpcException(mIsFollowerResponse.getBaseResp());
            }
            isFollowerMap = mIsFollowerResponse.getIsFollowerMap();
        } else {
            isFollowerMap = new HashMap<>();
        }
        return userIds.stream().map(id -> {
            UserVO userVo = new UserVO();
            UserInfo userInfo = userInfosMap.get(id);
            userVo.setUserId(id);
            userVo.setUsername(userInfo == null ? "未知用户" : userInfo.getUsername());
            userVo.setAvatar(userInfo == null ? "" : userInfo.getAvatar());
            userVo.setIsFollowing(isFollowingMap.getOrDefault(id, true));
            userVo.setIsFollower(isFollowerMap.getOrDefault(id, true));
            return userVo;
        }).collect(Collectors.toList());
    }
}
