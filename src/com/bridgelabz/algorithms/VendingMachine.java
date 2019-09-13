package com.bridgelabz.algorithms;
import java.util.Scanner;
public class VendingMachine 
{
	static int denom=0;
	static void getChange(int a[],int change,int index)
	{
					//System.out.println(" In method Change:::::::::::::::::"+change);
						for (int i =index; i>=0; i--) 
						{
							if(change>=a[i])
							{
								denom=change/a[i];
								change=change-a[i]*denom; 
								System.out.println(a[i]+" X "+denom);
								if(change==0)
									 System.exit(0);
							//	System.out.println("In for change:::::::::::::::"+change);
								getChange(a, change,i-1);
							}
						}
	}
	public static void main(String[] args) 
	{
				int a[]= {1,2,5,10,20,50,100,200,500,1000};
		
				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter change  denomination: ");
				int change = scanner.nextInt();
				getChange(a, change, a.length - 1);	
	}

}
