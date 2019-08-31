package com.bridgelabz.TestingPrograms;

import java.io.File;
import java.util.Arrays;

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
		int a[]= {24,12,45,10,9,68};
		int a1[]= {9,10,12,24,45,68};

		
		
		String[] s = { "Yam", "Any", "var", "bh" };
		
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
		
		if(binarySearch(s, "hi")!=-1)
		System.out.println("Any is found at index: "+binarySearch(s, "Any"));

		else
			System.out.println("hi not found");
		System.out.println(Arrays.toString(s));
		
		
		
		
		
		/*
		 * System.out.println(binarySearch(a1, 76)); if(binarySearch(a1, 76)!=-1)
		 * System.out.println(9+"found at index: "+binarySearch(a1, 9)); else
		 * System.out.println(76+"Not found");
		 */
	}
}
