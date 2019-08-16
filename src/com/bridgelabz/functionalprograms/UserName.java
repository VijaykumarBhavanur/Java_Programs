package com.bridgelabz.functionalprograms;

import java.util.Scanner;

public class UserName {
	
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		while(true)
		{
		System.out.println("Enter User name: ");
		String userName=scanner.nextLine();

		if(userName.length()<3)
			System.out.println("Username should be atleast three characters ");
		else
			{	
				System.out.println("Hello,"+userName+" How are you?");
				break;
			}
		}
	}

}
