package com.bridgelabz.TestingPrograms;

import java.util.Scanner;

public class SwapNibbles {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the number: ");
		int n=scanner.nextInt();
		int temp=n;
		String bin="";
		while(n>0)
		{
			int rem=n%2;
			bin=rem+bin;
			n=n/2;
		}	
		System.out.println(temp+" in binary: "+bin);
		//System.out.println(bin.length());
		
		if(bin.length()>=4 && bin.length()<8 ||bin.length()<4)
		{
			int pad=8-bin.length();
			
			while(pad!=0)
			{
				bin="0"+bin;
				pad--;
			}
		}
		/*
		 * else {
		 * 
		 * int pad=4-bin.length();
		 * 
		 * while(pad!=0) { bin="0"+bin; pad--; }
		 * 
		 * }
		 */
		
		System.out.println(temp+" in binary after padding 0's : "+bin);
		
		char c[]=bin.toCharArray();
		int	j=bin.length()/2;
		for (int i = 0; i <bin.length()/2; i++)
		{
			char t=c[i];
			c[i]=c[j];
			c[j]=t;
			j++;
		}
		
		System.out.println("After swapping nibbles: "+String.valueOf(c));
		double decimal=0;
		int number=Integer.parseInt(String.valueOf(c));
		
		for (int i = 0; i <bin.length(); i++)
		{
				int rem=number%10;
				decimal=decimal+rem*Math.pow(2, i);
				number=number/10;
		}
		System.out.println("Decimal equivalent of: "+String.valueOf(c)+" is: "+(int)decimal);
	}
	

}
