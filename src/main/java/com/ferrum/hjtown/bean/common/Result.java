package com.ferrum.hjtown.bean.common;

import com.ferrum.hjtown.bean.exception.CustomException;
import lombok.Data;

/**
 * @Auther: th
 * @CreateTime: 2022/12/1 16:02
 * @Description:
 */
@Data
public class Result<T> {

	private Integer code;
	private String msg;
	private T data;

	public void setResultCode(ResultCode resultCode){
		this.code = resultCode.code();
		this.msg = resultCode.msg();
	}

	public static <T> Result<T> success(){
		Result<T> result = new Result<>();
		result.setResultCode(ResultCode.SUCCESS);
		return result;
	}

	public static <T> Result<T> success(T data){
		Result<T> result = new Result<>();
		result.setResultCode(ResultCode.SUCCESS);
		result.setData(data);
		return result;
	}

	public static <T> Result<T> error(){
		Result<T> result = new Result<>();
		result.setResultCode(ResultCode.ERROR);
		return result;
	}

	public static <T> Result<T> error(CustomException exception){
		Result<T> result = new Result<>();
		result.setResultCode(exception.getResultCode());
		result.setMsg(exception.getErrorMsg());
		return result;
	}

	public static <T> Result<T> error(T data){
		Result<T> result = new Result<>();
		result.setResultCode(ResultCode.ERROR);
		result.setData(data);
		return result;
	}

}
