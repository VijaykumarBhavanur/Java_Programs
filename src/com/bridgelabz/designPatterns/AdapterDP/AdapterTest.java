package com.bridgelabz.designPatterns.AdapterDP;

import java.util.Scanner;

public class AdapterTest 
{
	public static void main(String[] args) 
	{
		TemperatureInfo tempInfo = new TemperatureClassReporter();
		testTempInfo(tempInfo);
	}
	
	 public static void testTempInfo(TemperatureInfo tempInfo)
	 {
		 Scanner scanner=new Scanner(System.in);
		 System.out.println("Enter temperature in celsius: ");
		 double tempC=scanner.nextDouble();
		 tempInfo.setTemperatureInC(tempC);
		 
		 
		 System.out.println("temp in C:"+ tempInfo.getTemperatureInC());
		 System.out.println("temp in F:"+ tempInfo.getTemperatureInF());
		 
		 System.out.println("Enter temperature in Fahrenheit: ");
		 double tempF=scanner.nextDouble();
		 
		 
		 tempInfo.setTemperatureInF(tempF);
		
		 System.out.println("temp in F:"+ tempInfo.getTemperatureInF());
		 System.out.println("temp in C:"+ tempInfo.getTemperatureInC());
	 }
}