package com.bridgelabz.designPatterns.FactoryDP;

import com.bridgelabz.designPatterns.FactoryDP.Currency;
import com.bridgelabz.designPatterns.FactoryDP.Dubai;
import com.bridgelabz.designPatterns.FactoryDP.India;
import com.bridgelabz.designPatterns.FactoryDP.USA;

public class CurrencyFactory {

	public static Currency createCurrency(String country) 
	{
		if(country.equalsIgnoreCase("india"))
		{
			 return new India();
		}
			else if(country.equalsIgnoreCase("usa"))
			{
			 return new USA();
			}
			else if(country.equalsIgnoreCase("dubai"))
			{
				return new Dubai();
			}
		throw new IllegalArgumentException("No such currency");
	}
}
