package kha.unit2;

import java.util.Scanner;
/**
 * <br>CarRecall.java
 * <br>This program tells the user about whether their car model is defective and must be repaired
 * <br>October 4, 2019
 *@author Richard Kha
 */
public class CarRecall {
	/**
	 * 
	 * This is the entry point to the program
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean inputValid = false;
		int carModel = 0;
		//this loop ends when the user enters valid input
		while (inputValid == false) {
			inputValid = true;
			System.out.print("Enter the car's model number: ");
			//this try catch catches bad input such as symbols that are not integers
			try {
				carModel = Integer.parseInt(sc.nextLine());	
			}
			catch (Exception e) {
				System.out.println("Incorrect input, please try again");
				inputValid = false;
			}
		}
		//switch displays a message only if certain numbers are inputed
		switch(carModel) {
		case 179: 
		case 189:
		case 190:
		case 191:
		case 192:
		case 193:
		case 194:
		case 195:
		case 199:
		case 221:
		case 780: System.out.println("Your car is defective. It must be repaired.");
		break;
		default: System.out.println("Your car is not defective.");
		}


	}

}
