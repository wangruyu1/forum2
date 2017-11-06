package com.leisure.forum.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leisure.forum.dto.BaseExceptionMessage;
import com.leisure.forum.exception.HttpException;
import com.leisure.forum.type.CodeType;

/**
 * 创建者:王如雨 创建时间:2017年11月6日 下午2:56:47
 */
@ControllerAdvice
@ResponseBody
public class GloableExceptionHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(GloableExceptionHandler.class);
	@ExceptionHandler(value = Exception.class)
	public BaseExceptionMessage handler(HttpServletRequest request, HttpServletResponse response, Exception e) {
		BaseExceptionMessage baseMessage = new BaseExceptionMessage();
		if (e instanceof HttpException) {
			baseMessage.setCode(CodeType.PARAM_ERROR);
			baseMessage.setStatus(HttpStatus.BAD_REQUEST.value());
			baseMessage.setMessage(e.getMessage());
			baseMessage.setExceptionStr("");
		}else {
			baseMessage.setCode(CodeType.UNKNOW_EXCEPTION);
			baseMessage.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			baseMessage.setExceptionStr(e.getMessage());
		}
		
		LOGGER.error("异常发生.\n",e);
		return baseMessage;
	}
}
