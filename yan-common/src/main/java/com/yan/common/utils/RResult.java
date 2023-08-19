package com.yan.common.utils;

import com.yan.common.constant.ResponseConstant;

import java.io.Serializable;

public class RResult<T> implements Serializable {
    private String code;
    private String message;
    private T data;
    private long total;

    public RResult(ResponseConstant error) {
        this(ResponseConstant.SUCCESS.getCode(), ResponseConstant.SUCCESS.getMessage(), null);
    }

    public RResult(String code, T data) {
        this(code, null, data);
    }

    public RResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> RResult<T> error(T message) {
        if (message == null) {
            return new RResult<>(ResponseConstant.ERROR);
        } else {
            return new RResult<>(ResponseConstant.ERROR.getCode(), message);
        }
    }

    public static <T> RResult<T> success(T data) {
        return new RResult<>(ResponseConstant.SUCCESS.getCode(), ResponseConstant.SUCCESS.getMessage(), data);
    }

    public RResult<T> error(String code, String message) {
        this.code = code;
        this.message = message;
        return this;
    }

    public RResult<T> success(String code, T data) {
        this.code = code;
        this.data = data;
        return this;
    }

    public RResult<T> success(String code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "RResult{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", total=" + total +
                '}';
    }
}
