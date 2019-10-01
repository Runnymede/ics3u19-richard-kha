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
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a value for time less than 4.5 seconds");

		double time = sc.nextDouble();

		double objectHeight = 100-2.9*Math.pow(time, 2);

		System.out.println("The height of the object is: "+ objectHeight);


	}

}
