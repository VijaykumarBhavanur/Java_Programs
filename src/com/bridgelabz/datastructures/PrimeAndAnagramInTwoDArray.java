package com.bridgelabz.datastructures;

import java.util.ArrayList;

public class PrimeAndAnagramInTwoDArray 
{
	/* Method to check if a number is Prime*/  
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
	
	/*Method to count number of digits in a number*/
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
	
	/*Method to check is two numbers are anagram*/
	 static boolean isAnagram(int n1, int n2)
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

	 /*Method to compare two integer arrays*/
	private static boolean compare(int a1[], int a2[]) 
	{
		
		for (int i = 0; i < a1.length; i++)
		{
				if(a1[i]!=a2[i])
					return false;
		}
		return true;
	}

	/*Method to sort an integer array*/
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
	
	 /* Method to add elements to 2-D array and display*/
	 static void TwoDArray(ArrayList<Integer> one,ArrayList<Integer> two)
	{

			int p_and_ana[][]=new int[9][12];
			
			int p_not_ana[][]=new int[7][9];
			int index=0;
			
			//Storing prime number and its anagram in 2-D Array
			for (int i = 0; i < 9; i++) 
			{
				for (int j = 0; j <12; j++) 
				{
					if(index<one.size())
					{
						p_and_ana[i][j]=(int)one.get(index);
						index++;
					}
				}
			}
			
			index=0;
			
			//Storing prime number which is not anagram in 2-D Array
			for (int i = 0; i < 7; i++) 
			{
				for (int j = 0; j <9; j++) 
				{
					if(index<two.size())
					{
						p_not_ana[i][j]=(int)two.get(index);
						index++;
					}
				}
			}
			
			
			
		// Displaying 2-D array with prime number and its anagram
		System.out.println("\n2D_Array with Prime and Anagram");
		for (int i = 0; i <9; i++) {
			for (int j = 0; j <12; j++) {
				System.out.print(p_and_ana[i][j]+"  ");
			}
			System.out.println();
		}
		
	 
	// Displaying 2-D array with prime number which is not anagram 
			System.out.println("\n2D_Array with prime number which is not anagram ");
			for (int i = 0; i <7; i++) {
				for (int j = 0; j <9; j++) {
					System.out.print(p_not_ana[i][j]+"  ");
				}
				System.out.println();
			}
			
		}
	 
	 public static void main(String[] args) 
	{
		 /* ArrayList to store all prime numbers in range of 0-1000*/
		ArrayList<Integer> primeList= new ArrayList<Integer>();
		
		/* ArrayList to store all prime numbers and their anagram*/
		ArrayList<Integer> one= new ArrayList<Integer>();
		
		
		/* ArrayList to store all prime numbers which are not anagram  */
		ArrayList<Integer> two= new ArrayList<Integer>();
		
		
		int index1=0,index2=0;
		
 		for (int i = 2; i <1000; i++)
		{
			if(isPrime(i))   //Finding a prime number in range 0-1000 and adding to arrayList
				primeList.add(i);
		}
 		
 		System.out.println("ArrayList with all prime numbers in range of 0-1000");
 		System.out.println(primeList+"\ncount: "+primeList.size());
 		
 		
 		
 		/* Logic to find if a prime-number is anagram by comparing it with elements of given list 
 		 * If anagram number is added to arrayList 'one'
 		 * If not number is added to arrayList 'two' 
 		 */
 		
 		for (int i = 0; i <primeList.size(); i++) 
 		{
			boolean flag=false; //flag to check if prime-number is anagram eg.113,131
			
 			for (int j = i+1; j < primeList.size(); j++) 
 			{
 				if(primeList.get(j)!=-1)
 				if(isAnagram(primeList.get(i),primeList.get(j)))
 				{
 					flag=true;
 					//System.out.print(primeList.get(j)+" ");
 					one.add(index1, primeList.get(j));
 					index1++;
 					primeList.set(j, -1);
 				}
 					
			}
 			if(flag)
 			{
 				//System.out.println(primeList.get(i));
 				one.add(index1,primeList.get(i));
 				index1++;
 			}
 			else if (flag==false && primeList.get(i)!=-1)
 			{
 				two.add(index2, primeList.get(i));
 				index2++;
 			}
		}
 		
 		System.out.println("\nArrayList with all prime numbers and their anagram ");
 		System.out.println(one+"\n count: "+one.size()+"\n");
 		System.out.println("\nArrayList with all prime numbers which are not anagram ");
 		System.out.println(two+"\n count: "+two.size()+"\n");
 		
 		TwoDArray(one, two);
	}
}

