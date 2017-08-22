package com.pm.common.base.utils.exceptions;

/**
 * Created by dell on 2015/11/29.
 */
public class ArgumentException extends RuntimeException {
	
	private static final long serialVersionUID = -2489040710097245104L;

	public ArgumentException() {
    }

    public ArgumentException(Throwable t) {
        super(t);
    }

    public ArgumentException(String msg, Throwable t) {
        super(msg, t);
    }

    public ArgumentException(String msg) {
        super(msg);
    }
}

