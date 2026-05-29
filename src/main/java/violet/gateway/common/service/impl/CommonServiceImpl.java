package violet.gateway.common.service.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
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
    private static RedisTemplate<String, String> redisTemplate;
    private final SnowFlake imageIdGenerator = new SnowFlake(0, 0);
    private final String USER_AVATAR_OSS_PATH = "avatar/user/%d.png";
    private final String CONV_AVATAR_OSS_PATH = "avatar/conversation/%d.png";
    private final String AGENT_AVATAR_OSS_PATH = "avatar/agent/%d.png";
    private final String SOURCE_OSS_PATH = "material/source/%d.png";
    private final String IMAGE_MESSAGE_OSS_PATH = "message/image/%d.png";
    private final String VIDEO_MESSAGE_OSS_PATH = "message/video/%d.mp4";
    private final String EMOJI_OSS_PATH = "emoji/%d.%s";

    private String resolveEmojiExt(MultipartFile file) {
        String contentType = file.getContentType();
        if ("image/gif".equalsIgnoreCase(contentType)) {
            return "gif";
        }
        String filename = file.getOriginalFilename();
        if (filename != null && filename.toLowerCase().endsWith(".gif")) {
            return "gif";
        }
        return "png";
    }

    @Override
    public JSONObject uploadImage(MultipartFile image, String type) throws Exception {
        String ossPath;
        Long imageId = imageIdGenerator.nextId();
        switch (type) {
            case "user_avatar":
                ossPath = String.format(USER_AVATAR_OSS_PATH, imageId);
                break;
            case "conv_avatar":
                ossPath = String.format(CONV_AVATAR_OSS_PATH, imageId);
                break;
            case "agent_avatar":
                ossPath = String.format(AGENT_AVATAR_OSS_PATH, imageId);
                break;
            case "material_source":
                ossPath = String.format(SOURCE_OSS_PATH, imageId);
                break;
            case "image_message":
                ossPath = String.format(IMAGE_MESSAGE_OSS_PATH, imageId);
                break;
            case "emoji":
                ossPath = String.format(EMOJI_OSS_PATH, imageId, resolveEmojiExt(image));
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

    @Override
    public JSONObject checkVersion(JSONObject req) throws Exception {
        String version = redisTemplate.opsForValue().get("latest_version");
        if (version == null || version.isEmpty()) {
            log.error("Latest version not found in Redis");
            throw new NullPointerException("Latest version not found in Redis");
        }
        return JSONObject.parseObject(version);
    }
}
