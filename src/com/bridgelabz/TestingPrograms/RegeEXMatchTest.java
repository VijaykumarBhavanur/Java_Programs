package com.bridgelabz.TestingPrograms;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegeEXMatchTest 
{

	public static void main(String[] args) 
	{
	
		 String name="Vijaykumar";
		 String fullName="Vijaykumar Bhavanur";
		 String mobile="9164480832";
		 String date=LocalDateTime.now().getDayOfMonth()+"/"+LocalDateTime.now().getMonthValue()+"/"+LocalDateTime.now().getYear();
		 
		 String[] patterns= {"<<name>>","<<ful.*name>>","X{10}","XX/XX/XXXX"};
		 
		 String[] update={name,fullName,mobile,date};
		 
		 Scanner scanner =new Scanner(System.in);
		 System.out.println("Enter your message: "); 
		
		 String  message=scanner.nextLine();
		 //Hi,<<name>>  your fullname is <<fullname>>,your mobile number is 91-XXXXXXXXXX as per records today XX/XX/XXXX
		 
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
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 //System.out.println(date);
		 
		//String date1=new 
		 // Scanner scanner =new Scanner(System.in);
		 // System.out.println("Enter your message: "); 
		  //String  message=scanner.nextLine(); //How are you <<name>>? Is <<fullname>> is your fullname? and 91-XXXXXXXXX is your mobile number? //String str="your <<name>>";
		  
		 // Pattern pattern1=Pattern.compile("<<name>>"); 
		  
		 // Pattern pattern2=Pattern.compile("<<ful.*name>>");
		  
		  //Pattern pattern3=Pattern.compile("91-X{9}"); 
		  
		// String message="Today date is: XX/XX/XXXX";
		 
		 // Pattern pattern4=Pattern.compile("X{1}/X{1}/X{3}"); 
		 // Pattern pattern4=Pattern.compile("X[2]/X[2]/X[4]");
		  
		  		//Scanner scanner =new Scanner(System.in);
			    //System.out.println("Enter your message: ");
		  
		  	 // String m=scanner.nextLine();//"Your mobile number:  91-XXXXXXXXX";
		  	  
		  	  
		/*
		 * Pattern pattern4=Pattern.compile("X{2}/X{2}/X{4}"); Matcher
		 * matcher1=pattern4.matcher(m);
		 * 
		 * StringBuffer sb1= new StringBuffer();
		 * 
		 * while(matcher1.find()) { matcher1.appendReplacement(sb1,date);
		 * System.out.println(matcher1.group()); } matcher1.appendTail(sb1);
		 * System.out.println(sb1);
		 */
		  
		  
		  
		/*
		  Matcher matcher1=pattern1.matcher(message);
		  
		  StringBuffer sb1= new StringBuffer();
		  
		  while(matcher1.find()) { matcher1.appendReplacement(sb1, name); }
		  matcher1.appendTail(sb1); System.out.println(sb1);
		  
		  message=sb1.toString();
		  
		  StringBuffer sb2= new StringBuffer(); Matcher
		  matcher2=pattern2.matcher(message);
		  
		  while(matcher2.find()) { matcher2.appendReplacement(sb2,fullName); }
		  matcher2.appendTail(sb2);
		  
		  System.out.println(sb2);
		 
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		/*
		 * while(matcher1.find()) { matcher1.appendReplacement(sb1, name); }
		 * matcher1.appendTail(sb1); System.out.println(sb1);
		 */
		  
		  
		/*
		 * String message="your <<fullname>>"; Pattern
		 * pattern1=Pattern.compile("<<ful.*name>>"); Matcher
		 * matcher=pattern1.matcher(message);
		 * 
		 * 
		 * while(matcher.find()) { System.out.println(matcher.group()); }
		 */
	}

}
