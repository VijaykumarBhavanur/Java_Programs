package com.bridgelabz.oops;

public class Company 
{
	int serialNo;
	String companyName;
	int numberofShareAvailable;
	double eachSharePrice;

	
	public Company(int serialNo,String companyName, int numberofShareAvailable, double eachSharePrice) 
	{
		this.serialNo=serialNo;
		this.companyName = companyName;
		this.numberofShareAvailable = numberofShareAvailable;
		this.eachSharePrice = eachSharePrice;
	}


	public int getNumberofShareAvailable() {
		return numberofShareAvailable;
	}


	public void setNumberofShareAvailable(int numberofShareAvailable) {
		this.numberofShareAvailable = numberofShareAvailable;
	}


	public double getEachSharePrice() {
		return eachSharePrice;
	}


	public void setEachSharePrice(double eachSharePrice) {
		this.eachSharePrice = eachSharePrice;
	}
	
	
	
}
