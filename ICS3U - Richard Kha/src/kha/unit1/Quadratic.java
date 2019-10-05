package kha.unit1;

import java.util.Scanner;
/**
 * ObjectHeight.java
 * This program performs the quadratic formula when given the three variables: a, b, c
 * September 30, 2019
 *@author Richard Kha
 */
public class Quadratic {
	/**
	 * 
	 * This is the entry point to the program
	 */
		System.out.println("Quadratic equation solver");
	
		//This section prompts the user for values for the variables a, b and c
		double aValue = inputParse("a");
		double bValue = inputParse("b");
		double cValue = inputParse("c");

		//This section performs the quadratic equation with the three variables, finding both of the roots
		double quadraticAnswer1 = (-bValue+Math.sqrt(Math.pow(bValue, 2)- 4* aValue*cValue))/(2*aValue);
		double quadraticAnswer2 = (-bValue-Math.sqrt(Math.pow(bValue, 2)- 4* aValue*cValue))/(2*aValue);

		System.out.println("Your roots are: "+ quadraticAnswer1+ ", and "+ quadraticAnswer2 );

	}
	//This method prevents bad input from the user
	static double inputParse(String letterExamined) {
		Scanner sc = new Scanner(System.in);
		double inputInDouble = 0;
		boolean inputValid = false;
		
		//this loop ends when the user enters valid input
		while (inputValid == false) {
			inputValid = true;
			
			//this try catch catches bad input such as in symbols and letters
			try {
				System.out.println("Please give me a value for "+ letterExamined);
				inputInDouble = Double.parseDouble(sc.nextLine());
			}
			catch (Exception e) {
				System.out.println("Incorrect input, please try again");
				inputValid = false;
			}
		}
		return inputInDouble;
	}
}
