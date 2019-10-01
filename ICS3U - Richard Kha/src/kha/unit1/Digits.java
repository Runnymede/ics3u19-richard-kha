package kha.unit1;

import java.util.Scanner;
/**
 * ObjectHeight.java
 * This program tells the user about the ones, tens, and hundreds of a number ranging from 0 to 999
 * September 30, 2019
 *@author Richard Kha
 */
public class Digits {
	/**
	 * 
	 * This is the entry point to the program
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		//prompts the user to input a number and stores it in 'digits'
		System.out.println("Give a integer from 0 and 999");
		int digits = sc.nextInt();

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
