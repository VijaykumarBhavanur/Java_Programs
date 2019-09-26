package com.bridgelabz.TestingPrograms;

public class TestClass {

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
							if (ccol == 3) 
								return "Computer won ";
						//	{
				/*
				 * System.out.println("Computer won "); break;
				 */
							//}
					
							if (ucol == 3)
								return "User won ";
			/*
			 * { System.out.println("User won "); break; }
			 */
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

						if (urow == 3) 
							return "User won ";
				/*
				 * { System.out.println("user won"); break; }
				 */
				
						if (crow == 3) 
						return "Computer won ";
					/*	{
							System.out.println("computer won");
							break;
						}*/

					}

	if (ud1 == 3 || ud2 == 3)
		return "User won ";
		//System.out.println("user won");

	if (cd1 == 3 || cd2 == 3)
		return "Computer won ";
		//System.out.println("computer won");

	return null;
}
	public static void main(String[] args) 
	{
		char array[][] = { { '*', 'X', 'X' }, { 'X', '0', '0' }, { '0', '*', '*' } };
		
		System.out.println(isWon(array));
		
		
		
	}
		  
		
}
