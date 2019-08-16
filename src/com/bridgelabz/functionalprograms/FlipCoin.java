package com.bridgelabz.functionalprograms;

import java.util.Random;
import java.util.Scanner;

public class FlipCoin {

	public static void main(String[] args) {
		
		  Scanner scanner=new Scanner(System.in);
		  System.out.println("Enter number of times to flip the coin: "); 
		  int noOfTimes=scanner.nextInt(); 
		  double headCount=0.0,tailCount=0.0; 
		  Random r=new Random();
		  
		  if(noOfTimes<=0)
			  System.out.println("Invalid input! input should be positive integer greater than zero");
		  else
		  {  
			  for (int i = 0; i <noOfTimes; i++)
			  {
				  double random=r.nextDouble();
				  if(random<0.5)
					  tailCount++;
				  else
					  headCount++;
			  }
			  System.out.println("TailCount: "+tailCount);
			  System.out.println("HeadCount: "+headCount);
			  double headTailPercentage=(headCount/tailCount)*100;
			  System.out.println(" Percentage of Head vs Tails: "+headTailPercentage+"%");
		  }
		 
	}
}
