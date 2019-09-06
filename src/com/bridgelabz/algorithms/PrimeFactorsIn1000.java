package com.bridgelabz.algorithms;

public class PrimeFactorsIn1000 {

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
	public static void main(String[] args) {
		
		
		for (int i = 0; i <1000; i++)
		{
			 boolean prime=isPrime(i);
			 if(prime)
				 System.out.println(i);
		}
		
	}

}
