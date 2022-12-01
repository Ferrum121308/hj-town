package com.ferrum.hjtown.handler;

import com.ferrum.hjtown.bean.common.Result;
import com.ferrum.hjtown.bean.exception.CustomException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Auther: th
 * @CreateTime: 2022/12/1 16:19
 * @Description:
 */
@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(CustomException.class)
	public Result<String> handleCustomException(CustomException customException){
		return Result.error(customException);
	}

}
