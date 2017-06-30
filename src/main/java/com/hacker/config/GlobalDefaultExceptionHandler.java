package com.hacker.config;

import com.hacker.exception.BaseException;
import com.hacker.message.JsonData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:全局controller层异常处理
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public JsonData defaultExceptionHandler(Exception e){
		JsonData jsonData=new JsonData();
		if (e instanceof BaseException){
			BaseException exception= (BaseException) e;
			jsonData.setErrResult(exception.getCode(),exception.getMessage());
		}
		return jsonData;
	}
	
}
