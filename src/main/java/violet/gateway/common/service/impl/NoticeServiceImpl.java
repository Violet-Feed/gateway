package violet.gateway.common.service.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import violet.gateway.common.proto_gen.common.StatusCode;
import violet.gateway.common.proto_gen.im.*;
import violet.gateway.common.service.NoticeService;
import violet.gateway.common.utils.CustomAuthenticationToken;
import violet.gateway.common.utils.RpcException;

@Slf4j
@Service
public class NoticeServiceImpl implements NoticeService {
    @GrpcClient("im")
    private IMServiceGrpc.IMServiceBlockingStub imStub;

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
        JSONObject data = new JSONObject();
        data.put("notices", getNoticeListResponse.getNoticesList());
        return data;
    }

    @Override
    public JSONObject getNoticeMergeList(JSONObject req) throws Exception {
        Long noticeId = req.getLong("notice_id");
        Long page = req.getLong("page");
        GetNoticeMergeListRequest getNoticeMergeListRequest = GetNoticeMergeListRequest.newBuilder().setNoticeId(noticeId).setPage(page).build();
        GetNoticeMergeListResponse getNoticeMergeListResponse = imStub.getNoticeMergeList(getNoticeMergeListRequest);
        if (getNoticeMergeListResponse.getBaseResp().getStatusCode() != StatusCode.Success) {
            log.error("[getNoticeMergeList] GetNoticeMergeList rpc err, err = {}", getNoticeMergeListResponse.getBaseResp());
            throw new RpcException(getNoticeMergeListResponse.getBaseResp());
        }
        JSONObject data = new JSONObject();
        data.put("notices", getNoticeMergeListResponse.getMergesList());
        return data;
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
        data.put("count", getNoticeCountResponse.getNoticeCount());
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
}
