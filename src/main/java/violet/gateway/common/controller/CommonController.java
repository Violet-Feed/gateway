package violet.gateway.common.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
    public JSONObject uploadImage(@RequestParam("image") MultipartFile image, @RequestParam("type") String type, @RequestParam("name") String name) {
        JSONObject resp = new JSONObject();
        try {
            JSONObject data = commonService.uploadImage(image, type, name);
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
}
