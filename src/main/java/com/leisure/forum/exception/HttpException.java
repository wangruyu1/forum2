package com.leisure.forum.exception;

/**
 * 创建者:王如雨 创建时间:2017年11月6日 下午2:44:32
 */
public class HttpException extends Exception {

	public HttpException() {
		super();
	}

	public HttpException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public HttpException(String message, Throwable cause) {
		super(message, cause);
	}

	public HttpException(String message) {
		super(message);
	}

	public HttpException(Throwable cause) {
		super(cause);
	}

}
