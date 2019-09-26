package com.bridgelabz.AddressBook;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Contact {

	@JsonProperty
    private	int id;
	@JsonProperty
	private String firstName;
	@JsonProperty
	private String lastName;
	@JsonProperty
	private String city;
	@JsonProperty
	private String zipCode;
	@JsonProperty
	private String mobileNumber;
	
	public Contact()
	{
		
	}
	public Contact(int id,String firstName, String lastName, String city, String zipCode, String mobileNumber)
	{
		this.id=id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.zipCode = zipCode;
		this.mobileNumber = mobileNumber;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getZipCode() {
		return zipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	public String getPhoneNumber() {
		return mobileNumber;
	}


	public void setPhoneNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public static void main(String[] args)
	{

	}

}
