package com.cg.creditcardbillpayment.exceptions;

public class DuplicateAccountException extends RuntimeException{

	public DuplicateAccountException(String message) {
		super(message);
	}
}
