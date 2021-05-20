package com.cg.creditcardbillpayment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.creditcardbillpayment.entities.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long>{
	
	@Query("select transaction from Transaction transaction where transaction.card.cardId=:id")
	List<Transaction> getCardTransaction(long id);

}
