package com.bridgelabz.designPatterns.FacadeDP;

import java.sql.Connection;

public class MySqlHelper {
	
	public static Connection getMySqlDBConnection()
	{
		System.out.println("Returning MYSQL Connection.....");
		return null;
	}
	
	public void generateMySqlPDFReport(String tableName, Connection con)
	{
		System.out.println("Generating PDF Report using MYSQL DB");
	}
	
	public void generateMySqlHTMLReport(String tableName, Connection con)
	{
		System.out.println("Generating HTML Report using MYSQL DB");
	}
}
