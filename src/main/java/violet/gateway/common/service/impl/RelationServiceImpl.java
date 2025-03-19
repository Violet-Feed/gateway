package violet.gateway.common.service.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import violet.gateway.common.proto_gen.http.FollowRequest;
import violet.gateway.common.proto_gen.http.GetFollowListRequest;
import violet.gateway.common.service.RelationService;

@Slf4j
@Service
public class RelationServiceImpl implements RelationService {

    @Override
    public JSONObject follow(FollowRequest req) {
        return null;
    }

    @Override
    public JSONObject unfollow(FollowRequest req) {
        return null;
    }

    @Override
    public JSONObject getFollowingList(GetFollowListRequest req) {
        return null;
    }

    @Override
    public JSONObject getFollowerList(GetFollowListRequest req) {
        return null;
    }

    @Override
    public JSONObject getFriendList(GetFollowListRequest req) {
        return null;
    }
}
