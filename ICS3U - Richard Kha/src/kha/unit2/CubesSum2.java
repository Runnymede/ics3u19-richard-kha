package kha.unit2;

/**
 * <br>DigitsSum2.java
 * <br>This program tells the user what integers of two, three, and four digits are
 * <br>equal to the sum of the cubes of their digits
 * <br>October 29, 2019
 *@author Richard Kha
 */
public class CubesSum2 {
	/**
	 * 
	 * This is the entry point to the program
	 */
	public static void main(String[] args) {

		//declaring variables and assigning one of them
		int number = 10;
		int counter;
		int sumOfDigits;
		double divisor;
		String numberString;
		//loop to test 10000 numbers
		while (number<10000) {
			//assigning these variables as 0 each time so calculations can be made for each number
			counter = 0;
			sumOfDigits = 0;
			
			//converts the digits into a string so charAt can be used
			numberString = String.valueOf(number);

			//loop performs calculations to find sum of the cubes of individual digits
			while (counter<numberString.length()) {	
				divisor = Math.pow(10,(numberString.length()-counter));
				sumOfDigits +=  Math.pow((int)((number%divisor)/(divisor/10)),3);
				counter++;
			}
			//if statement checks if the sum of the cubes of individual digits equals the starting number
			if (sumOfDigits == number) {
				System.out.println(number);
			}
			//counter to count to 10000
			number++;
		}

	}
}