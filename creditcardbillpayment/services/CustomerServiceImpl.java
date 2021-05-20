package com.cg.creditcardbillpayment.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.creditcardbillpayment.dao.CustomerRepository;
import com.cg.creditcardbillpayment.entities.Customer;
import com.cg.creditcardbillpayment.exceptions.CustomerException;
import com.cg.creditcardbillpayment.exceptions.DuplicateCustomerException;
import com.cg.creditcardbillpayment.exceptions.NoSuchCustomerException;
import com.cg.creditcardbillpayment.exceptions.UserException;


/******************************************************************************************
 * @author 				S.Abhishek 
 * Description			:It is a service class that provides the services to add a customer,
 *  					remove a customer, update a customer and view a customer 
 * Version - 1.0 
 * Created Date - 24-March-2021
 ******************************************************************************************/
@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	

	
	
	/******************************************************************************************************
	 * Method                            	:addCustomer 
	 * Description                       	:To add the customer to the database
	 * @param customer                   	- customer to be added to the database
	 * @returns Customer                 	- returns customer after adding the customer to database 
	 * @throws DuplicateCustomerException	- It is raised when customer already exists
	 * CreatedBy                        	- S.Abhishek 
	 * Created Date                     	- 23-MAR-2021
	 ******************************************************************************************************/	
	@Override
	public Customer addCustomer(Customer customer) throws DuplicateCustomerException {
		// TODO Auto-generated method stub
		Optional<Customer> resultCustomer = customerRepository.findById(customer.getCustomerId());
		if (resultCustomer.isPresent()) {
			throw new DuplicateCustomerException("Customer with " + customer.getCustomerId() + " already exists");
		} else {
			return customerRepository.saveAndFlush(customer);
		}

	}
	
	
	
	/************************************************************************************
	 * Method                           :removeCustomer 
	 * Description                      :To remove the customer from the database
	 * @param custId                  	- customer to be removed from the database
	 * @returns String                  - returns string message when customer removed 
	 * @throws NoSuchCustomerException 	- It is raised when customer does not exists
	 * CreatedBy                        - S.Abhishek 
	 * Created Date                     - 23-MAR-2021
	 ************************************************************************************/
	@Override
	public String removeCustomer(Long custId) throws NoSuchCustomerException {
		// TODO Auto-generated method stub
		try {
			Optional<Customer> resultCustomer = customerRepository.findById(custId);
			if (resultCustomer.isEmpty()) {
				throw new NoSuchCustomerException("Customer id " + custId + " does not exists");
			} else {
				customerRepository.delete(resultCustomer.get());
				return "Customer id " + custId + " removed Successfully ";
			}
		} catch (Exception exception) {
			throw new UserException("Delete the Statements and transactions before removing the customer");
		}
	}

	/******************************************************************************************************
	 * Method                            	:updateCustomer 
	 * Description                       	:To update the customer in the database
	 * @param custId                 	 	- to check the customer is present in the database
	 * @param customer                   	- customer to be updated in the database
	 * @returns Customer                 	- returns customer after updating the customer to database 
	 * @throws NoSuchCustomerException		- It is raised when customer not exists in database
	 * CreatedBy                        	- S.Abhishek 
	 * Created Date                     	- 23-MAR-2021
	 ******************************************************************************************************/
	@Override
	public Customer updateCustomer(Long custId, Customer customer) throws NoSuchCustomerException {
		// TODO Auto-generated method stub
		Optional<Customer> resultCustomer = customerRepository.findById(custId);
		if (resultCustomer.isEmpty()) {
			throw new NoSuchCustomerException("Customer id " + custId + " not found");
		} else {
			return customerRepository.save(customer);
		}
	}
	
	
	
	/************************************************************************************
	 * Method                           :getCustomer 
	 * Description                      :To get the customer from the database
	 * @param custId                  	- To fetch the customer from the database
	 * @returns Customer                - returns customer after fetching the database
	 * @throws NoSuchCustomerException 	- It is raised when customer does not exists
	 * CreatedBy                        - S.Abhishek 
	 * Created Date                     - 23-MAR-2021
	 ************************************************************************************/
	@Override
	public Customer getCustomer(Long custId) throws NoSuchCustomerException {
		Optional<Customer> resultCustomer = customerRepository.findById(custId);
		if (resultCustomer.isEmpty()) {
			throw new NoSuchCustomerException("Customer id " + custId + " does not exists");
		}
		return resultCustomer.get();
	}
	
	
	
	
	/************************************************************************************
	 * Method                           :getAllCustomers
	 * Description                      :To get all the customers from the database
	 * @returns List<Customer>          - returns customers after fetching from the database 
	 * @throws NoSuchCustomerException 	- It is raised when customers not found
	 * CreatedBy                        - S.Abhishek 
	 * Created Date                     - 23-MAR-2021
	 ************************************************************************************/
	@Override
	public List<Customer> getAllCustomers() throws NoSuchCustomerException {
		// TODO Auto-generated method stub
		List<Customer> resultCustomers = customerRepository.findAll();
		if (resultCustomers.isEmpty()) {
			throw new NoSuchCustomerException("No customers found");
		}
		return resultCustomers;
	}

}
