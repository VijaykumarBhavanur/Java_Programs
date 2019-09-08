package com.bridgelabz.datastructures;

public class PrimeInTwoDArray 
{
	/* Method to to check  if number is Prime? */
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
		a[10][0]= "      901-1000  ";
		 
		 int cindex=1;
		 int rindex=1;
		 int range=100;
		 
		for (int i = 2; i <=1000; i++)
		{
			if(isPrime(i) && i<=range) 
			{
				a[rindex][cindex]=i;
				cindex++;
			}
			
			if(i>range)
			{
				range=range+100;
				cindex=1;
				rindex++;
			}
		}
		
		/* Display 2-D Array */
		for (int i = 0; i <11; i++) 
		{
			for (int j = 0; j <26; j++) 
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
