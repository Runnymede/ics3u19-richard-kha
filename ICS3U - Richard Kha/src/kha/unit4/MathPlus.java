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
	long [] arr = {-32,-1878,3,5,7,2,5,99};
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
	 * This method calculates the index of the minimum value in the array
	 * @param double type, one dimensional array 
	 * @return the index of the minimum value in the array
	 */
	public static int min(double[] array) {
	
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
	 * This method calculates the index of the minimum value in the array
	 * @param byte type, one dimensional array 
	 * @return the index of the minimum value in the array
	 */
	public static int min(byte[] array) {
		
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
	 * This method calculates the index of the minimum value in the array
	 * @param long type, one dimensional array 
	 * @return the index of the minimum value in the array
	 */
	public static int min(long[] array) {
		
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
	 * This method calculates the index of the minimum value in the array
	 * @param float type, one dimensional array 
	 * @return the index of the minimum value in the array
	 */
	public static int min(float[] array) {
		
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
	 * This method calculates the index of the minimum value in the array
	 * @param short type, one dimensional array 
	 * @return the index of the minimum value in the array
	 */
	public static int min(short[] array) {
		
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
	 * This method calculates the index of the maximum value in the array
	 * @param double type, one dimensional array 
	 * @return the index of the maximum value in the array
	 */
	public static int max(double[] array) {
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
	 * This method calculates the index of the maximum value in the array
	 * @param byte type, one dimensional array 
	 * @return the index of the maximum value in the array
	 */
	public static int max(byte[] array) {
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
	 * This method calculates the index of the maximum value in the array
	 * @param long type, one dimensional array 
	 * @return the index of the maximum value in the array
	 */
	public static int max(long[] array) {
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
	 * This method calculates the index of the maximum value in the array
	 * @param float type, one dimensional array 
	 * @return the index of the maximum value in the array
	 */
	public static int max(float[] array) {
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
	 * This method calculates the index of the maximum value in the array
	 * @param short type, one dimensional array 
	 * @return the index of the maximum value in the array
	 */
	public static int max(short[] array) {
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
	 * This method sums up all the values in the array
	 * @param double type, one dimensional array 
	 * @return the sum of all the values in the array
	 */
	public static double sum(double[] array) {
		double total = 0;
		
		//calculating sum
		for (int i = 0; i< array.length; i++) {
			total += array[i];
		}
		return total;
	}
	/**
	 * This method sums up all the values in the array
	 * @param byte type, one dimensional array 
	 * @return the sum of all the values in the array
	 */
	public static byte sum(byte[] array) {
		byte total = 0;
		
		//calculating sum
		for (int i = 0; i< array.length; i++) {
			total += array[i];
		}
		return total;
	}
	/**
	 * This method sums up all the values in the array
	 * @param long type, one dimensional array 
	 * @return the sum of all the values in the array
	 */
	public static long sum(long[] array) {
		long total = 0;
		
		//calculating sum
		for (int i = 0; i< array.length; i++) {
			total += array[i];
		}
		return total;
	}
	/**
	 * This method sums up all the values in the array
	 * @param float type, one dimensional array 
	 * @return the sum of all the values in the array
	 */
	public static float sum(float[] array) {
		float total = 0;
		
		//calculating sum
		for (int i = 0; i< array.length; i++) {
			total += array[i];
		}
		return total;
	}
	/**
	 * This method sums up all the values in the array
	 * @param short type, one dimensional array 
	 * @return the sum of all the values in the array
	 */
	public static short sum(short[] array) {
		short total = 0;
		
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

	/**
	 * This calculates the average of all the values in the array
	 * @param double type, one dimensional array 
	 * @return the average if all the values in the array
	 */
	public static double average(double[] array) {
		/*
		Calculating average through calling the sum method and dividing the return
		by the size of the array.
		and cause inaccuracies with the answer.
		*/
		double average = sum(array)/array.length;
		return average;
	}

	/**
	 * This calculates the average of all the values in the array
	 * @param byte type, one dimensional array 
	 * @return the average if all the values in the array
	 */
	public static double average(byte[] array) {
		/*
		Calculating average through calling the sum method and dividing the return
		by the size of the array.
		The 1.0 is because bytes will truncate the value
		and cause inaccuracies with the answer.
		*/
		double average = sum(array)*1.0/array.length;
		return average;
	}

	/**
	 * This calculates the average of all the values in the array
	 * @param long type, one dimensional array 
	 * @return the average if all the values in the array
	 */
	public static double average(long[] array) {
		/*
		Calculating average through calling the sum method and dividing the return
		by the size of the array.
		The 1.0 is because longs will truncate the value
		and cause inaccuracies with the answer.
		*/
		double average = sum(array)*1.0/array.length;
		return average;
	}

	/**
	 * This calculates the average of all the values in the array
	 * @param float type, one dimensional array 
	 * @return the average if all the values in the array
	 */
	public static double average(float[] array) {
		/*
		Calculating average through calling the sum method and dividing the return
		by the size of the array.
		and cause inaccuracies with the answer.
		*/
		double average = sum(array)/array.length;
		return average;
	}
	
	/**
	 * This calculates the average of all the values in the array
	 * @param short type, one dimensional array 
	 * @return the average if all the values in the array
	 */
	public static double average(short[] array) {
		/*
		Calculating average through calling the sum method and dividing the return
		by the size of the array.
		The 1.0 is because shorts will truncate the value
		and cause inaccuracies with the answer.
		*/
		double average = sum(array)*1.0/array.length;
		return average;
	}
	

}
