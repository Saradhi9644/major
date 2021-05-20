package com.cg.creditcardbillpayment.services;

import java.util.List;

import com.cg.creditcardbillpayment.entities.CreditCard;
import com.cg.creditcardbillpayment.exceptions.DuplicateCreditCardException;
import com.cg.creditcardbillpayment.exceptions.NoSuchCreditCardException;

public interface ICreditCardService {
	
	public CreditCard addCreditCard(CreditCard creditCard) throws DuplicateCreditCardException;

	public String removeCreditCard(long cardId) throws NoSuchCreditCardException;

	public CreditCard updateCreditCard(long cardId, CreditCard card) throws NoSuchCreditCardException;

	public CreditCard getCreditCard(long cardId) throws NoSuchCreditCardException;

	public List<CreditCard> getAllCreditCards() throws NoSuchCreditCardException;
	
	public boolean checkCardNumber(String cardNumber) throws DuplicateCreditCardException; 

}
