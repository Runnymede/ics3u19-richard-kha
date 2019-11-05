package kha.unit2;


import java.util.Scanner;

public class PrimeNumberMod {

	public static void main(String[] args) {
		//initializes and declares variables
		int number1 = inputParse("1st");
		int number2 = inputParse("2nd");
		int numberStorage;
		if (number2< number1) {
			numberStorage = number1;
			number1 = number2;
			number2 = numberStorage;
		}
		int counter;
		boolean prime;
		while (number1<=number2) {
			prime = true;
			counter = 2;
			while (counter<=(int)(Math.sqrt(Math.abs(number1)))){
				if (number1%counter == 0) {
					prime = false;
					break;
				}

				counter++;
			}
			if (number1 == -2147483648) {
				prime = false;
			}
			if (prime == true) {

				System.out.println(number1);
			}
			number1++;
		}
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
