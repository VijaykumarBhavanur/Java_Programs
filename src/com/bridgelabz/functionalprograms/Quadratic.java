package com.bridgelabz.functionalprograms;

import java.util.Scanner;

public class Quadratic {

	public static void main(String[] args) {
		
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter the values of a, b and c: ");
			double a=scanner.nextInt();
			double b=scanner.nextInt();
			double c=scanner.nextInt();
			
			double delta=b*b-4*a*c;
			
			double squareRoot=Math.sqrt(delta);
			double firstroot=(-b +squareRoot)/(2*a);
			double secondroot=(-b-squareRoot)/(2*a);
			System.out.println("Quadratic Equation: "+a+"x^2+"+b+"x+"+c);
			System.out.println("First root: "+firstroot);
			System.out.println("Second root: "+secondroot);
			
	}

}
