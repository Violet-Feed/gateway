package violet.gateway.common.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.multipart.MultipartFile;

public interface CommonService {
    JSONObject uploadImage(MultipartFile image, String type, String name) throws Exception;
}
