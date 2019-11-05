package kha.unit2;

import java.util.Scanner;
/**
 * <br>GuessingGamePt1.java
 * <br>This program compares the user's input to a integer from 1 to 20 (inclusive) and responds with relation to 
 * <br>whether the 2 numbers are equal
 * <br>October 22, 2019
 *@author Richard Kha
 */
public class GuessingGamePt1 {
	/**
	 * 
	 * This is the entry point to the program
	 */
	public static void main(String[] args) {
		//creates and declares objects and variables
		Scanner sc = new Scanner(System.in);
		boolean inputValid=false;
		int userInput = 0;
		int computerNum = (int)(Math.random()*20)+1;

		//this loop ends when the user enters valid input
		while (inputValid == false) {
			inputValid = true;
			System.out.print("Enter a integer between 1 and 20: ");

			//this try catch catches bad input such as symbols and numbers which are not between 1 and 20
			try {
				userInput = Integer.parseInt(sc.nextLine());
				if (userInput<1 || userInput>20) {
					inputValid = false;
					System.out.println("Input is not between the range of 1 and 20");
				}
			}
			catch (Exception e) {
				System.out.println("Incorrect input, please try again");
				inputValid = false;
			}
		}
		//Displays the user's input and the computer's number
		System.out.println("Computer's number: "+computerNum);
		System.out.println("User's number: "+userInput);

		//Displays message based on whether the user's input is equal to the computer's number
		if (computerNum == userInput) {
			System.out.println("Good job!");
		}
		else {
			System.out.println("Better luck next time!");
		}

	}

}
