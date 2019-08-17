package com.bridgelabz.functionalprograms;

import java.util.Scanner;

public class Distance
{
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter x1: ");
		int x1=scanner.nextInt();
	
		System.out.println("Enter y1: ");
		int y1=scanner.nextInt();
		
		double distance=Math.sqrt(x1*x1+y1*y1);
		System.out.println("Distance between (0,0) and ("+x1+","+y1+") is: "+distance);
		

	}

}
