package com.hjho.validator.constant;

public enum Status{
	SUCCESS(0, "OK"),
	INVALID(4444, "Invalid"),
	FAIL(500, "REQUEST FAIL"),
	UNKNOWN_ERROR(9999, "unknown error");
	
	Status(int code) {
		this.code = code;
	}

	Status(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	private int code;
	private String description;
	
	public int getCode() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}

	public Status forCode(int code) {
		Status status = Status.UNKNOWN_ERROR;
		for(Status s: Status.values()) {
			if(s.code == code) {
				status = s;
				break;
			}
		}
		return status;
	}
}