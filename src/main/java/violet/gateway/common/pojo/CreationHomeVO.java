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
public class CreationHomeVO {
    private Long creationId;
    private Integer materialType;
    private String coverUrl;
    private String title;
    private Long createTime;
    private Long userId;
    private String username;
    private String avatar;
    private Long diggCount;
    private Boolean isDigg;
}
