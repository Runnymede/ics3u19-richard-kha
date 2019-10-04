package kha.unit1;

import java.util.Scanner;
/**
 * ObjectHeight.java
 * This program tells the user about the height of an object at a specific time
 * September 24, 2019
 *@author Richard Kha
 */
public class ObjectHeight {
	/**
	 * 
	 * This is the entry point to the program
	 */
	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		double time = 0;
		//this variable is used to indicate when the loop ends 
		boolean inputValid = false;
		
		
		//this loop prevents bad input from the user, as in input which is not under 4.5 or symbols
		while (inputValid == false) {
			inputValid = true;
			System.out.println("Enter a value for time less than 4.5 seconds");
			
			try {
				time = Double.parseDouble(sc.nextLine());
				if (time>=4.5) {
					inputValid = false;
					System.out.println("Input is not under 4.5, try again");
				}
			}

			catch (Exception e) {
				System.out.println("Incorrect input, please try again");
				inputValid = false;
			}

		}
		//calculating the height of the object with formula
		double objectHeight = 100-2.9*Math.pow(time, 2);

		System.out.println("The height of the object is: "+ objectHeight);


	}


}
