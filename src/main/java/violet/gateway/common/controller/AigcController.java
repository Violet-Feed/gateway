package violet.gateway.common.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import violet.gateway.common.proto_gen.common.StatusCode;
import violet.gateway.common.service.AigcService;
import violet.gateway.common.utils.RpcException;

@Slf4j
@RestController
@RequestMapping("/api/aigc")
public class AigcController {
    @Autowired
    private AigcService creationService;

    @PostMapping("/create_material")
    public JSONObject createMaterial(@RequestBody JSONObject req) {
        JSONObject resp = new JSONObject();
        try {
            JSONObject data = creationService.createMaterial(req);
            resp.put("code", StatusCode.Success_VALUE);
            resp.put("message", StatusCode.Success);
            resp.put("data", data);
        } catch (RpcException e) {
            resp.put("code", e.getStatus().getStatusCodeValue());
            resp.put("message", e.getStatus().getStatusCode());
        } catch (NullPointerException e) {
            resp.put("code", StatusCode.Param_Error_VALUE);
            resp.put("message", StatusCode.Param_Error);
            log.error("[createMaterial] err, err = {}", e.toString());
        } catch (Exception e) {
            resp.put("code", StatusCode.Unknown_Error_VALUE);
            resp.put("message", StatusCode.Unknown_Error);
            log.error("[createMaterial] err, err = {}", e.toString());
        }
        return resp;
    }

    @PostMapping("/video_material_callback")
    public JSONObject videoMaterialCallback(@RequestBody JSONObject req) {
        return creationService.videoMaterialCallback(req);
    }

    @PostMapping("/create_creation")
    public JSONObject createCreation(@RequestBody JSONObject req) {
        JSONObject resp = new JSONObject();
        try {
            JSONObject data = creationService.createCreation(req);
            resp.put("code", StatusCode.Success_VALUE);
            resp.put("message", StatusCode.Success);
            resp.put("data", data);
        } catch (RpcException e) {
            resp.put("code", e.getStatus().getStatusCodeValue());
            resp.put("message", e.getStatus().getStatusCode());
        } catch (NullPointerException e) {
            resp.put("code", StatusCode.Param_Error_VALUE);
            resp.put("message", StatusCode.Param_Error);
            log.error("[createCreation] err, err = {}", e.toString());
        } catch (Exception e) {
            resp.put("code", StatusCode.Unknown_Error_VALUE);
            resp.put("message", StatusCode.Unknown_Error);
            log.error("[createCreation] err, err = {}", e.toString());
        }
        return resp;
    }
}
