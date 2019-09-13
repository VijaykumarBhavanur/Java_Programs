package com.bridgelabz.TestingPrograms;

import org.json.simple.JSONObject;

public class InventaryJSON 
{
	 String name;
	 double weightInKg;
	 double priceInRupees;
	 
	public InventaryJSON(String name, double weightInKg, double priceInRupees) 
	{
		super();
		this.name = name;
		this.weightInKg = weightInKg;
		this.priceInRupees = priceInRupees;
	}

	public static InventaryJSON createInventary(JSONObject json,String key)
	{
		InventaryJSON inventaryJSON=null;
		
		JSONObject json1=(JSONObject) json.get(key);
		String name= (String) json1.get("name");
		double weight=Double.valueOf((String) json1.get("weightInKg"));
		double price=Double.valueOf((String) json1.get("priceInRupees"));
		
		inventaryJSON=new InventaryJSON(name, weight, price);
		
		return inventaryJSON;
	}
	
	public static double GetInventaryValue(InventaryJSON inventary)
	{
		return (inventary.weightInKg*inventary.priceInRupees);
	}

	public static void main(String[] args) 
	{
	
		
	}

}
