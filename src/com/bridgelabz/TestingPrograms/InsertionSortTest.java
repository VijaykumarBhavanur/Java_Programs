package com.bridgelabz.TestingPrograms;

import java.util.Arrays;

public class InsertionSortTest 
{
	public static void main(String[] args)
	{
		int a[]= {3, 6, 1, 8, 4, 5};
		System.out.println("Before sorting: ");
		System.out.println(Arrays.toString(a));
		System.out.println("*******************************************");
	
		for (int i = 1; i < a.length; i++)
		{
			int j=i-1;
			
			int temp=a[i];
			
			while(j>=0 && a[j]>temp)
			{
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=temp;
			
			System.out.println("After "+(i)+" iteration");
			System.out.println(Arrays.toString(a));
			System.out.println("*******************************************");
		}
	}

}
