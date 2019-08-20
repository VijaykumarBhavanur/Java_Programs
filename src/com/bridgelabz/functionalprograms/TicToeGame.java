package com.bridgelabz.functionalprograms;

import java.util.Random;
import java.util.Scanner;

public class TicToeGame {
	
	static	String isWon(char[][]array)
	{
		int urow = 0,ucol = 0,ud1 = 0,ud2 = 0; //variables to check if user won
		int crow = 0,ccol = 0,cd1 = 0,cd2 = 0; //variables to check if computer won
		
		for (int j = 0; j < array.length; j++) 
		{
						for (int i = 0; i < array.length; i++)
						{
							if (array[i][j] == 'X')
								ucol++;
							else
								ucol = 0;
				
							if (array[i][j] == '*')
								ccol++;
							else
								ccol = 0;
						}
								if (ccol == 3)  //If all '*'s in a column
									return "Sorry!!, Computer won ";
						
								if (ucol == 3)
									return "You won ";	 //If all 'X's in a column
		}
						for (int i = 0; i < array.length; i++)
						{
							for (int j = 0; j < array.length; j++) 
							{
								if (array[i][j] == 'X')
									urow++;
								else
									urow = 0;
					
								if (array[i][j] == '*')
									crow++;
								else
									crow = 0;
					
								if (i == j && array[i][j] == 'X')
									ud1++;
					
								if (i == j && array[i][j] == '*')
									cd1++;
					
								if (i + j == 2 && array[i][j] == 'X')
									ud2++;
					
								if (i + j == 2 && array[i][j] == '*')
									cd2++;
							}

							if (urow == 3)  //If all 'X's in a row
								return "You won ";	
					
					
							if (crow == 3)  //If all '*'s in a row
							return "Sorry!!, Computer won ";
						}

		if (ud1 == 3 || ud2 == 3)
			return "You won ";	 //If all 'X's in diagonal

		if (cd1 == 3 || cd2 == 3)
			return "Sorry!!, Computer won "; //If all '*'s in diagonal

		return null;
	}
	
	static	boolean isFull(char a[][])
	{
		
				for (int i = 0; i < a.length; i++) 
				{
							for (int j = 0; j < a.length; j++) 
							{
								if(a[i][j]=='0')
									return false;
							}
				}
				
		return true;
	}
	
	 static void displayGameBoard(char board[][])
	 {
		 for (int i = 0; i < board.length; i++ ) {
				for (int j = 0; j < board.length; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
	
	 }
	 
	public static void main(String[] args)
	{
		char board[][] = { { '0', '0', '0' }, { '0', '0', '0' }, { '0', '0', '0' } };

		System.out.println("Before Play: ");
		displayGameBoard(board);

		Scanner scanner = new Scanner(System.in);
		Random r = new Random();
		
		while (true)
		{
			System.out.println("*****************************");
						while (true) 
						{
							System.out.println("Enter row and column to insert: ");
							int row = scanner.nextInt();
							int col = scanner.nextInt();												/* User input for cell entry.......*/
			
							if (row > 2 || col > 2 || board[row][col] != '0')
								System.out.println("Invalid cell or cell not empty choose some other cell");
			
							else 
							{
								board[row][col] = 'X';
								break;
							}
						}

					while (true) 
					{
						int row1 = r.nextInt(3);
						int col1 = r.nextInt(3);
						if (board[row1][col1] == '0' || isFull(board) == true)      /* Random  input by computer for cell entry.......*/
						{
							board[row1][col1] = '*';
							break;
						}
					}
					
					displayGameBoard(board); //Display board after each input
							
					if (isFull(board) == true && isWon(board)==null ) // If board full and neither user nor computer won then match draw
					{
						System.out.println("Sorry!!! Match draw Try another time........");
						break;
					}
					
					if(isWon(board)!=null)
					{
						System.out.println(isWon(board));  //Check if either user or computer won?
						break;
					}
		 }
		displayGameBoard(board); 
	}
}