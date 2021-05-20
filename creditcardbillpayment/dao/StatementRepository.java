package com.cg.creditcardbillpayment.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.creditcardbillpayment.entities.CreditCard;
import com.cg.creditcardbillpayment.entities.Statement;


public interface StatementRepository extends JpaRepository<Statement,Long>{

	@Query("select statement from Statement statement where statement.dueAmount=0")
	public List<Statement> getBilledStatement();
	
	@Query("select statement from Statement statement where statement.dueAmount!=0")
	public List<Statement> getUnBilledStatement();
	
	@Query("select statement from Statement statement where statement.card.cardId=:Id")
	public Optional<Statement> findCardById(long Id);
}
