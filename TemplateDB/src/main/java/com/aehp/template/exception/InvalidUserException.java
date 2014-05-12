package com.aehp.template.exception;

public class InvalidUserException  extends RuntimeException {

	private static final long serialVersionUID = 100L;

	public InvalidUserException(String s) {
        super(s);
    }

}
