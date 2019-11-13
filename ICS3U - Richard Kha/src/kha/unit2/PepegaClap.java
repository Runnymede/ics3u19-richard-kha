package bows;

import java.util.Scanner;

public class PepegaClap {


	public static void main(String[] args) {
		System.out.println("Input the highest or lowest exponent value and the highest or lowest base value and a power table will be generated from 1 to that number");
		System.out.println("When calculating the positive exponents, any numbers larger than 9223372036854775807 will be marked as N/A");
		System.out.println("When calculating the negative exponents, any numbers smaller than 0.000000001 will be marked as 0.0");

		//declaring variables
		int inputExponent = inputParse("Enter the highest exponent value");
		int inputBase = inputParse("Enter the highest base value");
		long number; 
		int baseNumber;
		int exponentNumber;

		//this loop counts from 0 to the base number the user inputed
		for (int a =-1; a<=Math.abs(inputBase); a++) {
			//putting the value of the counter (a) into baseNumber allows the value of 'a' to be used without changing the value of the counter for the loop
			baseNumber = a;
			
			//if statement handles putting x as the label for the first column
			if (baseNumber == -1) {
				System.out.printf("%4s","x");
			}
			//else statement prints out 0 to the base number for the first column
			else {
				
				//if statement handles negative bases
				if (inputBase<0) {
					baseNumber = 0-baseNumber;
				}
				System.out.printf("%4s",baseNumber);
			}	
			//loop prints out the rest of the table, Math.abs in for loop allows for negative input
			for(int i =0; i<=Math.abs(inputExponent); i++) {
				
				//putting the value of the Math.pow(a, i) into number allows for calculations
				number = (long) Math.pow(a, i);
				
				//when negative numbers are with an odd exponent, a negative result is produced
				if (inputBase<0 && i%2 ==1) {
					number = 0-number;
				}
				//when dividing by 0 (as in 0 to the exponent of a negative power) print undefined 
				if (a == 0 && i!=0 && inputExponent<0) {
					System.out.printf("%20s","undefined");	
				}
				//prints out x^(number), the header for each of the columns past 'x'
				else if (a == -1) {
					//allows the exponent number to count to the exponent number the user inputed
					exponentNumber=i;
					//if the exponent is negative, use a trick to make the exponent negative (this is not used for calculations however)
					if (inputExponent<0) {
						exponentNumber = 0-exponentNumber;
					}
					System.out.printf("%20s","x^"+exponentNumber);
				}
				/*
				if the number is the highest value for long, print N/A since printing anything else is incorrect.
				also the since the calculation for negative exponents is not calculated yet, inputExponent>0 is a condition
				*/
				else if (number == Long.MAX_VALUE &&inputExponent>0) {
					System.out.printf("%20s","N/A");
				}	
				//calculations for negative exponents
				else if (inputExponent<0) {
					//formula which prints the answer with accuracy up to 10 significant digits
					System.out.printf("%20s",(Math.round((1.0/number)*1000000000.0))/1000000000.0);
				}
				else {
					//printing positive exponent result
					System.out.printf("%20s",number);
				}
			}
			//separates the data into rows
			System.out.println();
		}


	}
	/**
	 * Gets the users input and refuses bad input.
	 * @return integer for main calculations.
	 */
	static int inputParse(String numberExamined) {
		Scanner sc = new Scanner(System.in);
		int integerInput = 0;
		boolean inputValid = false;

		//this loop ends when the user enters valid input
		while (inputValid == false) {
			inputValid = true;

			//this try catch catches bad input such as in symbols and letters
			try {
				System.out.println(numberExamined);
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



