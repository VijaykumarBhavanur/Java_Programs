package com.bridgelabz.datastructures;

import java.util.Scanner;

public class BinarySearchTree {

	public static int factorial(int n)
	{
		int fact=1;
		
		while(n>0)
		{
			fact=fact*n;
			n--;
		}
		return fact;
	}
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter number of nodes to get number of binary search trees possible: ");
		int nodes=scanner.nextInt();
		int numberOfBinarySearchTrees= factorial(2*nodes)/(factorial(nodes+1)*factorial(nodes));
		System.out.println(numberOfBinarySearchTrees+" Binary Search Trees are possible for "+nodes+" nodes");
	}

}
