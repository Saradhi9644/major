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

import com.cg.creditcardbillpayment.entities.Customer;
import com.cg.creditcardbillpayment.exceptions.DuplicateCreditCardException;
import com.cg.creditcardbillpayment.exceptions.DuplicateCustomerException;
import com.cg.creditcardbillpayment.exceptions.NoSuchCustomerException;
import com.cg.creditcardbillpayment.services.ICustomerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;


	/***************************************************************************************************
	 * Method                           	: addCustomer 
	 * Description                      	: To add the customer to the database
	 * @param customer                  	- customer to be added to the database
	 * @param RequestBody               	- It maps the HttpRequest body to a transfer or domain object,
                                          	enabling automatic deserialization of the inbound HttpRequest 
                                          	body onto a Java object.
	 * @returns Customer                 	- returns customer after adding the customer to database 
	 * @throws DuplicateCustomerException 	- It is raised when customer already exists
	 * CreatedBy                        	- S.Abhishek 
	 * Created Date                     	- 24-MAR-2021
	 **************************************************************************************************/
	@PostMapping("/add")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)throws DuplicateCustomerException{
		Customer resultCustomer = customerService.addCustomer(customer);
		return new ResponseEntity<Customer>(resultCustomer,HttpStatus.OK);
	}
	
	
	
	
	
	/**************************************************************************************************
	 * Method                           : removeCustomer 
	 * Description                      : To remove the customer from the database
	 * @param id                 		- customer to be deleted from the database
	 * @param PathVariable              - used to handle template variables in the request URI mapping,  
	 										and use them as method parameters
	 * @returns String                  - returns when customer removed
	 * @throws NoSuchCustomerException 	- It is raised when customer not exists
	 * CreatedBy                        - S.Abhishek 
	 * Created Date                     - 24-MAR-2021
	 **************************************************************************************************/
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removeCustomer(@PathVariable Long id) throws NoSuchCustomerException{
		return new ResponseEntity<String>(customerService.removeCustomer(id),HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	/************************************************************************************************
	 * Method                           : updateCustomer 
	 * Description                      : To update the customer in the database
	 * @param customer                  - customer to be updated
	 * @param RequestBody               - It maps the HttpRequest body to a transfer or domain object,
                                          	enabling automatic deserialization of the inbound HttpRequest 
                                          	body onto a Java object.
	 * @returns Customer                - returns customer after updating the customer to database 
	 * @throws NoSuchCustomerException 	- It is raised when customer not found
	 * CreatedBy                        - S.Abhishek 
	 * Created Date                     - 23-MAR-2021
	 ************************************************************************************************/
	
	
	@PutMapping("/update")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) throws NoSuchCustomerException {
		Customer resultCustomer = customerService.updateCustomer(customer.getCustomerId(),customer);
		return new ResponseEntity<Customer>(resultCustomer, HttpStatus.OK);
	}
	
	
	
	/************************************************************************************
	 * Method                           : findCustomer 
	 * Description                      : To find the customer from the database using id
	 * @param id                  		- To fetch the customer from the database
	 * @param PathVariable              - used to handle template variables in the request URI mapping,  
	 										and use them as method parameters
	 * @returns Customer                - returns customer after fetching the database
	 * @throws NoSuchCustomerException  - It is raised when customer does not exists
	 * CreatedBy                        - S.Abhishek 
	 * Created Date                     - 23-MAR-2021
	 ************************************************************************************/
	
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<Customer> findCustomer(@PathVariable Long id) throws NoSuchCustomerException{
		Customer resultCustomer = customerService.getCustomer(id);
		return new ResponseEntity<Customer>(resultCustomer, HttpStatus.OK);
	}
	
	
	
	/****************************************************************************************
	 * Method                           : getAllCustomers
	 * Description                      : To get all the customers from the database
	 * @returns List<Customer>          - returns customers after fetching from the database 
	 * @throws NoSuchCustomerException  - It is raised when customers not found
	 * CreatedBy                        - S.Abhishek 
	 * Created Date                     - 23-MAR-2021
	 ****************************************************************************************/
	@GetMapping("/getall")
	public ResponseEntity<List<Customer>> getAllCustomer() throws NoSuchCustomerException{
		List<Customer> resultCustomers = customerService.getAllCustomers();
		return new ResponseEntity<List<Customer>>(resultCustomers, HttpStatus.OK);
	}
}
