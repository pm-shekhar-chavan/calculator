package com.text.calc.exception;

public class InvalidExpressionException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public InvalidExpressionException(String msg) {
		super(msg);
	}

}
