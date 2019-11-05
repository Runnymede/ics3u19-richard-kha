package kha.unit2;

import java.util.Scanner;
/**
 * <br>StringThings.java
 * <br>This program performs multiple operations with strings and displays the output of those operations
 * <br>October 09, 2019
 *@author Richard Kha
 */
public class StringThings {
	/**
	 * 
	 * This is the entry point to the program
	 */
	public static void main(String[] args) {
		//declaring variables
		Scanner sc = new Scanner(System.in);
		String username = "Secure";
		String password = "password";
		int index = 0;
		String inputUsername;
		String inputPassword;
		String input = "0";
		String input2;

		//prevents string of less than 5 characters

		while (input.length()<7) {
			System.out.println("Input a word that is at least 7 characters long");
			input = sc.next();
			if (input.length()<7) {
				System.out.println("Error");
			}
		}
		//displays output of some statistics
		System.out.println("Upper case: "+input.toUpperCase());
		System.out.println("Lower case: "+input.toLowerCase());
		System.out.println("Length: "+input.length());
		System.out.println("The character at index 6 is: "+input.charAt(6));

		//input
		boolean inputValid = false;
		//this loop ends when the user enters valid input
		while (inputValid == false) {
			inputValid = true;
			System.out.println("What index of the string do you want");
			//this try catch catches bad input such as symbols that are not integers and indexes that will lead to an out of bounds errpr
			try {
				index = Integer.parseInt(sc.nextLine());
				if (index> input.length()-1 || index<0) {
					System.out.println("Error, this index is out of bounds, please try again");
					inputValid = false;
				}
			}
			catch (Exception e) {
				System.out.println("Incorrect input, please try again");
				inputValid = false;
			}
		}
		System.out.println("Character is: "+input.charAt(index));

		//input
		System.out.println("Input two words");
		input = sc.next();
		input2 = sc.next();

		//calculates which word comes first
		if (input.compareTo(input2) > 0) {
			System.out.println(input +" comes after "+ input2);
		}
		else if(input.compareTo(input2) < 0) {
			System.out.println(input+" comes before "+ input2);
		}
		else {
			System.out.println("Same words");
		}

		//input
		System.out.println("Input the username");
		inputUsername = sc.next();
		System.out.println("Input the password");
		inputPassword = sc.next();

		//checks if strings are equal to the actual password and username
		if (inputUsername.equals(username)&&inputPassword.equals(password)) {
			System.out.println("Welcome");
		}
		else {
			System.out.println("You got the wrong username or password");
		}
	}
}
