package top.hzfq.admin.model;

/**
 * @author hzfq
 * @email huzhifengqing@qq.com
 * @date 2020/4/29
 */
public class ResultModel<T> {

    private Integer code;
    private String msg;
    private T content;

    private ResultModel(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
        this.content = null;
    }

    private ResultModel(ResultEnum resultEnum, T content) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
        this.content = content;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getContent() {
        return content;
    }

    public static <T> ResultModel apply(ResultEnum resultEnum) {
        return new ResultModel(resultEnum);
    }

    public static <T> ResultModel apply(ResultEnum resultEnum, T content) {
        return new ResultModel(resultEnum, content);
    }
}
