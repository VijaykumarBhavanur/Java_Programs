package com.bridgelabz.functionalprograms;

import java.util.ArrayList;

public class PrimeFactors {

	static boolean isPrime(int n)
	{
		int i=2;
		while(i<=n/2)
		{
			if(n%i==0)
				return false;
			i++;
		}
		
		return true;
		
	}
	
	public static void main(String[] args) 
	{
		int n=12;
		int i=2;
		ArrayList<Integer> arrayList=new ArrayList<>();
		
		while(i<=n/2)
		{
				if(n%i==0&&isPrime(i)==true)
					arrayList.add(i);
				
				i++;
		}
			System.out.println(arrayList);
	}

}
