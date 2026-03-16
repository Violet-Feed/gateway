package violet.gateway.common.service.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import violet.gateway.common.service.CommonService;
import violet.gateway.common.utils.CustomAuthenticationToken;
import violet.gateway.common.utils.OSSUtil;
import violet.gateway.common.utils.SnowFlake;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
@Service
public class CommonServiceImpl implements CommonService {
    private final SnowFlake avatarIdGenerator = new SnowFlake(0, 0);
    private final String USER_AVATAR_OSS_PATH = "avatar/user/%d.png";
    private final String CONV_AVATAR_OSS_PATH = "avatar/conversation/%d.png";
    private final String AGENT_AVATAR_OSS_PATH = "avatar/agent/%d.png";
    private final String SOURCE_OSS_PATH = "material/source/%d.png";

    @Override
    public JSONObject uploadImage(MultipartFile image, String type) throws Exception {
        String ossPath;
        Long avatarId = avatarIdGenerator.nextId();
        switch (type) {
            case "user_avatar":
                ossPath = String.format(USER_AVATAR_OSS_PATH, avatarId);
                break;
            case "conv_avatar":
                ossPath = String.format(CONV_AVATAR_OSS_PATH, avatarId);
                break;
            case "agent_avatar":
                ossPath = String.format(AGENT_AVATAR_OSS_PATH, avatarId);
                break;
            case "material_source":
                ossPath = String.format(SOURCE_OSS_PATH, avatarId);
                break;
            default:
                log.error("Unsupported image type: {}", type);
                throw new NullPointerException("Unsupported image type: " + type);
        }
        try (InputStream in = image.getInputStream()) {
            String sourceUrl = OSSUtil.upload(in, ossPath);
            JSONObject data = new JSONObject();
            data.put("source_url", sourceUrl);
            return data;
        } catch (IOException e) {
            log.error("Failed to read file input stream: {}", e.getMessage());
            throw e;
        }
    }
}
