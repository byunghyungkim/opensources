package com.luuf.core.spring.model;

import com.luuf.core.object.BaseObject;

public class BooleanResult extends BaseObject {

	private static final long serialVersionUID = 5392893154707715805L;

	private boolean isSuccess;
	private String message;
	
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "BooleanResult [isSuccess=" + isSuccess + ", message=" + message
				+ "]";
	}
	
}
