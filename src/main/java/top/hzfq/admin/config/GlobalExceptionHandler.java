package top.hzfq.admin.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import top.hzfq.admin.model.ResultEnum;
import top.hzfq.admin.model.ResultModel;

/**
 * 全局异常处理器
 *
 * @author hzfq
 * @email huzhifengqing@qq.com
 * @date 2020/5/2
 */
@ControllerAdvice
@Configuration
public class GlobalExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(JsonProcessingException.class)
    public ResultModel jsonProcessingException(JsonProcessingException e) {
        logger.error(e.toString());
        return ResultModel.apply(ResultEnum.SERVER_ERROR);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResultModel httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        logger.error(e.toString());
        return ResultModel.apply(ResultEnum.SERVER_ERROR);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResultModel nullPointerException(NullPointerException e) {
        logger.error(e.toString());
        return ResultModel.apply(ResultEnum.SERVER_ERROR);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResultModel runtimeException(RuntimeException e) {
        logger.error(e.toString());
        return ResultModel.apply(ResultEnum.SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResultModel exception(Exception e) {
        logger.error(e.toString());
        return ResultModel.apply(ResultEnum.SERVER_ERROR);
    }
}
