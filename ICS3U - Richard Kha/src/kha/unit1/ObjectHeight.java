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
		int i=0;
		System.out.println("Enter a value for time less than 4.5 seconds");
		
		
		//this loop prevents bad input from the user, as in input not under 4.5 or strings
		while (i ==0) {
			i=1;
			try {
				time = Double.parseDouble(sc.nextLine());
				if (time>=4.5) {
					i=0;
					System.out.println("Input is not under 4.5, try again");
				}
			}

			catch (Exception e) {
				System.out.println("Incorrect input, please try again");
				i=0;
			}

		}
		double objectHeight = 100-2.9*Math.pow(time, 2);

		System.out.println("The height of the object is: "+ objectHeight);


	}


}
