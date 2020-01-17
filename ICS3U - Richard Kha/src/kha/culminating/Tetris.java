package kha.culminating;
import hsafx.Console;
import hsafx.ConsoleView;
import javafx.scene.image.Image;

public class Tetris extends ConsoleView {

	static byte [][] coordinates = new byte [2][4];
	static byte [][] board = new byte[22][10];

	final static byte [][][] tetrominos = {{{0,0,0,1},{5,4,6,5}},{{0,0,0,0},{5,4,6,3}},{{1,1,0,0},{5,4,5,6}},{{0,0,1,1},{5,4,5,6}},{{0,0,0,1},{5,4,6,6}},{{0,1,0,0},{5,4,4,6}},{{0,0,1,1},{4,5,5,4}}};
	static byte speed = 0;
	static byte count = 0;
	static byte tempNum = 0;
	static byte tempNum2 = 0;
	static byte constantSpeedChange = 8;
	static byte normal = constantSpeedChange;
	static byte [] delay = new byte[3];
	static Image[] img = new Image[5];
	static byte colour = 0;
	@Override
	public void run() {
		Console c = new Console(600, 800, 12, "Console Template", this);
	
		// ================= Your Code Starts Here
		c.autoRefreshOff();
		img[0] = new Image("2.png");
		img[1] = new Image("1.png");
		img[2] = new Image("3.png");
		img[3] = new Image("4.png");
		img[4] = new Image("5.png");    
		
		while (true) {
			
			boolean refres = false;
			
			if (c.isKeyDown("Right")  ) {
			
				boolean move = true;
				refres = true;
				
				label4:
					for (byte i = 0; i<4; i++) {
						if (coordinates[1][i]+1 == board[1].length) {
							move = false;
							break label4;
						}
						if (board[coordinates[0][i]][coordinates[1][i]+1] == 2) {
							move = false;
							break label4;
						}
					}
				if (move == true) {
					delay[2] = 0;
					tempNum = 1;
					movement(tempNum,tempNum);
				}
			}
			if (c.isKeyDown("Left")  ) {
			
				refres = true;
				boolean move = true;

				label3:
					for (byte i = 0; i<4; i++) {
						if (coordinates[1][i]-1 == -1) {
							move = false;
							break label3;
						}
						if (board[coordinates[0][i]][coordinates[1][i]-1] == 2) {
							move = false;
							break label3;
						}
					}
				if (move == true ) {
					delay[2] = 0;
					tempNum = 1;
					tempNum2 = -1;
					movement(tempNum,tempNum2);
				}
			}
			if (c.isKeyDown("Down")) {
				constantSpeedChange = 1;
			}
			else {
				constantSpeedChange = normal;
			}
			
			if (c.isKeyDown("X")  && count!=6&& delay[1]>4) {
				delay[1] = 0;
				tempNum =-1;
				refres= true;
				rotation(tempNum);
				
			}
			if (c.isKeyDown("C")  && count!=6 && delay[1]>4) {
				delay[1] = 0;
				tempNum =1;
				refres= true;
				rotation(tempNum);
				
			}
		
			if (c.isKeyDown("Space") && delay[0]>4  ) {
				delay[0] = 0;
				refres = true;
				byte [][] coordinates3 = new byte [2][4];
				byte counter = 0;
				for (byte i = 0; i<4; i++) {
					coordinates3[0][i] = coordinates [0][i];
					coordinates3[1][i] = coordinates [1][i];
				}
				while (place(coordinates3) == false) {
					counter++;
					for (byte i = 0; i<4; i++) {
						coordinates3[0][i]++;
					}
				}
				tempNum = 0;
				movement(tempNum,counter);
				speed = constantSpeedChange;
			}
			if (speed%constantSpeedChange == 0) {
				
			if (place(coordinates) == true) {
				for (byte i = 0; i<4; i++) {
					board[coordinates[0][i]][coordinates[1][i]] = 2;
				}
				
				for (byte i = 0; i<board.length; i++) {
					byte counter = 0;
					for (byte i2 = 0; i2<board[1].length; i2++) {
						if (board[i][i2] != 0) {
							counter++;
						}
					}
					if (counter == board[1].length) {
						for (byte i2 = 0; i2<board[1].length; i2++) {
							board[i][i2] = 0;
						}
						for (byte i2 = i; i2>0; i2--) {
							for (byte i3 = 0; i3<board[1].length; i3++) {
								board[i2][i3] = board[i2-1][i3];
							}
						}
					}
				}
				randomTetromino();
				

			}
			else {
				tempNum = 0;
				tempNum2 = 1;
					movement(tempNum,tempNum2);
			}
			refres = true;
			
			}
			if (refres == true) {
			
				c.clear();
				byte index = 0;
				for (byte i = 2; i<board.length; i++) {
					for (byte i2 = 0; i2<board[1].length; i2++ ) {
						
						if (board[i][i2] != 0 ) {
							index = 1;
						}
						else {
							index = 0;
						}
							c.drawImage(img[index], i2*20+40, i*20+40);
					}
					
				}
				
			}
			
			c.refresh();
			speed++;
			
			for (byte i = 0; i<delay.length;i++) {
				if (delay[i]<8) {
				delay[i]++;
				}
			}
			c.sleep(60);
		}

		// ================= Your Code Ends Here
	}

	public static void main(String[] args) {
		randomTetromino();
		launch(args);
	}
	public static void rotation (byte num) {
		boolean change = true;
		byte [][] coordinates2 = new byte [2][4];
		for (byte i = 1; i<4; i++) {
			byte tempX = 0;
			byte tempY = 0;

			if (coordinates [0][i]>coordinates[0][0]) {
				tempX = (byte) (-num*Math.abs(coordinates[0][i]-coordinates [0][0]));
			}
			else {
				tempX = (byte) (num*Math.abs(coordinates[0][i]-coordinates [0][0]));
			}
			if (coordinates [1][i]>coordinates[1][0]) {
				tempY =  (byte) (num*Math.abs(coordinates[1][i]-coordinates [1][0]));
			}
			else {
				tempY = (byte) (-num*Math.abs(coordinates[1][i]-coordinates [1][0]));
			}
			tempY += coordinates[0][0];
			tempX += coordinates[1][0];
			coordinates2[1][i] = tempX;
			coordinates2[0][i] = tempY;	
			if (tempY>=20 || tempY<0 || tempX>=10 || tempX<0) {
				change = false;
			}
			if (change != false && board[tempY][tempX] == 2) {
				change = false;
			}
			
		}
		if (change == true) {
			
			for (byte i = 0; i<4; i++) {
				board[coordinates[0][i]][coordinates[1][i]] = 0;
				
			}
			for (byte i = 1; i<4; i++){
				coordinates[0][i] = coordinates2[0][i];
				coordinates[1][i] = coordinates2[1][i];
			}
			for (byte i = 0; i<4; i++) {
				board[coordinates[0][i]][coordinates[1][i]] = 1;
			}
		}
	}
	public static void randomTetromino() {
		count = (byte)(Math.random()*7);
		colour = (byte)(Math.random()*4+1);
		for (byte i = 0; i<4; i++) {
			coordinates [0][i] = (byte) (tetrominos[count][0][i]+2);
			coordinates [1][i] = tetrominos[count][1][i];
		}
		for (byte i = 0; i<4; i++) {
			if (board[coordinates[0][i]][coordinates[1][i]] != 0) {
				endGame();
			}
			board[coordinates[0][i]][coordinates[1][i]] = 1;
		}
	}
	public static void movement(byte axis, byte amount) {
		for (byte i = 0; i<4; i++) {
			board[coordinates[0][i]][coordinates[1][i]] = 0;
		}
		for (byte i = 0; i<4; i++) {
			coordinates[axis][i]+=amount;
		}
		for (byte i = 0; i<4; i++) {
			board[coordinates[0][i]][coordinates[1][i]] = 1;
		}
	}
	public static boolean place(byte[][] array) {
		boolean place = false;
		for (byte i = 0; i<4; i++) {
			if (array[0][i]+1 == board.length) {
				place = true;
			}
			else if (board[array[0][i]+1][array[1][i]] == 2) {
				place = true;
			}

		}
		return place;
	}
	public static void endGame() {
		System.exit(0);
	}
}


