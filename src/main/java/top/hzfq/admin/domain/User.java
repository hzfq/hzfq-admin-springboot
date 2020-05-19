package top.hzfq.admin.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author hzfq
 * @email huzhifengqing@qq.com
 * @date 2020/5/2
 */
@Data
public class User {

    private Integer userId;
    private String username;
    private String password;
    private LocalDateTime registered; //×¢²áÊ±¼ä
}
