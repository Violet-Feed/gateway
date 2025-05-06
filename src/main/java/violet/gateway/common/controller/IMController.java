package violet.gateway.common.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import violet.gateway.common.proto_gen.common.StatusCode;
import violet.gateway.common.service.IMService;
import violet.gateway.common.utils.RpcException;

@Slf4j
@RestController
@RequestMapping("/api/im")
public class IMController {
    @Autowired
    private IMService imService;

    @PostMapping("/send_message")
    public JSONObject sendMessage(@RequestBody JSONObject req) {
        JSONObject resp = new JSONObject();
        try {
            JSONObject data = imService.sendMessage(req);
            resp.put("code", StatusCode.Success_VALUE);
            resp.put("message", StatusCode.Success);
            resp.put("data", data);
        } catch (RpcException e) {
            resp.put("code", e.getStatus().getStatusCodeValue());
            resp.put("message", e.getStatus().getStatusCode());
        } catch (NullPointerException e) {
            resp.put("code", StatusCode.Param_Error_VALUE);
            resp.put("message", StatusCode.Param_Error);
            log.error("[sendMessage] err, err = {}", e.toString());
        } catch (Exception e) {
            resp.put("code", StatusCode.Unknown_Error_VALUE);
            resp.put("message", StatusCode.Unknown_Error);
            log.error("[sendMessage] err, err = {}", e.toString());
        }
        return resp;
    }

    @PostMapping("/get_message_by_user")
    public JSONObject getMessageByUser(@RequestBody JSONObject req) {
        JSONObject resp = new JSONObject();
        try {
            JSONObject data = imService.getMessageByUser(req);
            resp.put("code", StatusCode.Success_VALUE);
            resp.put("message", StatusCode.Success);
            resp.put("data", data);
        } catch (RpcException e) {
            resp.put("code", e.getStatus().getStatusCodeValue());
            resp.put("message", e.getStatus().getStatusCode());
        } catch (NullPointerException e) {
            resp.put("code", StatusCode.Param_Error_VALUE);
            resp.put("message", StatusCode.Param_Error);
            log.error("[getMessageByUser] err, err = {}", e.toString());
        } catch (Exception e) {
            resp.put("code", StatusCode.Unknown_Error_VALUE);
            resp.put("message", StatusCode.Unknown_Error);
            log.error("[getMessageByUser] err, err = {}", e.toString());
        }
        return resp;
    }

    @PostMapping("/get_command_by_user")
    public JSONObject getCommandByUser(@RequestBody JSONObject req) {
        JSONObject resp = new JSONObject();
        try {
            JSONObject data = imService.getCommandByUser(req);
            resp.put("code", StatusCode.Success_VALUE);
            resp.put("message", StatusCode.Success);
            resp.put("data", data);
        } catch (RpcException e) {
            resp.put("code", e.getStatus().getStatusCodeValue());
            resp.put("message", e.getStatus().getStatusCode());
        } catch (NullPointerException e) {
            resp.put("code", StatusCode.Param_Error_VALUE);
            resp.put("message", StatusCode.Param_Error);
            log.error("[getCommandByUser] err, err = {}", e.toString());
        } catch (Exception e) {
            resp.put("code", StatusCode.Unknown_Error_VALUE);
            resp.put("message", StatusCode.Unknown_Error);
            log.error("[getCommandByUser] err, err = {}", e.toString());
        }
        return resp;
    }

    @PostMapping("/get_message_by_conversation")
    public JSONObject getMessageByConversation(@RequestBody JSONObject req) {
        JSONObject resp = new JSONObject();
        try {
            JSONObject data = imService.getMessageByConversation(req);
            resp.put("code", StatusCode.Success_VALUE);
            resp.put("message", StatusCode.Success);
            resp.put("data", data);
        } catch (RpcException e) {
            resp.put("code", e.getStatus().getStatusCodeValue());
            resp.put("message", e.getStatus().getStatusCode());
        } catch (NullPointerException e) {
            resp.put("code", StatusCode.Param_Error_VALUE);
            resp.put("message", StatusCode.Param_Error);
            log.error("[getMessageByConversation] err, err = {}", e.toString());
        } catch (Exception e) {
            resp.put("code", StatusCode.Unknown_Error_VALUE);
            resp.put("message", StatusCode.Unknown_Error);
            log.error("[getMessageByConversation] err, err = {}", e.toString());
        }
        return resp;
    }

    @PostMapping("/mark_read")
    public JSONObject markRead(@RequestBody JSONObject req) {
        JSONObject resp = new JSONObject();
        try {
            JSONObject data = imService.markRead(req);
            resp.put("code", StatusCode.Success_VALUE);
            resp.put("message", StatusCode.Success);
            resp.put("data", data);
        } catch (RpcException e) {
            resp.put("code", e.getStatus().getStatusCodeValue());
            resp.put("message", e.getStatus().getStatusCode());
        } catch (NullPointerException e) {
            resp.put("code", StatusCode.Param_Error_VALUE);
            resp.put("message", StatusCode.Param_Error);
            log.error("[markRead] err, err = {}", e.toString());
        } catch (Exception e) {
            resp.put("code", StatusCode.Unknown_Error_VALUE);
            resp.put("message", StatusCode.Unknown_Error);
            log.error("[markRead] err, err = {}", e.toString());
        }
        return resp;
    }

    @PostMapping("/get_members_read_index")
    public JSONObject getMembersReadIndex(@RequestBody JSONObject req) {
        JSONObject resp = new JSONObject();
        try {
            JSONObject data = imService.getMembersReadIndex(req);
            resp.put("code", StatusCode.Success_VALUE);
            resp.put("message", StatusCode.Success);
            resp.put("data", data);
        } catch (RpcException e) {
            resp.put("code", e.getStatus().getStatusCodeValue());
            resp.put("message", e.getStatus().getStatusCode());
        } catch (NullPointerException e) {
            resp.put("code", StatusCode.Param_Error_VALUE);
            resp.put("message", StatusCode.Param_Error);
            log.error("[getMembersReadIndex] err, err = {}", e.toString());
        } catch (Exception e) {
            resp.put("code", StatusCode.Unknown_Error_VALUE);
            resp.put("message", StatusCode.Unknown_Error);
            log.error("[getMembersReadIndex] err, err = {}", e.toString());
        }
        return resp;
    }

    @PostMapping("/create_conversation")
    public JSONObject createConversation(@RequestBody JSONObject req) {
        JSONObject resp = new JSONObject();
        try {
            JSONObject data = imService.createConversation(req);
            resp.put("code", StatusCode.Success_VALUE);
            resp.put("message", StatusCode.Success);
            resp.put("data", data);
        } catch (RpcException e) {
            resp.put("code", e.getStatus().getStatusCodeValue());
            resp.put("message", e.getStatus().getStatusCode());
        } catch (NullPointerException e) {
            resp.put("code", StatusCode.Param_Error_VALUE);
            resp.put("message", StatusCode.Param_Error);
            log.error("[createConversation] err, err = {}", e.toString());
        } catch (Exception e) {
            resp.put("code", StatusCode.Unknown_Error_VALUE);
            resp.put("message", StatusCode.Unknown_Error);
            log.error("[createConversation] err, err = {}", e.toString());
        }
        return resp;
    }

    @PostMapping("/get_conversation_info")
    public JSONObject getConversationInfo(@RequestBody JSONObject req) {
        JSONObject resp = new JSONObject();
        try {
            JSONObject data = imService.getConversationInfo(req);
            resp.put("code", StatusCode.Success_VALUE);
            resp.put("message", StatusCode.Success);
            resp.put("data", data);
        } catch (RpcException e) {
            resp.put("code", e.getStatus().getStatusCodeValue());
            resp.put("message", e.getStatus().getStatusCode());
        } catch (NullPointerException e) {
            resp.put("code", StatusCode.Param_Error_VALUE);
            resp.put("message", StatusCode.Param_Error);
            log.error("[getConversationInfo] err, err = {}", e.toString());
        } catch (Exception e) {
            resp.put("code", StatusCode.Unknown_Error_VALUE);
            resp.put("message", StatusCode.Unknown_Error);
            log.error("[getConversationInfo] err, err = {}", e.toString());
        }
        return resp;
    }
}
