package com.cg.creditcardbillpayment.exceptions;

public class DuplicatePaymentException extends RuntimeException{

	public DuplicatePaymentException(String message) {
		super(message);
	}
}
