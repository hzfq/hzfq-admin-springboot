package top.hzfq.admin.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerInterceptor;
import top.hzfq.admin.domain.User;
import top.hzfq.admin.model.ResultEnum;
import top.hzfq.admin.model.ResultModel;
import top.hzfq.admin.service.UserService;
import top.hzfq.admin.util.Constants;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * 登录拦截器
 *
 * @author hzfq
 * @email huzhifengqing@qq.com
 * @date 2020/5/2
 */
@Configuration
public class LoginInterceptor implements HandlerInterceptor {

    @Resource
    private ObjectMapper objectMapper;
    @Resource
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String username = (String) request.getSession().getAttribute(Constants.SESSION_USER);
        if (StringUtils.isBlank(username)) {
            reject(response, ResultEnum.USER_NOT_LOGIN);
            return false;
        }
        User user = userService.getUserByUsername(username);
        if (user == null) {
            reject(response, ResultEnum.USER_ERROR);
            return false;
        }
        return true;
    }

    private void reject(HttpServletResponse res, ResultEnum resultEnum) throws Exception {
        res.reset();
        res.setContentType(MediaType.APPLICATION_JSON_VALUE);
        res.setHeader(HttpHeaders.CACHE_CONTROL, "no-store");
        res.setCharacterEncoding(StandardCharsets.UTF_8.name());
        PrintWriter writer = res.getWriter();
        writer.write(objectMapper.writeValueAsString(ResultModel.apply(resultEnum)));
        writer.flush();
    }
}
