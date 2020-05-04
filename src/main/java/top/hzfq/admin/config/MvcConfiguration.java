package top.hzfq.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * 自定义mvc配置
 *
 * @author hzfq
 * @email huzhifengqing@qq.com
 * @date 2020/5/2
 */
@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    @Resource
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/login", "/error", "/static/**", "/**/favicon.ico");
    }
}
