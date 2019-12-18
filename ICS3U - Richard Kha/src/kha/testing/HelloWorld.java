package kha.testing;

import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int counter = 0;
		int highestCount = 0;
		String apples = sc.nextLine();
		char[] array = new char[apples.length()];
		int[] array2 = new int[apples.length()];
		int[] array3 = new int[apples.length()];
		array = apples.toCharArray();
		int b = 0;
		for ( b = 0; b<apples.length(); b++) {
		for (int a = 0; a<apples.length(); a++) {
			if (array[b]==array[a]) {
				array2[b]++;
				try {
				if (array[b] == array[b-1]) {
					array3[b]++;
				}
				}
				catch (Exception e){
					
				}
			}
			
		}
		if (array2[b]>highestCount) {
			highestCount = b;
		}
		}
		System.out.println(highestCount+ " "+ array3[b]);
	}
}


