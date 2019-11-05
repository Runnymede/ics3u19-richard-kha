package kha.unit2;

import java.util.Scanner;
/**
 * <br>CarRecall2.java
 * <br>This program tells the user about whether their car model is defective and must be repaired
 * <br>October 28, 2019
 *@author Richard Kha
 */
public class CarRecall2 {
	/**
	 * 
	 * This is the entry point to the program
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int carModel = -1;
		System.out.println("Enter 0 to exit the program ");
		while (carModel!=0) {
			boolean inputValid = false;
			//this loop ends when the user enters valid input
			while (inputValid == false) {
				System.out.println("Enter the car's model number: ");
				inputValid = true;
				//this try catch catches bad input such as symbols that are not integers
				try {
					carModel = Integer.parseInt(sc.nextLine());	
				}
				catch (Exception e) {
					System.out.println("Incorrect input, please try again");
					inputValid = false;
				}
			}
			//exits the loop when 0 is entered, skipping the rest of the code
			switch(carModel) {
			case 0:
				break;
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

}
