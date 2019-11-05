package kha.unit2;
import java.util.Scanner;
/**
 * <br>PackageCheck.java
 * <br>This program tells the user about whether their package is accepted to the delivery service, and 
 * <br>such depends on the users input for weight,length, width and height
 * <br>October 15, 2019
 *@author Richard Kha
 */
public class PackageCheck {
	/**
	 * 
	 * This is the entry point to the program
	 */
	public static void main(String[] args) {

		//assigns and declares variables, asks user for input
		double weight = inputParse("weight","kilograms");
		double length = inputParse("length","centimeters");
		double width = inputParse("width","centimeters");
		double height = inputParse("height","centimeters");

		//calculation to find size in centimeters cubed
		double size = length*width*height;

		//chooses which message to display with the users input
		if (weight> 27 && size> 100000 ) {
			System.out.println("Too large and too heavy.");
		}
		else if (weight> 27) {
			System.out.println("Too heavy.");
		}
		else if (size> 100000) {
			System.out.println("Too large.");
		}
		else {
			System.out.println("Accepted");
		}
		System.out.println("Weight: "+ weight+"kg "+"Size: "+size+"cm^3");

	}

	//This method prevents bad input from the user
	static double inputParse(String unitType, String units) {
		Scanner sc = new Scanner(System.in);
		double inputInDouble = 0;
		boolean inputValid = false;

		//this loop ends when the user enters valid input
		while (inputValid == false) {
			inputValid = true;

			//this try catch catches bad input such as in symbols and letters
			try {
				System.out.println("Enter package "+ unitType +" in "+ units);
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
