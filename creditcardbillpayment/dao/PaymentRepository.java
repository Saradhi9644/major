package com.cg.creditcardbillpayment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.creditcardbillpayment.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long>{

	@Query("select payment from Payment payment where payment.card.cardId=:id")
	List<Payment> getCardPayments(long id);

}
