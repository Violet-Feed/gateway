package violet.gateway.common.pojo;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CommentVO {
    private Long commentId;
    private Integer contentType;
    private String content;
    private Long userId;
    private String username;
    private String avatar;
    private Long sibUserId;
    private String sibUsername;
    private Long createTime;
    private Long replyCount;
    private Long diggCount;
    private Boolean isDigg;
}
