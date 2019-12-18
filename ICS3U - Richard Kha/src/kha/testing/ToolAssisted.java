package kha.testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ToolAssisted {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc =  new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(sc.readLine());
		Stack<Integer> stack2 = new Stack<Integer>();
		int counter = 0;
		for (int d = 0; d<a; d++) {
			int input = Integer.parseInt(sc.readLine());
			if (input == 0) {
				stack2.pop();
			}
			else {
				stack2.push(input);
			}
		}

		for (int i = 0; i<stack2.size(); i++) {
			counter = counter + stack2.pop();
			i--;
		}
		
		System.out.println(counter);
	}

}
