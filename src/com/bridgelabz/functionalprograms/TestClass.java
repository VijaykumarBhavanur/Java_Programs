package com.bridgelabz.functionalprograms;

import java.util.LinkedList;
import java.util.Scanner;

public class TestClass {

	public static void main(String[] args) 
	{
		/*
		 * int h1=4; int m1=4; int s1=35;
		 * 
		 * int c1=h1*3600+m1*60+s1; //System.out.println(c1);
		 * 
		 * int h2=4; int m2=16; int s2=8;
		 * 
		 * int c2=h2*3600+m2*60+s2; //System.out.println(c2);
		 * 
		 * //System.out.println(c2-c1);
		 * 
		 * int r1=(c2-c1)%3600; int hr=(c2-c1)/3600; int r2=r1%60; int min=r1/60; int
		 * sec=r2;
		 * 
		 * System.out.println(hr+"hr:"+min+"min:"+sec+"sec");
		 */
		
		
		char array[][]= {{'1','0','1'},{'0','0','1'},{'1','0','1'}};
		
		int row=0;
		int d1=0,d2=0;
		
		for (int i = 0; i < array.length; i++) 
		{
				for (int j = 0; j < array.length; j++)
				{
						if(array[i][j]=='1')
							row++;
						else
							row=0;
						 if(i==j&&array[i][j]=='1')
							d1++;
						if(i+j==2&&array[i][j]=='1')
							d2++;
				}
			
			if(row==3)
				System.out.println("row has all 1's ");	
		}
		
			if(d1==3)
				System.out.println("diagonal1 has only 1's ");
			else if(d2==3)
				System.out.println("diagonal2 has only 1's ");
			
			else
				System.out.println("all are different!!!");
			
			
			
		/*for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				 if(i==j&&array[i][j]=='1')
					d1++;
			}
		}
		if(d1==3)
			System.out.println("diagonal1 has only 1's ");
		else
			System.out.println("diagonal has different elements");
		
		
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				 if(i+j==2&&array[i][j]=='1')
					d2++;
			}
		}
		if(d2==3)
			System.out.println("diagonal2 has only 1's ");
		else
			System.out.println("diagonal has different elements");
		}	*/
 }
}
