package com.bridgelabz.functionalprograms;

import java.util.LinkedList;

public class TestClass {

	public static void main(String[] args) 
	{
		String str="gadag";
		char[] c=str.toCharArray();
		LinkedList ll=new LinkedList();
		
		for (int i = 0; i < c.length; i++)
			ll.add(c[i]);

	int index=ll.size()-1;
	for (int i = 0; i <ll.size()/2; i++) 
	{
			if(ll.get(i)!=ll.get(index))
			{
				System.out.println("Not palindrome");
				return;
			}
			
				index--;
	}

	System.out.println("Palindrome");
	}

}
