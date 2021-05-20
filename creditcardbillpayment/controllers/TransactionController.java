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

import com.cg.creditcardbillpayment.entities.Transaction;
import com.cg.creditcardbillpayment.services.ITransactionService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/transaction")
public class TransactionController {
	@Autowired
	private ITransactionService transactionService;
	
	
	/**************************************************************************************************************************************
	 * Method 									: addTransaction
     * Description 								: To add the transaction to the Database
	 * @param transaction      					- transaction to be added to the Database
	 * @param RequestBody						- It maps the HttpRequest body to a transfer or domain object,
	  											  enabling automatic deserialization of the inbound HttpRequest body onto a Java object.
	 * @returns Transaction                  	- returns transaction
	 * @throws TransactionServiceException 		- It is raised when transaction already exists in the Database
     * Created By                               - M.V.Sai Prakash
     * Created Date                             - 24-03-2021                          
	 *************************************************************************************************************************************/

	@PostMapping("/add")
	public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction) {
		transactionService.addTransaction(transaction);
		return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
	}

	
	
	/************************************************************************************************************
	 * Method 									: getTransaction
     * Description 								: To fetch the transaction from the Database
	 * @param id      							- id of the transaction to be fetched
	 * @param PathVariable						- used to handle template variables in the request URI mapping,  
	 											  and use them as method parameters
	 * @returns Transaction                  	- returns transaction
	 * @throws TransactionServiceException 		- It is raised when transaction does not exist in the Database
     * Created By                               - M.V.Sai Prakash
     * Created Date                             - 24-03-2021                          
	 ************************************************************************************************************/

	@GetMapping("/get/{id}")
	public ResponseEntity<Transaction> getTransaction(@PathVariable long id) {
		Transaction transaction = transactionService.getTransactionDetails(id);
		return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
	}
	
	
	
	
	
	/*******************************************************************************************************************************************
	 * Method 									: updateTransaction
     * Description 								: To update the transaction to the Database
	 * @param transaction      					- transaction to be updated in the Database
	 * @param RequestBody						- It maps the HttpRequest body to a transfer or domain object,
	  											  enabling automatic deserialization of the inbound HttpRequest body onto a Java object.
	 * @returns Transaction                  	- returns transaction
	 * @throws TransactionServiceException 		- It is raised when transaction does not exist in the Database
     * Created By                               - M.V.Sai Prakash
     * Created Date                             - 24-03-2021                          
	 ******************************************************************************************************************************************/
	
	@PutMapping("/update")
	public ResponseEntity<Transaction> updateTransaction(@RequestBody Transaction transaction) {
		transactionService.updateTransaction(transaction.getTransactionId(), transaction);
		return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
	}
	
	
	
	
	/************************************************************************************************************
	 * Method 									: deleteTransaction
     * Description 								: To delete the transaction from the Database
	 * @param id      							- id of the transaction to be deleted
	 * @param PathVariable						- used to handle template variables in the request URI mapping,  
	 											  and use them as method parameters
	 * @returns String                  		- returns successful message after transaction removed
	 * @throws TransactionServiceException 		- It is raised when transaction does not exist in the Database
     * Created By                               - M.V.Sai Prakash
     * Created Date                             - 24-03-2021                          
	 ************************************************************************************************************/
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTransaction(@PathVariable long id)  {	
		return new ResponseEntity<String>(transactionService.removeTransaction(id), HttpStatus.OK);		
	}

	
	
	
	/******************************************************************************************************************
	 * Method 									: getAllTransaction
     * Description 								: To fetch all the transactions from the Database
	 * @returns List<Transaction>               - returns all transactions in the Database
	 * @throws TransactionServiceException 		- It is raised when transactions does not exist in the Database
     * Created By                               - M.V.Sai Prakash
     * Created Date                             - 24-03-2021                          
	 ******************************************************************************************************************/
	
	@GetMapping("/getall")
	public ResponseEntity<List<Transaction>> getAllTransaction() {
		List<Transaction> transactions = transactionService.getAllTransactions();
		return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
	}	
	
	
	/************************************************************************************************************
	 * Method 									: getCardTransaction
     * Description 								: To fetch the transactions from the Database using card id
	 * @param id      							- card id of the transactions to be fetched
	 * @param PathVariable						- used to handle template variables in the request URI mapping,  
	 											  and use them as method parameters
	 * @returns List<Transaction>               - returns all transactions	
     * Created By                               - M.V.Sai Prakash
     * Created Date                             - 24-03-2021                          
	 ************************************************************************************************************/
	@GetMapping("/getcard/{id}")
	public ResponseEntity<List<Transaction>> getCardTransaction(@PathVariable long id) {
		List<Transaction> transaction = transactionService.getCardTransactionDetails(id);
		return new ResponseEntity<List<Transaction>>(transaction, HttpStatus.OK);
	}
}
