package top.hzfq.admin.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import top.hzfq.admin.model.PageModel;
import top.hzfq.admin.model.ResultEnum;
import top.hzfq.admin.model.ResultModel;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author hzfq
 * @email huzhifengqing@qq.com
 * @date 2020/4/9
 */
@RequestMapping("/admin")
@RestController
public class DemoController {

    @Resource
    private ObjectMapper objectMapper;

    @GetMapping(value = "/test")
    public ResultModel<String> test() {
        return ResultModel.apply(ResultEnum.SUCCESS, "test");
    }

    @GetMapping(value = "/test2")
    public String test2() throws JsonProcessingException {
        return objectMapper.writeValueAsString("test2");
    }

    @GetMapping(value = "/hello")
    public String hello(String username) {
        return "Hello, " + username + ", Good Nice!";
    }

    @PostMapping(value = "/getNumbers")
    public List<Integer> getNumbers(@RequestBody PageModel pageModel) {
        return Arrays.asList(1, 2, 3, 4, 5);
    }
}
