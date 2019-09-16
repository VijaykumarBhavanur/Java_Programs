package com.bridgelabz.oops;
import java.util.Random;

import com.bridgelabz.utility.CommonUtility;

public class PlayCards 
{
	/*  Method to  shuffle cards of deck  */
	public static String[] shuffleCards(String[] deck)
	{
		
		Random r=new Random();
		//Shuffling cards 52 times
		int i=1;
		while(i<=52)
		{
				int card1=r.nextInt(52);
				int card2=r.nextInt(52);
				
				String temp=deck[card1];
				deck[card1]=deck[card2];
				deck[card2]=temp;
				i++;
		}
		return deck;
	}
	
	/*  Method to  distribute cards to each player  */
	public static void giveCardToPlayer(String[] deck,String[] player1,String[] player2,String[] player3,String[] player4)
	{
		/* Distributing 9 cards to each player*/
		
		/* 4 index i.e 1  for each player */
		int index1=0;
		int index2=0;
		int index3=0;
		int index4=0;
		
		/* index for deck of cards */
		int deckIndex=0;
		
		
		
		/*   Distributing cards to each player  */
		for (int i = 0; i <9; i++) 
		{
			if(index1!=9 && index2!=9 && index3!=9 && index4!=9)
			{
				player1[index1++]=deck[deckIndex++];
				player2[index2++]=deck[deckIndex++];
				player3[index3++]=deck[deckIndex++];
				player4[index4++]=deck[deckIndex++];
			}
			
		}
		
		System.out.println("Player1 cards are:  \n");
		displayPlayerCards(player1);
		
		System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
		System.out.println("Player2 cards are:  \n");
		displayPlayerCards(player2);
		
		System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
		System.out.println("Player3 cards are:  \n");
		displayPlayerCards(player3);
		
		System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
		System.out.println("Player4 cards are:  \n");
		displayPlayerCards(player4);
	}
	
	
	/*  Method to  display cards of each player in 2-D array  */
	public static void displayPlayerCards(String[] player)
	{
		String play1[][]=new String[3][3];
		int index=0;
		for (int i = 0; i <3; i++)
		{
			for (int j = 0; j <3; j++)
			{
				play1[i][j]=player[index];
				index++;
			}
		}
		
		
		/*Dispalying cards recieved by player*/
		for (int i = 0; i <3; i++)
		{
			for (int j = 0; j <3; j++)
			{
				System.out.print(play1[i][j]+"  ");
			}
			System.out.println();
		}
		
	}
	
	
	/*  Method to  display deck of cards in 2-D array  */
	public static void displayDeck(String[] deck)
	{
		String cards[][]=new String[4][13];
		int index=0;
		
		for (int i = 0; i <4; i++) 
		{
			for (int j = 0; j <13; j++)
			{
				cards[i][j]=deck[index];
				index++;
			}
		}
		
		/*Displaying cards*/
		
		
		for (int i = 0; i <4; i++) 
		{
			for (int j = 0; j <13; j++)
			{
				System.out.print(cards[i][j]+"  ");
			
			}
			System.out.println();
		}
		
	}
	
	
	
	public static void main(String[] args) 
	{
		
		/* Array to store deck of cards */
		String deck[]= { "C-02","C-03","C-04","C-05","C-06","C-07","C-08","C-09","C-10","C-Jack", "C-Queen", "C-King", "C-Ace",
				         "D-02","D-03","D-04","D-05","D-06","D-07","D-08","D-09","D-10","D-Jack", "D-Queen", "D-King", "D-Ace",
				         "H-02","H-03","H-04","H-05","H-06","H-07","H-08","H-09","H-10","H-Jack", "H-Queen", "H-King", "H-Ace",
				         "S-02","S-03","S-04","S-05","S-06","S-07","S-08","S-09","S-10","S-Jack", "S-Queen", "S-King", "S-Ace" };
		
		
		System.out.println("Deck of Cards before shuffle: \n");
		displayDeck(deck);
		
		System.out.println("\n**********************************************************************************\n");
		System.out.println("Deck of Cards after shuffle: \n");
		
		deck=shuffleCards(deck);
		displayDeck(deck);
		
		/* 4-Arrays i.e 1 for each player*/
		String[] player1=new String[9];
		String[] player2=new String[9];
		String[] player3=new String[9];
		String[] player4=new String[9];
		
		
		System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=Distributing cards to each player=+=+=+=+=+=+==+=+=+=+=+\n");
	    giveCardToPlayer(deck, player1,player2,player3,player4);
	    
	   System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
	   System.out.println("Player 1 cards after sorting: \n");
	   player1=CommonUtility.bubbleSort(player1);
	   displayPlayerCards(player1);
	   
	   System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
	   
	   
	   
	   System.out.println("Player 2 cards after sorting: \n");
	   player2=CommonUtility.bubbleSort(player2);
	   displayPlayerCards(player2);
	   
	   System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
	   
	   System.out.println("Player 3 cards after sorting: \n");
	   player3=CommonUtility.bubbleSort(player3);
	   displayPlayerCards(player3);
	   
	   System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		
	   
	   System.out.println("Player 4 cards after sorting: \n");
	   player4=CommonUtility.bubbleSort(player4);
	   displayPlayerCards(player4);
	   
	 
	   System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	   System.out.println("\n Adding Player1 cards to Queue::::::::::");
	  
	   QueueTest Q1=new QueueTest();
	   Q1.addLast(new Player("Player1",player1));
	   Q1.display();
	   System.out.println();
	   
	   
	   System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	   System.out.println("\n Adding Player2 cards to Queue::::::::::");
	   QueueTest Q2=new QueueTest();
	   Q2.addLast(new Player("Player2",player2));
	   Q2.display();
	   System.out.println();
	   
	   
	   System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	   System.out.println("\n Adding Player3 cards to Queue::::::::::");
	   QueueTest Q3=new QueueTest();
	   Q3.addLast(new Player("Player3",player3));
	   Q3.display();
	   System.out.println();
	   
	   
	   System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	   System.out.println("\n Adding Player4 cards to Queue::::::::::");
	   QueueTest Q4=new QueueTest();
	   Q4.addLast(new Player("Player4",player4));
	   Q4.display();
	   System.out.println();
	   
	   
	   
	   System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/");
	   
	   QueueTest mainPlayer =new QueueTest();
	   mainPlayer.addLast(Q1);
	   mainPlayer.addLast(Q2);
	   mainPlayer.addLast(Q3);
	   mainPlayer.addLast(Q4);
	   
	   mainPlayer.display(mainPlayer);
	   
	   
	   
	   
	   
	}
}
