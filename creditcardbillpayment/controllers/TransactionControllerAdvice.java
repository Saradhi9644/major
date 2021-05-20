package com.cg.creditcardbillpayment.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.cg.creditcardbillpayment.exceptions.TransactionServiceException;

@RestControllerAdvice
public class TransactionControllerAdvice {	
	
	@ExceptionHandler(TransactionServiceException.class)
	public ResponseEntity<String> transactionException(Exception exp) {
		return new ResponseEntity<String>(exp.getMessage(), HttpStatus.NOT_FOUND);
	}
}
