package kha.testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc =  new BufferedReader(new InputStreamReader(System.in));
		int counter = 0;
		while (1==1)
		{
			int a = Integer.parseInt(sc.readLine());
			counter = counter + a;
			System.out.println(counter);
		}
	}

}
