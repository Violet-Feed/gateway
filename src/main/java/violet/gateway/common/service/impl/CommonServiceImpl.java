package violet.gateway.common.service.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import violet.gateway.common.service.CommonService;
import violet.gateway.common.utils.OSSUtil;
import violet.gateway.common.utils.SnowFlake;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
@Service
public class CommonServiceImpl implements CommonService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    private final SnowFlake imageIdGenerator = new SnowFlake(0, 0);
    private final String USER_AVATAR_OSS_PATH = "avatar/user/%d.%s";
    private final String CONV_AVATAR_OSS_PATH = "avatar/conversation/%d.%s";
    private final String AGENT_AVATAR_OSS_PATH = "avatar/agent/%d.%s";
    private final String SOURCE_OSS_PATH = "material/source/%d.%s";
    private final String IMAGE_MESSAGE_OSS_PATH = "message/image/%d.%s";
    private final String VIDEO_MESSAGE_OSS_PATH = "message/video/%d.%s";
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
                ossPath = String.format(USER_AVATAR_OSS_PATH, imageId, "png");
                break;
            case "conv_avatar":
                ossPath = String.format(CONV_AVATAR_OSS_PATH, imageId, "png");
                break;
            case "agent_avatar":
                ossPath = String.format(AGENT_AVATAR_OSS_PATH, imageId, "png");
                break;
            case "material_source":
                ossPath = String.format(SOURCE_OSS_PATH, imageId, "png");
                break;
            case "image_message":
                ossPath = String.format(IMAGE_MESSAGE_OSS_PATH, imageId, "png");
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
            log.error("[uploadImage] Failed to read file input stream: {}", e.getMessage());
            throw e;
        }
    }

    private String resolveExt(String fileName, String contentType, String defaultExt) {
        if (fileName != null && !fileName.isEmpty()) {
            String lower = fileName.toLowerCase();
            int index = lower.lastIndexOf('.');
            if (index >= 0 && index < lower.length() - 1) {
                String ext = lower.substring(index + 1);
                if (ext.matches("[a-z0-9]{1,8}")) {
                    return ext;
                }
            }
        }
        if (contentType != null && !contentType.isEmpty()) {
            String ct = contentType.toLowerCase();
            if (ct.contains("jpeg")) return "jpg";
            if (ct.contains("png")) return "png";
            if (ct.contains("webp")) return "webp";
            if (ct.contains("gif")) return "gif";
            if (ct.contains("mp4")) return "mp4";
            if (ct.contains("quicktime")) return "mov";
            if (ct.contains("x-m4v")) return "m4v";
            if (ct.contains("webm")) return "webm";
        }
        return defaultExt;
    }

    private void checkAllowedExt(String ext, String... allowedExts) {
        if (ext == null) {
            throw new IllegalArgumentException("不支持的文件格式");
        }
        String lowerExt = ext.toLowerCase();
        for (String allowedExt : allowedExts) {
            if (lowerExt.equals(allowedExt)) {
                return;
            }
        }
        throw new IllegalArgumentException("不支持的文件格式");
    }

    public JSONObject getUploadToken(JSONObject req) throws Exception {
        Long imageId = imageIdGenerator.nextId();
        String type = req.getString("type");
        String fileName = req.getString("file_name");
        String contentType = req.getString("content_type");
        String ossPath;
        long maxSize;
        String ext;
        switch (type) {
            case "user_avatar":
                ext = resolveExt(fileName, contentType, "png");
                ossPath = String.format(USER_AVATAR_OSS_PATH, imageId, ext);
                maxSize = 10L * 1024 * 1024;
                break;
            case "conv_avatar":
                ext = resolveExt(fileName, contentType, "png");
                ossPath = String.format(CONV_AVATAR_OSS_PATH, imageId, ext);
                maxSize = 10L * 1024 * 1024;
                break;
            case "agent_avatar":
                ext = resolveExt(fileName, contentType, "png");
                ossPath = String.format(AGENT_AVATAR_OSS_PATH, imageId, ext);
                maxSize = 10L * 1024 * 1024;
                break;
            case "material_source": {
                ext = resolveExt(fileName, contentType, "png");
                checkAllowedExt(ext, "jpg", "jpeg", "png", "webp", "gif");
                ossPath = String.format(SOURCE_OSS_PATH, imageId, ext);
                maxSize = 10L * 1024 * 1024;
                break;
            }
            case "image_message": {
                ext = resolveExt(fileName, contentType, "png");
                checkAllowedExt(ext, "jpg", "jpeg", "png", "webp", "gif");
                ossPath = String.format(IMAGE_MESSAGE_OSS_PATH, imageId, ext);
                maxSize = 10L * 1024 * 1024;
                break;
            }
            case "video_message": {
                ext = resolveExt(fileName, contentType, "mp4");
                checkAllowedExt(ext, "mp4", "mov", "m4v", "webm");
                ossPath = String.format(VIDEO_MESSAGE_OSS_PATH, imageId, ext);
                maxSize = 100L * 1024 * 1024;
                break;
            }
            case "emoji": {
                ext = resolveExt(fileName, contentType, "png");
                checkAllowedExt(ext, "jpg", "jpeg", "png", "webp", "gif");
                ossPath = String.format(EMOJI_OSS_PATH, imageId, ext);
                maxSize = 10L * 1024 * 1024;
                break;
            }
            default:
                log.error("Unsupported upload type: {}", type);
                throw new NullPointerException("Unsupported upload type: " + type);
        }
        return OSSUtil.generateUploadToken(ossPath, maxSize);
    }

    @Override
    public JSONObject checkVersion(JSONObject req) throws Exception {
        String version = redisTemplate.opsForValue().get("latest_version");
        if (version == null || version.isEmpty()) {
            log.error("[checkVersion] Latest version not found in Redis");
            throw new NullPointerException("Latest version not found in Redis");
        }
        return JSONObject.parseObject(version);
    }
}
