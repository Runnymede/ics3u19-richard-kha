package kha.testing;

import java.util.Scanner;
/**
 * <br>DigitsSum.java
 * <br>This program tells the user the sum of the digits of the positive integer they enter
 * <br>October 29, 2019
 *@author Richard Kha
 */
public class DigitsSum {
	/**
	 * 
	 * This is the entry point to the program
	 */
	public static void main(String[] args) {
		//declaration of objects and variables
		Scanner sc = new Scanner(System.in);
		boolean inputValid = false;
		int userInput = 0;
		int counter = 0;
		int sumOfDigits = 0;
		String userInputString;
	
		//this loop ends when the user enters valid input
		while (inputValid == false) {
			System.out.print("Enter a positive integer: ");
			inputValid = true;
			
			//this try catch catches bad input such as symbols that are not integers
			try {
				userInput = Integer.parseInt(sc.next());
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
		
		//while takes the value of each of the digits and adds them to sumOfDigits
		while (counter<userInputString.length()) {
			//charAt finds each digit and returns a char, getNumericValue gets the numeric value of the chars
			sumOfDigits += Character.getNumericValue((userInputString.charAt(counter)));
			counter++;
		}
		System.out.println("The sum of the digits is: "+ sumOfDigits);
	}

}