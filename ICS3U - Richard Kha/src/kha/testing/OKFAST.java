package kha.testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OKFAST {

	public static void main(String[] args) throws IOException {
		BufferedReader sc =  new BufferedReader(new InputStreamReader(System.in));
		int [][][] array = new int[25][6][100];
		int counter = 0;
		String i = sc.readLine();
		int counter2 = 0;
		int tempValue;
		int location = Integer.MAX_VALUE;
		for (int d = 0; d<100; d++) {
			tempValue = 0;
			for (int si = 0; si<6; si++) {
				for (int mon = 0; mon<25; mon++) {
					array[mon][si][d] = Character.getNumericValue(i.charAt(counter));
					if (array[mon][si][d] == 0) {
						tempValue++;
					}
					counter++;
					
				}
			}
			if (tempValue<location) {
				location = tempValue;
				counter2 = d;
			}
		}
		int value1 = 0;
		int value2 = 0;
		for (int si = 0; si<6; si++) {
			for (int mon = 0; mon<25; mon++) {
				if (array[mon][si][counter2] == 1) {
					value1++;
				}
				if (array[mon][si][counter2] == 2) {
					value2++;
				}
			}
		}
		System.out.println(value1*value2);
	
		
	}

}
