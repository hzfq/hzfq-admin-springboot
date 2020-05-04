package top.hzfq.admin.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 日志切面
 *
 * @author hzfq
 * @email huzhifengqing@qq.com
 * @date 2020/4/9
 */
@Configuration
@Aspect
@Slf4j
public class LoggerAspect {

    @Pointcut("execution(* top.hzfq.admin.controller.*.*(..))")
    public void logPrint() {
    }

    @Before("logPrint()")
    public void before(JoinPoint point) throws JsonProcessingException {
        StringBuilder logStr = new StringBuilder();
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        logStr.append("Request IP: ");
        logStr.append(req.getRemoteAddr());
        logStr.append(", URI: ");
        logStr.append(req.getRequestURI());
        Signature signature = point.getSignature();
        logStr.append(", Class: ");
        logStr.append(signature.getDeclaringTypeName());
        logStr.append(", Method: ");
        logStr.append(signature.getName());
        Object[] args = point.getArgs();
        if (args.length > 0) {
            logStr.append(", ");
            for (int i = 0; i < args.length; i++) {
                logStr.append("Param_");
                logStr.append(i);
                logStr.append(": ");
                logStr.append(new ObjectMapper().writeValueAsString(args[i]));
                logStr.append(", ");
            }
        }
        logStr.deleteCharAt(logStr.lastIndexOf(",")).deleteCharAt(logStr.lastIndexOf(" "));
        log.info(logStr.toString());
    }
}
