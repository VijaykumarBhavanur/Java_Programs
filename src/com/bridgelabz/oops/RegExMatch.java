package com.bridgelabz.oops;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExMatch 
{

	public static void main(String[] args) 
	{
	
		 String name="Vijaykumar";
		 String fullName="Vijaykumar Bhavanur";
		 String mobile="9164480832";
		 String date=LocalDateTime.now().getDayOfMonth()+"/"+LocalDateTime.now().getMonthValue()+"/"+LocalDateTime.now().getYear();
		 
		 String[] patterns= {"<<name>>","<<ful.*name>>","X{10}","X{2}/X{2}/X{4}"};
		 
		 String[] update={name,fullName,mobile,date};
		 
		 Scanner scanner =new Scanner(System.in);
		 System.out.println("Enter your message: "); 
		
		 String  message=scanner.nextLine();
		
		 
		 /*  *********Standard input message******
		  * 
		  * 
		  *  Hi,<<name>>  your fullname is <<fullname>>,your mobile number is 91-XXXXXXXXXX as per records today XX/XX/XXXX
		  * 
		  */
		 
		 
		 for (int i = 0; i < patterns.length; i++)
		 {
			 Pattern pattern=Pattern.compile(patterns[i]);
			 Matcher matcher=pattern.matcher(message);
			 
			 StringBuffer sb= new StringBuffer();
			 
			 while(matcher.find())
			 {
				 matcher.appendReplacement(sb,update[i]);
			 }
			 
			 matcher.appendTail(sb);
			 message=sb.toString();
			 
			 System.out.println("*************************************\n"+message+"\n");
		 }
	}

}
