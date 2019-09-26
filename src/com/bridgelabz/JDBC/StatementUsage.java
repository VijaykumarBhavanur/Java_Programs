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
	static void insert() throws ClassNotFoundException, SQLException
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter eid:");
		int eid=scanner.nextInt();
		System.out.println("Enter ename: ");
		String ename=scanner.next();
		
		Statement statement1=getStatement();
		int result=statement1.executeUpdate("insert into employee values("+eid+","+ename+")");
		System.out.println(result+" rows inserted.....");
		statement1.close();
		
	}
	
	public static Statement getStatement() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/employee_details","root","password");
		 statement=connection.createStatement();
		return statement;
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		ResultSet result=getStatement().executeQuery("select * from employee");
		
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2));
		}
		insert();
		result.close();
		statement.close();
		
	}

}
