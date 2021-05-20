package com.cg.creditcardbillpayment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.creditcardbillpayment.entities.Statement;
import com.cg.creditcardbillpayment.exceptions.DuplicateStatementException;
import com.cg.creditcardbillpayment.exceptions.NoSuchStatementException;
import com.cg.creditcardbillpayment.services.IStatementService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/statement")
public class StatementController {
	@Autowired
	private IStatementService statementService;
	
	
	/*********************************************************************************************************
	* Method                				: addStatement
	* Description            				: To add the statement to the Database
	* @param statement      				- Statement to be added to the Database
	* @param RequestBody    				- It maps the HttpRequest body to a transfer or domain object,
	                          				enabling automatic deserialization of the inbound HttpRequest body
	                           				onto a Java object.
	* @returns Statement    				- returns statement
	* @throws DuplicateStatementException	- It is raised when statement already exists in the Database
	* Created By 							- K.Hima Susmitha
	* Created Date 							- 24-03-2021
	********************************************************************************************************/
	@PostMapping("/add")
	public ResponseEntity<Statement> addStatement(@RequestBody Statement statement)throws DuplicateStatementException {
		return new ResponseEntity<Statement>(statementService.addStatement(statement), HttpStatus.OK);

	}
	
	
	
	
	/******************************************************************************************************
	* Method                				: getStatement
	* Description            				: To fetch the statement from the Database
	* @param id      						- Statement to be fetched to the Database
	* @param PathVariable   				- used to handle template variables in the request URI mapping,  
	 										and use them as method parameters
	* @returns Statement    				- returns statement
	* @throws NoSuchStatementException 		- It is raised when statement not exists in the Database
	* Created By 							- K.Hima Susmitha
	* Created Date 							- 24-03-2021
	********************************************************************************************************/

	@GetMapping("/{id}")
	public ResponseEntity<Statement> getStatement(@PathVariable long id) throws NoSuchStatementException {
		return new ResponseEntity<Statement>(statementService.getStatement(id), HttpStatus.OK);
	}
	
	
	
	
	
	/********************************************************************************************************
	* Method 							:updateStatement
	* Description 						:To update the statement stored in the Database
	* @param statement 					- Statement to be updated to the Database
	* @param RequestBody 				- It maps the HttpRequest body to a transfer or domain object,
	                          			enabling automatic deserialization of the inbound HttpRequest body
	                           			onto a Java object.
	* @returns Statement 				-  returns statement
	* @throws NoSuchStatementException 	- It is raised when statement not exists in the Database
	* Created By 						- K.Hima Susmitha
	* Created Date						- 24-03-2021
	*******************************************************************************************************/
	@PutMapping("/update")
	public ResponseEntity<Statement> updateStatement(@RequestBody Statement statement) throws NoSuchStatementException {
		Statement resultStatement = statementService.updateStatement(statement.getStatementId(), statement);
		return new ResponseEntity<Statement>(resultStatement, HttpStatus.OK);

	}
	
	
	
	
	
	/********************************************************************************************************
	* Method 							: deleteStatement
	* Description 						: To delete the statement from the Database
	* @param id 		 				- statement to be delete from Database
	* @param PathVariable 				- used to handle template variables in the request URI mapping,  
	 										and use them as method parameters
	* @returns String	 				- returns string message when statement removed
	* @throws NoSuchStatementException 	- It is raised when statement not exists in the Database
	* Created By 						- K.Hima Susmitha
	* Created Date 						- 24-03-2021
	********************************************************************************************************/
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStatement(@PathVariable Long id) throws NoSuchStatementException {
		return new ResponseEntity<String>(statementService.removeStatement(id), HttpStatus.OK);

	}
	
	
	
	
	/*****************************************************************************************************
	* Method 							: getallStatements
	* Description 						: To fetchAll the statement from the Database
	* @returns List<Statement>			- returns all statements
	* @throws NoSuchStatementException 	- It is raised when statement not exists in the Database
	* Created By 						- K.Hima Susmitha
	* Created Date						- 24-03-2021
	*******************************************************************************************************/
	@GetMapping("/getall")
	public ResponseEntity<List<Statement>> getAllStatements() throws NoSuchStatementException {
		List<Statement> statements = statementService.getAllStatements();
		return new ResponseEntity<List<Statement>>(statements, HttpStatus.OK);
	}
	
	
	
	
	/************************************************************************************
	* Method  						: getbilledStatement
	* Description 					: To fetch the billedStatements from the Database
	* @returns List<Statement> 		- returns all billed statements
	* Created By					- K.Hima Susmitha
	* Created Date 					- 24-03-2021
	**************************************************************************************/
	@GetMapping("/getbilledstatement")
	public ResponseEntity<List<Statement>> getBilledStatement() {
		List<Statement> statements = statementService.getBilledStatement();
		return new ResponseEntity<List<Statement>>(statements, HttpStatus.OK);
	}
	
	
	
	
	/************************************************************************************
	* Method  					: getUnbilledStatement
	* Description 				: To fetch the unbilledStatements from the Database
	* @returns List<Statement>  - returns all unbilled statements
	* Created By 				- K.Hima Susmitha
	* Created Date 				- 24-03-2021
	**************************************************************************************/

	@GetMapping("/getunbilledstatement")
	public ResponseEntity<List<Statement>> getUnbilledStatement() {
		List<Statement> statements = statementService.getUnbilledStatement();
		return new ResponseEntity<List<Statement>>(statements, HttpStatus.OK);
	}
	
	
	/******************************************************************************************************
	* Method                				: getStatementbyCardId
	* Description            				: To fetch the statement from the Database
	* @param id      						- Statement to be fetched from the Database using card id
	* @param PathVariable   				- used to handle template variables in the request URI mapping,  
	 										and use them as method parameters
	* @returns Statement    				- returns statement
	* @throws NoSuchStatementException 		- It is raised when statement not exists in the Database
	* Created By 							- K.Hima Susmitha
	* Created Date 							- 24-03-2021
	********************************************************************************************************/
	@GetMapping("/cardid/{id}")
	public ResponseEntity<Statement> getStatementbyCardId(@PathVariable long id) throws NoSuchStatementException {
		return new ResponseEntity<Statement>(statementService.getStatementByCardId(id), HttpStatus.OK);
	}
	
}
