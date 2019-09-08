package com.bridgelabz.datastructures;

import java.util.ArrayList;

public class PrimeAndAnagramInTwoDArray 
{
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
	
	public  static int getDigitCount(int number)
	{
		int digCount=0;
		while(number>0)
		{
			digCount++;
			number=number/10;
		}
		
		return digCount;
	}
	
	private static boolean isAnagram(int n1, int n2)
	{
		int num1[]=new int[getDigitCount(n1)];
		int num2[]=new int[getDigitCount(n2)];
		int i=0;
				if(getDigitCount(n1)!=getDigitCount(n2))
					return false;
				else
				{
					
					while(n1!=0 && n2!=0)
					{
						int rem1=n1%10;
						int rem2=n2%10;
						
						num1[i]=rem1;
						num2[i]=rem2;
						
						
						n1=n1/10;
						n2=n2/10;
						i++;
					}
					
					
					num1=sort(num1);
					num2=sort(num2);
				}
		return compare(num1,num2);
	}

	private static boolean compare(int a1[], int a2[]) 
	{
		
		for (int i = 0; i < a1.length; i++)
		{
				if(a1[i]!=a2[i])
					return false;
		}
		return true;
	}

	 static int[] sort(int a[]) 
	{
		for (int i = 0; i < a.length; i++)
		{
				for (int j = 0; j < a.length; j++) 
				{
						if(a[i]>a[j])
						{
							int temp=a[i];
							a[i]=a[j];
							a[j]=temp;
						}
				}
		}
		return a;
	}
	public static void main(String[] args) 
	{
		ArrayList<Integer> primeList= new ArrayList<Integer>();
		ArrayList<Integer> one= new ArrayList<Integer>();
		ArrayList<Integer> two= new ArrayList<Integer>();
		
 		for (int i = 2; i <1000; i++)
		{
			if(isPrime(i))
				primeList.add(i);
		}
 		System.out.println(primeList+"\ncount: "+primeList.size());
 		
 		boolean flag=false;
 		
 		for (int i = 0; i < primeList.size(); i++) 
 		{
			for (int j = i+1; j <primeList.size(); j++) 
			{
				if(isAnagram(primeList.get(i),primeList.get(j)));
				{
				flag=true;
				break;
				}
			}
			
			if(flag)
			{
				one.add(primeList.get(i));
				flag=false;
			}
			else
				two.add(primeList.get(i));
			
		}
 		
 		System.out.println(one+"\n count: "+one.size());
 		System.out.println(two+"\n count: "+two.size());
 	
	}

}
