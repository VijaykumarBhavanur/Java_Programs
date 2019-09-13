package com.bridgelabz.algorithms;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
					st=st+arr[i]+"}\n";
			}
		 
		 System.out.println(st);
	 }
	
	 
	 public static void main(String[] args) throws FileNotFoundException 
	{
		
		 Scanner scanner = new Scanner( new File("/home/admin1/Desktop/words.txt") );
		 ArrayList<String> words=new ArrayList<String>();
		 scanner.useDelimiter(" ");
		 
	
		 
		 while(scanner.hasNext())
		 {
			words.add(scanner.next().replaceAll("\\uFEFF", ""));
			// System.out.println(scanner.next().replaceAll("\\uFEFF", ""));
		 }
		 System.out.println(words);
		 
		 String arr[] = new String[words.size()];
		 
		
		for (int j = 0; j < words.size(); j++) 
		{
			arr[j] = words.get(j);
		}
		Scanner scanner1 = new Scanner(System.in);

		arr = sortStrings(arr);

		System.out.println("Strings after sorting");
		displayString(arr);

		System.out.println("Enter string to search:");
		String input = scanner1.next();

		int index = binarySearchString(arr, input);

		if (index != -1)
			System.out.println(input + " found at index: " + index);
		else
			System.out.println(input + " not found");
		 
	}
}
