package kha.unit3;

import java.util.Scanner;

public class NameRead {

	public static void main(String[] args) {
		//declaring and assigning variables
		Scanner sc = new Scanner(System.in);
		int amount = sc.nextInt();
		String[] array = new String[amount];
		
		//getting all the names from the user
		for (int i = 0; i<amount; i++) {
			array[i] = sc.next();
		}
		
		//printing the names out in order
		for(int i = 0; i<amount; i++) {
			System.out.println(array[i]);
		}
		
		//printing the names out in reverse
		for(int i = amount-1; i>=0; i--) {
			System.out.println(array[i]);
		}

	}

}
