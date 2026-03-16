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
public class AgentVO {
    private Long agentId;
    private String agentName;
    private String avatarUri;
    private String description;
    private String personality;
    private Long ownerId;
    private Long createTime;
    private Integer status;
    private String extra;
    private String ownerUsername;
    private String ownerAvatar;
}
