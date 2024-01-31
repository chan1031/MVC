package edu.jeiu.diary_pjt.common;

public class ATResponse {
	
	// "success" 또는 "fail"
	private String status;
	
	private String code;
	private String message;
	
	public ATResponse(String status, String code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
