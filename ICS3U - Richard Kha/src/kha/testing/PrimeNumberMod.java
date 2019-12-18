package kha.testing;

import java.util.ArrayList;
import java.util.Scanner;

public class PrimeNumberMod {

	public static void main(String[] args) {
		//initializes and declares variables

		int number = 0;
		int number2 = 0;

		number = inputParse("first");
		number2 = inputParse("second");
		ArrayList<Integer> number1Array = new ArrayList<Integer>();
		ArrayList<Integer> number2Array = new ArrayList<Integer>();
		number1Array = inputFactor(number);
		number2Array = inputFactor(number2);
		System.out.print(number1Array);
		System.out.print(number2Array);

	}
	static ArrayList<Integer> inputFactor(int numberExamined) {
		int counter = 1;
		ArrayList<Integer> integerFactors = new ArrayList<Integer>();
		numberExamined = Math.abs(numberExamined);
		//loop checks if the numberExamined is not a prime, and if so, it exits the program
		while (counter < numberExamined) {
			if (numberExamined%counter == 0) {
				integerFactors.add(counter);
			}
			counter++;
		}
		return integerFactors;
	}
	static int inputParse(String numberExamined) {
		Scanner sc = new Scanner(System.in);
		int integerInput = 0;
		boolean inputValid = false;

		//this loop ends when the user enters valid input
		while (inputValid == false) {
			inputValid = true;

			//this try catch catches bad input such as in symbols and letters
			try {
				System.out.println("Please give me a value for your "+numberExamined+ " integer");
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
