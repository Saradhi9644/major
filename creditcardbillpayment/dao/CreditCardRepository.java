package com.cg.creditcardbillpayment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.creditcardbillpayment.entities.CreditCard;


@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard,Long>{

	boolean existsByCardNumber(String cardNumber);
}
