package kha.testing;

import java.util.Scanner;

public class TwoSeconds {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] tttBoard = new char[3][3];
		for (int i = 0; i<3; i++) {
			String a = sc.next();
			tttBoard[i][0] = a.charAt(0);
			tttBoard[i][1] = a.charAt(1);
			tttBoard[i][2] = a.charAt(2);
		}
		boolean gWin = false;
		boolean tWin = false;
		for (int i = 0; i<2; i++) {
		int counter = 0;
		char mark = 'X';
		if (i == 1) {
			mark = 'O';
		}
		for (int c = 0; c<3; c++) {
			counter = 0;
			for (int t = 0; t<3; t++) {
				if(tttBoard[t][c] == mark) {
					counter++;
				}
			}
			if (counter == 3) {
				break;
			}
		}
		if (counter == 3) {
		}
		else {

			for (int c = 0; c<3; c++) {
				counter = 0;
				for (int t = 0; t<3; t++) {
					if(tttBoard[c][t] == mark) {
						counter++;
					}
				}
				if (counter == 3) {
					break;
				}
			}
		}
		if (tttBoard[0][0] == mark &&tttBoard[1][1] == mark &&tttBoard[2][2] == mark ) {
			counter = 3;
		}
		if (tttBoard[2][0] == mark &&tttBoard[1][1] == mark &&tttBoard[0][2] == mark ) {
			counter = 3;
		}
		if (counter == 3) {
			if (mark == 'X') {
				tWin = true;
			}
			else {
				gWin = true;
			}
			
		}
		

	}
		if (tWin == true && gWin==true) {
			System.out.println("Error, redo");
			
		}
		else if(tWin == true) {
			System.out.println("Timothy");
		}
		else if (gWin == true) {
			System.out.println("Griffy");
		}
		else {
			System.out.println("Tie");
		}
	}

}
