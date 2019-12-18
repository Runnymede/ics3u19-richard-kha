package kha.testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ez {
	static int [][]array1 = new int[10000][10000];
	static int [][]array2 = new int[10000][10000];
	public static void main(String[] args) throws IOException {
		BufferedReader sc =  new BufferedReader(new InputStreamReader(System.in));
		String movement1 = sc.readLine();
		String movement2 = sc.readLine();
		String [] movement1array = movement1.split(",");
		String [] movement2array = movement2.split(",");
		array1 = maN(movement1array);
		array2 = maN(movement2array);
		int [][] array = new int[1000][2];
		int counter = 10000;
//		for (int i = 0; i<10000; i++) {
//			for (int d = 0; d<10000; d++) {
//				if (array1[i][d] == 1 && array2[i][d] == 1 && (i!=5000&&d!=5000)) {
//					if ((Math.abs(i-5000) + Math.abs(d-5000))<counter) {
//						counter = (Math.abs(i-5000) + Math.abs(d-5000));
//					}
//				}
//			}
//		}
		System.out.println(counter);
	}
	public static int[][] maN(String[] array){
		int[][] arrayUsing = new int[10000][10000];
		int x = 5000;
		int y = 5000;
		arrayUsing[5000][5000] = 1;
		for (int i = 0; i<array.length; i++) {
			int tempNumber = 0;
			tempNumber = Integer.parseInt(array[i].substring(1));
			if (array[i].charAt(0) == 'U'){
				for (int d = 1; d<tempNumber; d++) {
					arrayUsing[y+d][x] = 1;
				}
			}
			else if (array[i].charAt(0) == 'D'){
				for (int d = 1; d<tempNumber; d++) {
					arrayUsing[y-d][x] = 1;
				}
			}
			else if (array[i].charAt(0) == 'R'){
				for (int d = 1; d<tempNumber; d++) {
					arrayUsing[y][x+d] = 1;
				}
			}
			else {
				for (int d = 1; d<tempNumber; d++) {
					arrayUsing[y][x-d] = 1;
				}
			}
		}
		return arrayUsing;
	}
}
