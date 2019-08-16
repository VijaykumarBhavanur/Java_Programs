package com.bridgelabz.functionalprograms;

import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDArray {

	static void printTwoDArray(Object array[][])
	{
		PrintWriter pw = new PrintWriter(System.out, true);
		for (int i = 0; i < array.length; i++) {
					for (int j = 0; j < array.length; j++) {
						pw.printf(array[i][j]+" ");
					}
					System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int rows=0,columns=0;
		
		System.out.println("Enter number of rows: ");
		rows=scanner.nextInt();
		System.out.println("Enter number of columns: ");
		columns=scanner.nextInt();
		
		Object a[][]=new Object[rows][columns];
		
		System.out.println("Enter elements row wise: ");
			for (int i = 0; i < a.length; i++) 
			{
				for (int j = 0; j < a.length; j++) 
				{
					a[i][j]=scanner.next();
				
				}
			}
			
			printTwoDArray(a);
	}
}
