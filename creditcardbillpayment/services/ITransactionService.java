package com.cg.creditcardbillpayment.services;

import java.util.List;

import com.cg.creditcardbillpayment.entities.Transaction;

public interface ITransactionService {
	
	public Transaction addTransaction(Transaction transaction);
	public String removeTransaction(long id);
	public Transaction updateTransaction(long id, Transaction transaction);
	public Transaction getTransactionDetails(long id);
	public List<Transaction> getAllTransactions();
	public List<Transaction> getCardTransactionDetails(long id);
}