package com.bridgelabz.functionalprograms;

import java.util.Scanner;

public class WindChill {

	public static void main(String[] args) {
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter temperature(in Fahrenheit), temperature<=50: ");
			double t=scanner.nextDouble();
			
			System.out.println("Enter wind speed(in miles per hour), 3<=speed && speed<=120 : ");
			double v=scanner.nextDouble();
			
			double w=35.74+0.6215*t+(0.4275*t-32.75)*Math.pow(v,0.16);			
			
			System.out.println("Wind Chill: "+w);
		
	}

}
