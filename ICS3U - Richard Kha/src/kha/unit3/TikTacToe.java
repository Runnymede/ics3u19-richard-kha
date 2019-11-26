package kha.unit3;

import java.util.Scanner;

public class TikTacToe {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] tttBoard = new char[3][3];
		String player = "Player1";
		int counter = 0;
		char mark = ' ';
		for (int i = 0; i<9; i++) {
			if (i%2 == 1) {
				player = "Player2";
				mark = 'o';
			}
			else {
				player = "Player1";
				mark = 'x';
			}
			int columnMove = 0;
			int rowMove = 0;
			do {
				for (int c = 0; c<tttBoard.length; c++) {
					System.out.println("-------");
					for (int d = 0; d<tttBoard[c].length; d++) {
						System.out.print("|"+tttBoard[c][d]);
					}
					System.out.print('|');
					System.out.println();
					
				}
				System.out.println("-------");
				columnMove = sc.nextInt()-1;
				rowMove = sc.nextInt()-1;
			}while (tttBoard[columnMove][rowMove]!= '\u0000');

			tttBoard[rowMove][columnMove] = mark;

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
			if (tttBoard[0][0] == mark &&tttBoard[1][1] == mark &&tttBoard[2][2] == mark ) {
				counter = 3;
			}
			if (tttBoard[2][0] == mark &&tttBoard[1][1] == mark &&tttBoard[0][2] == mark ) {
				counter = 3;
			}
			if (counter == 3) {
				System.out.println(player + " wins!");
				System.exit(0);
			}
			
		}
	}

}
