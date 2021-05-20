package com.cg.creditcardbillpayment.services;

import java.util.List;

import com.cg.creditcardbillpayment.entities.Payment;
import com.cg.creditcardbillpayment.exceptions.DuplicatePaymentException;
import com.cg.creditcardbillpayment.exceptions.NoSuchPaymentException;

public interface IPaymentService {
	
	public Payment addPayment(Payment payment) throws DuplicatePaymentException;
	public String removePayment(long id) throws NoSuchPaymentException;
	public Payment updatePayment(long id, Payment payment) throws NoSuchPaymentException;
	public Payment getPayment(long id) throws NoSuchPaymentException;
	public List<Payment> getAllPayments()  throws NoSuchPaymentException;
	public List<Payment> getCardPaymentDetails(long id) throws NoSuchPaymentException;
	
}
