package com.bridgelabz.TestingPrograms;

import java.util.Arrays;

import com.bridgelabz.utility.CommonUtility;

public class BubbleSortString 
{
	public static void main(String[] args)
	{
		CommonUtility util=new CommonUtility();
		
		String s1[]={"Refactor","Source","Navigate","Edit","File"};

		int n = s1.length;
		System.out.println("Before sorting");
		util.displayString(s1);
		
		for (int i = 0; i < n; i++) 
		{
			for (int j = 0; j < n - i - 1; j++) 
			{
				if (s1[j].toLowerCase().compareTo(s1[j+1].toLowerCase()) >0) 
				{
					String temp = s1[j];
					s1[j] = s1[j + 1];
					s1[j + 1] = temp;
				}

			}

		}
		
		System.out.println("After sorting: ");
		util.displayString(s1);
	
	}

}
