package kha.unit2;
/**
 * <br>EvenNumbers.java
 * <br>This program prints out all the even numbers from 1 to 100
 * <br>November 11, 2019
 *@author Richard Kha
 */
public class EvenNumbers {
	/**
	 * 
	 * This is the entry point to the program
	 */
	public static void main(String[] args) {
		
		//loop to get values from 1 to 100
		for (int number = 1; number<=100; number++) {
			
			//calculation to find the even numbers between 1 to 100
			if(number%2 == 0) {
				System.out.println(number);
			}
		}

	}

}
