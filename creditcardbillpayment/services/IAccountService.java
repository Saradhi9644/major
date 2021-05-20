package com.cg.creditcardbillpayment.services;

import java.util.List;

import com.cg.creditcardbillpayment.entities.Account;
import com.cg.creditcardbillpayment.exceptions.NoSuchAccountException;

public interface IAccountService {
	
	public Account addAccount(Account account);
	public String removeAccount(long id) throws NoSuchAccountException;
	public Account updateAccount(long id, Account account) throws NoSuchAccountException;
	public Account getAccount(long id) throws NoSuchAccountException;
	public List<Account> getAllAccounts() throws NoSuchAccountException;
	
}
