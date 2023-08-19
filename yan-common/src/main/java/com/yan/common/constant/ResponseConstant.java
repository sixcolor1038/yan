package com.yan.common.constant;

public enum ResponseConstant {

    SUCCESS("000", "操作成功"),
    ERROR("-1", "操作失败");


    private final String code;
    private final String message;

    ResponseConstant(String code, String message) {
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
