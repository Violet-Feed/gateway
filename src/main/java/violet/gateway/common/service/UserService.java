package violet.gateway.common.service;

import com.alibaba.fastjson.JSONObject;
import violet.gateway.common.proto_gen.http.GetUserProfileRequest;
import violet.gateway.common.proto_gen.http.LoginRequest;
import violet.gateway.common.proto_gen.http.RegisterRequest;
import violet.gateway.common.proto_gen.http.SearchUserRequest;

public interface UserService {
    JSONObject login(LoginRequest req);
    JSONObject register(RegisterRequest req);
    JSONObject getUserProfile(GetUserProfileRequest req);
    JSONObject searchUsers(SearchUserRequest req);
}
