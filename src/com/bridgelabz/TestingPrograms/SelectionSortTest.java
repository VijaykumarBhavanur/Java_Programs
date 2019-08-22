package com.bridgelabz.TestingPrograms;
import java.util.Arrays;
public class SelectionSortTest
{
	static int smallest(int a[],int index)
	{
		int small=a[index];
		int smallestIndex=0;
		for (int i =index;i < a.length; i++)
		{
			if(a[i]<small)
			{
				small=a[i];
				smallestIndex= i;
			}
		}
		return smallestIndex;
	}
	
	public static void main(String[] args)
	{
		
		int a[]= {3, 6, 1, 8, 4, 5};
		
		System.out.println("Before sorting: ");
		System.out.println(Arrays.toString(a));
		System.out.println("*******************************************");
		for (int i = 0; i < a.length; i++) 
		{
			
			int small = smallest(a, i);
			System.out.println("smallest: " + a[small]);
			 
			if(small!=0)
			{
				int temp=a[i];
				a[i]=a[small];
				a[small]=temp;
			}
			else
				break;
			System.out.println("After "+(i+1)+" iteration :");
			System.out.println(Arrays.toString(a));
			
			System.out.println("*******************************************");
		}
		
	}
	

}