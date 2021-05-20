package com.cg.creditcardbillpayment.controllers;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.creditcardbillpayment.exceptions.DuplicateAccountException;
import com.cg.creditcardbillpayment.exceptions.NoSuchAccountException;



@RestControllerAdvice
public class AccountControllerAdvice {

	@ExceptionHandler(NoSuchAccountException.class)
	public ResponseEntity<String> notFoundException(Exception exp) {
		return new ResponseEntity<String>(exp.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(DuplicateAccountException.class)
	public ResponseEntity<String> duplicateException(Exception exp) {
		return new ResponseEntity<String>(exp.getMessage(), HttpStatus.CONFLICT);
	}
}
