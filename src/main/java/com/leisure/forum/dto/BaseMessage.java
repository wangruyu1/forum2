package com.leisure.forum.dto;

/**
 * 创建者:王如雨 创建时间:2017年11月6日 下午3:35:51
 */
public class BaseMessage {
	private int code;
	private int status;
	private String message;

	public BaseMessage() {
		super();
	}

	public BaseMessage(int code, int status, String message) {
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

}
