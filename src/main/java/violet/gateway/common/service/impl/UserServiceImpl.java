package violet.gateway.common.service.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import violet.gateway.common.pojo.UserVO;
import violet.gateway.common.proto_gen.action.*;
import violet.gateway.common.proto_gen.common.StatusCode;
import violet.gateway.common.service.UserService;
import violet.gateway.common.utils.CustomAuthenticationToken;
import violet.gateway.common.utils.JwtUtil;
import violet.gateway.common.utils.RpcException;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @GrpcClient("action")
    private ActionServiceGrpc.ActionServiceBlockingStub actionStub;

    @Override
    public JSONObject login(JSONObject req) throws Exception {
        String username = req.getString("username");
        String password = req.getString("password");
        LoginRequest loginRequest = LoginRequest.newBuilder().setUsername(username).setPassword(password).build();
        LoginResponse loginResponse = actionStub.login(loginRequest);
        if (loginResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[login] Login rpc err, err = {}", loginResponse.getBaseResp());
            throw new RpcException(loginResponse.getBaseResp());
        }
        String token = JwtUtil.createJWT(String.valueOf(loginResponse.getUserId()));
        JSONObject data = new JSONObject();
        data.put("user_id", loginResponse.getUserId());
        data.put("token", token);
        return data;
    }

    @Override
    public JSONObject register(JSONObject req) throws Exception {
        String username = req.getString("username");
        String password = req.getString("password");
        String confirmPassword = req.getString("confirm_password");
        RegisterRequest registerRequest = RegisterRequest.newBuilder().setUsername(username).setPassword(password).setConfirmPassword(confirmPassword).build();
        RegisterResponse registerResponse = actionStub.register(registerRequest);
        if (registerResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[register] Register rpc err, err = {}", registerResponse.getBaseResp());
            throw new RpcException(registerResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        return data;
    }

    @Override
    public JSONObject getUserProfile(JSONObject req) throws Exception {
        Long userId = req.getLong("user_id");
        Boolean needFollowInfo = req.getBoolean("need_follow_info");
        Boolean needFriendInfo = req.getBoolean("need_friend_info");
        GetUserInfosRequest getUserInfosRequest = GetUserInfosRequest.newBuilder().addUserIds(userId).build();
        GetUserInfosResponse getUserInfosResponse = actionStub.getUserInfos(getUserInfosRequest);
        if (getUserInfosResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getUserProfile] GetUserInfos rpc err, err = {}", getUserInfosResponse.getBaseResp());
            throw new RpcException(getUserInfosResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        data.put("user_info", getUserInfosResponse.getUserInfos(0));
        if (needFollowInfo == Boolean.TRUE) {
            MGetFollowCountRequest.Builder mGetFollowCountRequest = MGetFollowCountRequest.newBuilder().addUserIds(userId).setNeedFollowing(true).setNeedFollower(true);
            if (needFriendInfo == Boolean.TRUE) {
                mGetFollowCountRequest.setNeedFriend(true);
            }
            MGetFollowCountResponse mGetFollowCountResponse = actionStub.mGetFollowCount(mGetFollowCountRequest.build());
            if (mGetFollowCountResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
                log.error("[getUserProfile] MGetFollowCount rpc err, err = {}", mGetFollowCountResponse.getBaseResp());
                throw new RpcException(mGetFollowCountResponse.getBaseResp());
            }
            data.put("following_count", mGetFollowCountResponse.getFollowingCountMap().get(userId));
            data.put("follower_count", mGetFollowCountResponse.getFollowerCountMap().get(userId));
            if (needFriendInfo == Boolean.TRUE) {
                data.put("friend_count", mGetFollowCountResponse.getFriendCountMap().get(userId));
            }
            CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
            Long fromUserId = authentication.getUserId();
            if (!Objects.equals(fromUserId, userId)) {
                MIsFollowRequest mIsFollowingRequest = MIsFollowRequest.newBuilder().setFromUserId(fromUserId).addToUserIds(userId).build();
                MIsFollowResponse mIsFollowingResponse = actionStub.mIsFollowing(mIsFollowingRequest);
                if (mIsFollowingResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
                    log.error("[getUserProfile] mIsFollowing rpc err, err = {}", mIsFollowingResponse.getBaseResp());
                    throw new RpcException(mIsFollowingResponse.getBaseResp());
                }
                data.put("is_following", mIsFollowingResponse.getIsFollowingMap().get(userId));
                MIsFollowRequest mIsFollowerRequest = MIsFollowRequest.newBuilder().setFromUserId(fromUserId).addToUserIds(userId).build();
                MIsFollowResponse mIsFollowerResponse = actionStub.mIsFollower(mIsFollowerRequest);
                if (mIsFollowerResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
                    log.error("[getUserProfile] mIsFollower rpc err, err = {}", mIsFollowerResponse.getBaseResp());
                    throw new RpcException(mIsFollowerResponse.getBaseResp());
                }
                data.put("is_follower", mIsFollowerResponse.getIsFollowerMap().get(userId));
            }
        }
        return data;
    }

    @Override
    public JSONObject getUserInfos(JSONObject req) throws Exception {
        List<Long> userIds = req.getJSONArray("user_ids").toJavaList(Long.class);
        GetUserInfosRequest getUserInfosRequest = GetUserInfosRequest.newBuilder().addAllUserIds(userIds).build();
        GetUserInfosResponse getUserInfosResponse = actionStub.getUserInfos(getUserInfosRequest);
        if (getUserInfosResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getUserInfos] GetUserInfos rpc err, err = {}", getUserInfosResponse.getBaseResp());
            throw new RpcException(getUserInfosResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        data.put("user_infos", getUserInfosResponse.getUserInfosList());
        return data;
    }

    @Override
    public JSONObject searchUsers(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        String keyword = req.getString("keyword");
        Integer page = req.getInteger("page");
        SearchUsersRequest searchUserRequest = SearchUsersRequest.newBuilder().setKeyword(keyword).setPage(page).build();
        SearchUsersResponse searchUsersResponse = actionStub.searchUsers(searchUserRequest);
        if (searchUsersResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[searchUsers] SearchUsers rpc err, err = {}", searchUsersResponse.getBaseResp());
            throw new RpcException(searchUsersResponse.getBaseResp());
        }
        try {
            List<UserVO> userVOList = fillFollowInfo(userId, searchUsersResponse.getUserInfosList());
            JSONObject data = new JSONObject();
            data.put("user_infos", userVOList);
            return data;
        } catch (Exception e) {
            log.error("[searchUsers] fillFollowInfo err ", e);
            throw new Exception("fillFollowInfo error");
        }
    }

    @Override
    public JSONObject reportClick(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        List<Long> creationIds = req.getJSONArray("creationIds").toJavaList(Long.class);
        ReportClickRequest reportClickRequest = ReportClickRequest.newBuilder().setUserId(userId).addAllCreationIds(creationIds).setTimestamp(System.currentTimeMillis()).build();
        ReportClickResponse reportClickResponse = actionStub.reportClick(reportClickRequest);
        if (reportClickResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[reportClick] ReportClick rpc err, err = {}", reportClickResponse.getBaseResp());
            throw new RpcException(reportClickResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        return data;
    }

    private List<UserVO> fillFollowInfo(Long userId, List<UserInfo> userInfos) throws RpcException {
        if (userInfos.isEmpty()) {
            return Collections.emptyList();
        }
        List<Long> userIds = userInfos.stream().map(UserInfo::getUserId).collect(Collectors.toList());
        MGetFollowCountRequest mGetFollowCountRequest = MGetFollowCountRequest.newBuilder().addAllUserIds(userIds).setNeedFollower(true).build();
        MGetFollowCountResponse mGetFollowCountResponse = actionStub.mGetFollowCount(mGetFollowCountRequest);
        if (mGetFollowCountResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[fillUserInfo] MGetFollowCount rpc err, err = {}", mGetFollowCountResponse.getBaseResp());
            throw new RpcException(mGetFollowCountResponse.getBaseResp());
        }
        Map<Long, Long> followerCountMap = mGetFollowCountResponse.getFollowerCountMap();
        MIsFollowRequest mIsFollowingRequest = MIsFollowRequest.newBuilder().setFromUserId(userId).addAllToUserIds(userIds).build();
        MIsFollowResponse mIsFollowingResponse = actionStub.mIsFollowing(mIsFollowingRequest);
        if (mIsFollowingResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[fillUserInfo] MIsFollowing rpc err, err = {}", mIsFollowingResponse.getBaseResp());
            throw new RpcException(mIsFollowingResponse.getBaseResp());
        }
        Map<Long, Boolean> isFollowingMap = mIsFollowingResponse.getIsFollowingMap();
        MIsFollowRequest mIsFollowerRequest = MIsFollowRequest.newBuilder().setFromUserId(userId).addAllToUserIds(userIds).build();
        MIsFollowResponse mIsFollowerResponse = actionStub.mIsFollower(mIsFollowerRequest);
        if (mIsFollowerResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[fillUserInfo] MIsFollower rpc err, err = {}", mIsFollowerResponse.getBaseResp());
            throw new RpcException(mIsFollowerResponse.getBaseResp());
        }
        Map<Long, Boolean> isFollowerMap = mIsFollowerResponse.getIsFollowerMap();
        log.info("isFollowingMap = {}, isFollowerMap = {}", isFollowingMap, isFollowerMap);
        return userInfos.stream().map(userInfo -> {
            UserVO userVo = new UserVO();
            userVo.setUserId(userInfo.getUserId());
            userVo.setUsername(userInfo.getUsername());
            userVo.setAvatar(userInfo.getAvatar());
            userVo.setFollowerCount(followerCountMap.getOrDefault(userInfo.getUserId(), 0L));
            userVo.setIsFollowing(isFollowingMap.getOrDefault(userInfo.getUserId(), false));
            userVo.setIsFollower(isFollowerMap.getOrDefault(userInfo.getUserId(), false));
            return userVo;
        }).collect(Collectors.toList());
    }
}
