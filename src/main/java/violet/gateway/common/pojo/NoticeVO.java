package violet.gateway.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeVO {
    private Long noticeId;
    private Integer noticeType;
    private String noticeContent;
    private Long senderId;
    private String senderUsername;
    private String senderAvatar;
    private Long refId;
    private Integer refType;
    private String refCoverUrl;
    private Long refUserId;
    private Long createTime;
    private Long aggCount;
}
