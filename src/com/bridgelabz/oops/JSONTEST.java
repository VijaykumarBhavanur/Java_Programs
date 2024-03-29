package com.bridgelabz.oops;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONTEST 
{
	public static void main(String[] args) throws IOException, ParseException 
	{
		
		System.out.println("Enter item name to get it's value in Rs.\n");
		System.out.println("Choose one among: {Rice,Wheat,Pulse}");
		Scanner scanner=new Scanner(System.in);
		
		String key=scanner.next();
		
		while(!key.equalsIgnoreCase("rice") && !key.equalsIgnoreCase("wheat") && !key.equalsIgnoreCase("pulse") )
		{
			System.out.println("Invalid item: \n enter valid item name: ");
			 key=scanner.next();
		}
		
		if(key.equalsIgnoreCase("rice"))
			key="Rice";
		else if(key.equalsIgnoreCase("wheat"))
			key="Wheat";
		else key="Pulse";
		
		
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(new FileReader("/home/admin1/Desktop/rice.json"));
		JSONObject json=(JSONObject)obj;
		
		InventaryJSON inv1=InventaryJSON.createInventary(json,key);
		
		
		System.out.println("Enter number of KG's to purcahse: ");
		int kg=scanner.nextInt();
		double value=kg*inv1.priceInRupees;
		
		
		//double value=InventaryJSON.GetInventaryValue(inv1);
		
		JSONObject newJson=new JSONObject();
		newJson.put("Value",value);
		System.out.println(newJson);
	
	}
}
	