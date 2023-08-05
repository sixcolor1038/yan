package com.yan.common.utils;

import com.yan.common.constant.HttpCodeEnum;

import java.io.Serializable;

public class ResponseResult<T> implements Serializable {
	private Integer code;
	private String message;
	private T data;

	public ResponseResult() {
		this.code = 200;
	}

	public ResponseResult(Integer code, T data) {
		this.code = code;
		this.data = data;
	}

	public ResponseResult(Integer code, String msg, T data) {
		this.code = code;
		this.message = msg;
		this.data = data;
	}

	public ResponseResult(Integer code, String msg) {
		this.code = code;
		this.message = msg;
	}

	public static <T> ResponseResult<T> errorResult(int code, String msg) {
		return new ResponseResult<>(code, msg);
	}

	public static <T> ResponseResult<T> okResult(int code, String msg) {
		return new ResponseResult<>(code, msg);
	}

	public static <T> ResponseResult<T> okResult(T data) {
		return new ResponseResult<>(200, "Success", data);
	}

	public static <T> ResponseResult<T> errorResult(HttpCodeEnum enums) {
		return new ResponseResult<>(enums.getCode(), enums.getMessage());
	}

	public static <T> ResponseResult<T> errorResult(HttpCodeEnum enums, String message) {
		return new ResponseResult<>(enums.getCode(), message);
	}

	public static <T> ResponseResult<T> setHttpCodeEnum(HttpCodeEnum enums) {
		return new ResponseResult<>(enums.getCode(), enums.getMessage());
	}

	private static <T> ResponseResult<T> setHttpCodeEnum(HttpCodeEnum enums, String message) {
		return new ResponseResult<>(enums.getCode(), message);
	}

	public ResponseResult<T> error(Integer code, String msg) {
		this.code = code;
		this.message = msg;
		return this;
	}

	public ResponseResult<T> ok(Integer code, T data) {
		this.code = code;
		this.data = data;
		return this;
	}

	public ResponseResult<T> ok(Integer code, T data, String msg) {
		this.code = code;
		this.data = data;
		this.message = msg;
		return this;
	}

	public ResponseResult<T> ok(T data) {
		this.data = data;
		return this;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
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

	@Override
	public String toString() {
		return "ResponseResult{" +
				"code=" + code +
				", message='" + message + '\'' +
				", data=" + data +
				'}';
	}
}
