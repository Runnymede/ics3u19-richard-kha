package kha.unit2;

import java.util.Scanner;

/**
 * <br>NumberCheck.java
 * <br>This program tells the user about whether their integer input is positive or negative, 
 * <br>and if it is divisible by 7 (does not generate remainder)
 * <br>October 2, 2019
 *@author Richard Kha
 */
public class NumberCheck {
	/**
	 * 
	 * This is the entry point to the program
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//prompts the user for a integer and stores it into 'input'

		boolean inputValid = false;
		int userInput = 0;
		//this loop ends when the user enters valid input
		while (inputValid == false) {
			inputValid = true;
			System.out.println("Input a integer for testing");
			//this try catch catches bad input such as symbols that are not integers
			try {
				userInput = Integer.parseInt(sc.nextLine());	
			}
			catch (Exception e) {
				System.out.println("Incorrect input, please try again");
				inputValid = false;
			}
		}
		//Calculates whether the integer is positive or negative
		if(userInput < 0) {
			System.out.println("Negative integer");
		}
		else {
			System.out.println("Positive integer");
		}

		//Calculates if the number is divisible by 7 (does not create a remainder) 
		if (userInput%7 != 0) {
			System.out.println("Creates a remainder when divided by 7 (not divisible)");
		}
		else {
			System.out.println("Does not create remainder when divided by 7 (divisible)");
		}


	}

}
