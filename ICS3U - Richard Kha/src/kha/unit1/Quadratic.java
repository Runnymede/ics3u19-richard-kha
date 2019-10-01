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
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		//This section prompts the user for values for the variables a, b and c
		System.out.println("Please give me a value for a");
		double aValue = sc.nextDouble();
		System.out.println("Please give me a value for b");
		double bValue = sc.nextDouble();
		System.out.println("Please give me a value for c");
		double cValue = sc.nextDouble();

		//This section performs the quadratic equation with the three variables, finding both of the roots
		double quadraticAnswer1 = (-bValue+Math.sqrt(Math.pow(bValue, 2)- 4* aValue*cValue))/(2*aValue);
		double quadraticAnswer2 = (-bValue-Math.sqrt(Math.pow(bValue, 2)- 4* aValue*cValue))/(2*aValue);

		System.out.println("Your roots are: "+ quadraticAnswer1+ ", and "+ quadraticAnswer2 );

	}

}
