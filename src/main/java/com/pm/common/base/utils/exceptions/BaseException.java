package com.pm.common.base.utils.exceptions;

import java.util.ResourceBundle;

public class BaseException extends Exception {

	private static final long serialVersionUID = 8295273333975229235L;

	private static ResourceBundle rb = ResourceBundle.getBundle("errorDefine");
	
	private String errorCode;
	private String message;

	public BaseException(Object... args) {
		message = String.format(rb.getString(getErrorCode()), args);
	}

	public BaseException(Throwable t, Object... args) {
		this(args);
		initCause(t);
	}
	
	public BaseException(String errorCode, String cause) {
		this.errorCode = errorCode;
		this.message = cause;
	}
	
	@Override
	public String getMessage() {
		return message;
	}


    public void setMessage(String message) {
        this.message = message;
    }

	public String getErrorCode() {
		return errorCode;
	}
}
