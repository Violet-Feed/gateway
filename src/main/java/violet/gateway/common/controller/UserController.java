package violet.gateway.common.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import violet.gateway.common.proto_gen.http.GetUserProfileRequest;
import violet.gateway.common.proto_gen.http.LoginRequest;
import violet.gateway.common.proto_gen.http.RegisterRequest;
import violet.gateway.common.proto_gen.http.SearchUserRequest;
import violet.gateway.common.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public JSONObject login(@RequestBody LoginRequest req){
        return userService.login(req);
    }

    @PostMapping("/register")
    public JSONObject register(@RequestBody RegisterRequest req){
        return userService.register(req);
    }

    @PostMapping("/get_info")
    public JSONObject GetUserProfile(@RequestBody GetUserProfileRequest req){
        return userService.getUserProfile(req);
    }

    @PostMapping("/search")
    public JSONObject searchUsers(@RequestBody SearchUserRequest req){
        return userService.searchUsers(req);
    }
}
