package kha.unit4;


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
		double [] arr = {-32,-1878,3,5,4,7,7,7,2,4,99};
		
		System.out.println(min(arr));
		System.out.println(max(arr));
		System.out.println(sum(arr));
		System.out.println(average(arr));
		System.out.println(median(arr));
		System.out.println(mode(arr));
		System.out.println(factorial(5));
		System.out.println(numOfFactors(5));
		System.out.println(factors(24));
	
	}
	/**
	 * This method calculates the index of the minimum value in the array
	 * @param array - integer type, one dimensional array 
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
	 * @param array - double type, one dimensional array 
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
	 * @param array - byte type, one dimensional array 
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
	 * @param array - long type, one dimensional array 
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
	 * @param array - float type, one dimensional array 
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
	 * @param array - short type, one dimensional array 
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
	 * @param array - integer type, one dimensional array 
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
	 * @param array - double type, one dimensional array 
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
	 * @param array - byte type, one dimensional array 
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
	 * @param array - long type, one dimensional array 
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
	 * @param array - float type, one dimensional array 
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
	 * @param array - short type, one dimensional array 
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
	 * @param array - integer type, one dimensional array 
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
	 * @param array - double type, one dimensional array 
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
	 * @param array - byte type, one dimensional array 
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
	 * @param array - long type, one dimensional array 
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
	 * @param array - float type, one dimensional array 
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
	 * @param array - short type, one dimensional array 
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
	 * @param array - integer type, one dimensional array 
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
	 * @param array - double type, one dimensional array 
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
	 * @param array - byte type, one dimensional array 
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
	 * @param array - long type, one dimensional array 
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
	 * @param array - float type, one dimensional array 
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
	 * @param array - short type, one dimensional array 
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
	/**
	 * This finds the median value of the array
	 * @param array - double type, one dimensional array
	 * @return the median value of the array
	 */
	public static double median(double[] array) {
		double median = 0;
		
		/*
		the calculation for the median value changes with whether 
		the array has an even or odd number of elements
		*/
		if (array.length%2 == 1) {
			median = array[array.length/2];
		}
		else {
			median = (array[array.length/2]+array[array.length/2-1])/2;
		}
		return median;
	}
	/**
	 * This finds the mode value of the array
	 * @param array - double type, one dimensional array
	 * @return the mode value of the array
	 */
	public static double mode(double[] array) {
		double mode = 0;
		int counter = 0;
		
		/*
		this loop takes every individual element of the array and finds
		how many times it occurs
		*/
		for (int i = 0; i<array.length; i++) {
			int tempCounter = 0;
			double tempMode = array[i];
			for (int i2 = 0; i2<array.length; i2++) {
				if (tempMode == array[i2]) {
					tempCounter++;
				}
			}
			if (tempCounter > counter) {
			mode = tempMode;
			counter = tempCounter;
			}
		}
		return mode;
	}
	/**
	 * This finds the factorial value of an integer
	 * @param array - integer type value
	 * @return the value of the input's factorial
	 */
	public static long factorial(int input) {
		long factorial = 1;
		if (input == 0) {
		}
		else if(input<0) {
			factorial = -1;
		}
		else {
			for (int i = 0; i<input; i++) {
				factorial *= input-i; 
			}
		}
		return factorial;
	}
	
	public static int numOfFactors(int input) {
		int numOfFactors = 0;
		for (int i = 1; i<=input; i++) {
			if (input%i == 0) {
				numOfFactors++;
			}
		}
		return numOfFactors;
	}
	
	public static int[] factors(int input) {
		int[] factors = new int [numOfFactors(input)];
		int index = 0;
		for (int i = 1; i<=input; i++) {
			if (input%i == 0) {
				factors[index] = i;
				index++;
			}
		}
		return factors;
	}
}
