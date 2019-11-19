package kha.unit2;

import java.util.Scanner;
/**
 * <br>CountVowels.java
 * <br>This program counts the number of vowels in a user given string
 * <br>November 19, 2019
 *@author Richard Kha
 */

public class CountVowels {
	/**
	 * 
	 * This is the entry point to the program
	 */
	public static void main(String[] args) {
		//declaring and assigning variables
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Text: ");
		String input = sc.nextLine();
		int counter = 0;

		//changing the entire text into a certain case so counting individual letters could be more simple
		String input2 = input.toLowerCase();

		//for loop counts from 1 to input.length, and this number is then used in charAt
		for (int i = 0; i<input.length(); i++) {

			//if character is a vowel, add to a counter
			if (input2.charAt(i) =='a' ||input2.charAt(i) =='e' ||input2.charAt(i) =='i' ||input2.charAt(i) =='o' ||input2.charAt(i) =='u' ) {
				counter ++;
			}
		}
		System.out.println("The number of vowels in "+input+" is "+ counter + ".");		


	}

}

