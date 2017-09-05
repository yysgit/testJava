package com.yys.common.returnCode;

import com.yys.common.enums.HttpCodeEnum;

import java.io.Serializable;
import java.util.HashMap;

/**
 * User: 杨永生
 * Date: 11:06 2017/9/1
 * Email: 1095737364@qq.com
 * 数据请求返回值:JSON返回值,包装code,指定code码:HttpCodeEnum
 */
public class HttpResponse<T> implements Serializable {
    private String code = "";
    private String message = "";
    private T body;

    public HttpResponse() {
    }

    /*
    * 请求成功返回:200
    * */
    public HttpResponse success(String message, T body) {
        this.code = HttpCodeEnum.SUCCESS.toCode();
        this.message = message;
        this.body = body;
        return this;
    }

    /*
      * 请求失败返回:300
      * */
    public HttpResponse failed(String message, T body) {
        this.code = HttpCodeEnum.FAILED.toCode();
        this.message = message;
        this.body = body;
        return this;
    }

    /*
        * 请求检测返回:400
        * */
    public HttpResponse check(String message, T body) {
        this.code = HttpCodeEnum.CHECK.toCode();
        this.message = message;
        this.body = body;
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getBody() {
        if (body == null) {
            return new HashMap();
        }
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
