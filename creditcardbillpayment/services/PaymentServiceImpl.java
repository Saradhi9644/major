package com.cg.creditcardbillpayment.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.creditcardbillpayment.dao.PaymentRepository;
import com.cg.creditcardbillpayment.entities.Payment;
import com.cg.creditcardbillpayment.entities.Transaction;
import com.cg.creditcardbillpayment.entities.User;
import com.cg.creditcardbillpayment.exceptions.DuplicatePaymentException;
import com.cg.creditcardbillpayment.exceptions.NoSuchPaymentException;
import com.cg.creditcardbillpayment.exceptions.NoSuchUserException;
import com.cg.creditcardbillpayment.exceptions.TransactionServiceException;

/**********************************************************************************************************
 *          @author          G.Balaji
 *          Description      It is a service class that provides the   services to add a payment,remove
 *                            a payment,update a payment and view the payments
 *          Version          1.0
 *          Created Date     23-March-2021
 **********************************************************************************************************/

@Service
public class PaymentServiceImpl implements IPaymentService{

	@Autowired
	private PaymentRepository paymentRepository;
	
	
	/***********************************************************************************************
	 * Method                             :addPayment
     * Description                        :To add payment to the Database
	 * @param Payment                     - Payment to be added to the Database
	 * @returns payment               	  - Return payment after adding the card to Database
	 * @throws DuplicatePaymentException  - It is raised When payment already exists in the Database                                 
     * Created By                         - G.Balaji
     * Created Date                       - 23-March-2021                          
	 ***********************************************************************************************/

	@Override
	public Payment addPayment(Payment payment) throws DuplicatePaymentException {
		// TODO Auto-generated method stub
		Optional<Payment> payment1 = paymentRepository.findById(payment.getPaymentId());
		if (payment1.isEmpty()) {
			return paymentRepository.saveAndFlush(payment);
		} else {
			throw new DuplicatePaymentException("Payment " + payment.getPaymentId() + " already exists");
		}
	}
	
	/***********************************************************************************************
	 * Method                         	: removePayment
     * Description                     	: To remove payment from the Database
	 * @param id                 		- Payment to be removed from the Database
	 * @throws NoSuchPaymentException  	- It is raised When payment does not exist in the Database 
	 * @returns String                 	- Return when payment deleted 
     * Created By                       - G.Balaji
     * Created Date                     - 23-March-2021                          
	 ***********************************************************************************************/

	@Override
	public String removePayment(long id) throws NoSuchPaymentException {
		// TODO Auto-generated method stub
		Optional<Payment> payment = paymentRepository.findById(id);
		if (payment.isEmpty())
			throw new NoSuchPaymentException("Payment id " + id + " does not exists");
		else
			paymentRepository.delete(payment.get());
		return "Payment deleted successfully";

	}
	
	
	
	/***********************************************************************************************
	 * Method                         	: updatePayment
     * Description                    	: To update the payment to the Database
     * @param id                 		- To check the Payment id in the Database
	 * @param Payment                  	- Payment to be  updated the Database
	 * @returns Payment                	- Return payment after updated to the Database
	 * @throws NoSuchPaymentException  	- It is raised When Id does not found in the Database                                 
     * Created By                       - G.Balaji
     * Created Date                     - 23-March-2021                          
	 ***********************************************************************************************/
	@Override
	public Payment updatePayment(long id, Payment payment) throws NoSuchPaymentException {
		// TODO Auto-generated method stub
		Optional<Payment> payment1 = paymentRepository.findById(id);
		if (payment1.isEmpty()) {
			throw new NoSuchPaymentException("Payment id " + id + " does not found");
		} else
			paymentRepository.save(payment);
		return payment;
	}
	
	
	/***********************************************************************************************
	 * Method                         	: getPayment
     * Description                     	: To fetch the payment from the Database
	 * @param id                  		- Payment to be fetched from the Database
	 * @returns Payment               	- Return payment after fetched from the Database
	 * @throws NoSuchPaymentException  	- It is raised When Id does not exist in the Database                                 
     * Created By                       - G.Balaji
     * Created Date                     - 23-March-2021                          
	 ***********************************************************************************************/

	@Override
	public Payment getPayment(long id) throws NoSuchPaymentException {
		// TODO Auto-generated method stub
		Optional<Payment> payment = paymentRepository.findById(id);
		if (payment.isEmpty()) {
			throw new NoSuchPaymentException("Id " + id + " does not exist");
		}
		return payment.get();

	}

	/***********************************************************************************************
	 * Method                         	: getAllPayments
     * Description                     	: To fetch the payments from the Database
	 * @returns List<Payment>          	- Return all payments after fetched from the Database
	 * @throws NoSuchPaymentException  	- It is raised When payment not exists in the Database                                 
     * Created By                       - G.Balaji
     * Created Date                     - 23-March-2021                          
	 ***********************************************************************************************/
	@Override
	public List<Payment> getAllPayments() throws NoSuchPaymentException {
		// TODO Auto-generated method stub
		List<Payment> payments = paymentRepository.findAll();
		if (payments.isEmpty()) {
			throw new NoSuchPaymentException("No Payments found");
		}
		return payments;
	}

	/***********************************************************************************************
	 * Method                         	: getCardPaymentDetails
     * Description                    	: To fetch the all payments of cardId
     * @param id                 		- To check the card id in the Database
	 * @returns List<Payment>           - Payments to be fetched from the Database
	 * @throws NoSuchPaymentException  	- It is raised When payments not found in the Database                                 
     * Created By                       - G.Balaji
     * Created Date                     - 23-March-2021                          
	 ***********************************************************************************************/
	@Override
	public List<Payment> getCardPaymentDetails(long id) throws NoSuchPaymentException {
		// TODO Auto-generated method stub
		List<Payment> payments = paymentRepository.getCardPayments(id);
		if (payments.isEmpty()) {
			throw new NoSuchPaymentException("No Payments found");
		}
		return payments;
	}

}
