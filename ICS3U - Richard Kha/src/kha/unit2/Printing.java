package kha.unit2;

import java.text.NumberFormat;
import java.util.Scanner;
/**
 * <br>Printing.java
 * <br>This program tells the user about the cost of printing a certain amount of copies
 * <br>specified by the user
 * <br>October 4, 2019
 *@author Richard Kha
 */
public class Printing {
	/**
	 * 
	 * This is the entry point to the program
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		NumberFormat cost = NumberFormat.getCurrencyInstance();

		boolean inputValid = false;
		int numberOfCopies = 0;
		//this loop ends when the user enters valid input
		while (inputValid == false) {
			inputValid = true;
			System.out.print("Enter the number of copies to be printed: ");
			//this try catch catches bad input such as symbols that are not integers
			try {
				numberOfCopies = Integer.parseInt(sc.nextLine());	
			}
			catch (Exception e) {
				System.out.println("Incorrect input, please try again");
				inputValid = false;
			}
		}
		double price;
		double totalCost;

		//assigns the price of each paper at the current amount of copies
		if (numberOfCopies < 100) {
			price = 0.30;
		}
		else if (numberOfCopies<500) {
			price = 0.28;
		}
		else if (numberOfCopies<750) {
			price = 0.27;

		}
		else if (numberOfCopies<1000) {
			price = 0.26;
		}
		else {
			price = 0.25;
		}

		//determines the total cost of printing the user-indicated amount of papers
		totalCost = price*numberOfCopies;

		System.out.println("Price per copy is: $"+ price );
		System.out.println("Total cost is: "+ cost.format(totalCost));
	}

}
