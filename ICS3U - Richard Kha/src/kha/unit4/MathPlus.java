package kha.unit4;

import java.io.IOException;

/**
 * <br>MathPlus.java
 * <br>This program contains methods which are similar to methods in the Math class
 * <br>December 19, 2019
 *@author Richard Kha
 */
public class MathPlus {
	/**
	 * This is the entry point to the program
	 * 
	 */
	public static void main(String[] args) {
	int [] arr = {-232,1,3,5,7,2,5,99};
	System.out.println(min(arr));
	System.out.println(max(arr));
	System.out.println(sum(arr));
	System.out.println(average(arr));
	}
	/**
	 * This method calculates the index of the minimum value in the array
	 * @param integer type, one dimensional array 
	 * @return the index of the minimum value in the array
	 */
	public static int min(int[] array) {
		int minIndex = 0;
		
		//calculating the index of the highest value
		for (int i = 0; i< array.length; i++) {
			if (array[i]<array[minIndex]) {
				minIndex = i;
			}
		}
		return minIndex;
	}
	/**
	 * This method calculates the index of the maximum value in the array
	 * @param integer type, one dimensional array 
	 * @return the index of the maximum value in the array
	 */
	public static int max(int[] array) {
		int maxIndex = 0;
		
		//calculating the index of the lowest value
		for (int i = 0; i< array.length; i++) {
			if (array[i]>array[maxIndex]) {
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	/**
	 * This method sums up all the values in the array
	 * @param integer type, one dimensional array 
	 * @return the sum of all the values in the array
	 */
	public static int sum(int[] array) {
		int total = 0;
		
		//calculating sum
		for (int i = 0; i< array.length; i++) {
			total += array[i];
		}
		return total;
	}
	/**
	 * This calculates the average of all the values in the array
	 * @param integer type, one dimensional array 
	 * @return the average if all the values in the array
	 */
	public static double average(int[] array) {
		/*
		Calculating average through calling the sum method and dividing the return
		by the size of the array.
		The 1.0 is because integers will truncate the value
		and cause inaccuracies with the answer.
		*/
		double average = sum(array)*1.0/array.length;
		return average;
	}

}
