package com.bridgelabz.functionalprograms;
import java.util.Scanner;

public class Gambler
{ 
    public static void main(String[] args)
    {
    	
    	Scanner scanner=new Scanner(System.in);
    	System.out.println("Enter Stake: ");
        int stake  =scanner.nextInt();
        System.out.println("Enter  goal: ");
        int goal   = scanner.nextInt();
        System.out.println("Enter no.Of trials: ");
        int trials = scanner.nextInt();

        int bets = 0;        
        int wins = 0;        

        
        for (int t = 0; t < trials; t++) 
        {
            int cash = stake;
            while (cash > 0 && cash < goal) 
            {
                bets++;
                if (Math.random() < 0.5) 
                	cash++;     
                else                   
                	cash--;     
            }
            if (cash == goal)
            	wins++;               
        }

       
        System.out.println("Number of wins: "+wins);
        System.out.println("Percentage of games won = " + 100.0 * wins / trials);
    }

}