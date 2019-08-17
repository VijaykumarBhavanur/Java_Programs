package com.bridgelabz.functionalprograms;

import java.util.Scanner;

public class PermutationOfString 
{
	
	static void printPermutation(String input)
	{
		char [] ch=input.toCharArray();
		
		for (int i = 1; i <ch.length; i++)
		{
				for (int j = i+1; j <ch.length; j++)
				{
						char temp=ch[i];
						ch[i]=ch[j];
						ch[j]=temp;
						System.out.println(String.valueOf(ch));
				}
		}
	}
	public static void main(String[] args) 
	{	
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter string: ");
		String string=sc.next();
		char [] ch=string.toCharArray();
		int i=0,j=0;
		for (int j2 = 0; j2 < ch.length; j2++) 
		{
						if(i!=j)
						{
							char temp=ch[j];
							ch[j]=ch[i];
							ch[i]=temp;
							System.out.println(String.valueOf(ch));
							printPermutation(String.valueOf(ch));
						}
						else
						{
							System.out.println(String.valueOf(ch));
							printPermutation(String.valueOf(ch));
						}
						j++;
		}

	}
}
