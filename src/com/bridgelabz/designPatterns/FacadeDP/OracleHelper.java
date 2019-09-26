package com.bridgelabz.designPatterns.FacadeDP;

import java.sql.Connection;

public class OracleHelper {
	
	public static Connection getOracleDBConnection()
	{
		System.out.println("Returning OracleDB Connection.....");
		return null;
	}
	
	public void generateOracleDBPDFReport(String tableName, Connection con)
	{
		System.out.println("Generating PDF Report using Oracle DB");
	}
	
	public void generateOracleDBHTMLReport(String tableName, Connection con)
	{
		System.out.println("Generating HTML Report using Oracle DB");
	}
}
