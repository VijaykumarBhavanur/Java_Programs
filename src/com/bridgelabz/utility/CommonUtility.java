package com.bridgelabz.utility;

public class CommonUtility {
	
	/* Function to count number of digits in a number*/
	
	
	public int getDigitCount(int number)
	{
		int digCount=0;
		while(number>0)
		{
			digCount++;
			number=number/10;
		}
		
		return digCount;
	}
	
	

}
