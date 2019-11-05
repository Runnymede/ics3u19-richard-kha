package kha.unit2;
import java.util.Scanner;
/**
 * <br>MathTutor.java
 * <br>This program generates random numbers and performs a random operation with these numbers
 * <br>and asks the user for the answer of these operations
 * <br>October 24, 2019
 *@author Richard Kha
 */
public class MathTutor {
	/**
	 * 
	 * This is the entry point to the program
	 */
	public static void main(String[] args) {
		System.out.println("Math tutor");
		System.out.println("Complete the questions, once you get one incorrect, you lose");
		System.out.println("Answers to the questions are rounded to two decimal places when nessesary");

		//streak finds how many questions the user got correct in a row
		int streak = -1;

		//loop allows for the game to be played infinitely, as long as the user gives correct answer
		while (1==1) {
			streak++;

			//declaring and assigning objects and variables
			Scanner sc = new Scanner(System.in);
			double firstNumber = (int)(Math.random()*10)+1;
			double secondNumber = (int)(Math.random()*10)+1;
			int operator= (int)(Math.random()*4);
			char symbol;
			double answer = 0.0;
			double input = 0;

			//Chooses the random operator and performs the operation with the two random numbers
			if (operator == 0) {
				symbol = '+';
				answer = firstNumber+secondNumber;
			}
			else if (operator ==1) {
				symbol = '-';
				answer = firstNumber-secondNumber;
			}
			else if (operator == 2) {
				symbol = '*';
				answer = firstNumber*secondNumber;
			}
			else {
				symbol = '/';
				answer = firstNumber/secondNumber;
			}

			//rounds the answer to two decimal places
			answer = Math.round(answer*100)/100.0;

			boolean inputValid = false;
			//this loop ends when the user enters valid input
			while (inputValid == false) {
				inputValid = true;
				System.out.print("What is "+firstNumber +" "+symbol+" "+secondNumber+"? ");
				//this try catch catches bad input such as symbols that are not integers
				try {
					input = Double.parseDouble(sc.nextLine());	
				}
				catch (Exception e) {
					System.out.println("Incorrect input, please try again");
					inputValid = false;
				}
			}
			//responds to the user whether their input was correct and closes the program when their input is incorrect
			if (input == answer) {
				System.out.println("Correct!");
			}
			else {
				System.out.println("Incorrect!");
				System.out.println("You got "+streak+" question(s) correct in a row");
				System.exit(0);
			}
		}
	}

}
