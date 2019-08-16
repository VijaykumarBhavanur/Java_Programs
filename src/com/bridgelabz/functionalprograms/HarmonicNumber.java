package com.bridgelabz.functionalprograms;

import java.util.Scanner;

public class HarmonicNumber {

	public static void main(String[] args) {
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter N: ");
			int N=scanner.nextInt();
			if(N==0)
				System.out.println("Invalid input,Entered number should be greater than zero");
			int i=1;
			double harmonicValue=0.0;
			while(i<=N)
			{
				harmonicValue=harmonicValue+(double)1/i;
				i++;
			}
			
			System.out.println(N+"th harmonic value is: "+harmonicValue);
	}

}
