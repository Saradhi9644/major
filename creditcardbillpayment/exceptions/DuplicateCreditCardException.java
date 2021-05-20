package com.cg.creditcardbillpayment.exceptions;

public class DuplicateCreditCardException extends RuntimeException{

	public DuplicateCreditCardException(String message) {
		super(message);
	}
}
