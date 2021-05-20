package com.cg.creditcardbillpayment.entities;

import javax.persistence.Embeddable;



@Embeddable
public class Address {
	
	private String doorNo;
	private String street;
	private String area;
	private String city;
	private String state;
	private Integer pincode;

	public Address() {
		super();
	}

	/**
	 * @param addressRef
	 * @param doorNo
	 * @param street
	 * @param area
	 * @param city
	 * @param state
	 * @param pincode
	 */
	public Address(String doorNo, String street, String area, String city, String state, Integer pincode) {
		super();
		
		this.doorNo = doorNo;
		this.street = street;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}


	
	/**
	 * @return the doorNo
	 */
	public String getDoorNo() {
		return doorNo;
	}

	/**
	 * @param doorNo the doorNo to set
	 */
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the pincode
	 */
	public Integer getPincode() {
		return pincode;
	}

	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(	Integer pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [ doorNo=" + doorNo + ", street=" + street + ", area=" + area
				+ ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
	}

	
}
