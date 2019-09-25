package com.bridgelabz.oops;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Transaction
{
	@JsonProperty
	String companyName;
	@JsonProperty
	String customerName;
	@JsonProperty
	int noOfSharesPurchased;
	@JsonProperty
	int noOfSharesSold;
	@JsonProperty
	double totalTransactionValue;
	
	public Transaction(String companyName, String customerName, int noOfSharesPurchased,int noOfSharesSold,double totalTransactionValue)
	{

		this.companyName = companyName;
		this.customerName = customerName;
		this.noOfSharesPurchased=noOfSharesPurchased;
		this.noOfSharesSold=noOfSharesSold;
		this.totalTransactionValue = totalTransactionValue;
	}

	public static void main(String[] args) 
	{

	}

}
