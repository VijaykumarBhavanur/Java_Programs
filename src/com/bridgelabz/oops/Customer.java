package com.bridgelabz.oops;

public class Customer
{
	int AccountId;
	String name;
	double accountBalance;
	int sharePurchased;
	Customer()
	{
		
	}
	public Customer(int AccountId,String name, double accountBalance, int sharePurchased) 
	{
		this.AccountId=AccountId;
		this.name = name;
		this.accountBalance = accountBalance;
		this.sharePurchased = sharePurchased;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getAccountBalance() {
		return accountBalance;
	}


	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}


	public int getSharePurchased() {
		return sharePurchased;
	}


	public void setSharePurchased(int sharePurchased) {
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
