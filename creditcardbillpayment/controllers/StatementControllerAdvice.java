package com.cg.creditcardbillpayment.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.creditcardbillpayment.exceptions.DuplicateStatementException;

import com.cg.creditcardbillpayment.exceptions.NoSuchStatementException;


@RestControllerAdvice
public class StatementControllerAdvice {

	@ExceptionHandler(NoSuchStatementException.class)
	public ResponseEntity<String> notFoundException(Exception exp){
		return new ResponseEntity<String> (exp.getMessage(),HttpStatus.NOT_FOUND);
	}

		
	@ExceptionHandler(DuplicateStatementException.class)
	public ResponseEntity<String> duplicateException(Exception exp){
		return new ResponseEntity<String> (exp.getMessage(),HttpStatus.CONFLICT);
	}
}
