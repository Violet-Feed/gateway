package violet.gateway.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    private Long userId;
    private String username;
    private String avatar;
    private Long followingCount;
    private Long followerCount;
    private Long friendCount;
    private Boolean isFollowing;
    private Boolean isFollower;
}
