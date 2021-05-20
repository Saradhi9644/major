package com.cg.creditcardbillpayment.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long paymentId;
	private PaymentMethod type;
	private LocalDate paymentDate;
	private String time;	
	private PaymentStatus status;
	private Double amount;
	
	@ManyToOne
	@JoinColumn(name="cardId")
	private CreditCard card;


	public Payment() {
		super();
	}


	public Payment(Long paymentId, PaymentMethod type, LocalDate paymentDate, String time, PaymentStatus status,
			Double amount) {
		super();
		this.paymentId = paymentId;
		this.type = type;
		this.paymentDate = paymentDate;
		this.time = time;
		this.status = status;
		this.amount = amount;
	}


	public Long getPaymentId() {
		return paymentId;
	}


	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}


	public PaymentMethod getType() {
		return type;
	}


	public void setType(PaymentMethod type) {
		this.type = type;
	}


	public LocalDate getPaymentDate() {
		return paymentDate;
	}


	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public PaymentStatus getStatus() {
		return status;
	}


	public void setStatus(PaymentStatus status) {
		this.status = status;
	}


	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}


	public CreditCard getCard() {
		return card;
	}


	public void setCard(CreditCard card) {
		this.card = card;
	}


	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", type=" + type + ", paymentDate=" + paymentDate + ", time=" + time
				+ ", status=" + status + ", amount=" + amount + "]";
	}


	
	

}
