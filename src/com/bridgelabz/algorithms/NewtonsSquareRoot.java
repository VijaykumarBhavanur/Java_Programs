package com.bridgelabz.algorithms;

import java.util.Scanner;

public class NewtonsSquareRoot 
{
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter a non-negative number to find Square-root: ");
		
		int c=scanner.nextInt();
		while(true)
		{
			if(c<=0)
			{
				System.out.println("Entered number is negative number please enter a positive number: ");
				 c=scanner.nextInt();
			}
			else
				break;
		}
		
		int t=c;
		
		double epsilon = 1e-15;
		while(Math.abs(t - c/t) > epsilon*t)
		{
		t=(c/t+t)/2;
		}

		System.out.println("Square-root of "+c+" is : "+t);
	}

}
