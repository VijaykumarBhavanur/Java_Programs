package com.bridgelabz.functionalprograms;
import java.time.LocalDateTime;
import java.util.Scanner;

public class StopWatch 
{
	public static void main(String[] args) 
	{			
		LocalDateTime time=LocalDateTime.now();
		Scanner scanner=new Scanner(System.in);
		
		int beforeStartHour=0;
		int beforeStartMinutes=0;
		int beforeStartSeconds=0;
		
		int afterStopHour=0;
		int afterStopMinutes=0;
		int afterStopSeconds=0;
		while(true)
		{
			System.out.println("Press S to start the watch: ");
			char c=scanner.next().charAt(0);
		
			if(c!='s'&&c!='S')
				System.out.println("Invalid input: ");
			else
				break;
		}
		beforeStartHour=time.getHour();
		beforeStartMinutes=time.getMinute();
		beforeStartSeconds=time.getSecond();
		
		System.out.println("********************Begin time of Stop-Watch****************");
		System.out.println(beforeStartHour+"hr :"+beforeStartMinutes+"min :"+beforeStartSeconds+"sec");
		
		int beforeTime=beforeStartHour*3600+beforeStartMinutes*60+beforeStartSeconds;
		
		while(true)
		{
			System.out.println("Press Q to stop the watch: ");
			char c=scanner.next().charAt(0);
			if(c!='q'&&c!='Q')
				System.out.println("Invalid input: ");
			else
				break;
		}
		
		LocalDateTime time1=LocalDateTime.now();
		afterStopHour=time1.getHour();
		afterStopMinutes=time1.getMinute();
		afterStopSeconds=time1.getSecond();
		
		System.out.println("********************Stop time of Stop-Watch****************");
		System.out.println(afterStopHour+"hr :"+afterStopMinutes+"min :"+afterStopSeconds+"sec");
		
		int aftertime=afterStopHour*3600+afterStopMinutes*60+afterStopSeconds;
		
		int r1=(aftertime-beforeTime)%3600;
		int totalhr=(aftertime-beforeTime)/3600;
		int r2=r1%60;
		int totlamin=r1/60;
		int totalsec=r2;
		
		System.out.println("***************Total time elapsed*************************");
		System.out.println(totalhr+"hr :"+totlamin+"min :"+totalsec+"sec");
	}
}
