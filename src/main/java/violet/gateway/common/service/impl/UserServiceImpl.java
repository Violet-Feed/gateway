package violet.gateway.common.service.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import violet.gateway.common.proto_gen.action.*;
import violet.gateway.common.proto_gen.common.StatusCode;
import violet.gateway.common.service.UserService;
import violet.gateway.common.utils.CustomAuthenticationToken;
import violet.gateway.common.utils.JwtUtil;
import violet.gateway.common.utils.RpcException;

import java.util.Objects;

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
            MGetFollowCountRequest.Builder mGetFollowCountRequest = MGetFollowCountRequest.newBuilder().addUserIds(userId).setNeedFollow(true);
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
    public JSONObject searchUsers(JSONObject req) throws Exception {
        String keyword = req.getString("keyword");
        SearchUsersRequest searchUserRequest = SearchUsersRequest.newBuilder().setKeyword(keyword).build();
        SearchUsersResponse searchUsersResponse = actionStub.searchUsers(searchUserRequest);
        if (searchUsersResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[searchUsers] SearchUsers rpc err, err = {}", searchUsersResponse.getBaseResp());
            throw new RpcException(searchUsersResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        data.put("user_infos", searchUsersResponse.getUserInfosList());
        return data;
    }
}
