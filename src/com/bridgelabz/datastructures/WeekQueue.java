package com.bridgelabz.datastructures;

import java.util.Scanner;

class  WeekQueue
{
	public static Queue getCalendarAsQueue()
	{
	
		Queue calendarQueue=new Queue();
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter month(1-12) & year(YYYY) to display calendar: ");
		int month=scanner.nextInt();
		int year=scanner.nextInt();
		
		String[] monthName={"January","February","March","April","May","June","July","August","September","October","November","December"};
		Object cal[][]=Calendar.getCalendar(month, year);
		
		for (int i = 0; i <7; i++)
		{
				for (int j = 0; j <7; j++) 
				{
					if(cal[i][j] instanceof String)
					{
						String s=(String) cal[i][j];
						  if(!s.contentEquals("  "))
							  calendarQueue.addLast(calendarQueue,cal[i][j]);
						  
					}
					else if(!(cal[i][j] instanceof String))
						calendarQueue.addLast(calendarQueue,cal[i][j]);
					System.out.print(cal[i][j]+" ");
				}
		}
		return calendarQueue;
	}
	
	public static void main(String[] args)
	{
		Queue calendarQueue=new Queue();
		calendarQueue.display(calendarQueue);
		
	}
}