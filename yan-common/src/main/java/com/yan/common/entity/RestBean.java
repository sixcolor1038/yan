package com.yan.common.entity;

public class RestBean<T> {
    private int code;
    private T message;
    private boolean status;

    private RestBean() {
    }

    private RestBean(int code, T message, boolean status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }

    public static <T> RestBean<T> success() {
        return new RestBean<>(200, null, true);
    }

    public static <T> RestBean<T> success(T data) {
        return new RestBean<>(200, data, true);
    }

    public static <T> RestBean<T> fail(int code) {
        return new RestBean<>(code, null, false);
    }

    public static <T> RestBean<T> fail(int code, T data) {
        return new RestBean<>(code, data, false);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
