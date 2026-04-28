package violet.gateway.common.service.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import violet.gateway.common.pojo.MemberVO;
import violet.gateway.common.proto_gen.action.ActionServiceGrpc;
import violet.gateway.common.proto_gen.action.GetUserInfosRequest;
import violet.gateway.common.proto_gen.action.GetUserInfosResponse;
import violet.gateway.common.proto_gen.action.UserInfo;
import violet.gateway.common.proto_gen.aigc.AgentInfo;
import violet.gateway.common.proto_gen.aigc.AigcServiceGrpc;
import violet.gateway.common.proto_gen.aigc.GetAgentsByIdsRequest;
import violet.gateway.common.proto_gen.aigc.GetAgentsByIdsResponse;
import violet.gateway.common.proto_gen.common.StatusCode;
import violet.gateway.common.proto_gen.im.*;
import violet.gateway.common.service.IMService;
import violet.gateway.common.utils.CustomAuthenticationToken;
import violet.gateway.common.utils.RpcException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class IMServiceImpl implements IMService {
    @GrpcClient("im")
    private IMServiceGrpc.IMServiceBlockingStub imStub;
    @GrpcClient("action")
    private ActionServiceGrpc.ActionServiceBlockingStub actionStub;
    @GrpcClient("aigc")
    private AigcServiceGrpc.AigcServiceBlockingStub aigcStub;

    @Override
    public JSONObject getInitInfo(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        GetInitInfoRequest getInitInfoRequest = GetInitInfoRequest.newBuilder()
                .setUserId(userId)
                .build();
        GetInitInfoResponse getInitInfoResponse = imStub.getInitInfo(getInitInfoRequest);
        if (getInitInfoResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getInitInfo] GetInitInfo rpc err, err = {}", getInitInfoResponse.getBaseResp());
            throw new RpcException(getInitInfoResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        data.put("user_cmd_index", getInitInfoResponse.getUserCmdIndex());
        return data;
    }

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
        SendMessageRequest sendMessageRequest = SendMessageRequest.newBuilder().setSenderId(userId).setSenderType(SenderType.User_VALUE).setConShortId(conShortId).setConId(conId).setConType(conType).setClientMsgId(clientMsgId).setMsgType(msgType).setMsgContent(msg_content).build();
        SendMessageResponse sendMessageResponse = imStub.sendMessage(sendMessageRequest);
        if (sendMessageResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[sendMessage] SendMessage rpc err, err = {}", sendMessageResponse.getBaseResp());
            throw new RpcException(sendMessageResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        data.put("msg_id", sendMessageResponse.getMsgId());
        return data;
    }

    @Override
    public JSONObject getMessageByUser(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Long userConIndex = req.getLong("user_con_index");
        Long limit = req.getLong("limit");
        GetMessageByUserRequest getMessageByInitRequest = GetMessageByUserRequest.newBuilder().setUserId(userId).setUserConIndex(userConIndex).setLimit(limit).build();
        GetMessageByUserResponse getMessageByInitResponse = imStub.getMessageByUser(getMessageByInitRequest);
        if (getMessageByInitResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getMessageByUser] GetMessageByUser rpc err, err = {}", getMessageByInitResponse.getBaseResp());
            throw new RpcException(getMessageByInitResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        data.put("cons", getMessageByInitResponse.getConsList());
        data.put("user_con_index", getMessageByInitResponse.getUserConIndex());
        data.put("has_more", getMessageByInitResponse.getHasMore());
        return data;
    }

    @Override
    public JSONObject getCommandByUser(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Long userCmdIndex = req.getLong("user_cmd_index");
        Long limit = req.getLong("limit");
        GetCommandByUserRequest getCommandByUserRequest = GetCommandByUserRequest.newBuilder().setUserId(userId).setUserCmdIndex(userCmdIndex).setLimit(limit).build();
        GetCommandByUserResponse getCommandByUserResponse = imStub.getCommandByUser(getCommandByUserRequest);
        if (getCommandByUserResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getCommandByUser] GetCommandByUser rpc err, err = {}", getCommandByUserResponse.getBaseResp());
            throw new RpcException(getCommandByUserResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        data.put("msg_bodies", getCommandByUserResponse.getMsgBodiesList());
        data.put("user_cmd_index", getCommandByUserResponse.getUserCmdIndex());
        data.put("has_more", getCommandByUserResponse.getHasMore());
        return data;
    }

    @Override
    public JSONObject getMessageByConversation(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Long conShortId = req.getLong("con_short_id");
        Long conIndex = req.getLong("con_index");
        Long limit = req.getLong("limit");
        GetMessageByConversationRequest getMessageByConversationRequest = GetMessageByConversationRequest.newBuilder().setSenderId(userId).setSenderType(SenderType.User_VALUE).setConShortId(conShortId).setConIndex(conIndex).setLimit(limit).build();
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

    @Override
    public JSONObject recallMessage(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Long conShortId = req.getLong("con_short_id");
        Long msgId = req.getLong("msg_id");
        RecallMessageRequest recallMessageRequest = RecallMessageRequest.newBuilder()
                .setUserId(userId)
                .setConShortId(conShortId)
                .setMsgId(msgId)
                .build();
        RecallMessageResponse recallMessageResponse = imStub.recallMessage(recallMessageRequest);
        if (recallMessageResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[recallMessage] RecallMessage rpc err, err = {}", recallMessageResponse.getBaseResp());
            throw new RpcException(recallMessageResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        return data;
    }

    @Override
    public JSONObject getMembersReadIndex(JSONObject req) throws Exception {
        Long conShortId = req.getLong("con_short_id");
        GetMembersReadIndexRequest getMembersReadIndexRequest = GetMembersReadIndexRequest.newBuilder().setConShortId(conShortId).build();
        GetMembersReadIndexResponse getMembersReadIndexResponse = imStub.getMembersReadIndex(getMembersReadIndexRequest);
        if (getMembersReadIndexResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getMembersReadIndex] GetMembersReadIndex rpc err, err = {}", getMembersReadIndexResponse.getBaseResp());
            throw new RpcException(getMembersReadIndexResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        data.put("read_index", getMembersReadIndexResponse.getReadIndexMap());
        return data;
    }

    @Override
    public JSONObject createConversation(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Integer conType = req.getInteger("con_type");
        List<Long> members = req.getJSONArray("members").toJavaList(Long.class);
        CreateConversationRequest createConversationRequest = CreateConversationRequest.newBuilder().setOwnerId(userId).setConType(conType).addAllMembers(members).build();
        CreateConversationResponse createConversationResponse = imStub.createConversation(createConversationRequest);
        if (createConversationResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[createConversation] CreateConversation rpc err, err = {}", createConversationResponse.getBaseResp());
            throw new RpcException(createConversationResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        data.put("con_core_info", createConversationResponse.getConCoreInfo());
        return data;
    }

    @Override
    public JSONObject getConversationInfo(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Long conShortId = req.getLong("con_short_id");
        GetConversationInfoRequest getConversationInfoRequest = GetConversationInfoRequest.newBuilder().setUserId(userId).setConShortId(conShortId).build();
        GetConversationInfoResponse getConversationInfoResponse = imStub.getConversationInfo(getConversationInfoRequest);
        if (getConversationInfoResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getConversationInfo] GetConversationInfo rpc err, err = {}", getConversationInfoResponse.getBaseResp());
            throw new RpcException(getConversationInfoResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        data.put("con_info", getConversationInfoResponse.getConInfo());
        return data;
    }

    @Override
    public JSONObject updateConversationCore(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Long conShortId = req.getLong("con_short_id");
        String type = req.getString("type");
        String value = req.getString("value");
        UpdateConversationCoreRequest updateConversationCoreRequest = UpdateConversationCoreRequest.newBuilder()
                .setUserId(userId)
                .setConShortId(conShortId)
                .setType(type)
                .setValue(value)
                .build();
        UpdateConversationCoreResponse updateConversationCoreResponse = imStub.updateConversationCore(updateConversationCoreRequest);
        if (updateConversationCoreResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[updateConversationCore] UpdateConversationCore rpc err, err = {}", updateConversationCoreResponse.getBaseResp());
            throw new RpcException(updateConversationCoreResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        return data;
    }

    @Override
    public JSONObject updateConversationSetting(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Long conShortId = req.getLong("con_short_id");
        String type = req.getString("type");
        String value = req.getString("value");
        UpdateConversationSettingRequest updateConversationSettingRequest = UpdateConversationSettingRequest.newBuilder()
                .setUserId(userId)
                .setConShortId(conShortId)
                .setType(type)
                .setValue(value)
                .build();
        UpdateConversationSettingResponse updateConversationSettingResponse = imStub.updateConversationSetting(updateConversationSettingRequest);
        if (updateConversationSettingResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[updateConversationSetting] UpdateConversationSetting rpc err, err = {}", updateConversationSettingResponse.getBaseResp());
            throw new RpcException(updateConversationSettingResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        return data;
    }

    @Override
    public JSONObject updateConversationMember(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Long conShortId = req.getLong("con_short_id");
        String type = req.getString("type");
        String value = req.getString("value");
        UpdateConversationMemberRequest updateConversationMemberRequest = UpdateConversationMemberRequest.newBuilder()
                .setUserId(userId)
                .setConShortId(conShortId)
                .setType(type)
                .setValue(value)
                .build();
        UpdateConversationMemberResponse updateConversationMemberResponse = imStub.updateConversationMember(updateConversationMemberRequest);
        if (updateConversationMemberResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[updateConversationMember] UpdateConversationMember rpc err, err = {}", updateConversationMemberResponse.getBaseResp());
            throw new RpcException(updateConversationMemberResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        return data;
    }

    @Override
    public JSONObject deleteConversation(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Long conShortId = req.getLong("con_short_id");
        DeleteConversationRequest deleteConversationRequest = DeleteConversationRequest.newBuilder()
                .setUserId(userId)
                .setConShortId(conShortId)
                .build();
        DeleteConversationResponse deleteConversationResponse = imStub.deleteConversation(deleteConversationRequest);
        if (deleteConversationResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[deleteConversation] DeleteConversation rpc err, err = {}", deleteConversationResponse.getBaseResp());
            throw new RpcException(deleteConversationResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        return data;
    }

    @Override
    public JSONObject addConversationMembers(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Long conShortId = req.getLong("con_short_id");
        List<Long> members = req.getJSONArray("members").toJavaList(Long.class);
        AddConversationMembersRequest addConversationMembersRequest = AddConversationMembersRequest.newBuilder()
                .setConShortId(conShortId)
                .addAllMembers(members)
                .setOperator(userId)
                .build();
        AddConversationMembersResponse addConversationMembersResponse = imStub.addConversationMembers(addConversationMembersRequest);
        if (addConversationMembersResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[addConversationMembers] AddConversationMembers rpc err, err = {}", addConversationMembersResponse.getBaseResp());
            throw new RpcException(addConversationMembersResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        return data;
    }

    @Override
    public JSONObject removeConversationMember(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Long conShortId = req.getLong("con_short_id");
        Long member = req.getLong("member");
        RemoveConversationMemberRequest removeConversationMembersRequest = RemoveConversationMemberRequest.newBuilder()
                .setConShortId(conShortId)
                .setMember(member)
                .setOperator(userId)
                .build();
        RemoveConversationMemberResponse removeConversationMemberResponse = imStub.removeConversationMember(removeConversationMembersRequest);
        if (removeConversationMemberResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[removeConversationMember] RemoveConversationMember rpc err, err = {}", removeConversationMemberResponse.getBaseResp());
            throw new RpcException(removeConversationMemberResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        return data;
    }

    @Override
    public JSONObject getConversationMembers(JSONObject req) throws Exception {
        Long conShortId = req.getLong("con_short_id");
        GetConversationMembersRequest getConversationMembersRequest = GetConversationMembersRequest.newBuilder()
                .setConShortId(conShortId)
                .build();
        GetConversationMembersResponse getConversationMembersResponse = imStub.getConversationMembers(getConversationMembersRequest);
        if (getConversationMembersResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getConversationMembers] GetConversationMembers rpc err, err = {}", getConversationMembersResponse.getBaseResp());
            throw new RpcException(getConversationMembersResponse.getBaseResp());
        }
        List<Long> userIds = getConversationMembersResponse.getMembersList().stream().map(ConversationUserInfo::getUserId).collect(Collectors.toList());
        GetUserInfosRequest getUserInfosRequest = GetUserInfosRequest.newBuilder()
                .addAllUserIds(userIds)
                .build();
        GetUserInfosResponse getUserInfosResponse = actionStub.getUserInfos(getUserInfosRequest);
        if (getUserInfosResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getConversationMembers] GetUserInfos rpc err, err = {}", getUserInfosResponse.getBaseResp());
            throw new RpcException(getUserInfosResponse.getBaseResp());
        }
        Map<Long, UserInfo> userInfoMap = getUserInfosResponse.getUserInfosList().stream().collect(Collectors.toMap(UserInfo::getUserId, userInfo -> userInfo));
        List<MemberVO> memberVOList = getConversationMembersResponse.getMembersList().stream().map(member -> {
            MemberVO memberVO = new MemberVO();
            memberVO.setConShortId(member.getConShortId());
            memberVO.setUserId(member.getUserId());
            memberVO.setPrivilege(member.getPrivilege());
            memberVO.setNickname(member.getNickName());
            memberVO.setCreateTime(member.getCreateTime());
            memberVO.setStatus(member.getStatus());
            memberVO.setExtra(member.getExtra());
            UserInfo userInfo = userInfoMap.get(member.getUserId());
            memberVO.setUsername(userInfo == null ? "未知用户" : userInfo.getUsername());
            memberVO.setAvatar(userInfo == null ? "" : userInfo.getAvatar());
            return memberVO;
        }).collect(Collectors.toList());
        JSONObject data = new JSONObject();
        data.put("members", memberVOList);
        return data;
    }

    @Override
    public JSONObject getConversationMembersByIds(JSONObject req) throws Exception {;
        Long conShortId = req.getLong("con_short_id");
        List<Long> memberIds = req.getJSONArray("member_ids").toJavaList(Long.class);
        GetConversationMembersByIdsRequest getConversationMembersByIdsRequest = GetConversationMembersByIdsRequest.newBuilder()
                .setConShortId(conShortId)
                .addAllMemberIds(memberIds)
                .build();
        GetConversationMembersByIdsResponse getConversationMembersByIdsResponse = imStub.getConversationMembersByIds(getConversationMembersByIdsRequest);
        if (getConversationMembersByIdsResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getConversationMembersByIds] GetConversationMembersByIds rpc err, err = {}", getConversationMembersByIdsResponse.getBaseResp());
            throw new RpcException(getConversationMembersByIdsResponse.getBaseResp());
        }
        List<Long> userIds = new ArrayList<>(getConversationMembersByIdsResponse.getMembersMap().keySet());
        GetUserInfosRequest getUserInfosRequest = GetUserInfosRequest.newBuilder()
                .addAllUserIds(userIds)
                .build();
        GetUserInfosResponse getUserInfosResponse = actionStub.getUserInfos(getUserInfosRequest);
        if (getUserInfosResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getConversationMembersByIds] GetUserInfos rpc err, err = {}", getUserInfosResponse.getBaseResp());
            throw new RpcException(getUserInfosResponse.getBaseResp());
        }
        Map<Long, UserInfo> userInfoMap = getUserInfosResponse.getUserInfosList().stream().collect(Collectors.toMap(UserInfo::getUserId, userInfo -> userInfo));
        Map<Long, MemberVO> memberVOMap = new HashMap<>();
        getConversationMembersByIdsResponse.getMembersMap().forEach((userId, member) -> {
            MemberVO memberVO = new MemberVO();
            memberVO.setConShortId(member.getConShortId());
            memberVO.setUserId(member.getUserId());
            memberVO.setPrivilege(member.getPrivilege());
            memberVO.setNickname(member.getNickName());
            memberVO.setCreateTime(member.getCreateTime());
            memberVO.setStatus(member.getStatus());
            memberVO.setExtra(member.getExtra());
            UserInfo userInfo = userInfoMap.get(member.getUserId());
            memberVO.setUsername(userInfo == null ? "未知用户" : userInfo.getUsername());
            memberVO.setAvatar(userInfo == null ? "" : userInfo.getAvatar());
            memberVOMap.put(userId, memberVO);
        });
        JSONObject data = new JSONObject();
        data.put("members", memberVOMap);
        return data;
    }

    @Override
    public JSONObject addConversationAgents(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Long conShortId = req.getLong("con_short_id");
        List<Long> agentIds = req.getJSONArray("agent_ids").toJavaList(Long.class);
        AddConversationAgentsRequest addConversationAgentsRequest = AddConversationAgentsRequest.newBuilder()
                .setConShortId(conShortId)
                .addAllAgentIds(agentIds)
                .setOperator(userId)
                .build();
        AddConversationAgentsResponse addConversationAgentsResponse = imStub.addConversationAgents(addConversationAgentsRequest);
        if (addConversationAgentsResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[addConversationAgents] AddConversationAgents rpc err, err = {}", addConversationAgentsResponse.getBaseResp());
            throw new RpcException(addConversationAgentsResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        return data;
    }

    @Override
    public JSONObject removeConversationAgent(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Long conShortId = req.getLong("con_short_id");
        Long agentId = req.getLong("agent_id");
        RemoveConversationAgentRequest removeConversationAgentRequest = RemoveConversationAgentRequest.newBuilder()
                .setConShortId(conShortId)
                .setAgentId(agentId)
                .setOperator(userId)
                .build();
        RemoveConversationAgentResponse removeConversationAgentResponse = imStub.removeConversationAgent(removeConversationAgentRequest);
        if (removeConversationAgentResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[removeConversationAgent] RemoveConversationAgent rpc err, err = {}", removeConversationAgentResponse.getBaseResp());
            throw new RpcException(removeConversationAgentResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        return data;
    }

    @Override
    public JSONObject getConversationAgents(JSONObject req) throws Exception {
        Long conShortId = req.getLong("con_short_id");
        GetConversationAgentsRequest getConversationAgentsRequest = GetConversationAgentsRequest.newBuilder()
                .setConShortId(conShortId)
                .build();
        GetConversationAgentsResponse getConversationAgentsResponse = imStub.getConversationAgents(getConversationAgentsRequest);
        if (getConversationAgentsResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getConversationAgents] GetConversationAgents rpc err, err = {}", getConversationAgentsResponse.getBaseResp());
            throw new RpcException(getConversationAgentsResponse.getBaseResp());
        }
        List<Long> agentIds = getConversationAgentsResponse.getAgentsList().stream().map(ConversationAgentInfo::getAgentId).collect(Collectors.toList());
        GetAgentsByIdsRequest getAgentsByIdsRequest = GetAgentsByIdsRequest.newBuilder()
                .addAllAgentIds(agentIds)
                .build();
        GetAgentsByIdsResponse getAgentsByIdsResponse = aigcStub.getAgentsByIds(getAgentsByIdsRequest);
        if (getAgentsByIdsResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getConversationAgents] GetAgentsByIds rpc err, err = {}", getAgentsByIdsResponse.getBaseResp());
            throw new RpcException(getAgentsByIdsResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        data.put("agents", getAgentsByIdsResponse.getAgentInfosList());
        return data;
    }

    @Override
    public JSONObject getConversationAgentsByIds(JSONObject req) throws Exception {
        Long conShortId = req.getLong("con_short_id");
        List<Long> agentIds = req.getJSONArray("agent_ids").toJavaList(Long.class);
        GetConversationAgentsByIdsRequest getConversationAgentsByIdsRequest = GetConversationAgentsByIdsRequest.newBuilder()
                .setConShortId(conShortId)
                .addAllAgentIds(agentIds)
                .build();
        GetConversationAgentsByIdsResponse getConversationAgentsByIdsResponse = imStub.getConversationAgentsByIds(getConversationAgentsByIdsRequest);
        if (getConversationAgentsByIdsResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getConversationAgentsByIds] GetConversationAgentsByIds rpc err, err = {}", getConversationAgentsByIdsResponse.getBaseResp());
            throw new RpcException(getConversationAgentsByIdsResponse.getBaseResp());
        }
        List<Long> agentIdList = new ArrayList<>(getConversationAgentsByIdsResponse.getAgentsMap().keySet());
        GetAgentsByIdsRequest getAgentsByIdsRequest = GetAgentsByIdsRequest.newBuilder()
                .addAllAgentIds(agentIdList)
                .build();
        GetAgentsByIdsResponse getAgentsByIdsResponse = aigcStub.getAgentsByIds(getAgentsByIdsRequest);
        if (getAgentsByIdsResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getConversationAgentsByIds] GetAgentsByIds rpc err, err = {}", getAgentsByIdsResponse.getBaseResp());
            throw new RpcException(getAgentsByIdsResponse.getBaseResp());
        }
        Map<Long, AgentInfo> agentInfoMap = getAgentsByIdsResponse.getAgentInfosList().stream().collect(Collectors.toMap(AgentInfo::getAgentId, agentInfo -> agentInfo));
        JSONObject data = new JSONObject();
        data.put("agents", agentInfoMap);
        return data;
    }
}
