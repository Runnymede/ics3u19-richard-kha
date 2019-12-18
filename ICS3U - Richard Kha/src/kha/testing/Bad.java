package kha.testing;

import java.util.Scanner;

public class Bad {

	public static void main(String[] args) {
	Scanner sc  = new Scanner(System.in);
	int counter = 0;
	int counter2 = 0;
	while (1==1) {
		int a = sc.nextInt();
		a = a/3; 
		counter2++;
		counter = counter + a;
		
		System.out.println(counter);
		System.out.println(counter2);
		}

	}

}
