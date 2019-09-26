package com.bridgelabz.TestingPrograms;

import java.util.Arrays;


public class BubbleSortTest 
{
	
	static void displayArray(int a[],int index)
	{
	
		for (int i = 0; i < a.length; i++) 
		{
			
				System.out.print(a[i]+"");
		}

	}
	public static void main(String[] args)
	{
		int a[] = { 21, 45, 10, 78, 9, 90, 11 };

		int n = a.length;

		System.out.println("Before sorting: ");
		System.out.println(Arrays.toString(a));

		for (int i = 0; i < n; i++) 
		{
			for (int j = 0; j < n - i - 1; j++) 
			{
				if (a[j] > a[j + 1]) 
				{
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}

			}
			System.out.println("After " + (i + 1) + " iteration: ");
			System.out.println(Arrays.toString(a));
			System.out.println("*********************************************");
		}

		System.out.println("Sorted Array: ");
		System.out.println(Arrays.toString(a));
		
	}

}
