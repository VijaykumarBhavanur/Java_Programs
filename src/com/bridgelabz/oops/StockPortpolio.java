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

	static Stock[] stock;

    static public double valueOfStock(Stock stock)
	{
			return stock.numberofShare*stock.sharePrice;
	}

	static public double getTotalStockValue() 
	{
		 double totalStockValue=0.0;
		 for (int i = 0; i <stock.length; i++)
		  {
			 totalStockValue=totalStockValue+valueOfStock(stock[i]);
			  
		  }
		return totalStockValue;
	}

	static public Stock createStock(JSONObject json) 
	{
		String stockName = (String) json.get("stockName");
		int numberofShare = Integer.valueOf((String) json.get("numberofShare"));
		double sharePrice = Double.valueOf((String) json.get("sharePrice"));
		Stock stock = new Stock(stockName, numberofShare, sharePrice);
		return stock;
	}

	
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
		Object obj = parser.parse(new FileReader("/home/admin1/Desktop/stock.json"));
		JSONObject json = (JSONObject) obj;

		JSONArray a = (JSONArray) json.get("STOCK");
		stock = new Stock[a.size()];

		for (int i = 0; i < a.size(); i++) 
		{
			Stock st = createStock((JSONObject) a.get(i));
			stock[i] = st;
		}

		  
		/*
		 * System.out.println("\nDisplaying Stock array: "); for (int i = 0; i
		 * <stock.length; i++) {
		 * System.out.println("StockName: "+stock[i].stockName+":::::numberOfPrice: "
		 * +stock[i].numberofShare+":::::::sharePrice: "+stock[i].sharePrice); }
		 * 
		 * 
		 * System.out.
		 * println("\n:::::::::::::::::::::::::::::Displaying value of Each stock::::::::::::::::::::\n"
		 * ); for (int i = 0; i <stock.length; i++) {
		 * System.out.println("\nStockName: "+stock[i].stockName+" StockValue: "
		 * +valueOfStock(stock[i]));
		 * 
		 * }
		 */
		
		  printStockReport(stock);
		  
		  System.out.println("\n:::::::Total Stock Value::::::::");
		  System.out.println("         "+getTotalStockValue());
		  
	}

}
