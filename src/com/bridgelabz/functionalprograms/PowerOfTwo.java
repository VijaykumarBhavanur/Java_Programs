package com.bridgelabz.functionalprograms;

import java.util.Scanner;

public class PowerOfTwo {
	static int power(int n,int p)
	{
		int power=1;
		while(p>0)
		{
			power=power*n;
			p--;
		}
		return power;
		
	}
	public static void main(String[] args)
	{
		
		  Scanner scanner=new Scanner(System.in); System.out.println("Enter N: ");
		  int  N=scanner.nextInt();
		  int i=1;
		
		  while(i<=N)//power(2,N)) 
			  {
			  System.out.println(power(2, i));
			  i++;
			  }
		 
		
		/*
		 * int count = 0; int n = 100000; while (n != 0) { System.out.println(n+" ");
		 * count++; n = n / 2; } System.out.println(count);
		 */
		 
		
	}

}
