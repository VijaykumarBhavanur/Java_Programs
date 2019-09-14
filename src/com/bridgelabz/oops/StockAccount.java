package com.bridgelabz.oops;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class StockAccount 
{

	
	public  static void createStockAccount(String file) throws FileNotFoundException, IOException, ParseException
	{
		JSONObject json=(JSONObject) new JSONParser().parse(new FileReader("/home/admin1/Desktop/customer.json"));
		JSONArray a=(JSONArray)json.get("CUSTOMER");
		
		
		for (int i = 0; i < a.size(); i++)
		{
			JSONObject j=(JSONObject)a.get(i);
			String name=(String)j.get("Name");
			double accountBalance=Double.valueOf(j.get("AccountBalance").toString());
			int sharePurchased=Integer.valueOf(j.get("SharePurchased").toString());
			Customer c=new Customer(name, accountBalance, sharePurchased);
			System.out.println("New stock account created with details: \n");
			System.out.print("\nName: "+c.name+" balance: "+c.accountBalance+"  no.OfShare: "+c.sharePurchased+"\n");
		}
		
	}
	
	public static TreeMap createCompanyStock(String file) throws FileNotFoundException, IOException, ParseException
	{
		
		TreeMap<Integer, Company> companyData=new TreeMap<Integer, Company>();
		
		JSONObject json=(JSONObject) new JSONParser().parse(new FileReader(file));
		JSONArray a=(JSONArray)json.get("STOCK");
		
		
		for (int i = 0; i < a.size(); i++)
		{
			JSONObject j=(JSONObject)a.get(i);
			String companyName=(String)j.get("companyName");
			int numberofShareAvailable=Integer.valueOf(j.get("numberofShareAvailable").toString());
			double eachSharePrice=Double.valueOf(j.get("eachSharePrice").toString());
			Company company=new Company(companyName,numberofShareAvailable,eachSharePrice);
			
			companyData.put(i,company);
			System.out.println("New company stock  created with details: \n");
			System.out.print("Name: "+company.companyName+" No.OfShares: "+company.numberofShareAvailable+"  PriceOfEachShare: "+company.eachSharePrice+"\n");
		}
		
		return companyData;
		
	}
	public static double valueOf(Customer customer)
	{
		return customer.getValueOfAccount();
	}
	
	public static void buy(int noOfShares,Company company,Customer customer)
	{
		if(noOfShares>company.numberofShareAvailable)
			System.out.println(noOfShares+" are not available for company "+company.companyName+"\nNumber of shares available are: "+company.numberofShareAvailable);
		else	
		{
			System.out.println("Before transaction:\n customer account balance: "+customer.accountBalance);
			System.out.println("share purchased: "+customer.sharePurchased);
			customer.accountBalance=customer.accountBalance-(company.eachSharePrice*noOfShares);
			
			
			System.out.println("After transaction:\n customer account balance: "+customer.accountBalance);
			System.out.println("share purchased: "+customer.sharePurchased);
		}
	}
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException
	{

		String file="/home/admin1/Desktop/rice.json";
		String file1="/home/admin1/Desktop/companyShare.json";
		createStockAccount(file);
		System.out.println();
		
		TreeMap<String, Company> companyList=createCompanyStock(file1);
		System.out.println();
		
		
		System.out.println("  Company-name    Number of share available      Price of eack stock");
		Set s=companyList.keySet();
		
		for (Object object : s)
		{
			Company c=(Company)companyList.get(object);
			System.out.print("    "+c.companyName+"     "+c.numberofShareAvailable+"      "+c.eachSharePrice+"\n");
		}
		
	}

}
