package kha.culminating;

import hsafx.Console;
import hsafx.ConsoleView;

public class Tetris extends ConsoleView {


	static int [][] coordinates = new int [2][4];
	static int [][] board = new int[20][10];

	final static int [][][] tetrominos = {{{0,0,0,1},{5,4,6,5}},{{0,0,0,0},{5,4,6,3}},{{1,1,0,0},{5,4,5,6}},{{0,0,1,1},{5,4,5,6}},{{0,0,0,1},{5,4,6,6}},{{1,0,0,0},{4,4,5,6}},{{0,0,1,1},{4,5,5,4}}};
	static int speed = 0;
	@Override
	public void run() {
		Console c = new Console(600, 300, 12, "Console Template", this);

		// ================= Your Code Starts Here
		c.autoRefreshOff();

		while (true) {
			//int speed = 0;
			c.clear();

			for (int i = 0; i<board.length; i++) {
				for (int i2 = 0; i2<board[1].length; i2++ ) {
					c.print(board[i][i2]+ " ");
				}
				c.println();
			}

			if (c.isKeyDown("Right")) {
				boolean move = true;
				for (int i = 0; i<4; i++) {
					if (coordinates[1][i]+1 == board[1].length) {
						move = false;
					}
				}
				if (move == true) {
					for (int i = 0; i<4; i++) {
						board[coordinates[0][i]][coordinates[1][i]] = 0;
					}
					for (int i = 0; i<4; i++) {
						coordinates[1][i]++;
					}
					for (int i = 0; i<4; i++) {
						board[coordinates[0][i]][coordinates[1][i]] = 1;
					}
				}
			}
			if (c.isKeyDown("Left")) {
				boolean move = true;
				for (int i = 0; i<4; i++) {
					if (coordinates[1][i]-1 == -1) {
						move = false;
					}
				}
				if (move == true) {
					for (int i = 0; i<4; i++) {
						board[coordinates[0][i]][coordinates[1][i]] = 0;
					}
					for (int i = 0; i<4; i++) {
						coordinates[1][i]--;
					}
					for (int i = 0; i<4; i++) {
						board[coordinates[0][i]][coordinates[1][i]] = 1;
					}
				}
			}
			if (c.isKeyDown("X")) {
				for (int i = 0; i<4; i++) {
					board[coordinates[0][i]][coordinates[1][i]] = 0;
				}
				
				for (int i = 1; i<4; i++) {
					int tempX = 0;
					int tempY = 0;

					if (coordinates [0][i]>coordinates[0][0]) {
						tempY = coordinates[0][i]-coordinates [0][0];
					}
					else {
						tempY = -(coordinates[0][0]-coordinates [0][i]);
					}
					if (coordinates [1][i]>coordinates[1][0]) {
						tempX = coordinates[1][i]-coordinates [1][0];
					}
					else {
						tempX = -(coordinates[1][0]-coordinates [1][i]);
					}
					tempY += coordinates[1][0];
					tempX += coordinates[0][0];
					coordinates[0][i] = tempX;
					coordinates[1][i] = tempY;	
				}
				for (int i = 0; i<4; i++) {
					board[coordinates[0][i]][coordinates[1][i]] = 1;
				}
				for (int i = 0; i<board.length; i++) {
					for (int i2 = 0; i2<board[1].length; i2++ ) {
						c.print(board[i][i2]+ " ");
					}
					c.println();
				}
			}
			
			
			
			boolean place = false;
			for (int i = 0; i<4; i++) {
				if (coordinates[0][i]+1 == 20) {
					place = true;
				}
				else if (board[coordinates[0][i]+1][coordinates[1][i]] == 2) {
					place = true;
				}
				
			}
			if (speed%10 == 0 && place == true) {
				for (int i = 0; i<4; i++) {
					board[coordinates[0][i]][coordinates[1][i]] = 2;
				}
				int count = (int)(Math.random()*7);
				coordinates [0] = tetrominos[count][0];
				coordinates [1] = tetrominos[count][1];
				for (int i = 0; i<4; i++) {
					board[coordinates[0][i]][coordinates[1][i]] = 1;
				}
			}
			if (speed%10 == 0) {
				for (int i = 0; i<4; i++) {
					board[coordinates[0][i]][coordinates[1][i]] = 0;
				}
				for (int i = 0; i<4; i++) {
					coordinates[0][i]++;
				}
				for (int i = 0; i<4; i++) {
					board[coordinates[0][i]][coordinates[1][i]] = 1;
				}
			}

			c.refresh();
			speed++;
			c.sleep(100);
			

			//			if (c.isKeyDown('f')) {
			//				board = new int[20][10];
			//			}
		}

		// ================= Your Code Ends Here
	}

	public static void main(String[] args) {
		int count = (int)(Math.random()*7);
		coordinates [0] = tetrominos[count][0];
		coordinates [1] = tetrominos[count][1];
		for (int i = 0; i<4; i++) {
			board[coordinates[0][i]][coordinates[1][i]] = 1;
		}
		//  c.println("+SHIFT");

		launch(args);
	}
}
