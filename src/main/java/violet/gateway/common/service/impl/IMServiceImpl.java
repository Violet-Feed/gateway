package violet.gateway.common.service.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import violet.gateway.common.proto_gen.common.StatusCode;
import violet.gateway.common.proto_gen.im.*;
import violet.gateway.common.service.IMService;
import violet.gateway.common.utils.CustomAuthenticationToken;
import violet.gateway.common.utils.RpcException;

@Slf4j
@Service
public class IMServiceImpl implements IMService {
    @GrpcClient("im")
    private IMServiceGrpc.IMServiceBlockingStub imStub;

    @Override
    public JSONObject sendMessage(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Long conShortId = req.getLong("con_short_id");
        String conId = req.getString("con_id");
        Integer conType = req.getInteger("con_type");
        Long clientMsgId = req.getLong("client_msg_id");
        Integer msgType = req.getInteger("msg_type");
        String msg_content = req.getString("msg_content");
        SendMessageRequest sendMessageRequest = SendMessageRequest.newBuilder().setUserId(userId).setConShortId(conShortId).setConId(conId).setConType(conType).setClientMsgId(clientMsgId).setMsgType(msgType).setMsgContent(msg_content).build();
        SendMessageResponse sendMessageResponse = imStub.sendMessage(sendMessageRequest);
        if (sendMessageResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[sendMessage] SendMessage rpc err, err = {}", sendMessageResponse.getBaseResp());
            throw new RpcException(sendMessageResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        return data;
    }

    @Override
    public JSONObject getMessageByInit(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Long userConIndex = req.getLong("user_con_index");
        GetMessageByInitRequest getMessageByInitRequest = GetMessageByInitRequest.newBuilder().setUserId(userId).setUserConIndex(userConIndex).build();
        GetMessageByInitResponse getMessageByInitResponse = imStub.getMessageByInit(getMessageByInitRequest);
        if (getMessageByInitResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getMessageByInit] GetMessageByInit rpc err, err = {}", getMessageByInitResponse.getBaseResp());
            throw new RpcException(getMessageByInitResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        data.put("cons", getMessageByInitResponse.getConsList());
        data.put("has_more", getMessageByInitResponse.getHasMore());
        data.put("next_user_con_index", getMessageByInitResponse.getNextUserConIndex());
        data.put("user_con_index", getMessageByInitResponse.getUserConIndex());
        data.put("user_cmd_index", getMessageByInitResponse.getUserCmdIndex());
        return data;
    }

    @Override
    public JSONObject getMessageByConversation(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Long conShortId = req.getLong("con_short_id");
        Long conIndex = req.getLong("con_index");
        Long limit = req.getLong("limit");
        GetMessageByConversationRequest getMessageByConversationRequest = GetMessageByConversationRequest.newBuilder().setUserId(userId).setConShortId(conShortId).setConIndex(conIndex).setLimit(limit).build();
        GetMessageByConversationResponse getMessageByConversationResponse = imStub.getMessageByConversation(getMessageByConversationRequest);
        if (getMessageByConversationResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getMessageByConversation] GetMessageByConversation rpc err, err = {}", getMessageByConversationResponse.getBaseResp());
            throw new RpcException(getMessageByConversationResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        data.put("msg_bodies", getMessageByConversationResponse.getMsgBodiesList());
        return data;
    }

    @Override
    public JSONObject markRead(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Long conShortId = req.getLong("con_short_id");
        Long readConIndex = req.getLong("read_con_index");
        Long readBadgeCount = req.getLong("read_badge_count");
        MarkReadRequest markReadRequest = MarkReadRequest.newBuilder().setUserId(userId).setConShortId(conShortId).setReadConIndex(readConIndex).setReadBadgeCount(readBadgeCount).build();
        MarkReadResponse markReadResponse = imStub.markRead(markReadRequest);
        if (markReadResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[markRead] MarkRead rpc err, err = {}", markReadResponse.getBaseResp());
            throw new RpcException(markReadResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        return data;
    }
}
