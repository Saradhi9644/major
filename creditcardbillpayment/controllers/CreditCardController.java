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

import com.cg.creditcardbillpayment.entities.CreditCard;
import com.cg.creditcardbillpayment.exceptions.DuplicateCreditCardException;
import com.cg.creditcardbillpayment.exceptions.DuplicateCustomerException;
import com.cg.creditcardbillpayment.exceptions.NoSuchCreditCardException;
import com.cg.creditcardbillpayment.exceptions.NoSuchCustomerException;
import com.cg.creditcardbillpayment.services.ICreditCardService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/creditcard")
public class CreditCardController {

	@Autowired
	private ICreditCardService creditcardService;
	
	
	/***************************************************************************************************
	 * Method                           	: addCreditCard 
	 * Description                      	: To add the CreditCard to the database
	 * @param creditcard                  	- creditcard to be added to the database
	 * @param RequestBody               	- It maps the HttpRequest body to a transfer or domain object,
                                          	enabling automatic deserialization of the inbound HttpRequest 
                                          	body onto a Java object.
	 * @returns CreditCard                 	- returns creditcard after adding to database 
	 * @throws DuplicateCreditCardException	- It is raised when creditcard already exists
	 * CreatedBy                        	- Peram Manogna
	 * Created Date                     	- 24-03-2021
	 **************************************************************************************************/
	
	@PostMapping("/add")
	public ResponseEntity<CreditCard> addCreditCard(@RequestBody CreditCard creditcard) throws DuplicateCreditCardException {
		CreditCard resultCreditCard = creditcardService.addCreditCard(creditcard);
		return new ResponseEntity<CreditCard>(resultCreditCard, HttpStatus.OK);

	}
	
	

	/************************************************************************************
	 * Method                           : getCreditCard 
	 * Description                      : To find the creditcard from the database using id
	 * @param id                  		- To fetch the creditcard from the database
	 * @param PathVariable              - used to handle template variables in the request URI mapping,  
	 										and use them as method parameters
	 * @returns CreditCard              - returns CreditCard after fetching the database
	 * @throws NoSuchCreditCardException- It is raised when CreditCard does not exists
	 * CreatedBy                        - Peram Manogna 
	 * Created Date                     - 24-03-2021
	 ************************************************************************************/
	@GetMapping("/{id}")
	public ResponseEntity<CreditCard> getCreditCard(@PathVariable long id) throws NoSuchCreditCardException {
		CreditCard creditcard = creditcardService.getCreditCard(id);
		return new ResponseEntity<CreditCard>(creditcard, HttpStatus.OK);

	}
	
	
	
	
	

	/************************************************************************************
	 * Method                           : deleteCreditCard 
	 * Description                      : To delete the creditcard from the database using id
	 * @param id                  		- Creditcard to be deleted from the database
	 * @param PathVariable              - used to handle template variables in the request URI mapping,  
	 										and use them as method parameters
	 * @returns String              	- returns success when creditCard removed
	 * @throws NoSuchCreditCardException- It is raised when CreditCard does not exists
	 * CreatedBy                        - Peram Manogna 
	 * Created Date                     - 24-03-2021
	 ************************************************************************************/
	

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCreditCard(@PathVariable long id) throws NoSuchCreditCardException {
		return new ResponseEntity<String>(creditcardService.removeCreditCard(id), HttpStatus.OK);
	}

	
	
	

	/***************************************************************************************************
	 * Method                           	: updateCreditCard 
	 * Description                      	: To update the CreditCard to the database
	 * @param creditcard                  	- creditcard to be updated to the database
	 * @param RequestBody               	- It maps the HttpRequest body to a transfer or domain object,
                                          	enabling automatic deserialization of the inbound HttpRequest 
                                          	body onto a Java object.
	 * @returns CreditCard                 	- returns creditcard after updating to database 
	 * @throws NoSuchCreditCardException	- It is raised when creditcard not exists
	 * CreatedBy                        	- Peram Manogna
	 * Created Date                     	- 24-03-2021
	 **************************************************************************************************/
	
	@PutMapping("/update")
	public ResponseEntity<CreditCard> updateCreditCard(@RequestBody CreditCard creditcard) throws NoSuchCreditCardException {
		CreditCard resultcreditCard = creditcardService.updateCreditCard(creditcard.getCardId(), creditcard);
		return new ResponseEntity<CreditCard>(resultcreditCard, HttpStatus.OK);
	}
	
	
	
	
	
	/****************************************************************************************
	 * Method                           : getAllCreditCards
	 * Description                      : To get all the creditcards from the database
	 * @returns List<CreditCard>        - returns all creditcards after fetching from the database 
	 * @throws NoSuchCreditCardException- It is raised when creditcards not found
	 * CreatedBy                        - Peram Manogna 
	 * Created Date                     - 24-03-2021
	 ****************************************************************************************/

	@GetMapping("/getall")
	public ResponseEntity<List<CreditCard>> getAllCreditCards() throws NoSuchCreditCardException {
		List<CreditCard> creditcards = creditcardService.getAllCreditCards();
		return new ResponseEntity<List<CreditCard>>(creditcards, HttpStatus.OK);

	}
	
	/************************************************************************************
	 * Method                           	: checkCardNumber 
	 * Description                      	: To check the creditcard  number in the database 
	 * @param number                  		- Creditcard number to be checked in the database
	 * @param PathVariable              	- used to handle template variables in the request URI mapping,  
	 										and use them as method parameters
	 * @returns boolean              		- returns true, if it exists
	 * @throws DuplicateCreditCardException	- It is raised when CreditCard already exists
	 * CreatedBy                        	- Peram Manogna 
	 * Created Date                     	- 24-03-2021
	 ************************************************************************************/
	
	@GetMapping("/cardnumber/{number}")
	public ResponseEntity<Boolean> checkCardNumber(@PathVariable String number) throws DuplicateCreditCardException {
		return new ResponseEntity<Boolean>(creditcardService.checkCardNumber(number), HttpStatus.OK);
	}

}
