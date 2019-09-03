package com.bridgelabz.TestingPrograms;

import java.util.Arrays;

public class MergesortTest 
{
	public static void main(String[] args) 
	{
	
		int a[]= {65,2,78,5,101,9,41,23};
		
		int lb=0;
		int up=a.length-1;
		
		System.out.println("Before Sorting: ");
		System.out.println(Arrays.toString(a));
		mergeSort(a, lb, up);
	
		System.out.println("After Sorting: ");
		System.out.println(Arrays.toString(a));
				
	}
	
	public static void merge(int a[],int lb,int mid,int up)
	{
		 int n1 = mid - lb + 1; 
	     int n2 = up - mid; 
		
	     int left[]=new int[n1];
	     int right[]=new int[n2];
	     
	     for (int l=0; l<n1;l++) 
	            left[l] = a[lb + l]; 
	     
	        for (int l=0; l<n2;l++) 
	        	right[l] = a[mid + 1+ l]; 
	        
	        int i = 0, j = 0; 
	        int k = lb; 
	        
	        while (i < n1 && j < n2) 
	        { 
	            if (left[i] <= right[j]) 
	            { 
	                a[k] = left[i]; 
	                i++; 
	            } 
	            else
	            { 
	              a[k] = right[j]; 
	                j++; 
	            } 
	            k++; 
	        } 
	        
	        
	        /* Copy remaining elements of left[] if any */
	        while (i < n1) 
	        { 
	            a[k] = left[i]; 
	            i++; 
	            k++; 
	        } 
	  
	        /* Copy remaining elements of right[] if any */
	        while (j < n2) 
	        { 
	            a[k] = right[j]; 
	            j++; 
	            k++; 
	        } 
	    } 
	
	public static void mergeSort(int a[],int lb,int up)
	{	
		if(lb<up)
		{
			int mid=(lb+up)/2;
			mergeSort(a, lb, mid);
			mergeSort(a, mid+1,up);
			merge(a,lb,mid,up);
		}
	}

}
