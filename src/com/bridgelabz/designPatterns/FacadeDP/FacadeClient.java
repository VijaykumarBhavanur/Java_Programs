package com.bridgelabz.designPatterns.FacadeDP;
/*
 * Facade Design Pattern===>providing single helper interface on top of sub-interfaces
 * to reduce complexity for client at front end eg: we start the laptop by pressing
 * power button, but internally lot  of things are hidden like circuit connection power supply etc.
 * 
 * 
 *  
 *  We simply call the method dataSource.getConnection() to get the connection 
 *  but internally a lot of things happen such as loading the driver,
 *   creating connection or fetching connection from pool, 
 *   update stats and then return the connection reference to caller method this is another example 
 *   of facade pattern.
 * */



public class FacadeClient
{
		public static void main(String[] args) 
		{
			String tableName="Employee";
			//generating MySql HTML report and Oracle PDF report using Facade
			FacadeHelper.generateReport(FacadeHelper.DBTypes.MYSQL, FacadeHelper.ReportTypes.HTML, tableName);
			FacadeHelper.generateReport(FacadeHelper.DBTypes.ORACLE, FacadeHelper.ReportTypes.PDF, tableName);
		}
	}
