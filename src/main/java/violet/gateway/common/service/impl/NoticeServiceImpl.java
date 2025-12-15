package violet.gateway.common.service.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import violet.gateway.common.pojo.NoticeVO;
import violet.gateway.common.proto_gen.action.ActionServiceGrpc;
import violet.gateway.common.proto_gen.action.GetUserInfosRequest;
import violet.gateway.common.proto_gen.action.GetUserInfosResponse;
import violet.gateway.common.proto_gen.action.UserInfo;
import violet.gateway.common.proto_gen.aigc.AigcServiceGrpc;
import violet.gateway.common.proto_gen.aigc.Creation;
import violet.gateway.common.proto_gen.aigc.GetCreationByIdsRequest;
import violet.gateway.common.proto_gen.aigc.GetCreationByIdsResponse;
import violet.gateway.common.proto_gen.common.StatusCode;
import violet.gateway.common.proto_gen.im.*;
import violet.gateway.common.service.NoticeService;
import violet.gateway.common.utils.CustomAuthenticationToken;
import violet.gateway.common.utils.RpcException;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class NoticeServiceImpl implements NoticeService {
    @GrpcClient("im")
    private IMServiceGrpc.IMServiceBlockingStub imStub;
    @GrpcClient("action")
    private ActionServiceGrpc.ActionServiceBlockingStub actionStub;
    @GrpcClient("aigc")
    private AigcServiceGrpc.AigcServiceBlockingStub aigcStub;

    @Override
    public JSONObject getNoticeList(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Integer group = req.getInteger("group");
        Long page = req.getLong("page");
        GetNoticeListRequest getNoticeListRequest = GetNoticeListRequest.newBuilder().setUserId(userId).setGroup(group).setPage(page).build();
        GetNoticeListResponse getNoticeListResponse = imStub.getNoticeList(getNoticeListRequest);
        if (getNoticeListResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getNoticeList] GetNoticeList rpc err, err = {}", getNoticeListResponse.getBaseResp());
            throw new RpcException(getNoticeListResponse.getBaseResp());
        }
        try {
            List<NoticeVO> noticeVOList = fillNoticeInfo(group, getNoticeListResponse.getNoticesList());
            JSONObject data = new JSONObject();
            data.put("notices", noticeVOList);
            return data;
        } catch (RpcException e) {
            log.error("[getNoticeList] fillNoticeInfo err, err = {}", e.toString());
            throw new Exception("fillNoticeInfo error");
        }
    }

    @Override
    public JSONObject getNoticeAggList(JSONObject req) throws Exception {
        Long noticeId = req.getLong("notice_id");
        Long page = req.getLong("page");
        GetNoticeAggListRequest getNoticeAggListRequest = GetNoticeAggListRequest.newBuilder().setNoticeId(noticeId).setPage(page).build();
        GetNoticeAggListResponse getNoticeAggListResponse = imStub.getNoticeAggList(getNoticeAggListRequest);
        if (getNoticeAggListResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getNoticeAggList] GetNoticeAggList rpc err, err = {}", getNoticeAggListResponse.getBaseResp());
            throw new RpcException(getNoticeAggListResponse.getBaseResp());
        }
        try {
            List<NoticeVO> noticeVOList = fillNoticeInfo(getNoticeAggListResponse.getNoticesList());
            JSONObject data = new JSONObject();
            data.put("notices", noticeVOList);
            return data;
        } catch (RpcException e) {
            log.error("[getNoticeAggList] fillNoticeInfo err, err = {}", e.toString());
            throw new Exception("fillNoticeInfo error");
        }
    }

    @Override
    public JSONObject getNoticeCount(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Integer group = req.getInteger("group");
        GetNoticeCountRequest getNoticeCountRequest = GetNoticeCountRequest.newBuilder().setUserId(userId).setGroup(group).build();
        GetNoticeCountResponse getNoticeCountResponse = imStub.getNoticeCount(getNoticeCountRequest);
        if (getNoticeCountResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getNoticeCount] GetNoticeCount rpc err, err = {}", getNoticeCountResponse.getBaseResp());
            throw new RpcException(getNoticeCountResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        data.put("notice_count", getNoticeCountResponse.getNoticeCount());
        return data;
    }

    @Override
    public JSONObject markNoticeRead(JSONObject req) throws Exception {
        CustomAuthenticationToken authentication = (CustomAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Long userId = authentication.getUserId();
        Integer group = req.getInteger("group");
        MarkNoticeReadRequest markNoticeReadRequest = MarkNoticeReadRequest.newBuilder().setUserId(userId).setGroup(group).build();
        MarkNoticeReadResponse markNoticeReadResponse = imStub.markNoticeRead(markNoticeReadRequest);
        if (markNoticeReadResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[markNoticeRead] MarkNoticeRead rpc err, err = {}", markNoticeReadResponse.getBaseResp());
            throw new RpcException(markNoticeReadResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        return data;
    }

    private List<NoticeVO> fillNoticeInfo(Integer group, List<NoticeBody> notices) throws RpcException {
        if (notices.isEmpty()) {
            return Collections.emptyList();
        }
        List<Long> userIds = notices.stream().map(NoticeBody::getSenderId).distinct().collect(Collectors.toList());
        GetUserInfosRequest getUserInfosRequest = GetUserInfosRequest.newBuilder()
                .addAllUserIds(userIds)
                .build();
        GetUserInfosResponse getUserInfosResponse = actionStub.getUserInfos(getUserInfosRequest);
        if (getUserInfosResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[fillNoticeInfo] GetUserInfos rpc err, err = {}", getUserInfosResponse.getBaseResp());
            throw new RpcException(getUserInfosResponse.getBaseResp());
        }
        Map<Long, UserInfo> userInfosMap = getUserInfosResponse.getUserInfosList().stream().collect(Collectors.toMap(UserInfo::getUserId, userInfo -> userInfo));
        Map<Long, Creation> refMap;
        if (NoticeGroup.Action_Group_VALUE == group) {
            List<Long> creationIds = notices.stream().map(NoticeBody::getRefId).distinct().collect(Collectors.toList());
            GetCreationByIdsRequest getCreationByIdsRequest = GetCreationByIdsRequest.newBuilder()
                    .addAllCreationIds(creationIds)
                    .build();
            GetCreationByIdsResponse getCreationByIdsResponse = aigcStub.getCreationByIds(getCreationByIdsRequest);
            if (getCreationByIdsResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
                log.error("[fillNoticeInfo] GetCreationByIdsResponse rpc err, err = {}", getCreationByIdsResponse.getBaseResp());
                throw new RpcException(getCreationByIdsResponse.getBaseResp());
            }
            refMap = getCreationByIdsResponse.getCreationsMap();
        } else {
            refMap = new HashMap<>();
        }
        return notices.stream().map(noticeBody -> {
            NoticeVO noticeVO = new NoticeVO();
            noticeVO.setNoticeId(noticeBody.getNoticeId());
            noticeVO.setNoticeType(noticeBody.getNoticeType());
            noticeVO.setNoticeContent(noticeBody.getNoticeContent());
            noticeVO.setSenderId(noticeBody.getSenderId());
            UserInfo userInfo = userInfosMap.get(noticeBody.getSenderId());
            noticeVO.setSenderUsername(userInfo == null ? "未知用户" : userInfo.getUsername());
            noticeVO.setSenderAvatar(userInfo == null ? "" : userInfo.getAvatar());
            noticeVO.setRefId(noticeBody.getRefId());
            Creation creation = refMap.get(noticeBody.getRefId());
            if (creation != null) {
                noticeVO.setRefType(creation.getMaterialType());
                noticeVO.setRefCoverUrl(creation.getCoverUrl());
                noticeVO.setRefUserId(creation.getUserId());
            }
            noticeVO.setCreateTime(noticeBody.getCreateTime());
            noticeVO.setAggCount(noticeBody.getAggCount());
            return noticeVO;
        }).collect(Collectors.toList());
    }

    private List<NoticeVO> fillNoticeInfo(List<NoticeAggBody> notices) throws RpcException {
        if (notices.isEmpty()) {
            return Collections.emptyList();
        }
        List<Long> userIds = notices.stream().map(NoticeAggBody::getSenderId).distinct().collect(Collectors.toList());
        GetUserInfosRequest getUserInfosRequest = GetUserInfosRequest.newBuilder()
                .addAllUserIds(userIds)
                .build();
        GetUserInfosResponse getUserInfosResponse = actionStub.getUserInfos(getUserInfosRequest);
        if (getUserInfosResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[fillNoticeInfo] GetUserInfos rpc err, err = {}", getUserInfosResponse.getBaseResp());
            throw new RpcException(getUserInfosResponse.getBaseResp());
        }
        Map<Long, UserInfo> userInfosMap = getUserInfosResponse.getUserInfosList().stream().collect(Collectors.toMap(UserInfo::getUserId, userInfo -> userInfo));
        return notices.stream().map(noticeBody -> {
            NoticeVO noticeVO = new NoticeVO();
            noticeVO.setSenderId(noticeBody.getSenderId());
            UserInfo userInfo = userInfosMap.get(noticeBody.getSenderId());
            noticeVO.setSenderUsername(userInfo == null ? "未知用户" : userInfo.getUsername());
            noticeVO.setSenderAvatar(userInfo == null ? "" : userInfo.getAvatar());
            noticeVO.setCreateTime(noticeBody.getCreateTime());
            return noticeVO;
        }).collect(Collectors.toList());
    }
}
