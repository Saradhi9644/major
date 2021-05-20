package com.cg.creditcardbillpayment.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.creditcardbillpayment.dao.AccountRepository;
import com.cg.creditcardbillpayment.entities.Account;

import com.cg.creditcardbillpayment.exceptions.DuplicateAccountException;
import com.cg.creditcardbillpayment.exceptions.NoSuchAccountException;
import com.cg.creditcardbillpayment.exceptions.UserException;

/*******************************************************************************************
 * @author          	:Rishu Raj
 * Description      	:AccountServiceImpl is a class which is used to implement  
 *          				 necessary business logics for methods such as addAccount,
 *          				 removeAccount, updateAccount, getAccount, getAllAccounts.       					  
 * Version             	- 1.0
 * Created Date      	- 22-MAR-2021
 *******************************************************************************************/
@Service
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private AccountRepository accountRepository;

	/***********************************************************************************************************
	 * Method							: addAccount
     * Description						: To add any account in database using predefined method, saveAndFlush.
     * @param account					- account to be added in database
	 * @returns Account          		- returns account after added to the database
	 * @throws DuplicateAccountException- It is raised when account already exists
     * Created By						- Rishu Raj
     * Created Date						- 22-MAR-2021 
	 ***********************************************************************************************************/
	
	@Override
	public Account addAccount(Account account) {
		// TODO Auto-generated method stub
		Optional<Account> resultAccount = accountRepository.findById(account.getAccountNumber());
		if (resultAccount.isEmpty()) {
			return accountRepository.saveAndFlush(account);
		} else {
			throw new DuplicateAccountException("Account id " + account.getAccountNumber() + " is already exists.");
		}
	}

	
	

	/***********************************************************************************************************
	 * Method							: removeAccount
     * Description						: To delete any particular account using it's accountNumber through
     * 									  deleteById method.
     * @param id						- account id to be removed from database
	 * @returns String          		- returns account removed string
	 * @throws NoSuchAccountException	- It is raised when account not exists
     * Created By						- Rishu Raj
     * Created Date						- 22-MAR-2021 
	 ***********************************************************************************************************/
	
	@Override
	public String removeAccount(long id) throws NoSuchAccountException {
		// TODO Auto-generated method stub
		try {
		if (accountRepository.findById(id).isPresent()) {
			accountRepository.deleteById(id);
			return "Account deleted successfully";
		} else {
			throw new NoSuchAccountException("Account id " + id + " does not exists.");
		}} catch (Exception exception) {
			throw new UserException("Delete the Statements and transactions before removing the account" );
		}
	}
	

	
	/***********************************************************************************************************
	 * Method							: updateAccount
     * Description						: To update any particular account and their details stored in database
     * 									  using save method.
     * @param id						- account id to check in database
     * @param account					- account to be updated in database
	 * @returns Account          		- returns updated account 
	 * @throws NoSuchAccountException	- It is raised when account not exists
     * Created By						- Rishu Raj
     * Created Date						- 22-MAR-2021 
	 ***********************************************************************************************************/
	
	@Override
	public Account updateAccount(long id, Account account) throws NoSuchAccountException {
		// TODO Auto-generated method stub
		Optional<Account> resultAccount = accountRepository.findById(id);
		if (resultAccount.isEmpty()) {
			throw new NoSuchAccountException("Account id " + id + " not found.");
		} else {
			accountRepository.save(account);
		}
		return account;
	}
	
	
	

	/***********************************************************************************************************
	 * Method							: getAccountById
     * Description						: To fetch any particular account using it's accountNumber,
     * 									  using findById.get() method.
     * @param id						- account id to check in database
 	 * @returns Account          		- returns fetched account 
	 * @throws NoSuchAccountException	- It is raised when account not exists
     * Created By						- Rishu Raj
     * Created Date						- 22-MAR-2021 
	 ***********************************************************************************************************/
	@Override
	public Account getAccount(long id) throws NoSuchAccountException {
		// TODO Auto-generated method stub
		if (accountRepository.findById(id).isPresent()) {
			return accountRepository.findById(id).get();
		} else {
			throw new NoSuchAccountException("Account id " + id + " does not exists.");
		}
	}
	
	

	/***********************************************************************************************************
	 * Method							: getAllAccounts
     * Description						: To fetch all accounts and their details stored in database.
   	 * @returns Account          		- returns list of all accounts
	 * @throws NoSuchAccountException	- It is raised when account not exists
     * Created By						- Rishu Raj
     * Created Date						- 22-MAR-2021 
	 ***********************************************************************************************************/
	@Override
	public List<Account> getAllAccounts() throws NoSuchAccountException {
		// TODO Auto-generated method stub
		List<Account> resultAccounts = accountRepository.findAll();
		if (resultAccounts.isEmpty()) {
			throw new NoSuchAccountException("No Accounts found");
		}
		return resultAccounts;
	}

}
