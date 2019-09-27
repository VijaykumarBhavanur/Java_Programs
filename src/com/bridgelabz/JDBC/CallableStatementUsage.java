package com.bridgelabz.JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class CallableStatementUsage {

	static CallableStatement call;

	public static void getSeniorEmployee() 
	{
		try {
			call = getConnection().prepareCall("{?=call getSenior()}");
			call.registerOutParameter(1, Types.VARCHAR);
			call.execute();
			String ename = call.getString(1);
			System.out.println("Senior Employee: " + ename);

		} catch (Exception e) {
			System.out.println("Failed to get senior employee");
		}
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/employee_details", "root",
				"password");
		return connection;
	}

	public static void GetEmployeeNameWithS()
	{
		try {
		call=getConnection().prepareCall("{call getNameStartingWithS()}");
		ResultSet res=call.executeQuery();
		
		while(res.next())
		{
			System.out.format("EID: %2s  ENAME:  %-5s",res.getInt(1),res.getString(2));
			System.out.println();
			
		}
		
		
		
		}
		catch (Exception e) {
			System.out.println("Failed to fetch employees with name S");
		}
	}
	public static void main(String[] args) 
	{
		GetEmployeeNameWithS();
		//getSeniorEmployee();
		/*
		 * 
		 * Connection connection=null; CallableStatement call=null;
		 * 
		 * try { Class.forName("com.mysql.cj.jdbc.Driver");
		 * 
		 * connection=DriverManager.getConnection(
		 * "jdbc:mysql://localhost/employee_details","root","password");
		 * 
		 * call=connection.prepareCall("{?= call getSeniorEmps()}");
		 * call.registerOutParameter(1,Types.VARCHAR); call.execute();
		 * System.out.println("Senior Employee: "+call.getString(1));
		 * 
		 * 
		 * 
		 * // Scanner scanner=new Scanner(System.in); //
		 * System.out.println("Enter empId: ");
		 * 
		 * int id=scanner.nextInt();
		 * call=connection.prepareCall("{call showEmployeeBasedOnID(?)}");
		 * call.setInt(1, id); ResultSet resultSet=call.executeQuery();
		 * while(resultSet.next()) {
		 * System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)); }
		 * 
		 * 
		 * 
		 * call=connection.prepareCall("{?=call countEmployee()}");
		 * call.registerOutParameter(1,Types.INTEGER); call.execute(); int
		 * countEmployee=call.getInt(1);
		 * 
		 * System.out.println("Employee count: "+countEmployee);
		 * 
		 * 
		 * // call=connection.prepareCall("{call showEmployeeInfo()}"); // ResultSet
		 * resultSet=call.executeQuery(); // while(resultSet.next()) { //
		 * System.out.println(resultSet.getString(1)+" "+resultSet.getString(2)); } }
		 * catch (Exception e) { e.getMessage(); }
		 */
	}

}
