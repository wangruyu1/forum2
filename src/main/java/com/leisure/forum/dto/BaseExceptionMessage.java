package com.leisure.forum.dto;

/**
 * 创建者:王如雨 创建时间:2017年11月6日 下午2:49:16
 */
public class BaseExceptionMessage {
	private int code;
	private int status;
	private String message;
	private String exceptionStr;

	public BaseExceptionMessage() {
		super();
	}

	public BaseExceptionMessage(int code, int status, String message, String exceptionStr) {
		super();
		this.code = code;
		this.status = status;
		this.message = message;
		this.exceptionStr = exceptionStr;
	}

	public BaseExceptionMessage(int code, int status, String message) {
		super();
		this.code = code;
		this.status = status;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getExceptionStr() {
		return exceptionStr;
	}

	public void setExceptionStr(String exceptionStr) {
		this.exceptionStr = exceptionStr;
	}

}
