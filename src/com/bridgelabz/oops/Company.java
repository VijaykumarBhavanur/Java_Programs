package com.bridgelabz.oops;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Company 
{
	@JsonProperty
	int serialNo;
	@JsonProperty
	String companyName;
	@JsonProperty
	int numberofShareAvailable;
	@JsonProperty
	double eachSharePrice;

	public Company() {
		
	}
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
