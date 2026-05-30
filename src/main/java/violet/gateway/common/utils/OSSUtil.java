package violet.gateway.common.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

@Slf4j
@Component
public class OSSUtil {
    private static String endpoint;
    private static String region;
    private static String bucketName;
    private static String accessKeyId;
    private static String accessKeySecret;

    @Value("${aliyun.oss.endpoint}")
    public void setEndpoint(String endpoint) {
        OSSUtil.endpoint = endpoint;
    }

    @Value("${aliyun.oss.region}")
    public void setRegion(String region) {
        OSSUtil.region = region;
    }

    @Value("${aliyun.oss.bucket-name}")
    public void setBucketName(String bucketName) {
        OSSUtil.bucketName = bucketName;
    }

    @Value("${aliyun.oss.access-key-id:}")
    public void setAccessKeyId(String accessKeyId) {
        OSSUtil.accessKeyId = accessKeyId;
    }

    @Value("${aliyun.oss.access-key-secret:}")
    public void setAccessKeySecret(String accessKeySecret) {
        OSSUtil.accessKeySecret = accessKeySecret;
    }

    public static JSONObject generateUploadToken(String ossPath, long maxSize) throws Exception {
        long expireSeconds = 300L;
        String expiration = DateTimeFormatter.ISO_INSTANT.format(Instant.now().plusSeconds(expireSeconds));

        JSONObject policy = new JSONObject();
        policy.put("expiration", expiration);

        JSONArray conditions = new JSONArray();

        JSONArray sizeCondition = new JSONArray();
        sizeCondition.add("content-length-range");
        sizeCondition.add(0);
        sizeCondition.add(maxSize);
        conditions.add(sizeCondition);

        JSONArray keyCondition = new JSONArray();
        keyCondition.add("eq");
        keyCondition.add("$key");
        keyCondition.add(ossPath);
        conditions.add(keyCondition);

        JSONArray statusCondition = new JSONArray();
        statusCondition.add("eq");
        statusCondition.add("$success_action_status");
        statusCondition.add("200");
        conditions.add(statusCondition);

        policy.put("conditions", conditions);
        String policyText = policy.toJSONString();
        String encodedPolicy = Base64.getEncoder().encodeToString(policyText.getBytes(StandardCharsets.UTF_8));
        String signature = hmacSha1Base64(accessKeySecret, encodedPolicy);

        String ossAccessUrl = String.format("https://%s.%s",
                bucketName,
                endpoint.replace("https://", ""));

        JSONObject data = new JSONObject();
        data.put("host", ossAccessUrl);
        data.put("accessId", accessKeyId);
        data.put("policy", encodedPolicy);
        data.put("signature", signature);
        data.put("key", ossPath);
        data.put("url", ossAccessUrl + '/' + ossPath);
        data.put("securityToken", null);

        return data;
    }

    private static String hmacSha1Base64(String secret, String data) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA1"));
        byte[] signData = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(signData);
    }

}
