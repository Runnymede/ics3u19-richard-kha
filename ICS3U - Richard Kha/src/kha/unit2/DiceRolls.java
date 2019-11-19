package kha.unit2;
/**
 * <br>DiceRolls.java
 * <br>This program generates two random numbers then displays these two numbers and their sum.
 * <br>It does this operation 5 times.
 * <br>November 19, 2019
 *@author Richard Kha
 */

public class DiceRolls {
	/**
	 * 
	 * This is the entry point to the program
	 */
	public static void main(String[] args) {
		//assigning variables
		int random1;
		int random2;
		int total;

		//headers for the columns
		System.out.printf("%-12s", "Dice1");
		System.out.printf("%-12s", "Dice2");
		System.out.printf("%-12s\n", "Total");

		//loop performs the following code five times
		for (int i = 0; i < 5; i++) {

			/*
			this block of code generates 2 random numbers and adds them together, 
			and then displays these 2 numbers and also the sum of the two numbers
			 */
			random1 = (int) (Math.random() * 6) + 1;
			random2 = (int) (Math.random() * 6) + 1;
			total = random1 + random2;
			System.out.printf("%-12s", random1);
			System.out.printf("%-12s", random2);
			System.out.printf("%-12s\n", total);

		}

	}

}
