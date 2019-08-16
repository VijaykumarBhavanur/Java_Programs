package com.bridgelabz.functionalprograms;

import java.util.Scanner;

import com.bridgelabz.utility.CommonUtility;

public class LeapYear {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		CommonUtility util=new CommonUtility();
		System.out.println("Enter an year to check whether it is Leap: ");
		int year=scanner.nextInt();
		if(util.getDigitCount(year)<4)
			System.out.println("Invalid Input year should have  4 digits");
		else
		{
			if(year%400==0 || year%4==0 && year%100!=0)
				System.out.println(year+" is leap year");
			else
				System.out.println(year+" is not leap year");
		}
	}
}