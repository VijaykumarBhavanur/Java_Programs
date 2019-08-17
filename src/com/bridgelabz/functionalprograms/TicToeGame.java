package com.bridgelabz.functionalprograms;

import java.util.Random;
import java.util.Scanner;

public class TicToeGame {
	
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
	
 static void  checkIfWon(char a[][])
 {
	 
	 	for (int i = 0,j=0; i < a.length; i++,j++)
	 		
	 		{
			 if(i==j&&a[i][j]=='X'||a[0][j]=='X'||a[1][j]=='X'||a[2][j]=='X'||i+j==2 && a[i][j]=='X')
				 System.out.println("You won");
			 else if (i==j&&a[i][j]=='*'||a[0][j]=='*'||a[1][j]=='*'||a[2][j]=='*'||i+j==2 && a[i][j]=='*')
				 System.out.println("Computer won");
			 else
				 System.out.println("match draw");
				//return "You won!";
	 		}
	 		
	 	}
	
	 	//return "Sorry computer won!";

	 
 public static void main(String[] args)
	{
		/*
		 * char board[][] = {{'0','0','0'},{'0','0','0'},{'0','0','0'} };
		 * 
		 * 
		 * System.out.println("Before Play: "); displayGameBoard(board);
		 * 
		 * Scanner scanner = new Scanner(System.in); Random r = new Random(); while
		 * (true) { System.out.println("*****************************"); while (true) {
		 * System.out.println("Enter row and column to insert: "); int row =
		 * scanner.nextInt(); int col = scanner.nextInt();
		 * 
		 * if (row>2||col>2 || board[row][col] != '0') { System.out.println("no space");
		 * }
		 * 
		 * else { board[row][col] = 'X'; break; } }
		 * 
		 * while (true) { int row1 = r.nextInt(3); int col1 = r.nextInt(3); if
		 * (board[row1][col1] == '0'||isFull(board)==true) { board[row1][col1] = '*';
		 * break; } } displayGameBoard(board); if (isFull(board) == true) {
		 * System.out.println("board full!!!!!"); break; } }
		 * 
		 * System.out.println("Final Board:::::::::"); displayGameBoard(board);
		 */
	 
	 //System.out.println("$$$$$$$$$$$$$$$$$$$$$");
	 
	 char board[][] = {{'X','*','X'} ,{'*','*','X'},{'X','X','*'} };
	  checkIfWon(board);
	}
}

