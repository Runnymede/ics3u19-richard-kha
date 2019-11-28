package kha.unit3;

import java.util.Scanner;
/**
 * <br>This program allows for a game of tic tac toe with 2 different users.
 * <br>The program prints out the board and asks for input for the column position 
 * <br>and the row position of their piece placement, and continues to do this
 * <br>alternating between the first player and second player,
 * <br>till a user wins or 9 moves have been taken.
 * <br>November 28, 2019
 * @author Richard Kha
 *
 */
public class TikTacToe {
	/**
	 * 
	 * This is the entry point to the program
	 */
	//making char array static and outside main method for global use
	static char[][] tttBoard = new char[3][3];
	public static void main(String[] args) {
		//declaring variables and objects
		Scanner sc = new Scanner(System.in);
		String player = "";
		int counter = 0;
		char mark = ' ';
		boolean condition = false;
		int columnMove = 0;
		int rowMove = 0;
		//for loop allows for 9 turns to be played(as there are 9 spaces in a tik tac toe board
		for (int i = 0; i<9; i++) {

			//changes from player1 to player2
			if (i%2 == 1) {
				player = "Player2";
				mark = 'o';
			}
			else {
				player = "Player1";
				mark = 'x';
			}

			/*
			loop to take in user input and make sure the user is not trying to 
			fill an already filled position in the tik tac toe board
			 */
			do {
				printBoard();
				if (condition == true) {
					System.out.println("Invalid Input, space is already filled");
				}
				columnMove = inputParse("column",player);
				rowMove = inputParse("row",player);
				condition = tttBoard[rowMove][columnMove]!= '\u0000';
			}while (condition);

			tttBoard[rowMove][columnMove] = mark;


			//checks for vertical wins 
			for (int c = 0; c<3; c++) {
				counter = 0;
				for (int t = 0; t<3; t++) {
					if(tttBoard[t][c] == mark) {
						counter++;
					}
				}
				if (counter == 3) {
					break;
				}
			}
			//if else to prevent counter from being reset if it's already equal to 3
			if (counter == 3) {
			}
			else {

				//checks for horizontal wins
				for (int c = 0; c<3; c++) {
					counter = 0;
					for (int t = 0; t<3; t++) {
						if(tttBoard[c][t] == mark) {
							counter++;
						}
					}
					if (counter == 3) {
						break;
					}
				}
			}
			//checks for diagonal win (from top left to bottom right)
			if (tttBoard[0][0] == mark &&tttBoard[1][1] == mark &&tttBoard[2][2] == mark ) {
				counter = 3;
			}
			//checks for diagonal win (from bottom left to top right)
			if (tttBoard[2][0] == mark &&tttBoard[1][1] == mark &&tttBoard[0][2] == mark ) {
				counter = 3;
			}

			//prints out win statement if user has 3 pieces in a horizontal, vertical or diagonal line
			if (counter == 3) {
				printBoard();
				System.out.println(player + " wins!");
				break;
			}

		}
		//if the loop executes entirely (meaning board is filled) and no user has won, print message
		if (counter!=3) {
			printBoard();
			System.out.println("It's a tie!");
		}
	}
	/**
	 * This method prints out the tik tac toe board with formating 
	 */
	public static void printBoard(){
		for (int c = 0; c<3; c++) {
			System.out.println("-------");
			for (int d = 0; d<3; d++) {
				System.out.print("|"+tttBoard[c][d]);
			}
			System.out.print('|');
			System.out.println();

		}
		System.out.println("-------");
	}
	/**
	 * Gets the user's input and refuses bad input or integers higher than 3 or lower than 1.
	 * @param locationOfInput - used in string for message prompt
	 * @param player - used in string for message prompt
	 * @return a integer used in main method place the player's mark 
	 */
	static int inputParse(String locationOfInput,String player) {
		Scanner sc = new Scanner(System.in);
		int input = 0;
		boolean inputValid = false;

		//this loop ends when the user enters valid input
		while (inputValid == false) {
			inputValid = true;

			//this try catch catches bad input such as in symbols and letters
			try {
				System.out.println(player+", put in a integer between 1 and 3 for the "+locationOfInput+" position");
				input = Integer.parseInt(sc.nextLine());
				if (input>3||input<0) {
					inputValid = false;
					printBoard();
					System.out.println("Input is not between 1 and 3");
				}
			}
			catch (Exception e) {
				System.out.println("Incorrect input, please try again");
				inputValid = false;
			}
		}
		return input-1;
	}

}
