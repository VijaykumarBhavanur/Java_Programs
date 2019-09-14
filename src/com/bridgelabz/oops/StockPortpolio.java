package com.bridgelabz.oops;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class StockPortpolio 
{

	static Stock[] stock; //Array to hold list of stocks

	
	/*Method to calculate value of Particular Stock*/
    static public double valueOfStock(Stock stock)
	{
			return stock.numberofShare*stock.sharePrice;
	}

    
    /*Method to calculate Total value of Stocks(sum of all stock values)*/
	static public double getTotalStockValue() 
	{
		 double totalStockValue=0.0;
		 for (int i = 0; i <stock.length; i++)
		  {
			 totalStockValue=totalStockValue+valueOfStock(stock[i]);
			  
		  }
		return totalStockValue;
	}

	
	/*Method to create new stock from  json-object read from json file*/
	static public Stock createStock(JSONObject json) 
	{
		String stockName = (String) json.get("stockName");
		int numberofShare = Integer.valueOf((String) json.get("numberofShare"));
		double sharePrice = Double.valueOf((String) json.get("sharePrice"));
		Stock stock = new Stock(stockName, numberofShare, sharePrice);
		return stock;
	}

	
	/*Method to printStockReport (Each stock-name,number of shares, Price-Per-Share and StockValue of each stock )*/
	static public void printStockReport(Stock[] stock)
	{
		System.out.println("  Stock-Name       Number-Of-Shares    Price-Per-Share        StockValue    ");
		System.out.println("-----------------------------------------------------------------------------");
		for (int i = 0; i <stock.length; i++)
		  {
			System.out.println("  "+stock[i].stockName+"            "+stock[i].numberofShare+"                "+stock[i].sharePrice+"                "+valueOfStock(stock[i]));
			  
		  }
	}
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException 
	{
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("/home/admin1/Desktop/stock.json")); //Reading stock details from json-file
		JSONObject json = (JSONObject) obj;

		JSONArray a = (JSONArray) json.get("STOCK");
		stock = new Stock[a.size()];

		for (int i = 0; i < a.size(); i++) 
		{
			//Creating stock object from json-object
			Stock st = createStock((JSONObject) a.get(i));
			stock[i] = st;  //Storing each stock in array
		}

		  
		  //Printing Stock-report
		  printStockReport(stock);
		  
		  System.out.println("\n:::::::Total Stock Value::::::::");
		  System.out.println("         "+getTotalStockValue());
	}

}
