package com.bridgelabz.oops;

/*Custom class with for storing stock-detail*/
public class Stock 
{
	String stockName;
	int numberofShare;
	double sharePrice;
	
	public Stock(String stockName, int numberofShare, double sharePrice)
    {
		this.stockName = stockName;
		this.numberofShare = numberofShare;
		this.sharePrice = sharePrice;
	}

}
