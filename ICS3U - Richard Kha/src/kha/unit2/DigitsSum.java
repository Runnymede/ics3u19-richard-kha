package kha.unit2;

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
		//declaring objects and variables and assigning some of them
		Scanner sc = new Scanner(System.in);
		boolean inputValid = false;
		int userInput = 0;
		int counter = 0;
		int sumOfDigits = 0;
		String userInputString;
		double divisor;
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
		
		//loop performs calculations to find the sum of each of the digits
		while (counter<userInputString.length()) {	
			//calculations to add the individual digits together
			divisor = Math.pow(10,(userInputString.length()-counter));
			sumOfDigits += (int) ((userInput%divisor)/(divisor/10));
			
			counter++;
		}
		System.out.println("The sum of the digits is: "+ sumOfDigits);

	}

}
