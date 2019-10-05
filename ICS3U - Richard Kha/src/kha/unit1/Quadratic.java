package kha.unit1;

import java.util.Scanner;
/**
 * ObjectHeight.java
 * This program performs the quadratic formula when given the three variables: a, b, c
 * September 30, 2019
 *@author Richard Kha
 */
public class Quadratic {
	/**
	 * 
	 * This is the entry point to the program
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//prompts the user to input a number and stores it in 'digits'
	
		int digits = 0;
		boolean inputValid = false;
		
		//this loop ends when the user enters valid input
		while (inputValid == false) {
			inputValid = true;
			System.out.println("Give a integer from 0 and 999");
			//this try catch catches bad input such as symbols and numbers which are not between 0 and 999
			try {
				digits = Integer.parseInt(sc.nextLine());
				if (digits<0 || digits>999) {
					inputValid = false;
					System.out.println("Input is not between the range of 0 and 999");
				}
			}
			catch (Exception e) {
				System.out.println("Incorrect input, please try again");
				inputValid = false;
			}

		}
		//performs calculations to find the value of the ones, tens and hundreds of a number
		int hundreds = digits/100;
		digits -= hundreds*100;
		int tens = digits/10;
		digits -= tens*10;

		//digits is ones due to the calculations
		System.out.println("Hundreds: "+ hundreds );
		System.out.println("Tens: "+ tens );
		System.out.println("Ones: "+ digits);



	}

}
