package violet.gateway.common.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import violet.gateway.common.proto_gen.common.StatusCode;
import violet.gateway.common.service.RelationService;
import violet.gateway.common.utils.RpcException;

@Slf4j
@RestController
@RequestMapping("/api/relation")
public class RelationController {
    @Autowired
    private RelationService relationService;

    @PostMapping("/follow")
    public JSONObject follow(@RequestBody JSONObject req) {
        JSONObject resp = new JSONObject();
        try {
            JSONObject data = relationService.follow(req);
            resp.put("code", StatusCode.Success_VALUE);
            resp.put("message", StatusCode.Success);
            resp.put("data", data);
        } catch (RpcException e) {
            resp.put("code", e.getStatus().getStatusCodeValue());
            resp.put("message", e.getStatus().getStatusMessage());
        } catch (Exception e) {
            resp.put("code", StatusCode.Unknown_Error_VALUE);
            resp.put("message", StatusCode.Unknown_Error);
            log.error(String.format("[follow] err, err = %s.", e));
        }
        return resp;
    }

    @PostMapping("/unfollow")
    public JSONObject unfollow(@RequestBody JSONObject req) {
        JSONObject resp = new JSONObject();
        try {
            JSONObject data = relationService.unfollow(req);
            resp.put("code", StatusCode.Success_VALUE);
            resp.put("message", StatusCode.Success);
            resp.put("data", data);
        } catch (RpcException e) {
            resp.put("code", e.getStatus().getStatusCodeValue());
            resp.put("message", e.getStatus().getStatusMessage());
        } catch (Exception e) {
            resp.put("code", StatusCode.Unknown_Error_VALUE);
            resp.put("message", StatusCode.Unknown_Error);
            log.error(String.format("[unfollow] err, err = %s.", e));
        }
        return resp;
    }

    @PostMapping("/get_following_list")
    public JSONObject getFollowingList(@RequestBody JSONObject req) {
        JSONObject resp = new JSONObject();
        try {
            JSONObject data = relationService.getFollowingList(req);
            resp.put("code", StatusCode.Success_VALUE);
            resp.put("message", StatusCode.Success);
            resp.put("data", data);
        } catch (RpcException e) {
            resp.put("code", e.getStatus().getStatusCodeValue());
            resp.put("message", e.getStatus().getStatusMessage());
        } catch (Exception e) {
            resp.put("code", StatusCode.Unknown_Error_VALUE);
            resp.put("message", StatusCode.Unknown_Error);
            log.error(String.format("[getFollowingList] err, err = %s.", e));
        }
        return resp;
    }

    @PostMapping("/get_follower_list")
    public JSONObject getFollowerList(@RequestBody JSONObject req) {
        JSONObject resp = new JSONObject();
        try {
            JSONObject data = relationService.getFollowerList(req);
            resp.put("code", StatusCode.Success_VALUE);
            resp.put("message", StatusCode.Success);
            resp.put("data", data);
        } catch (RpcException e) {
            resp.put("code", e.getStatus().getStatusCodeValue());
            resp.put("message", e.getStatus().getStatusMessage());
        } catch (Exception e) {
            resp.put("code", StatusCode.Unknown_Error_VALUE);
            resp.put("message", StatusCode.Unknown_Error);
            log.error(String.format("[getFollowerList] err, err = %s.", e));
        }
        return resp;
    }

    @PostMapping("/get_friend_list")
    public JSONObject getFriendList(@RequestBody JSONObject req) {
        JSONObject resp = new JSONObject();
        try {
            JSONObject data = relationService.getFriendList(req);
            resp.put("code", StatusCode.Success_VALUE);
            resp.put("message", StatusCode.Success);
            resp.put("data", data);
        } catch (RpcException e) {
            resp.put("code", e.getStatus().getStatusCodeValue());
            resp.put("message", e.getStatus().getStatusMessage());
        } catch (Exception e) {
            resp.put("code", StatusCode.Unknown_Error_VALUE);
            resp.put("message", StatusCode.Unknown_Error);
            log.error(String.format("[getFriendList] err, err = %s.", e));
        }
        return resp;
    }
}
