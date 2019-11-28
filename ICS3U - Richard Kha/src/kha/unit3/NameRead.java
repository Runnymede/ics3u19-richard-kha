package kha.unit3;

import java.util.Scanner;
/**
 * <br>This program takes a number of names from the user, then
 * <br>it prints these names in forward order and then in reverse order
 * <br>
 * <br>November 28, 2019
 * @author Richard Kha
 *
 */
public class NameRead {
	/**
	 * 
	 * This is the entry point to the program
	 */
	public static void main(String[] args) {
		//declaring and assigning variables
		Scanner sc = new Scanner(System.in);
		int amount = 0;
		String[] array = new String[amount];
		System.out.println("How many names will you input?");
		amount = sc.nextInt();
		
		//getting all the names from the user
		for (int i = 0; i<amount; i++) {
			array[i] = sc.next();
		}
		
		//printing the names out in order
		for(int i = 0; i<amount; i++) {
			System.out.println("Normal order");
			System.out.println(array[i]);
		}
		
		//printing the names out in reverse
		for(int i = amount-1; i>=0; i--) {
			System.out.println("Reverse order");
			System.out.println(array[i]);
		}

	}

}