package kha.testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WhatAmIDoing {
	/**
	 * 
	 * This is the entry point to the program
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc =  new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(sc.readLine());
		int number2 =Integer.parseInt(sc.readLine());
		int left = number%number2;
		int how = number/number2;
		int distance = number2 - left;
		
		if (distance>left && how!=0) {
			System.out.println(left);
		}
		else {
			System.out.println(distance);
		}
	}

}
