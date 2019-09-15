package com.bridgelabz.oops;

public class Transaction
{
	
	String companyName;
	String customerName;
	int noOfSharesPurchased;
	int noOfSharesSold;
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
