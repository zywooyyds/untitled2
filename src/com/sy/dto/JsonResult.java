package com.sy.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonResult {
    /**状态码，这个状态码要和最终的HTTP状态码保持一致**/
    private Integer code;
    /**当出现错误的时候的错误信息**/
    private String errMsg;
    /**操作完毕后要携带的数据**/
    private Object data;

    public Integer getCode() {
        return code;
    }

    public JsonResult setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public JsonResult setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public JsonResult setData(Object data) {
        this.data = data;
        return this;
    }
}

