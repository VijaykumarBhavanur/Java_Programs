package com.bridgelabz.algorithms;

import java.util.Scanner;

public class GuessUsingBinarySearch 
{
	static Scanner scanner=new Scanner(System.in);
	
	static void binarySearch(int low,int high)
	{
		
		int mid=(low+high)/2;
		System.out.println("Press Y if your guessed number is: "+mid+"\n Press n if not:");
		char c=scanner.next().charAt(0);
		
		if(c=='Y' || c=='y')
		{
			System.out.println("Hey! your guess  number is: "+mid);
			return;
		}
		
		System.out.println("Press l if your guess is between :"+low+" & "+(mid-1));
		System.out.println("Press r if your guess is between :"+(mid+1)+" & "+high);
		
		c=scanner.next().charAt(0);
		
		if(c=='L' || c=='l')
			binarySearch(low,mid-1);
		else
			binarySearch(mid+1,high);
	}

	public static void main(String[] args) 
	{
		System.out.println("Enter N: ");
		int N=scanner.nextInt();
		binarySearch(1,N);
	}

}
