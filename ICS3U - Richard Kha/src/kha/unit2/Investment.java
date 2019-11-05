package kha.unit2;
/**
 * <br>Investment.java
 * <br>This program tells the user about how many years it would take for a $2,500 investment to be worth at
 * <br>least $5,000 at a rate of 7.5% a year
 * <br>October 29, 2019
 *@author Richard Kha
 */
public class Investment {
	/**
	 * 
	 * This is the entry point to the program
	 */
	public static void main(String[] args) {
		double investment = 2500;
		int time = 0;

		//loop calculates how many years it'll take for the investment to be worth $5,000
		while (investment<5000) {
			investment *= 1.075;
			time++;
		}
		System.out.println("It will take "+time+" years for the $2,500 investment to be worth at least %5,000");
	}

}
