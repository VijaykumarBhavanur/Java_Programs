package com.bridgelabz.TestingPrograms;

public class DecimalToBinary {

	public static void main(String[] args) 
	{
		int number=16;
		String bin="";
		
		while(number>0)
		{
			
			int rem=number%2;
			
			bin=rem+bin;
			number=number/2;
		}
		
		if(bin.length()%4!=0)
			
			for (int i = 0; i <4-bin.length(); i++) 
			{
				bin="0"+bin;
			}
		System.out.println(bin);
	}

}
