package kha.unit2;

import java.util.Scanner;
/**
 * <br>PrimeNumberMod.java
 * <br>This program prompts the user for two integers and then displays the prime numbers between those two
 * <br>November 05, 2019
 *@author Richard Kha
 */
public class PrimeNumberMod {
	/**
	 * 
	 * This is the entry point to the program
	 */
	public static void main(String[] args) {
		System.out.println("Input two numbers and this program will list all the prime numbers between them (inclusive)");
		
		//initializes and declares variables
		int number1 = inputParse("1st");
		int number2 = inputParse("2nd");
		int numberStorage;
		int counter;
		boolean prime;
		
		System.out.println("Your prime numbers are:");
		
		//these lines allow the user to put in the numbers in any order (e.g. lowest to highest and highest to lowest)
		numberStorage = number1;
		number1 = Math.min(number1, number2);
		number2 = Math.max(numberStorage, number2);
		
		//negative numbers, 0, and 1 cannot be prime, so we do not need to test if they are prime, and thus can skip them
		if (number1<=1){
		number1 = 2;
		}
		
		//while statement tests all the numbers in between the two inputed (inclusive) for if they are prime numbers
		while (number1<=number2) {
			prime = true;
			counter = 2;
			//this while loop specifically tests each individual number
			while (counter<=(int)Math.sqrt(number1)){
				if (number1%counter == 0) {
					prime = false;
					break;
				}
				counter++;
			}
			if (prime == true) {
				System.out.println(number1);
			}
			number1++;
		}
	}
	/**
	 * Gets the users input and refuses bad input.
	 * @return integer for main calculations.
	 */
	static int inputParse(String numberExamined) {
		Scanner sc = new Scanner(System.in);
		int integerInput = 0;
		boolean inputValid = false;

		//this loop ends when the user enters valid input
		while (inputValid == false) {
			inputValid = true;

			//this try catch catches bad input such as in symbols and letters
			try {
				System.out.println("Please give me a value for your "+numberExamined+ " integer");
				integerInput= Integer.parseInt((sc.nextLine()));
			}
			catch (Exception e) {
				System.out.println("Incorrect input, please try again");
				inputValid = false;
			}
		}
		return integerInput;
	}

}