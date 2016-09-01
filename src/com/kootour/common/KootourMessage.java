package com.kootour.common;

import java.io.Serializable;

public class KootourMessage implements Serializable {

	private static final long serialVersionUID = -1L;

	private boolean hasError;
	private String message;
	private Object data;

	public boolean isHasError() {
		return hasError;
	}

	public void setHasError(boolean hasError) {
		this.hasError = hasError;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
