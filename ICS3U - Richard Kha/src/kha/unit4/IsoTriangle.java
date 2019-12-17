package kha.unit4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * <br>IsoTriangle.java
 * <br>This program prints out an isosceles triangle which size depends on the user's input
 * <br>December 17, 2019
 *@author Richard Kha
 */
public class IsoTriangle {
/**
 * 
 * This is the entry point to the program
 * @throws NumberFormatException
 * @throws IOException
 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		//declaration of variables
		BufferedReader sc =  new BufferedReader(new InputStreamReader(System.in));
		boolean inputValid = false;
		int size = 0;
		int amountOfSpaces;
		int amountOfStars;
		
		//this loop ends when the user enters valid input
		while (inputValid == false) {
			inputValid = true;
			System.out.println("Give a positive integer for the size of this isosceles triangle");
			
			//this try catch catches bad input such as symbols and numbers which are not over or equal to 0
			try {
				size = Integer.parseInt((sc.readLine()));
				if (size<0) {
					inputValid = false;
					System.out.println("The size of an isosceles triangle cannot be negative, please try again");
				}
			}
			catch (Exception e) {
				System.out.println("Incorrect input, please try again");
				inputValid = false;
			}

		}
		
		//part of calculations for the amount of spaces
		amountOfSpaces = size;
		
		//loop to send numbers related to the triangle into methods drawSpaces and drawStars
		for (int i = 0; i<size; i++) {
		
		//formulas to send correct numbers
		amountOfStars = 2*(i)+1;
		amountOfSpaces --;
		
		//sending values to methods
		drawSpaces(amountOfSpaces);
		
		drawStars(amountOfStars);
		
		//separating each row
		System.out.println();
		}
	}
	/**
	 * This method prints out a certain amount of spaces on a line
	 * @param amount (the amount of spaces)
	 */
	
	public static void drawSpaces(int amount1) {
		for (int i = 0; i<amount1; i++) {
			System.out.print(" ");
		}
		
	}
	/**
	 * This method prints out a certain amount of stars on a line
	 * @param amount (the amount of stars)
	 */
	public static void drawStars(int amount) {
		for(int i = 0; i<amount; i++) {
			System.out.print("*");
		}
	}

}
