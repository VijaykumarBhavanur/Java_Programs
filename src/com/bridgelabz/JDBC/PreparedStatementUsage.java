package com.bridgelabz.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedStatementUsage 
{
	static Scanner scanner=new Scanner(System.in);
	static PreparedStatement preparedStatement;
	Connection connection;
	
	static void insert() 
	  {
		try {
			Scanner scanner=new Scanner(System.in); 
			System.out.println("Enter employee name: "); 
			String ename=scanner.next();
			preparedStatement=getConnection().prepareStatement("insert into employee(ename) values(?)");
			preparedStatement.setString(1,ename);
			int result=preparedStatement.executeUpdate();
			System.out.println(result+" rows inserted.....");
		}
		catch (Exception e)
		{
			System.out.println("Failed to insert.......");
		}
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/employee_details","root","password");
		return connection;
	}
	
	public static void delete()
	{
		try
		{
		System.out.println("Enter Employee id to delete: ");
		int eid=scanner.nextInt();
		preparedStatement=getConnection().prepareStatement("delete from employee where eid=?");
		preparedStatement.setInt(1,eid);
		int result=preparedStatement.executeUpdate();
		System.out.println("Row  with id: "+eid+" deleted sucessfuly........");
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
		System.out.println("Enter new employee name: ");
		String ename=scanner.next();
		
		preparedStatement=getConnection().prepareStatement("update employee set ename=? where eid=?");
		preparedStatement.setString(1,ename);
		preparedStatement.setInt(2,eid);
		int result=preparedStatement.executeUpdate();
		
		System.out.println("Row  with id: "+eid+" updated sucessfuly........");
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
			preparedStatement=getConnection().prepareStatement("select * from employee");
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				System.out.format("EID: %2s  ENAME:  %-5s",resultSet.getInt(1),resultSet.getString(2));
				System.out.println();
				
			}
		}
		catch (Exception e) 
		{
			System.out.println("Failed to display...");
		}
		
	}
	
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
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
		/*
		 * Class.forName("com.mysql.cj.jdbc.Driver"); Connection
		 * connection=DriverManager.getConnection(
		 * "jdbc:mysql://localhost/employee_details","root","password");
		 * 
		 * 
		 * PreparedStatement preparedStatement=connection.
		 * prepareStatement("insert into employee(eid,ename) values(?,?)");
		 * preparedStatement.setString(1,"12"); preparedStatement.setString(2,"Jijoy");
		 * preparedStatement.executeUpdate();
		 */
		
		//PreparedStatement pStatement=connection.prepareStatement("select * from employee where eid=?");
		//pStatement.setString(1,"1");
		
		/*
		 * PreparedStatement pStatement=connection.
		 * prepareStatement("update employee set ename=? where eid=?");
		 * pStatement.setString(1,"Ramachar"); pStatement.setString(2,"2");
		 * pStatement.executeUpdate();
		 */
		
		/*
		 * PreparedStatement preparedStatement=connection.
		 * prepareStatement("delete from employee where eid=?");
		 * preparedStatement.setString(1,"3"); preparedStatement.executeUpdate();
		 */
		/*
		 * ResultSet res=pStatement.executeQuery();
		 * 
		 * while(res.next()) {
		 * System.out.println(res.getString(1)+" "+res.getString(2)); }
		 */
	}

}
