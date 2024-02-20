package com.yan.common.utils;

import com.yan.common.constant.HttpStatus;

import java.io.Serializable;

public class RResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private String code;
    private String message;
    private T data;

    public RResult() {
    }

    public RResult(HttpStatus status) {
        this(HttpStatus.SUCCESS.getCode(), HttpStatus.SUCCESS.getMessage(), null);
    }

    public RResult(String code, T data) {
        this(code, null, data);
    }

    public RResult(String code, String message) {
        this(code, message, null);
    }
    public RResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public static <T> RResult<T> success(T data) {
        return new RResult<>(HttpStatus.SUCCESS.getCode(), HttpStatus.SUCCESS.getMessage(), data);
    }

    public static <T> RResult<T> create(T data) {
        return new RResult<>(HttpStatus.CREATED.getCode(), HttpStatus.CREATED.getMessage(), data);
    }

    public RResult<T> success(String code, T data) {
        this.code = code;
        this.data = data;
        return this;
    }

    public static RResult<String> ok() {
        return new RResult<>(HttpStatus.SUCCESS.getCode(), HttpStatus.SUCCESS.getMessage());
    }

    public RResult<T> success(String code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
        return this;
    }

    public static <T> RResult<T> fail() {
        return new RResult<>(HttpStatus.FAILED.getCode(), HttpStatus.FAILED.getMessage(), null);
    }

    public RResult<T> fail(String code, String message) {
        this.code = code;
        this.message = message;
        return this;
    }

    public static <T> RResult<T> fail(T message) {
        if (message == null) {
            return new RResult<>(HttpStatus.FAILED);
        } else {
            return new RResult<>(HttpStatus.FAILED.getCode(), message);
        }
    }


    public static <T> RResult<T> notFound() {
        return new RResult<>(HttpStatus.NOT_FOUND.getCode(), HttpStatus.NOT_FOUND.getMessage(), null);
    }

    public static <T> RResult<T> notFound(String message) {
        return new RResult<>(HttpStatus.NOT_FOUND.getCode(), message, null);
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "RResult{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
