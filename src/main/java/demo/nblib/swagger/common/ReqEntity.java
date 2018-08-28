package demo.nblib.swagger.common;

import io.swagger.annotations.ApiModelProperty;

/**
 * 响应结果集
 */
public class ReqEntity<T> {

    @ApiModelProperty(value = "响应信息")
    private String msg;

    @ApiModelProperty(value = "响应状态码")
    private Integer code;

    @ApiModelProperty(value = "返回对象")
    private T data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
