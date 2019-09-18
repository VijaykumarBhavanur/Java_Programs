package com.bridgelabz.TestingPrograms;

public class St
{
	public static void main(String[] args) 
	{
		String st="Java";
		char[]c=st.toCharArray();
		int a[]=new int[128];
		
		for (int i = 0; i < c.length; i++) 
		{
			a[c[i]]++;
		}
		
		for (int i = 0; i < a.length; i++)
		{
			if(a[i]!=0)
				System.out.println((char)i+" occured "+a[i]+" times");
		}
	}

}
