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

import com.cg.creditcardbillpayment.entities.Account;
import com.cg.creditcardbillpayment.exceptions.DuplicateAccountException;
import com.cg.creditcardbillpayment.exceptions.NoSuchAccountException;

import com.cg.creditcardbillpayment.services.IAccountService;


/************************************************************************************
 *         @author          Rishu Raj
 *         Description      It is a RestController class. This class handles all the 
 *          				HTTP Request toward "/accounts" "folder".                      					  
 *         Version          1.0
 *         Created Date    	22-MAR-2021
 ************************************************************************************/

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private IAccountService accountService;

	
	/***********************************************************************************************************
	 * Method							: addAccount
     * Description						: To add any account in database 
     * @param account					- account to be added in database
     * @param RequestBody               - It maps the HttpRequest body to a transfer or domain object,
                                          enabling automatic deserialization of the inbound HttpRequest 
                                          body onto a Java object.
	 * @returns Account          		- returns account after added to database
     * Created By						- Rishu Raj
     * Created Date						- 22-MAR-2021 
	 ***********************************************************************************************************/
	@PostMapping("/add")
	public ResponseEntity<Account> addAccount(@RequestBody Account account) {
		return new ResponseEntity<Account>(accountService.addAccount(account), HttpStatus.OK);
	}
	
	
	/***********************************************************************************************************
	 * Method							: deleteAccount
     * Description						: To remove any account from database 
     * @param accountnumber				- account to be removed from database
     * @param PathVariable              - used to handle template variables in the request URI mapping,  
	 										and use them as method parameters
	 * @returns String          		- returns account removed string
	 * @throws NoSuchAccountException	- It is raised when account not exists in database
     * Created By						- Rishu Raj
     * Created Date						- 22-MAR-2021 
	 ***********************************************************************************************************/
	@DeleteMapping("/remove/{accountnumber}")
	public ResponseEntity<String> deleteAccount(@PathVariable long accountnumber) throws NoSuchAccountException {
		return new ResponseEntity<String>(accountService.removeAccount(accountnumber), HttpStatus.OK);
	}


	/***********************************************************************************************************
	 * Method							: updateAccount
     * Description						: To update any particular account and their details stored in database.
     * @param account					- account to be updated in database
     * @param RequestBody               - It maps the HttpRequest body to a transfer or domain object,
                                          enabling automatic deserialization of the inbound HttpRequest 
                                          body onto a Java object.
	 * @returns Account          		- returns account after updated
	 * @throws NoSuchAccountException	- It is raised when account not exists in database
     * Created By						- Rishu Raj
     * Created Date						- 22-MAR-2021 
	 ***********************************************************************************************************/
	@PutMapping("/update")
	public ResponseEntity<Account> updateAccount(@RequestBody Account account) throws NoSuchAccountException {
		return new ResponseEntity<Account>(accountService.updateAccount(account.getAccountNumber(), account),
				HttpStatus.OK);
	}
	
	/***********************************************************************************************************
	 * Method							: getAccount
     * Description						: To fetch any particular account using it's accountNumber 
     * @param accountnumber				- account to be fetched from database
     * @param PathVariable              - used to handle template variables in the request URI mapping,  
	 										and use them as method parameters
	 * @returns Account          		- returns account after fetching from database
	 * @throws NoSuchAccountException	- It is raised when account not exists in database
     * Created By						- Rishu Raj
     * Created Date						- 22-MAR-2021 
	 ***********************************************************************************************************/
	
	@GetMapping("/{accountnumber}")
	public ResponseEntity<Account> getAccount(@PathVariable long accountnumber) throws NoSuchAccountException {
		return new ResponseEntity<Account>(accountService.getAccount(accountnumber), HttpStatus.OK);
	}


	/***********************************************************************************************************
	 * Method							: getAllAccounts
     * Description						: To fetch all accounts and their details stored in database.
     * @returns List<Account>        	- returns all accounts after fetching from database
	 * @throws NoSuchAccountException	- It is raised when account not exists in database
     * Created By						- Rishu Raj
     * Created Date						- 22-MAR-2021 
	 ***********************************************************************************************************/
	
	@GetMapping("/getallaccounts")
	public ResponseEntity<List<Account>> getAllAccounts() throws NoSuchAccountException  {
		return new ResponseEntity<List<Account>>(accountService.getAllAccounts(), HttpStatus.OK);
	}
}
