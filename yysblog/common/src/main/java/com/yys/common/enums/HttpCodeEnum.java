package com.yys.common.enums;

/**
 * User: 杨永生
 * Date: 11:09 2017/9/1
 * Email: 1095737364@qq.com
 */
public enum HttpCodeEnum {
    SUCCESS("200"),//成功
    FAILED("300"),//失败
    CHECK("400");//检测，提示
    private String code;
    HttpCodeEnum(String code) {
        this.code = code;
    }
    public String toCode() {
        return code;
    }
}
