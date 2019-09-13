package com.bridgelabz.algorithms;

import java.util.Scanner;

public class DayOfWeek 
{
	static int isLeap(int year)
	{
		if(year%400==0 || year%4==0 && year%100!=0)
			return 1;
		else
			return 0;
	}
	
	static int getDayOfWeek(int day,int month,int year) 
	{
			//Say year=2019
			int DayCode=day; //User entered date
			
			System.out.println("DayCode: "+DayCode);
			
			int y=year%100; //Last 2-digits of year i.e 19 in year 2019
			int y1=y/4+y;   //divide by 4 and add to last 2-digits of year i.e 19/4=4+19=23.
			int yearCode=y1%7; //divide 23/7 and get remainder i.e 23/7=2 which is year-code.
			
			System.out.println("yearCode: "+yearCode);
			/* Month-code is calculated based on concept of remaining days
			 * Since a month has 4-weeks so totalDays=4*7=28days remaining days are counted in next month
			 * January is 1st month so Month-Code=0
			 * February =(No. of days in Jan +remaining days in Jan)/7 =(31+0)/7=3 so monthCode for Feb=03
			 * Similarly,
			 * March=(No. of days in February+remaining days in February)/7=(28+3)/7=3 since Feb has 28days 
			 * remaining days in February=31-28=3days
			 * and soon...........
			 * */
			
			
			int monthC[]= {0,3,3,6,1,4,6,2,5,0,3,5}; //Month 0-11 i.e jan-dec by gregorian calendar 
			
			 /*Element at index=month-1 i.e for Jan month-number==1
				so 1-1=0th index in montC[] i.e 0 is monthcode of January*/
			
			int monthCode=monthC[month-1];
			System.out.println("monthcode: "+monthCode);
			/*Centuary code calculation*/
			int c=year/100; //1) Take first two digit of year say 20 in year 2019
							//Calculate next highest multiple of 4 for first 2 digits and subtract 1 from it
			
			
			//For year 2019 next highest multiple of 4 is 24= 24-1=23
			
			if(c%4==0)		
				c=(c+4)-1;    //If number is divisible by 4 then simply add 4 to get next highest multiple of 4
			else
				c=(c+(4-c%4))-1;         
			
			c=c-year/100; //Subtract first 2digits of year from remainder i.e 23-20=3
			
			c=c*2; 			//Multiply by 2
			int centuaryCode=c;	//Century code for 2019 is 6
			
			System.out.println("centuaryCode: "+centuaryCode);
			int leapYearCode=isLeap(year);  //LeapyearCode=0 since 2019 not a leap year
			System.out.println("leapYearCode: "+leapYearCode);
			System.out.println("("+yearCode+"+"+monthCode+"+"+centuaryCode+"+"+DayCode+"-"+leapYearCode+") %7");
			
			
			int dayOfWeek=(yearCode+monthCode+centuaryCode+DayCode-leapYearCode)%7;
			System.out.println("Returning day: "+dayOfWeek+"\n");
			return dayOfWeek;
			
		}
	
	public static void main(String[] args) 
	{
		String[] dayOfWeek= {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
		System.out.println("Enter date in DD/MM/YYYY format  to get day of particular date:");
		Scanner scanner=new Scanner(System.in);
		int day=scanner.nextInt();
		int month=scanner.nextInt();
		int year=scanner.nextInt();
		
		int daycode=getDayOfWeek(day, month, year);
		System.out.println(day+"-"+month+"-"+year+" was "+dayOfWeek[daycode]);

	}

}
