package com.cg.creditcardbillpayment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.creditcardbillpayment.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	
}
