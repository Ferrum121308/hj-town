package com.ferrum.hjtown.bean.exception;

import com.ferrum.hjtown.bean.common.ResultCode;
import lombok.Data;
import org.springframework.beans.propertyeditors.CustomNumberEditor;

/**
 * @Auther: th
 * @CreateTime: 2022/12/1 16:07
 * @Description:
 */
@Data
public class CustomException extends RuntimeException{

	private ResultCode resultCode;
	private String errorMsg;

	public CustomException(ResultCode resultCode){
		this.resultCode = resultCode;
		this.errorMsg = super.getMessage();
	}

	public CustomException(ResultCode resultCode, String errorMsg){
		this.resultCode = resultCode;
		this.errorMsg = errorMsg;
	}

}
