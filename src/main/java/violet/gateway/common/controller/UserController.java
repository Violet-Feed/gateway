package violet.gateway.common.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import violet.gateway.common.proto_gen.common.StatusCode;
import violet.gateway.common.service.UserService;
import violet.gateway.common.utils.RpcException;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public JSONObject login(@RequestBody JSONObject req) {
        JSONObject resp = new JSONObject();
        try {
            JSONObject data = userService.login(req);
            resp.put("code", StatusCode.Success_VALUE);
            resp.put("message", StatusCode.Success);
            resp.put("data", data);
        } catch (RpcException e) {
            resp.put("code", e.getStatus().getStatusCodeValue());
            resp.put("message", e.getStatus().getStatusMessage());
        } catch (Exception e) {
            resp.put("code", StatusCode.Unknown_Error_VALUE);
            resp.put("message", StatusCode.Unknown_Error);
            log.error(String.format("[login] err, err = %s.", e));
        }
        return resp;
    }

    @PostMapping("/register")
    public JSONObject register(@RequestBody JSONObject req) {
        JSONObject resp = new JSONObject();
        try {
            JSONObject data = userService.register(req);
            resp.put("code", StatusCode.Success_VALUE);
            resp.put("message", StatusCode.Success);
            resp.put("data", data);
        } catch (RpcException e) {
            resp.put("code", e.getStatus().getStatusCodeValue());
            resp.put("message", e.getStatus().getStatusMessage());
        } catch (Exception e) {
            resp.put("code", StatusCode.Unknown_Error_VALUE);
            resp.put("message", StatusCode.Unknown_Error);
            log.error(String.format("[register] err, err = %s.", e));
        }
        return resp;
    }

    @PostMapping("/get_info")
    public JSONObject GetUserProfile(@RequestBody JSONObject req) {
        JSONObject resp = new JSONObject();
        try {
            JSONObject data = userService.getUserProfile(req);
            resp.put("code", StatusCode.Success_VALUE);
            resp.put("message", StatusCode.Success);
            resp.put("data", data);
        } catch (RpcException e) {
            resp.put("code", e.getStatus().getStatusCodeValue());
            resp.put("message", e.getStatus().getStatusMessage());
        } catch (Exception e) {
            resp.put("code", StatusCode.Unknown_Error_VALUE);
            resp.put("message", StatusCode.Unknown_Error);
            log.error(String.format("[GetUserProfile] err, err = %s.", e));
        }
        return resp;
    }

    @PostMapping("/search")
    public JSONObject searchUsers(@RequestBody JSONObject req) {
        JSONObject resp = new JSONObject();
        try {
            JSONObject data = userService.searchUsers(req);
            resp.put("code", StatusCode.Success_VALUE);
            resp.put("message", StatusCode.Success);
            resp.put("data", data);
        } catch (RpcException e) {
            resp.put("code", e.getStatus().getStatusCodeValue());
            resp.put("message", e.getStatus().getStatusMessage());
        } catch (Exception e) {
            resp.put("code", StatusCode.Unknown_Error_VALUE);
            resp.put("message", StatusCode.Unknown_Error);
            log.error(String.format("[searchUsers] err, err = %s.", e));
        }
        return resp;
    }
}
