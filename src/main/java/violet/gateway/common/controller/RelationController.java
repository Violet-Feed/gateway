package violet.gateway.common.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import violet.gateway.common.proto_gen.http.FollowRequest;
import violet.gateway.common.proto_gen.http.GetFollowListRequest;
import violet.gateway.common.service.RelationService;

@RestController
@RequestMapping("/api/relation")
public class RelationController {
    @Autowired
    private RelationService relationService;

    @PostMapping("/follow")
    public JSONObject follow(@RequestBody FollowRequest req) {
        return relationService.follow(req);
    }

    @PostMapping("/unfollow")
    public JSONObject unfollow(@RequestBody FollowRequest req) {
        return relationService.unfollow(req);
    }

    @GetMapping("/get_following_list")
    public JSONObject getFollowingList(@RequestBody GetFollowListRequest req) {
        return relationService.getFollowingList(req);
    }

    @GetMapping("/get_follower_list")
    public JSONObject getFollowerList(@RequestBody GetFollowListRequest req) {
        return relationService.getFollowerList(req);
    }

    @GetMapping("/get_friend_list")
    public JSONObject getFriendList(@RequestBody GetFollowListRequest req) {
        return relationService.getFriendList(req);
    }
}
