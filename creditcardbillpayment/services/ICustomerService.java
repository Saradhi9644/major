package com.cg.creditcardbillpayment.services;

import java.util.List;

import com.cg.creditcardbillpayment.entities.Customer;
import com.cg.creditcardbillpayment.exceptions.DuplicateCustomerException;
import com.cg.creditcardbillpayment.exceptions.NoSuchCustomerException;

public interface ICustomerService {
	
	public Customer addCustomer(Customer customer)throws DuplicateCustomerException;
	public String removeCustomer(Long custId) throws NoSuchCustomerException;
	public Customer updateCustomer(Long custId, Customer customer) throws NoSuchCustomerException;
	public Customer getCustomer(Long custId) throws NoSuchCustomerException;
	public List<Customer> getAllCustomers() throws NoSuchCustomerException;
}
