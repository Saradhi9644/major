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

import com.cg.creditcardbillpayment.entities.Payment;
import com.cg.creditcardbillpayment.entities.Transaction;
import com.cg.creditcardbillpayment.exceptions.DuplicatePaymentException;
import com.cg.creditcardbillpayment.exceptions.NoSuchPaymentException;
import com.cg.creditcardbillpayment.exceptions.NoSuchStatementException;
import com.cg.creditcardbillpayment.services.IPaymentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private IPaymentService paymentService;

	
	/******************************************************************************************************
	 * Method                              : insertPayment 
	 * Description                         : To add the payment to the Database
	 * @param payment                      - payment to be added to the Database
	 * @param RequestBody                  - It maps the HttpRequest body to a transfer or domain
	                                         object, enabling automatic deserialization of the inbound
	                                         HttpRequest body onto a Java object.
	 * @returns Payment                    - returns Payment
	 * @throws DuplicatePaymentException   - It is raised when payment already exists in the Database 
	 * Created By                          - G.Balaji 
	 * Created Date                        - 24-03-2021
	 ******************************************************************************************************/
	@PostMapping("/insert")
	public ResponseEntity<Payment> insertPayment(@RequestBody Payment payment) throws DuplicatePaymentException {
		Payment resultPayment = paymentService.addPayment(payment);
		return new ResponseEntity<Payment>(resultPayment, HttpStatus.OK);

	}
	
	
	
	
	
	/*************************************************************************************************
	 * Method                              : deletePayment 
	 * Description                         : To remove the payment from the Database
	 * @param id	                       - payment to be deleted from the Database
	 * @param PathVariable                 - used to handle template variables in the request URI mapping,  
	 										and use them as method parameters
	 * @returns String                     - returns payment deleted successfully
	 * @throws NoSuchPaymentException      - It is raised when payment already removed from the Database 
	 * Created By                          - G.Balaji 
	 * Created Date                        - 24-03-2021
	 *************************************************************************************************/
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletePayment(@PathVariable long id) throws NoSuchPaymentException {
			return new ResponseEntity<String>(paymentService.removePayment(id), HttpStatus.OK);

	}
	
	
	
	
	
	/****************************************************************************************************
	 * Method                              : updatePayment 
	 * Description                         : To update the payment to the Database
	 * @param Payment                      - payment to be updated from the Database
	 * @param RequestBody                  - It maps the HttpRequest body to a transfer or domain
	                                         object, enabling automatic deserialization of the inbound
	                                         HttpRequest body onto a Java object.
	 * @returns Payment                    - returns Payment
	 * @throws NoSuchPaymentException      - It is raised when payment not exists in the Database 
	 * Created By                          - G.Balaji 
	 * Created Date                        - 24-03-2021
	 ****************************************************************************************************/
	@PutMapping("/update")
	public ResponseEntity<Payment> updatepayment(@RequestBody Payment payment) throws NoSuchPaymentException {
		Payment resultpayment = paymentService.updatePayment(payment.getPaymentId(), payment);
		return new ResponseEntity<Payment>(resultpayment, HttpStatus.OK);

	}
	
	
	
	
	
	/******************************************************************************************************
	 * Method                              	: findPayment 
	 * Description                         	: To get the payment from the Database
	 * @param id                      		- payment to be get from the Database
	 * @param PathVariable                 	- used to handle template variables in the request URI mapping,  
	 										and use them as method parameters
	 * @returns Payment                    	- returns Payment
	 * @throws NoSuchPaymentException      	- It is raised when payment not exists in the Database 
	 * Created By                          	- G.Balaji 
	 * Created Date                         - 24-03-2021
	 ******************************************************************************************************/
	@GetMapping("/{id}")
	public ResponseEntity<Payment> findPayment(@PathVariable long id) throws NoSuchPaymentException  {
		Payment resultpayment = paymentService.getPayment(id);
		return new ResponseEntity<Payment>(resultpayment, HttpStatus.OK);

	}
	
	/*****************************************************************************************************
	* Method 							: getAllPayments
	* Description 						: To fetchAll the payments from the Database
	* @returns List<Payment>			- returns all payments
	* @throws NoSuchPaymentException 	- It is raised when payments not exists in the Database
	* Created By 						- G.Balaji
	* Created Date						- 24-03-2021
	*******************************************************************************************************/
	@GetMapping("/getall")
	public ResponseEntity<List<Payment>> getAllPayments() throws NoSuchPaymentException  {
		List<Payment> resultPayments = paymentService.getAllPayments();
		return new ResponseEntity<List<Payment>>(resultPayments, HttpStatus.OK);

	}
	
	/******************************************************************************************************
	 * Method                              	: getCardPayments 
	 * Description                         	: To get the payments from the Database
	 * @param id                      		- payments to be get from the Database using card id
	 * @param PathVariable                 	- used to handle template variables in the request URI mapping,  
	 										and use them as method parameters
	 * @returns List<Payment>                    	- returns Payment
	 * @throws NoSuchPaymentException      	- It is raised when payment not exists in the Database 
	 * Created By                          	- G.Balaji 
	 * Created Date                         - 24-03-2021
	 ******************************************************************************************************/
	@GetMapping("/getcard/{id}")
	public ResponseEntity<List<Payment>> getCardPayments(@PathVariable long id) throws NoSuchPaymentException {
		List<Payment> payments = paymentService.getCardPaymentDetails(id);
		return new ResponseEntity<List<Payment>>(payments, HttpStatus.OK);
	}
}
