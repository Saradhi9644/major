package com.cg.creditcardbillpayment.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.creditcardbillpayment.dao.CreditCardRepository;
import com.cg.creditcardbillpayment.entities.CreditCard;
import com.cg.creditcardbillpayment.exceptions.CreditCardException;
import com.cg.creditcardbillpayment.exceptions.DuplicateCreditCardException;
import com.cg.creditcardbillpayment.exceptions.NoSuchCreditCardException;
import com.cg.creditcardbillpayment.exceptions.UserException;


/************************************************************************************
 *          @author          Peram Manogna
 *          Description      It is a service class that provides the services to add a transaction,
 *          				 remove a transaction,update a transaction and view a transaction          
 *          Version          1.0
 *          Created Date     24-03-2021
 ************************************************************************************/

@Service
public class CreditCardServiceImpl implements ICreditCardService {
	@Autowired
	private CreditCardRepository creditcardRepository;
	
	
	
	/************************************************************************************
	 * Method:                         		 :addCreditCard
     * Description							 :To add the creditcard to the Database
	 * @param CreditCard       			     - creditcard to be added to the Database
	 * @returns CreditCard                 	 - returns creditcard after adding the account to DataBase
	 * @throws  DuplicateCreditCardException - It is raised when creditcard id and card number already and
	 * 											exists in Database
     * Created By                            - Peram Manogna
     * Created Date                          - 24-03-2021                           
	 
	 ************************************************************************************/
	@Override
	public CreditCard addCreditCard(CreditCard creditCard) throws DuplicateCreditCardException {
		// TODO Auto-generated method stub
		Optional<CreditCard> resultCard = creditcardRepository.findById(creditCard.getCardId());
		if (resultCard.isEmpty()) {			
			if(!creditcardRepository.existsByCardNumber(creditCard.getCardNumber())) {
				creditcardRepository.saveAndFlush(creditCard);
			}else {
				throw new DuplicateCreditCardException("CreditCard " + creditCard.getCardNumber() + " already exists");
			}				
		} else {
			throw new DuplicateCreditCardException("CreditCard " + creditCard.getCardId() + " already exists");
		}
		return creditCard;
	}
	
	
	
	
	
	/************************************************************************************
	 * Method:                         		 :removeCreditCard
     * Description							 :To remove the creditcard to the Database
	 * @param cardId       			    	 - creditcard to be deleted from the Database
	 * @returns String                 	 	 - returns when removed successfully
	 * @throws  NoSuchCreditCardException	 - It is raised when creditcard does not exists in Database
     * Created By                            - Peram Manogna
     * Created Date                          - 24-03-2021                           
	 
	 ************************************************************************************/

	@Override
	public String removeCreditCard(long cardId) throws NoSuchCreditCardException {
		// TODO Auto-generated method stub
		try {
		Optional<CreditCard> creditcard = creditcardRepository.findById(cardId);
		if (creditcard.isEmpty()) {
			throw new NoSuchCreditCardException("Card id " + cardId + "does not exists");
		} else {
			creditcardRepository.delete(creditcard.get());
			return "Creditcard "+ cardId +" deleted successfully";
		}} catch (Exception exception) {
			throw new UserException("Delete the Statements and transactions before removing the creditcard" );
		}
	}
	
	
	

	/************************************************************************************
	 * Method:                         		 :updateCreditCard
     * Description							 :To update the creditcard to the Database
     * @param cardId 						 - To check the creditcard is present in database
	 * @param card       			     	 - card to be updated to the Database
	 * @returns CreditCard                 	 - returns creditcard
	 * @throws NoSuchCreditCardException	 - It is raised when creditcard does not exists in Database
     * Created By                            - Peram Manogna
     * Created Date                          - 24-03-2021                           
	 
	 ************************************************************************************/

	@Override
	public CreditCard updateCreditCard(long cardId, CreditCard card) throws NoSuchCreditCardException {
		// TODO Auto-generated method stub
		Optional<CreditCard> creditcard = creditcardRepository.findById(cardId);
		if (!creditcard.isEmpty()) {
			return creditcardRepository.save(card);
		} else {
			throw new NoSuchCreditCardException("Card id " + cardId + " does not exist");
		}
	}
	
	
	
	/************************************************************************************
	 * Method:                         		 :getCreditCard
     * Description							 :To fetch the creditcard to the Database
	 * @param cardId       			     	 - creditcard to be fetch to the Database
	 * @returns CreditCard                 	 - returns creditcard
	 * @throws  NoSuchCreditCardException	 - It is raised when creditcard does not exists in Database
     * Created By                            - Peram Manogna
     * Created Date                          - 24-03-2021                           
	 
	 ************************************************************************************/
	@Override
	public CreditCard getCreditCard(long cardId) throws NoSuchCreditCardException {
		// TODO Auto-generated method stub
		Optional<CreditCard> creditcard = creditcardRepository.findById(cardId);
		if (!creditcard.isEmpty())
			return creditcard.get();
		else
			throw new NoSuchCreditCardException("Card id " + cardId + " does not exist");
	}
	
	
	
	/************************************************************************************
	 * Method:                         		 :getAllCreditCards
     * Description							 :To fetchAll the creditcard to the Database
	 * @returns CreditCard                 	 - returns creditcards
	 * @throws  NoSuchCreditCardException	 - It is raised when creditcard does not exists in Database
     * Created By                            - Peram Manogna
     * Created Date                          - 24-03-2021                           
	 
	 ************************************************************************************/
	@Override
	public List<CreditCard> getAllCreditCards() throws NoSuchCreditCardException {
		// TODO Auto-generated method stub
		List<CreditCard> creditCards = creditcardRepository.findAll();
		if (creditCards.isEmpty()) {
			throw new NoSuchCreditCardException("No credit cards found");
		}
		return creditCards;
	}



	/************************************************************************************
	 * Method:                         		 :checkCardNumber
     * Description							 :To check the creditcard number exists in the Database
	 * @returns boolean                 	 - returns true, if exists
	 * @throws  DuplicateCreditCardException - It is raised when creditcard  exists in Database
     * Created By                            - Peram Manogna
     * Created Date                          - 24-03-2021                           
	 
	 ************************************************************************************/

	@Override
	public boolean checkCardNumber(String cardNumber) throws DuplicateCreditCardException {
		// TODO Auto-generated method stub
		if(creditcardRepository.existsByCardNumber(cardNumber)) {
			throw new DuplicateCreditCardException("Card Number "+cardNumber+" already exists");
		}
		return false;
	}

}
