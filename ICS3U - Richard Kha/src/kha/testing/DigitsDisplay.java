package kha.testing;

import java.util.Scanner;
/**
 * <br>DigitsDisplay.java
 * <br>This program tells the user about the positive integer they enter, one digit at a time
 * <br>October 29, 2019
 *@author Richard Kha
 */
public class DigitsDisplay {
	/**
	 * 
	 * This is the entry point to the program
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean inputValid = false;
		int userInput = 0;
		int counter = 0;
		String userInputString;
	
		//this loop ends when the user enters valid input
		while (inputValid == false) {
			System.out.print("Enter a positive integer: ");
			inputValid = true;
			
			//this try catch catches bad input such as symbols that are not integers
			try {
				userInput = Integer.parseInt(sc.nextLine());
				if (userInput <0) {
					inputValid = false;
					System.out.println("Input is not positive");
				}
			}
			catch (Exception e) {
				System.out.println("Incorrect input, please try again");
				inputValid = false;
			}
		}
		//converts the digits into a string so charAt can be used
		userInputString = String.valueOf(userInput);
		//prints out each of the digits, each on a separate line
		while (counter<userInputString.length()) {
			System.out.println(userInputString.charAt(counter));
			counter++;
		}

	}

}
