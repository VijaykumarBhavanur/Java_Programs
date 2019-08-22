package com.bridgelabz.TestingPrograms;

import java.util.Arrays;

public class Selection_Sort 
{
	public static void main(String[] args) 
	{
			
		int a[]= {3, 6, 1, 8, 4, 5};
		System.out.println("Before sorting: ");
		System.out.println(Arrays.toString(a));
		System.out.println("*******************************************");
		
		for (int i = 0; i < a.length; i++) 
		{
				
			int min=i;
			int flag=0;
			for (int j = i; j < a.length; j++) 
			{
				
				if(a[j]<a[min])
				{
					min=j;
					flag=1;
				}
				
			}
			
			int temp=a[min];
			a[min]=a[i];
			a[i]=temp;
			
			if(flag==0)
				break;
			System.out.println("After "+(i+1)+" iteration");
			System.out.println(Arrays.toString(a));
			System.out.println("*******************************************");
		
		}
	}

}
