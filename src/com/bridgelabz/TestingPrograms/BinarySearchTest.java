package com.bridgelabz.TestingPrograms;

public class BinarySearchTest {
	
	public static void main(String[] args)
	{
		int search[]= {1,2,3,4,5};
		int low=0;
		int high=search.length-1;
		
		int x=6;
		int res=binarySearchRecursive(x,search,low,high);
				
		if(res==-1)
			System.out.println("not found");
		else 
			System.out.println("found at index: "+res);
		/*
		 * int n=9;
		 * 
		 * while(low<=high) { mid=(low+high)/2; if(search[mid]==n) {
		 * System.out.println("found at index: "+mid); return; } else if(n<mid)
		 * high=mid-1; else low=mid+1; }
		 * 
		 * 
		 * 
		 * System.out.println("Sorry not found");
		 */
	}

	 static int binarySearchRecursive(int search, int[] array, int start, int end){
		
		int middle = (start + end)/2;
		
		
		  if(end < start){ return -1; }

		if (search < array[middle]){
			return binarySearchRecursive(search, array, start, middle - 1);
		}
		
		if (search > array[middle]){
			return binarySearchRecursive(search, array, middle + 1, end);
		}
		
		if (search == array[middle]){
			return middle;
		}
		
		return -1;
	}
}