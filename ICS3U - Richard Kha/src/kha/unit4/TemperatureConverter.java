package kha.unit4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * <br>TemperatureConverter.java
 * <br>This program converts the user's input from Celsius to Fahrenheit or Fahrenheit to Celsius.
 * <br>December 18, 2019
 *@author Richard Kha
 */
public class TemperatureConverter {
	/**
	 * This is the entry point to the program (throws are for BufferedReader)
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		//declaring variables
		BufferedReader sc =  new BufferedReader(new InputStreamReader(System.in));
		do {
		String input = " ";
		double value = 0;
		boolean inputValid = false;
		boolean pass = false;
		System.out.println("Would you like to convert Celsius to Fahrenheit or Fahrenheit to Celsius?");

		do  {

			System.out.println("Enter 1 for Celsius to Fahrenheit");
			System.out.println("Enter 2 for Fahrenheit to Celsius");
			input = sc.readLine().trim();

			pass = !input.equals("1")&&!input.equals("2");
			if (pass == true) {
				System.out.println("Invalid input, please try again");
			}

		}while (pass == true);


		//this loop ends when the user enters valid input
		while (inputValid == false) {
			inputValid = true;
			System.out.println("Input the number you want to convert");

			//this try catch catches bad input such as symbols and numbers which are not over or equal to 0
			try {
				value = Double.parseDouble(sc.readLine());
			}
			catch (Exception e) {
				System.out.println("Invalid input, please try again");
				inputValid = false;
			}

		}

		if (input.equals("1")) {

			System.out.println("Your answer is "+cToF(value)+"°C");
		}
		else {

			System.out.println("Your answer is "+fToC(value)+"°F");
		}
		System.out.println("Enter 1 if you want to do another calculation");
	} while (sc.readLine().trim().equals("1"));
		
	}
	public static double cToF(double value) {
		double answer = (value*9/5)+32;
		return answer;
	}
	public static double fToC(double value) {
		double answer = (value-32)/9*5;
		return answer;
	}

}
