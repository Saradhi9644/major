package com.cg.creditcardbillpayment.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.creditcardbillpayment.exceptions.CustomerException;
import com.cg.creditcardbillpayment.exceptions.DuplicateCustomerException;
import com.cg.creditcardbillpayment.exceptions.NoSuchCustomerException;
import com.cg.creditcardbillpayment.exceptions.UserException;


@RestControllerAdvice
public class CustomerControllerAdvice {
		
	@ExceptionHandler(NoSuchCustomerException.class)
	public ResponseEntity<String> notFoundException(Exception exp){
		return new ResponseEntity<String> (exp.getMessage(),HttpStatus.EXPECTATION_FAILED);
	}
		
	@ExceptionHandler(DuplicateCustomerException.class)
	public ResponseEntity<String> duplicateException(Exception exp){
		return new ResponseEntity<String> (exp.getMessage(),HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<String> customerException(Exception exp){
		return new ResponseEntity<String> (exp.getMessage(),HttpStatus.OK);
	}
}
