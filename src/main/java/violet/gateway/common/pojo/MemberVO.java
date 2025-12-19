package violet.gateway.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
    private Long conShortId;
    private Long userId;
    private Integer privilege;
    private String nickname;
    private Long createTime;
    private Integer status;
    private String extra;
    private String username;
    private String avatar;
}
