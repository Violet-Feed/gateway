package violet.gateway.common.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import violet.gateway.common.proto_gen.common.StatusCode;
import violet.gateway.common.service.CommonService;
import violet.gateway.common.utils.RpcException;

@Slf4j
@RestController
@RequestMapping("/api")
public class CommonController {
    @Autowired
    private CommonService commonService;

    @PostMapping("/upload_image")
    public JSONObject uploadImage(@RequestParam("image") MultipartFile image, @RequestParam("type") String type) {
        JSONObject resp = new JSONObject();
        try {
            JSONObject data = commonService.uploadImage(image, type);
            resp.put("code", StatusCode.Success_VALUE);
            resp.put("message", StatusCode.Success);
            resp.put("data", data);
        } catch (RpcException e) {
            resp.put("code", e.getStatus().getStatusCodeValue());
            resp.put("message", e.getStatus().getStatusCode());
        } catch (NullPointerException e) {
            resp.put("code", StatusCode.Param_Error_VALUE);
            resp.put("message", StatusCode.Param_Error);
            log.error("[uploadImage] err, err = {}", e.toString());
        } catch (Exception e) {
            resp.put("code", StatusCode.Unknown_Error_VALUE);
            resp.put("message", StatusCode.Unknown_Error);
            log.error("[uploadImage] err, err = {}", e.toString());
        }
        return resp;
    }

    @PostMapping("/check_version")
    public JSONObject checkVersion(@RequestBody JSONObject req) {
        JSONObject resp = new JSONObject();
        try {
            JSONObject data = commonService.checkVersion(req);
            resp.put("code", StatusCode.Success_VALUE);
            resp.put("message", StatusCode.Success);
            resp.put("data", data);
        } catch (RpcException e) {
            resp.put("code", e.getStatus().getStatusCodeValue());
            resp.put("message", e.getStatus().getStatusCode());
        } catch (NullPointerException e) {
            resp.put("code", StatusCode.Param_Error_VALUE);
            resp.put("message", StatusCode.Param_Error);
            log.error("[checkVersion] err, err = {}", e.toString());
        } catch (Exception e) {
            resp.put("code", StatusCode.Unknown_Error_VALUE);
            resp.put("message", StatusCode.Unknown_Error);
            log.error("[checkVersion] err, err = {}", e.toString());
        }
        return resp;
    }
}
