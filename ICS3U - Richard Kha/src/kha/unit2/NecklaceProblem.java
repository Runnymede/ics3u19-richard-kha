package kha.unit2;

import java.util.Scanner;
/**
 * <br>NecklaceProblem.java
 * <br>This program tells the necklace chain of the two numbers they input
 * <br>October 29, 2019
 *@author Richard Kha
 */
public class NecklaceProblem {
	/**
	 * 
	 * This is the entry point to the program
	 */
	public static void main(String[] args) {
		System.out.println("Necklace chain generator");
		
		//declares variables and assigns them
		int input1 = inputParse("first");
		int input2 = inputParse("second");
		int compute1 = input1;
		int compute2 = input2;
		int numStorage;
	
		//prints out first two numbers of the 
		System.out.print(input1 +" "+input2);
		do {
			numStorage = compute1;
			compute1 = compute2;
			compute2 = (numStorage + compute2)%10;
			System.out.print(" "+ compute2);
		}while (compute1!=input1 || compute2!=input2);
		
	}
	/**
	 * Gets the users input and refuses bad input.
	 * @return integer for main calculations.
	 */
	static int inputParse(String numberExamined) {
		Scanner sc = new Scanner(System.in);
		int integerInput = 0;
		boolean inputValid = false;

		//this loop ends when the user enters valid input
		while (inputValid == false) {
			inputValid = true;

			//this try catch catches bad input such as in symbols and letters
			try {
				System.out.println("Please give me a integer for your "+numberExamined+ " number");
				integerInput= Integer.parseInt((sc.nextLine()));
			}
			catch (Exception e) {
				System.out.println("Incorrect input, please try again");
				inputValid = false;
			}
		}
		return integerInput;
	}
}
