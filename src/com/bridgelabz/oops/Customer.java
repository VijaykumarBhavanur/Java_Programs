package com.bridgelabz.oops;

public class Customer
{
	String name;
	double accountBalance;
	int sharePurchased;
	
	public Customer(String name, double accountBalance, int sharePurchased) 
	{
		this.name = name;
		this.accountBalance = accountBalance;
		this.sharePurchased = sharePurchased;
	}


	public double getValueOfAccount()
	{
		return accountBalance;
	}
	public static void main(String[] args) 
	{

	}

}
