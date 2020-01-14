package kha.testing;

public class Testsad {
	static int [][] coordinates = new int [2][4];
	static int [][] board = new int[20][10];
	final static int [][][] tetrominos = {{{0,0,0,1},{5,4,6,5}},{{0,0,0,0},{5,4,6,3}},{{1,1,0,0},{5,4,5,6}},{{0,0,1,1},{5,4,5,6}},{{0,0,0,1},{5,4,6,6}},{{1,0,0,0},{4,4,5,6}},{{0,0,1,1},{4,5,5,4}}};
	public static void main(String[] args) {
		
		int count = (int)(Math.random()*7);
		coordinates [0] = tetrominos[count][0];
		coordinates [1] = tetrominos[count][1];
		for (int i = 0; i<4; i++) {
			board[coordinates[0][i]][coordinates[1][i]] = 1;
		}
		//  c.println("+SHIFT");
		for (int i = 0; i<board.length-13; i++) {
			for (int i2 = 0; i2<board[1].length; i2++ ) {
				System.out.print(board[i][i2]);
			}
			System.out.println();
		}
	}

}
