package com.cg.creditcardbillpayment.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.creditcardbillpayment.exceptions.NoSuchCreditCardException;
import com.cg.creditcardbillpayment.exceptions.CreditCardException;
import com.cg.creditcardbillpayment.exceptions.CustomerException;
import com.cg.creditcardbillpayment.exceptions.DuplicateCreditCardException;


@RestControllerAdvice
public class CreditCardControllerAdvice {
		
	@ExceptionHandler(NoSuchCreditCardException.class)
	public ResponseEntity<String> notFoundException(Exception exp){
		return new ResponseEntity<String> (exp.getMessage(),HttpStatus.EXPECTATION_FAILED);
	}
		
	@ExceptionHandler(DuplicateCreditCardException.class)
	public ResponseEntity<String> duplicateException(Exception exp){
		return new ResponseEntity<String> (exp.getMessage(),HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(CreditCardException.class)
	public ResponseEntity<String> creditcardException(Exception exp){
		return new ResponseEntity<String> (exp.getMessage(),HttpStatus.OK);
	}
}
