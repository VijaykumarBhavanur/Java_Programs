package com.bridgelabz.functionalprograms;
import java.util.Random;
import java.util.Scanner;

public class Coupon 
{
	   static int[] addDistinct(int a[],int n)
	   {
		   if(a.length==1)
		   {
			   a[0]=n;
			   return a;
		   }
		   
		   for (int i = 0; i < a.length; i++)
		   {
			  if(a[i]==n)
				  break;
			  if(a[i]==0)
			  {
				  a[i]=n;
				  return a;
			  }
		   }
		   return a;  
	   }
	   
	public static void main(String[] args)
	{
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter number of distinct coupon numbers needed: ");
			int range=scanner.nextInt();
			Random r=new Random();
			
			int distinct[]=new int[range];
			int randomCount=0;
			
			while(true)
			{
				randomCount++;
				
				int number=r.nextInt(1000);
				distinct=addDistinct(distinct, number);
				
				if(distinct[distinct.length-1]!=0)
					break;
			}
			
			System.out.println("No of random numbers required: "+randomCount);
			System.out.println("Distinct random numbers are: ");
				
			for (int i = 0; i < distinct.length; i++) 
			{
				System.out.print(distinct[i]+" ");
			}
	}

}
