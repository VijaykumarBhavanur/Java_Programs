package com.bridgelabz.TestingPrograms;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinarySearchString 
{	
	 static String[] sortStrings(String[] s) 
	{		
		for (int i = 1; i < s.length; i++) 
		{
			int j = i - 1;
			String temp = s[i];

			while (j >= 0 && s[j].toLowerCase().compareTo(temp.toLowerCase()) > 0) 
			{
				s[j + 1] = s[j];
				j--;
			}
			
			s[j + 1] = temp;
		}
		
		return s;
	}
	 
	 static int binarySearchString(String a[],String s1)
	 {
		 System.out.println("::::::::::::::::::::In binary search::::");
		 displayString(a);
		 
		 int low=0,high=a.length-1;
			
			while(low<=high)
			{
				
				int mid=(low+high)/2;
				if(a[mid].equals(s1))
					return mid;
				
				if(a[mid].compareTo(s1)<0)
					low=mid+1;
				
				else 
					high=mid-1;
			}	
			return -1;
	 }
	 
	 static void displayString(String arr[])
	 {
		 String st="{";
			for (int i = 0; i < arr.length; i++)
			{
				if(i!=arr.length-1)
					st=st+arr[i]+",";
				else
					st=st+arr[i]+"}";
			}
		 
		 System.out.println(st);
	 }
	
	 
	 public static void main(String[] args) throws FileNotFoundException 
	{
		
		/*
		 * String s1[]={"z", "Edit","File","Navigate","Refactor","Source", "abc"};
		 * 
		 * // String s1[]={"Refactor","Source","Navigate","Edit","File"};
		 * s1=sortStrings(s1); displayString(s1);
		 * System.out.println(binarySearchString(s1, "File"));
		 */
		  
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter number of Strings you wish to enter: ");

		int size = scanner.nextInt();

		String arr[] = new String[size];

		for (int i = 0; i < arr.length; i++) 
		{
			System.out.println("Enter string: ");
			arr[i] = scanner.next().trim();
		}

		arr = sortStrings(arr);

		System.out.println("Strings after sorting");
		displayString(arr);

		System.out.println("Enter string to search:");
		String input = scanner.next();

		int index = binarySearchString(arr, input);

		if (index != -1)
			System.out.println(input + " found at index: " + index);
		else
			System.out.println(input + " not found");
	}
}
