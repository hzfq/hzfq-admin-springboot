package top.hzfq.admin.service;

import org.springframework.stereotype.Service;
import top.hzfq.admin.domain.User;

/**
 * @author hzfq
 * @email huzhifengqing@qq.com
 * @date 2020/5/2
 */
@Service
public class UserService {

    public User getUserByUsername(String username) {

        return new User();
    }
}
