package top.hzfq.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import top.hzfq.admin.domain.User;
import top.hzfq.admin.model.ResultEnum;
import top.hzfq.admin.model.ResultModel;
import top.hzfq.admin.util.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

/**
 * @author hzfq
 * @email huzhifengqing@qq.com
 * @date 2020/5/2
 */
@RestController
public class UserController {

    @PostMapping("/login")
    public ResultModel login(@RequestBody User user) {
        //todo:验证参数

        //todo:添加会话
        HttpSession session = ((HttpServletRequest) RequestContextHolder.getRequestAttributes()).getSession();
        session.setAttribute(Constants.SESSION_USER, user.getUsername());

        return ResultModel.apply(ResultEnum.SUCCESS,user);
    }

    @PostMapping("/logout")
    public ResultModel logout(@RequestBody User user) {
        //todo:验证参数

        //todo:删除会话
        HttpSession session = ((HttpServletRequest) RequestContextHolder.getRequestAttributes()).getSession();
        session.removeAttribute(Constants.SESSION_USER);

        return ResultModel.apply(ResultEnum.SUCCESS);
    }
    @GetMapping("/getUser")
    public ResultModel getUser() {
        User user = new User();
        user.setUserId(1);
        user.setUsername("Jack");
        user.setPassword("123456");
        user.setRegistered(LocalDateTime.now());
        return ResultModel.apply(ResultEnum.SUCCESS, user);
    }
}
