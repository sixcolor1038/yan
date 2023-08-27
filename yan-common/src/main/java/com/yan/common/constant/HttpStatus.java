package com.yan.common.constant;

public enum HttpStatus {

    SUCCESS("000", "操作成功"),
    FAILED("-1", "操作失败"),
    CREATED("201","对象创建成功"),
    NOT_FOUND("404","资源不存在");

    private final String code;
    private final String message;

    HttpStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
