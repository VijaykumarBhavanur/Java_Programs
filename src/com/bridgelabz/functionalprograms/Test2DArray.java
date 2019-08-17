package com.bridgelabz.functionalprograms;

import java.util.Scanner;

public class Test2DArray {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter string: ");
		String string=sc.next();
		char [] ch=string.toCharArray();
		System.out.println(String.valueOf(ch));
		char temp;
		for (int i = 0,j=1;j < ch.length; j++)
		
		{
			temp=ch[i];
			ch[i]=ch[j];
			ch[j]=temp;
			System.out.println(String.valueOf(ch));
		
		}
	}
}
	
