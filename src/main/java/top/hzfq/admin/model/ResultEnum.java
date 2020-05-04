package top.hzfq.admin.model;

/**
 * @author hzfq
 * @email huzhifengqing@qq.com
 * @date 2020/4/29
 */
public enum ResultEnum {

    SUCCESS(2000, "请求成功"),
    PARAM_ERROR(4001, "请求参数错误"),
    USER_NOT_LOGIN(4002, "用户未登录"),
    USER_ERROR(4003, "用户不存在/密码错误"),
    SERVER_ERROR(5001, "服务器处理异常");

    private Integer code;
    private String msg;

    private ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
