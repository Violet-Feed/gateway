package violet.gateway.common.service;

import com.alibaba.fastjson.JSONObject;
import violet.gateway.common.proto_gen.http.FollowRequest;
import violet.gateway.common.proto_gen.http.GetFollowListRequest;

public interface RelationService {
    JSONObject follow(FollowRequest req);
    JSONObject unfollow(FollowRequest req);
    JSONObject getFollowingList(GetFollowListRequest req);
    JSONObject getFollowerList(GetFollowListRequest req);
    JSONObject getFriendList(GetFollowListRequest req);
}