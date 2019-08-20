package com.bridgelabz.algorithms;

import java.util.Scanner;

public class AnagramString 
{
	static String convert(String str)
	{
		
		char convert[]=str.toCharArray();
		for (int i = 0; i < convert.length; i++) 
		{
					if(convert[i]>=65&& convert[i]<=90)
						convert[i]=(char)(convert[i]+32);
		}
		
		
		return String.valueOf(convert);
		
	}
	
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter String1: ");
		String str1=scanner.next();
		
		  boolean output;
		  
		  System.out.println("Enter String2: "); String str2=scanner.next();
		  
		  if(str1.length()!=str2.length())
		  System.out.println("Entered string are not anagrams ");
		  
		  output=isAnagram(str1,str2);
		  
		  if(output) System.out.println("Entered Strings are anagram!"); else
		  System.out.println("Entered Strings are not anagram!");
		 
		
		
	}

	private static boolean isAnagram(String str1, String str2)
	{
		str1=sort(str1);
		str2=sort(str2);
		str1=convert(str1);
		str2=convert(str2);
		return compare(str1,str2);
	}

	private static boolean compare(String str1, String str2) 
	{
		char array1[]=str1.toCharArray();
		char array2[]=str2.toCharArray();
		
		for (int i = 0; i < array1.length; i++)
		{
				if(array1[i]!=array2[i])
					return false;
		}
		return true;
	}

	private static String sort(String str1) 
	{
		char sort[]=str1.toCharArray();
		for (int i = 0; i < sort.length; i++)
		{
				for (int j = 0; j < sort.length; j++) 
				{
						if(sort[i]>sort[j])
						{
							char temp=sort[i];
							sort[i]=sort[j];
							sort[j]=temp;
						}
				}
		}
		return String.valueOf(sort);
	}
}
