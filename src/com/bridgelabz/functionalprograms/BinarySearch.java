package com.bridgelabz.functionalprograms;

import java.util.Scanner;

public class BinarySearch {

	public static boolean  binarySearch(int arr[], int first, int last, int key){  
		   int mid = (first + last)/2;  
		   while( first <= last ){  
		      if ( arr[mid] < key ){  
		        first = mid + 1;     
		      }else if ( arr[mid] == key ){  
		       // System.out.println("Element is found at index: " + mid);  
		        //break;  
		    	  return true;
		      }else{  
		         last = mid - 1;  
		      }  
		      mid = (first + last)/2;  
		   }  
		   if ( first > last ){  
		      //System.out.println("Element is not found!");  
			   return false;
		   }  
		   
		   return false;
		 }  
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter N: ");
		int N=scanner.nextInt();
		int array[]=new int[N];
		
		for (int i = 0; i < N; i++)
		{
					array[i]=i;
		}

		
		for (int i : array) {
			System.out.println(i);
		}
		
		while(true)
		{
		System.out.println("Enter element to search: ");
		int item=scanner.nextInt();
		boolean search=binarySearch(array, 0, array.length-1, item);
		if(search==true)
			break;
		}
		System.out.println("element found");
	}

}
