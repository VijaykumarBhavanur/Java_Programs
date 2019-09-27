package com.bridgelabz.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Scanner;

public class BatchProccessingUsage 
{
	static ArrayList<Item>itemList=new ArrayList<Item>();
	
	public static void main(String[] args) 
	{
		try {
		
		Scanner scanner=new Scanner(System.in);
	
		while(true)
		{
			System.out.println("More items to insert? Press 'Y' if yes and 'N' if not");
			char ch=scanner.next().charAt(0);
			
			if(ch=='n' || ch=='N')
			break;
			
			System.out.println("Enter Item name: ");
			String iname=scanner.next();
			
			System.out.println("Enter Price: ");
			double price=scanner.nextDouble();
			
			System.out.println("Enter quantity: ");
			int quant=scanner.nextInt();
			
			Item item=new Item(iname, price, quant);
			itemList.add(item);
	 }
		
		Connection connection=PreparedStatementUsage.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("insert into Item(ITEMNAME,PRICE,QUANTITY)values(?,?,?)");
		
		for (Item item : itemList) 
		{
			System.out.println("adding item..........");
			preparedStatement.setString(1,item.getITEMNAME());
			preparedStatement.setDouble(2,item.getPRICE());
			preparedStatement.setInt(3,item.getQUANTITY());
			
			preparedStatement.addBatch();
		}
	int a[]=preparedStatement.executeBatch();
	
		System.out.println(a.length+" items added............");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		

	}
}