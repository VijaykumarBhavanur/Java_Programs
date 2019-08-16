package com.bridgelabz.utility;

public class CommonUtility {
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
