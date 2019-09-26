package com.bridgelabz.TestingPrograms;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortForString 
{
	static int binarySearch(String a[],String s)
	{
		int low=0,high=s.length()-1;
		
		while(low<=high)
		{
			int mid = low + (high - low) / 2; 
			
			if(a[mid]==s)
				return mid;
			
			if(a[mid].compareTo(s)<0)
				low=mid+1;
			
			else 
				high=mid-1;
		}	
		return -1;
	}
	
	
	public static void main(String[] args) 
	{
		System.out.println("Enter number of strings: ");
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		
		//String[] s = { "Yam", "Any", "var", "bh" };
		
		String[] strings=new String[n];
		
		System.out.println("Enter strings to be sorted: ");
		
		for (int i = 0; i <n; i++) 
		{
			strings[i]=scanner.next();
		}
		
		System.out.println("Entered input: ");
		for (int i = 0; i < strings.length; i++) 
		{
			System.out.print(strings[i]+" ");
		}
		for (int i = 1; i < strings.length; i++) 
		{
			int j = i - 1;
			String temp = strings[i];

			while (j >= 0 && strings[j].toLowerCase().compareTo(temp.toLowerCase()) > 0) 
			{
				strings[j + 1] = strings[j];
				j--;
			}
			
			strings[j + 1] = temp;
		}
		
		if(binarySearch(strings, "hi")!=-1)
		System.out.println("Any is found at index: "+binarySearch(strings, "Any"));

		else
			System.out.println("hi not found");
		System.out.println(Arrays.toString(strings));
		
		
		
		
		
	}
}
