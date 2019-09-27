package com.bridgelabz.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.bridgelabz.designPatterns.Singleton.StaticBlockSingleton;


public class StatementUsage
{
	static Statement statement;
	static Scanner scanner=new Scanner(System.in);
	
	static void insert() 
	  {
		try {
			Scanner scanner=new Scanner(System.in); 
			System.out.println("Enter employee name: "); 
			String ename=scanner.next();
		
			Statement statement1=getStatement();
			int result=statement1.executeUpdate("INSERT INTO employee(ENAME)VALUES('"+ename+"')");
			System.out.println(result+" rows inserted.....");
			statement1.close();
		}
		catch (Exception e)
		{
			System.out.println("Failed to insert.......");
		}
	}
	
	public static Statement getStatement() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/employee_details","root","password");
		 statement=connection.createStatement();
		return statement;
	}
	
	public static void delete()
	{
		try
		{
		System.out.println("Enter Employee id to delete: ");
		int eid=scanner.nextInt();
		Statement statement1=getStatement();
		statement1.executeUpdate("DELETE FROM employee where eid="+eid);
		System.out.println("Row  with id: "+eid+" deleted sucessfuly........");
		statement1.close();
		}catch (Exception e)
		{
			System.out.println("Failed to delete");
		}
		
	}

	public static void update() 
	{
		try
		{
		System.out.println("Enter Employee id to update: ");
		int eid=scanner.nextInt();
		Statement statement1=getStatement();
		System.out.println("Enter new employee name: ");
		String ename=scanner.next();
		
		statement1.executeUpdate("update employee set ename='"+ename+"' where eid="+eid);
		System.out.println("Row  with id: "+eid+" updated sucessfuly........");
		statement1.close();
		}
		catch (Exception e) 
		{
			System.out.println("Failed to update");
		}
	}
	
	public static void display() 
	{
		try
		{
		Statement statement1=getStatement();
		
		ResultSet resultSet=statement1.executeQuery("select * from employee");
		
		while(resultSet.next())
		{
			System.out.format("EID: %2s  ENAME:  %-5s",resultSet.getInt(1),resultSet.getString(2));
			System.out.println();
			
		}
		statement1.close();
		}
		catch (Exception e) 
		{
			System.out.println("Failed to display");
		}
	}
	
	public static void main(String[] args) 
	{
		System.out.println("Enter your choice:\n\n1.Insert Record\n2.Update Record\n3.Delete Record\n4.View Records");
		try {
				int choice=scanner.nextInt();
			
				switch(choice)
				{
					case 1: insert();
							break;
					case 2: update();
							break;
					case 3: delete();
							break;
					case 4: display();
							break;
					default: System.out.println("Invalid choice\n");
				
				}
		}
		catch (Exception e)
		{
			System.out.println("Invalid usage");
		}

	}

}
