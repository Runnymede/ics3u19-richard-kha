package kha.testing;

import java.util.Scanner;

public class DigitsDisplay3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean inputValid = false;
		int userInput = 0;
		int counter = 0;
		String userInputString;
	
		//this loop ends when the user enters valid input
		while (inputValid == false) {
			System.out.print("Enter a positive integer: ");
			inputValid = true;
			
			//this try catch catches bad input such as symbols that are not integers
			try {
				userInput = Integer.parseInt(sc.nextLine());
				if (userInput <0) {
					inputValid = false;
					System.out.println("Input is not positive");
				}
			}
			catch (Exception e) {
				System.out.println("Incorrect input, please try again");
				inputValid = false;
			}
		}
		//converts the digits into a string so charAt can be used
		userInputString = String.valueOf(userInput);
		int [] array = new int[userInputString.length()];
		//prints out each of the digits, each on a separate line
		while (counter<userInputString.length()) {
			int lengthOfNumbers = (int) Math.pow(10,(userInputString.length()-counter-1));
			array[counter] = (int) (userInput/lengthOfNumbers);
			userInput -= array[counter]*lengthOfNumbers;
			System.out.println(array[counter]);
			counter++;
		}

	}

}