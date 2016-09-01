package com.kootour.exception;

public class BusinessException extends RuntimeException {

	private String code;
	private String[] param;

	public String[] getParam() {
		return param;
	}

	public String getCode() {
		return code;
	}

	public BusinessException(String code,String... param){
		this.code = code;
		this.param = param;
	}
	
	
	public BusinessException(String msgId) {
		super(msgId);
	}

	public BusinessException(String msgId, Object arg) {
		super(msgId);
	}

	public BusinessException(String msgId, Object[] arg) {
		super(msgId);
	}
	
}
