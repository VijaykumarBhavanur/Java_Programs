package com.bridgelabz.JDBC;

public class Item 
{

	String ITEMNAME;
	double PRICE;
	int QUANTITY;
	
	public Item(String iTEMNAME, double pRICE, int qUANTITY) {
		super();
		ITEMNAME = iTEMNAME;
		PRICE = pRICE;
		QUANTITY = qUANTITY;
	}

	public String getITEMNAME() {
		return ITEMNAME;
	}

	public void setITEMNAME(String iTEMNAME) {
		ITEMNAME = iTEMNAME;
	}

	public double getPRICE() {
		return PRICE;
	}

	public void setPRICE(double pRICE) {
		PRICE = pRICE;
	}

	public int getQUANTITY() {
		return QUANTITY;
	}

	public void setQUANTITY(int qUANTITY) {
		QUANTITY = qUANTITY;
	}
	
	
	
}
