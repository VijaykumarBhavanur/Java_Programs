package com.bridgelabz.datastructures;

import java.util.Scanner;

public class Calendar 
{
	static int isLeap(int year)
	{
		if(year%400==0 || year%4==0 && year%100!=0)
			return 1;
		else
			return 0;
	}
	
	
	static int getDayOf1stDay(int month,int year)
	{
		
		//Say year=2019
		int DayCode=1; //Assuming date as 01
		
		
		int y=year%100; //Last 2-digits of year i.e 19 in year 2019
		int y1=y/4+y;   //divide by 4 and add to last 2-digits of year i.e 19/4=3+19=23.
		int yearCode=y1%7; //divide 23/7 and get remainder i.e 23/7=2 which is year-code.
		
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
		/*Centuary code calculation*/
		int c=year/100; //1) Take first two digit of year say 20 in year 2019
						//Calculate next highest multiple of 4 for first 2 digits and subtract 1 from it
		if(c%4==0)		//For year 2019 next highest multiple of 20= 24-1=23
			c=c+4-1;
		else
			c=c+(c%4+(4-c%4));
		
		c=c-year/100; //Subtract last 2digits of year from remainder i.e 23-20=3
		
		c=c*2; 			//Multiply by 2
		int centuaryCode=c;	//Century code for 2019 is 6
		
		int leapYearCode=isLeap(year);  //LeapyearCode=0 since 2019 not a leap year
		
		int day=(yearCode+monthCode+centuaryCode+DayCode-leapYearCode)%7;
		
		int days[]= {0,1,2,3,4,5,6};
		int week=days[day];
		
		return week;
		
	}
	public static void main(String[] args) 
	{
		
		int dayCode=getDayOf1stDay(8, 2019); //Get day of 1st Sep-2019 Sunday if 0,Monday if 1 soon...
		System.out.println(dayCode);
		Object calendar[][]=new Object[6][7];
		
		calendar[0][0]="Su";
		calendar[0][1]="Mo";
		calendar[0][2]="Tu";
		calendar[0][3]="We";
		calendar[0][4]="Th";
		calendar[0][5]="Fr";
		calendar[0][6]="Sa";
		
		int month=8;
		
		int days[]={31,28,31,30,31,30,31,31,30,31,30,31};
		
		int date=days[month-1];
		int m=1; //starting date 1
		
		/*
		 * int date=1; for (int i = 1; i <6; i++) { for (int j = 0; j <7; j++) {
		 * if(date<=30) { if(date<10) { calendar[i][j]="0"+String.valueOf(date); date++;
		 * } else { calendar[i][j]=date; date++; } } else calendar[i][j]=""; } }
		 */
		
		for (int i = 1; i <6; i++) {
			for (int j = 0; j <7; j++) {
				
				while(dayCode!=0)
				{
					calendar[i][j]="";
					dayCode--;
					//j++;
				}
				if(m<=date && m<10)
				{
					calendar[i][j]="0"+String.valueOf(m);
					m++;
				}
				else if(m<=date)
				{
					calendar[i][j]=m;
					m++;
				}
				else calendar[i][j]="";
			}
		}
		
		for (int i = 0; i <6; i++) 
		{
			for (int j = 0; j <7; j++) 
			{
				System.out.print(calendar[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
