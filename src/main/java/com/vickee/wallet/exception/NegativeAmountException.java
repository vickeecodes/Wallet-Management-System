package com.vickee.wallet.exception;

public class NegativeAmountException extends RuntimeException {

	String message;
	public NegativeAmountException(String message) {
		super(message);		
	}
}
