package violet.gateway.common.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import violet.gateway.common.proto_gen.common.StatusCode;
import violet.gateway.common.service.NoticeService;
import violet.gateway.common.utils.RpcException;

@Slf4j
@RestController
@RequestMapping("/api/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @PostMapping("/get_notice_list")
    public JSONObject getNoticeList(@RequestBody JSONObject req) {
        JSONObject resp = new JSONObject();
        try {
            JSONObject data = noticeService.getNoticeList(req);
            resp.put("code", StatusCode.Success_VALUE);
            resp.put("message", StatusCode.Success);
            resp.put("data", data);
        } catch (RpcException e) {
            resp.put("code", e.getStatus().getStatusCodeValue());
            resp.put("message", e.getStatus().getStatusCode());
        } catch (NullPointerException e) {
            resp.put("code", StatusCode.Param_Error_VALUE);
            resp.put("message", StatusCode.Param_Error);
            log.error("[getNoticeList] err, err = {}", e.toString());
        } catch (Exception e) {
            resp.put("code", StatusCode.Unknown_Error_VALUE);
            resp.put("message", StatusCode.Unknown_Error);
            log.error("[getNoticeList] err, err = {}", e.toString());
        }
        return resp;
    }

    @PostMapping("/get_notice_agg_list")
    public JSONObject getNoticeAggList(@RequestBody JSONObject req) {
        JSONObject resp = new JSONObject();
        try {
            JSONObject data = noticeService.getNoticeAggList(req);
            resp.put("code", StatusCode.Success_VALUE);
            resp.put("message", StatusCode.Success);
            resp.put("data", data);
        } catch (RpcException e) {
            resp.put("code", e.getStatus().getStatusCodeValue());
            resp.put("message", e.getStatus().getStatusCode());
        } catch (NullPointerException e) {
            resp.put("code", StatusCode.Param_Error_VALUE);
            resp.put("message", StatusCode.Param_Error);
            log.error("[getNoticeAggList] err, err = {}", e.toString());
        } catch (Exception e) {
            resp.put("code", StatusCode.Unknown_Error_VALUE);
            resp.put("message", StatusCode.Unknown_Error);
            log.error("[getNoticeAggList] err, err = {}", e.toString());
        }
        return resp;
    }

    @PostMapping("/get_notice_count")
    public JSONObject getNoticeCount(@RequestBody JSONObject req) {
        JSONObject resp = new JSONObject();
        try {
            JSONObject data = noticeService.getNoticeCount(req);
            resp.put("code", StatusCode.Success_VALUE);
            resp.put("message", StatusCode.Success);
            resp.put("data", data);
        } catch (RpcException e) {
            resp.put("code", e.getStatus().getStatusCodeValue());
            resp.put("message", e.getStatus().getStatusCode());
        } catch (NullPointerException e) {
            resp.put("code", StatusCode.Param_Error_VALUE);
            resp.put("message", StatusCode.Param_Error);
            log.error("[getNoticeCount] err, err = {}", e.toString());
        } catch (Exception e) {
            resp.put("code", StatusCode.Unknown_Error_VALUE);
            resp.put("message", StatusCode.Unknown_Error);
            log.error("[getNoticeCount] err, err = {}", e.toString());
        }
        return resp;
    }

    @PostMapping("/mark_notice_read")
    public JSONObject markNoticeRead(@RequestBody JSONObject req) {
        JSONObject resp = new JSONObject();
        try {
            JSONObject data = noticeService.markNoticeRead(req);
            resp.put("code", StatusCode.Success_VALUE);
            resp.put("message", StatusCode.Success);
            resp.put("data", data);
        } catch (RpcException e) {
            resp.put("code", e.getStatus().getStatusCodeValue());
            resp.put("message", e.getStatus().getStatusCode());
        } catch (NullPointerException e) {
            resp.put("code", StatusCode.Param_Error_VALUE);
            resp.put("message", StatusCode.Param_Error);
            log.error("[markNoticeRead] err, err = {}", e.toString());
        } catch (Exception e) {
            resp.put("code", StatusCode.Unknown_Error_VALUE);
            resp.put("message", StatusCode.Unknown_Error);
            log.error("[markNoticeRead] err, err = {}", e.toString());
        }
        return resp;
    }

}
