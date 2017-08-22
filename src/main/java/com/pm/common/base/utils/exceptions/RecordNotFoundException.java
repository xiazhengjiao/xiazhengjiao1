package com.pm.common.base.utils.exceptions;

public class RecordNotFoundException extends BaseException {

	private static final long serialVersionUID = 5401980973398848686L;

	@Override
	public String getErrorCode() {
		return "201";
	}
}
