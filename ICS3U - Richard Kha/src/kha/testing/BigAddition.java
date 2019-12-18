package kha.testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BigAddition {

	public static void main(String[] args) throws IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(sc.readLine());	
		String[] ap = new String[a];
		String[] ad = new String[a];
		String tempString = "";
		for (int i =0; i<a; i++) {
			tempString = sc.readLine();
			String[] strs = tempString.trim().split("\\s+"); 
			ap[i]= strs[0];
			ad[i]= strs[1];

		}
		for (int d = 0; d<a; d++) {
			System.out.println(hub(ap[d].trim(),ad[d].trim()));
		}

	}
	static String hub(String variable1,String variable2) {
		boolean aNegative = false;
		boolean bNegative = false;
		boolean aBigger = false;
		boolean sameNumber = false;
		int aFirstNumber = 0;
		int bFirstNumber = 0;
		int aLength = 0;
		int bLength = 0;
		int aStarting = 0;
		int bStarting = 0;
		char [] a = new char[variable1.length()];
		char [] b = new char[variable2.length()];
		aLength = a.length;
		bLength = b.length;
		a = variable1.toCharArray();
		b = variable2.toCharArray();
		if(a[0] == '-') {
			aNegative = true;
			aLength -=1;
			aFirstNumber = Character.getNumericValue(a[1]);
			aStarting = 1;
			a[0] = '0';
		}
		else {
			aFirstNumber = Character.getNumericValue(a[0]);
		}
		if(b[0] == '-') { 
			bNegative = true;
			bLength -=1;
			bFirstNumber = Character.getNumericValue(b[1]);
			bStarting = 1;
			b[0] = '0';
		}
		else {
			bFirstNumber = Character.getNumericValue(b[0]);
		}
		if (aLength>bLength) {
			aBigger = true;
		}
		int subtractor = 0;
		if (aStarting == 1 || bStarting == 1) {
			subtractor = 1;
		}
		if (aLength == bLength&&aFirstNumber==bFirstNumber) {

			for (int i = 0; i<a.length-subtractor; i++) {
				if (Character.getNumericValue(a[i+aStarting]) > Character.getNumericValue(b[i+bStarting])) {
					aBigger = true;
					break;
				}
				else if (Character.getNumericValue(b[i+bStarting])>Character.getNumericValue(a[i+aStarting])){
					break;
				}
				if (i == a.length-1) {
					sameNumber = true;
				}
			}

		}
		else if(aLength == bLength&&aFirstNumber>bFirstNumber) {
			aBigger = true;
		}


		char [] aFlipped = new char[variable1.length()];
		char [] bFlipped = new char[variable2.length()];
		for(int i = 0; i<a.length; i++) {
			aFlipped[i] = a[a.length-1-i];
		}
		for(int i = 0; i<b.length; i++) {
			bFlipped[i] = b[b.length-1-i];
		}
		String answer = null;

		if (bNegative == false &&aNegative == true || aNegative == false && bNegative == true) {
			if (aBigger == true) {
				answer = additionNegative(aFlipped,bFlipped);
			}
			else {
				answer = additionNegative(bFlipped,aFlipped);
			}

		}
		else if(aNegative == false && bNegative == false || aNegative == true && bNegative == true) {
			if (aBigger == true) {
				answer = additionPositive(aFlipped,bFlipped);
			}
			else {
				answer = additionPositive(bFlipped,aFlipped);
			}
		}
		if ((aBigger == true && aNegative == true &&sameNumber == false|| aBigger == false && bNegative == true&&sameNumber == false)&&!answer.equalsIgnoreCase("0") ) {
			answer = "-"+answer;
		}
		return answer;	
	}
	static String additionPositive(char[] arrayLarger,char[] arraySmaller) {
		char[] c = new char[arrayLarger.length+1];
		for (int i = 0; i<c.length; i++) {
			c[i] = '0';
		}
		int tempNumber = 0;
		for (int i = 0; i<arraySmaller.length; i++) {
			tempNumber = Character.getNumericValue(c[i])+Character.getNumericValue(arrayLarger[i]) + Character.getNumericValue(arraySmaller[i]);
			if (tempNumber>9) {
				c[i+1] = '1';
				tempNumber = tempNumber%10;
			}
			c[i] = (char) (tempNumber+48);
		}
		for (int d = arraySmaller.length; d<arrayLarger.length; d++) {
			tempNumber =  Character.getNumericValue(c[d])+Character.getNumericValue(arrayLarger[d]); 
			if (tempNumber>9) {
				c[d+1] = '1';
				tempNumber = tempNumber%10;
			}
			c[d] = (char)(tempNumber+48);
		}

		
		return reversal(c);	
	}
	static String additionNegative(char[] arrayLarger,char[] arraySmaller) {
		char[] c = new char[arrayLarger.length+1];
		for (int i = 0; i<c.length; i++) {
			c[i] = '0';
		}
		int tempNumber = 0;
		for (int i = 0; i<Integer.min(arrayLarger.length, arraySmaller.length); i++) {
			tempNumber = Character.getNumericValue(arrayLarger[i]) - Character.getNumericValue(arraySmaller[i])-Character.getNumericValue(c[i]);
			if (tempNumber<0) {
				c[i+1] = '1';
				tempNumber = tempNumber+10;
			}
			c[i] = (char) (tempNumber+48);
		}
		for (int d = arraySmaller.length; d<arrayLarger.length; d++) {
			tempNumber =  Character.getNumericValue(arrayLarger[d])-Character.getNumericValue(c[d]); 
			if (tempNumber<0) {
				c[d+1] = '1';
				tempNumber = tempNumber+10;
			}
			c[d] = (char)(tempNumber+48);
		}

		return reversal(c);	

	}
	static String reversal(char[] array) {
		char[] d = new char[array.length]; 
		for(int i = 0; i<array.length; i++) {
			d[i] = array[array.length-1-i];
		}
		String e = String.valueOf(d);
		e = e.replaceFirst("^0+(?!$)", "");
		return String.valueOf(e);

	}

}
