package kha.unit2;

import java.util.Scanner;
/**
 * <br>PrimeNumbers.java
 * <br>This program finds if the integer the user inputed is a prime number
 * <br>October 22, 2019
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
		//loop checks if the number is not a prime, and if so, it exits the program
		while (counter <= (int)Math.sqrt(Math.abs(number))) {
			if (number%counter == 0) {
				System.out.println("The number is not a prime");
				System.exit(0);
			}
			counter++;
		}
		//if statement deals with the case where the input is Integer.MIN_VALUE
		if (number == -2147483648) {
			System.out.println("The number is not a prime");
			System.exit(0);
		}
		//if loop finds that the number is a prime, it displays this message
		System.out.println("The number is a prime");
	}

}
