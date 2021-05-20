package com.cg.creditcardbillpayment.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class CreditCard {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long cardId;
	private String bankName;
	private CardType cardType;
	private String cardName;
	private String cardNumber;
	private LocalDate cardExpiry;
	private Integer cvv;
	private Integer creditLimit;	

	
	
	
	public CreditCard() {
		super();
	}

	

	public CreditCard(Long cardId, String bankName, CardType cardType, String cardName, String cardNumber,
			LocalDate cardExpiry, Integer cvv, Integer creditLimit) {
		super();
		this.cardId = cardId;
		this.bankName = bankName;
		this.cardType = cardType;
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.cardExpiry = cardExpiry;
		this.cvv = cvv;
		this.creditLimit = creditLimit;
	}



	/**
	 * @return the cardId
	 */
	public Long getCardId() {
		return cardId;
	}

	/**
	 * @param cardId the cardId to set
	 */
	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}

	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * @return the cardType
	 */
	public CardType getCardType() {
		return cardType;
	}

	/**
	 * @param cardType the cardType to set
	 */
	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	/**
	 * @return the cardName
	 */
	public String getCardName() {
		return cardName;
	}

	/**
	 * @param cardName the cardName to set
	 */
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	/**
	 * @return the cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * @return the cardExpiry
	 */
	public LocalDate getCardExpiry() {
		return cardExpiry;
	}

	/**
	 * @param cardExpiry the cardExpiry to set
	 */
	public void setCardExpiry(LocalDate cardExpiry) {
		this.cardExpiry = cardExpiry;
	}

	/**
	 * @return the cvv
	 */
	public Integer getCvv() {
		return cvv;
	}

	/**
	 * @param cvv the cvv to set
	 */
	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}



	public Integer getCreditLimit() {
		return creditLimit;
	}



	public void setCreditLimit(Integer creditLimit) {
		this.creditLimit = creditLimit;
	}



	@Override
	public String toString() {
		return "CreditCard [cardId=" + cardId + ", bankName=" + bankName + ", cardType=" + cardType + ", cardName="
				+ cardName + ", cardNumber=" + cardNumber + ", cardExpiry=" + cardExpiry + ", cvv=" + cvv
				+ ", creditLimit=" + creditLimit + "]";
	}



	

	
}
