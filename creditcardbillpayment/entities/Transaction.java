package com.cg.creditcardbillpayment.entities;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long transactionId;
	private TransactionStatus status;	
	private LocalDate transactionDate;
	private String time;	
	private Double transactionAmount;
	private PaymentMethod paymentMethod;

	
	@ManyToOne
	@JoinColumn(name="cardId")
	private CreditCard card;

	public Transaction() {
		super();
	}

	public Transaction(Long transactionId, TransactionStatus status, LocalDate transactionDate, String time,
			Double transactionAmount, PaymentMethod paymentMethod ) {
		super();
		this.transactionId = transactionId;
		this.status = status;
		this.transactionDate = transactionDate;
		this.time = time;
		this.transactionAmount = transactionAmount;
		this.paymentMethod = paymentMethod;
	
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public TransactionStatus getStatus() {
		return status;
	}

	public void setStatus(TransactionStatus status) {
		this.status = status;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public CreditCard getCard() {
		return card;
	}

	public void setCard(CreditCard card) {
		this.card = card;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", status=" + status + ", transactionDate="
				+ transactionDate + ", time=" + time + ", transactionAmount=" + transactionAmount + ", paymentMethod="
				+ paymentMethod + "]";
	}

	

	
}
