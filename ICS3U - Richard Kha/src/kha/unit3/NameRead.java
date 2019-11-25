package kha.unit3;

import java.util.Scanner;

public class NameRead {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int amount = sc.nextInt();
		String[] array = new String[amount];
		for (int i = 0; i<amount; i++) {
			array[i] = sc.next();
		}
		for(int i = 0; i<amount; i++) {
			System.out.println(array[i]);
		}
		for(int i = amount-1; i>=0; i--) {
			System.out.println(array[i]);
		}

	}

}
