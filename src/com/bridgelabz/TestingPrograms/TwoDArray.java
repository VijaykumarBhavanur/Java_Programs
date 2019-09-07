package com.bridgelabz.TestingPrograms;

import java.util.ArrayList;

public class TwoDArray 
{
  static boolean isPrime(int n)
  {
	int i=2;
	while(i<=n/2)
	{
		if(n%i==0)
			return false;
		i++;
	}
	  return true;
  }
	public static void main(String[] args) 
	{
		 Object[][] a=new Object[11][26];
		
		a[0][0] = "-------Range-----------";
		a[0][1] = "----Prime-numbers------";
		a[1][0] = "      0-100     ";
		a[2][0] = "      101-200   ";
		a[3][0] = "      201-300   ";
		a[4][0] = "      301-400   ";
		a[5][0] = "      401-500   ";
		a[6][0] = "      501-600   ";
		a[7][0] = "      601-700   ";
		a[8][0] = "      701-800   ";
		a[9][0] = "      801-900   ";
		a[10][0] = "     901-1000  ";
		 
		 int cindex=1;
		 int rindex=1;
		 
		 ArrayList<Integer> primeList=new ArrayList<Integer>();
		for (int i = 2; i <=1000; i++)
		{
			if(isPrime(i))
				primeList.add(i);
		}
		
		System.out.println(primeList);
		
	int range=100;
	
	for (int i = 0; i <primeList.size(); i++)
	{
			if(primeList.get(i)<=range)
			{
				a[rindex][cindex]=primeList.get(i);
				cindex++;
			}
			
			if(primeList.get(i)>=range)
			{
				range=range+100;
				cindex=1;
				rindex++;
			}
	}
		
		
		
		for (int i = 0; i < a.length; i++) 
		{
			for (int j = 0; j < a.length; j++) 
			{
				if(a[i][j]!=null)
				System.out.print(a[i][j]+"  ");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}
