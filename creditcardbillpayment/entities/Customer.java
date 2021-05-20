package com.cg.creditcardbillpayment.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long customerId;
	private String name;
	private String email;
	private String contactNo;
	private LocalDate dateOfBirth;
	
	@Embedded
	private Address address;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="accountNumber")
	private Account account;	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cardId")
	private CreditCard card;
	
	
	public Customer() {
		super();
	}


	/**
	 * @param customerId
	 * @param name
	 * @param email
	 * @param contactNo
	 * @param dateOfBirth
	 * @param address
	 */
	public Customer(Long customerId, String name, String email, String contactNo, LocalDate dateOfBirth,
			Address address) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
	}



	/**
	 * @return the customerId
	 */
	public Long getCustomerId() {
		return customerId;
	}



	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}



	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}



	/**
	 * @return the contactNo
	 */
	public String getContactNo() {
		return contactNo;
	}



	/**
	 * @param contactNo the contactNo to set
	 */
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}



	/**
	 * @return the dateOfBirth
	 */
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}



	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}



	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}




	/**
	 * @return the accounts
	 */
	public Account getAccounts() {
		return account;
	}



	/**
	 * @param accounts the accounts to set
	 */
	public void setAccounts(Account accounts) {
		this.account = accounts;
	}




	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo
				+ ", dateOfBirth=" + dateOfBirth + ", address=" + address + "]";
	}



	public CreditCard getCard() {
		return card;
	}



	public void setCard(CreditCard card) {
		this.card = card;
	}



	
}
