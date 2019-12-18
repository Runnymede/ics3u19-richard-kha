package kha.testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//brute force lol
public class Quick {
	final static int size = 20000;
	final static int half = 10000;
	static boolean [][]array1 = new boolean[size][size];
	static boolean [][]array2 = new boolean[size][size];
	
	public static void main(String[] args) throws IOException {
		BufferedReader sc =  new BufferedReader(new InputStreamReader(System.in));
		String movement1 = sc.readLine();
		String movement2 = sc.readLine();
		String [] movement1array = movement1.split(",");
		String [] movement2array = movement2.split(",");
		array1 = maN(movement1array);
		array2 = maN(movement2array);
		int counter = size*10;
		int counter2 = 0;
		
		for (int i = 0; i<size; i++) {
			for (int d = 0; d<size; d++) {
				if (array1[i][d] == true && array2[i][d] == true) {
					counter2++;
					if (i == half && d == half) {
						continue;
					}
					if ((Math.abs(i-half) + Math.abs(d-half))<counter) {
						counter = (Math.abs(i-half) + Math.abs(d-half));
					}
				}
			}
		}
		System.out.println(counter+" "+counter2);
	}
	public static boolean[][] maN(String[] array){
		boolean[][] arrayUsing = new boolean[size][size];
		int x = half;
		int y = half;
		arrayUsing[5][5] = true;
		for (int i = 0; i<array.length; i++) {
			//System.out.println(array[i]);
			int tempNumber = 0;
			tempNumber = Integer.parseInt(array[i].substring(1));
			if (array[i].startsWith("U")){
				for (int d = 1; d<=tempNumber; d++) {
					y++;
					arrayUsing[y][x] = true;
					
				}
				
			}
			else if (array[i].startsWith("D")){
				for (int d = 1; d<=tempNumber; d++) {
					y--;
					arrayUsing[y][x] =true;
					
				}
				
			}
			else if (array[i].startsWith("R")){
				for (int d = 1; d<=tempNumber; d++) {
					x++;
					arrayUsing[y][x] = true;
					
				}
				
			}
			else {
				for (int d = 1; d<=tempNumber; d++) {
					x--;
					arrayUsing[y][x] = true;
					
				}
				
			}
		}

		return arrayUsing;
	}
}
