package com.bridgelabz.designPatterns.FactoryDP;

public class TestFactory 
{
	public static void main(String[] args) 
	{
			try
			{
				Currency currency=CurrencyFactory.createCurrency("africa");
				System.out.println("Printing currency......"+currency.getCurrency());
			}catch (Exception e) 
			{
				System.out.println("Invalid country input");
			}
	}

}
