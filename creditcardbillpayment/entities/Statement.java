package com.cg.creditcardbillpayment.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Statement {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long statementId;
	private Double dueAmount;
	private LocalDate billingDate;
	private LocalDate dueDate;


	@ManyToOne
	@JoinColumn(name="cardId")
	private CreditCard card;

	public Statement() {
		super();
	}

	/**
	 * @param statementId
	 * @param dueAmount
	 * @param billingDate
	 * @param dueDate
	 * @param card
	 */
	public Statement(Long statementId, Double dueAmount, LocalDate billingDate, LocalDate dueDate, CreditCard card) {
		super();
		this.statementId = statementId;
		this.dueAmount = dueAmount;
		this.billingDate = billingDate;
		this.dueDate = dueDate;
		this.card = card;
	}

	/**
	 * @return the statementId
	 */
	public Long getStatementId() {
		return statementId;
	}

	/**
	 * @param statementId the statementId to set
	 */
	public void setStatementId(Long statementId) {
		this.statementId = statementId;
	}

	/**
	 * @return the dueAmount
	 */
	public Double getDueAmount() {
		return dueAmount;
	}

	/**
	 * @param dueAmount the dueAmount to set
	 */
	public void setDueAmount(Double dueAmount) {
		this.dueAmount = dueAmount;
	}

	/**
	 * @return the billingDate
	 */
	public LocalDate getBillingDate() {
		return billingDate;
	}

	/**
	 * @param billingDate the billingDate to set
	 */
	public void setBillingDate(LocalDate billingDate) {
		this.billingDate = billingDate;
	}

	/**
	 * @return the dueDate
	 */
	public LocalDate getDueDate() {
		return dueDate;
	}

	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * @return the card
	 */
	public CreditCard getCard() {
		return card;
	}

	/**
	 * @param card the card to set
	 */
	public void setCard(CreditCard card) {
		this.card = card;
	}

	@Override
	public String toString() {
		return "Statement [statementId=" + statementId + ", dueAmount=" + dueAmount + ", billingDate=" + billingDate
				+ ", dueDate=" + dueDate + ", card=" + card + "]";
	}
	
	

}
