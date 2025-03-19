package violet.gateway.common.service.impl;

import com.alibaba.fastjson.JSONObject;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import violet.gateway.common.proto_gen.action.Action;
import violet.gateway.common.proto_gen.action.ActionServiceGrpc;
import violet.gateway.common.proto_gen.http.GetUserProfileRequest;
import violet.gateway.common.proto_gen.http.LoginRequest;
import violet.gateway.common.proto_gen.http.RegisterRequest;
import violet.gateway.common.proto_gen.http.SearchUserRequest;
import violet.gateway.common.service.UserService;
import violet.gateway.common.utils.CustomAuthenticationToken;

@Service
public class UserServiceImpl implements UserService {
    @GrpcClient("action")
    private ActionServiceGrpc.ActionServiceBlockingStub actionStub;

    @Override
    public JSONObject login(LoginRequest req) {
        return null;
    }

    @Override
    public JSONObject register(RegisterRequest req) {
        return null;
    }

    @Override
    public JSONObject getUserProfile(GetUserProfileRequest req) {
        return null;
    }

    @Override
    public JSONObject searchUsers(SearchUserRequest req) {
        return null;
    }
}
