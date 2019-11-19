package kha.unit2;

import java.text.NumberFormat;
import java.util.Scanner;
/**
 * <br>LicenseToDrive.java
 * <br>This program prints out a percentage which represents the amount of
 * <br>numbers between 0000 and 9999 which are greater than the number the user enters
 * <br>November 18, 2019
 *@author Richard Kha
 */
public class LicenseToDrive {
	/**
	 * 
	 * This is the entry point to the program
	 */
	public static void main(String[] args) {
		//declaring and assigning variables and objects
		NumberFormat formatter = NumberFormat.getPercentInstance(); 
		formatter.setMaximumFractionDigits(3);
		int numTotal;
		int numGreater = 0;
		boolean inputValid = false;
		Scanner sc = new Scanner(System.in);
		int[] numMax = new int[4];
		int arrayIndex = 0;
		int numChanger = 0;
		int counter = 1;

		//this loop ends when the user enters valid input
		while (inputValid == false) {
			inputValid = true;
			System.out.println("This program prints out a percentage which represents the amount of ");
			System.out.println("numbers between 0000 and 9999 which are greater than the number you enter");
			System.out.println("Input a integer");

			//this try catch catches bad input such as symbols
			try {
				numGreater = Integer.parseInt(sc.nextLine());

			}
			catch (Exception e) {
				System.out.println("Incorrect input, please try again");
				inputValid = false;
			}

		}
		//there are no numbers between 0000 and 9999 which have their sum over 36, allowing this to pass will be problematic for the formulas used later on
		if (numGreater>36) {
			System.out.println("0% of numbers between 0 and 9999 (inclusive) have their sum of digits larger or equal to " +numGreater);
			System.exit(0);
		}

		//assigning the value of numGreater into numChanger so the value can be used and the original value is retained
		numChanger = numGreater;

		//for loop uses formula to make the program more efficient in its looping later on
		for (int subtraction = 9; subtraction>=0; ){
			if (numChanger == 0) {
				break;
			}
			if (numChanger-subtraction>=0) {
				numChanger-= subtraction;
				numMax[arrayIndex] = subtraction;
				arrayIndex++;
			}
			else {
				subtraction--;
			}
		}


		//for loop goes from 9999 to the specified number found in numMax (was generated before) and adds a number to the counter whenever the sum of the number's digits is over or equal to the number the user specified
		for (int num1 = 9; num1 >=0; num1--) {
			for (int num2 = 9; num2 >=0; num2--) {
				for (int num3 = 9; num3 >=0; num3--) {
					for (int num4 = 9; num4 >=0; num4--) {
						//loop breaks when it reaches specified number found in numMax (for efficiency)
						if (num1 == numMax[3] && num2 == numMax[2] && num3 == numMax[1]&& num4 == numMax[0]) {
							break;
						}
						numTotal = num1+num2+num3+num4;
						if (numTotal>=numGreater) {
							counter = counter+1;
						}
					}

				}

			}

		}
		//prints out the results using formatter to put the answer into a percent
		System.out.println(formatter.format(counter/10000.0)+ " of numbers between 0 and 9999 (inclusive) have their sum of digits larger or equal to " + numGreater);
	}

}


