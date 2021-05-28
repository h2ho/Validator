package com.hjho.validator.model;

import com.hjho.validator.constant.Status;

public class ApiResult<T> {

	private T data;
	private int status;
	
	public ApiResult() {}
	
	public ApiResult(int status, T data) {
		this.status = status;
		this.data = data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getStatus() {
		return status;
	}
	
	
	public static ApiResult<String> fromStatus(Status status) {
		ApiResult<String> s = new ApiResult<String>();
		s.setData(status.getDescription());
		s.setStatus(status.getCode());
		return s;
	}
}

