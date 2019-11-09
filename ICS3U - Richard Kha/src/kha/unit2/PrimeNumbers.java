package kha.unit2;

import java.util.Scanner;
/**
 * <br>PrimeNumbers.java
 * <br>This program finds if the integer the user inputed is a prime number
 * <br>November 05, 2019
 *@author Richard Kha
 */
public class PrimeNumbers {
	/**
	 * 
	 * This is the entry point to the program
	 */
	public static void main(String[] args) {
		//initializes and declares objects and variables
		Scanner sc = new Scanner(System.in);
		int counter = 2;
		boolean inputValid = false;
		int number = 0;
		System.out.println("Prime number identifier");
		//this loop ends when the user enters valid input
		while (inputValid == false) {
			System.out.print("Enter a integer: ");
			inputValid = true;

			//this try catch catches bad input such as symbols that are not integers
			try {
				number = Integer.parseInt(sc.nextLine());
			}
			catch (Exception e) {
				System.out.println("Incorrect input, please try again");
				inputValid = false;
			}
		}

		/*while loop checks if the number is not a prime, and if so, it exits the program. 
		 *Variable counter will check the all the possible factors for the number.
		 *The other condition to enter the while (number<=1) allows for numbers less than or equal to 1 
		 *to be tested with the if statement inside.
		 */
		while (counter <= (int)Math.sqrt(number) || number<=1) {
			//if the number has a divisor which isn't itself or 1, it is not a prime. Also, numbers less than 2 are not prime.
			if (number%counter == 0 ||number<=1) {
				System.out.println("The number is not a prime");
				System.exit(0);
			}
			counter++;
		}
		//if the while loop finds that the number is a prime, it displays this message
		System.out.println("The number is a prime");
	}

}
