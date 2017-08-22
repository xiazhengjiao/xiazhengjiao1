package com.pm.common.base.utils.exceptions;

public class ServiceException extends BaseException {
	
	public ServiceException(String cause) {
		super(cause);
	}
	
	public ServiceException(Throwable t) {
		super(t.getMessage());
	}
	
	@Override
	public String getErrorCode() {
		return "500";
	}

}
