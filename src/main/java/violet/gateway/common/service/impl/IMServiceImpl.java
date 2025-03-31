package violet.gateway.common.service.impl;

import com.alibaba.fastjson.JSONObject;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import violet.gateway.common.proto_gen.im.IMServiceGrpc;
import violet.gateway.common.service.IMService;

@Service
public class IMServiceImpl implements IMService {
    @GrpcClient("im")
    private IMServiceGrpc.IMServiceBlockingStub imStub;

    @Override
    public JSONObject sendMessage(JSONObject req) throws Exception {
        return null;
    }

    @Override
    public JSONObject getMessageByInit(JSONObject req) throws Exception {
        return null;
    }

    @Override
    public JSONObject getMessageByConversation(JSONObject req) throws Exception {
        return null;
    }

    @Override
    public JSONObject markRead(JSONObject req) throws Exception {
        return null;
    }
}
