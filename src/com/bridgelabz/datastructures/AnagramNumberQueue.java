package com.bridgelabz.datastructures;

public class AnagramNumberQueue
{
	static boolean isAnagram(int n1,int n2)
	{
		if(digitCount(n1)!=digitCount(n2))
			return false;
		
		if(compare(n1,n2))
				return true;
		else
			return false;
		
		
		//return true;
	}
	
	static boolean compare(int n1,int n2)
	{
		int arr1[]=new int[digitCount(n1)];
		int arr2[]=new int[digitCount(n2)];
		
		for (int i = 0; i < arr1.length; i++) 
		{
			int rem1=n1%10;
			int rem2=n2%10;
			
			arr1[i]=rem1;
			arr2[i]=rem2;
			n1=n1/10;
			n2=n2/10;
		}
		
		
		return false;
		
	}
	static int digitCount(int number)
	{
		int digCount=0;
		while(number>0)
		{
			digCount++;
			number=number/10;
		}
		
		return digCount;
	}
	public static void main(String[] args)
	{
		
		for (int i = 0; i <1000; i++)
		{
			for (int j = i; j <1000; j++)
			{
			
				if(isAnagram(i,j))
					System.out.println(i);
				
			}
		}
	}

}
