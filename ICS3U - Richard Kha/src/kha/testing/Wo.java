package kha.testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Wo {

	public static void main(String[] args) throws IOException {
		BufferedReader a = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(a.readLine());
		String length = a.readLine();
		String array = "";
		
		BigInteger hi = new BigInteger("0");
		for (int i = 0; i<size; i++) {
			char[] array2 = new char[array.length()+1];
				array2 = length.toCharArray();
			if (length.charAt(i) == '-') {
					array2[array2.length-1] = '\u0020';
					array = String.valueOf(array2).trim();
					BigInteger temp = new BigInteger(array);
					hi = hi.add(temp);
				}
				else {
					array2[array2.length-1] = length.charAt(i);
					array = String.valueOf(array2).trim();
					BigInteger temp = new BigInteger(array);
					hi = hi.add(temp);
				}
				
				
		}
		System.out.println(hi);
		
		
	}

}
