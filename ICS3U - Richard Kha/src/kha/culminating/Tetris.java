
package kha.culminating;
import java.io.File;

import hsafx.Console;
import hsafx.ConsoleView;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;

public class Tetris extends ConsoleView {

	static byte [][] coordinates = new byte [2][4];
	static byte [][] board = new byte[24][10];
	final static byte [][][] tetrominos = {{{0,0,0,1},{5,4,6,5}},{{0,0,0,0},{5,4,6,3}},{{1,1,0,0},{5,4,5,6}},{{0,0,1,1},{5,4,5,6}},{{0,0,0,1},{5,4,6,6}},{{0,1,0,0},{5,4,4,6}},{{0,0,1,1},{4,5,5,4}}};
	static byte [][] nextPieceCoordinates = new byte[2][4];
	static byte [][] nextPieceBoard= new byte[2][4];
	static byte type = 0;
	static Image[] img = new Image[10];
	static Image[] font = new Image[10];
	static byte colour = 0;
	static boolean finishGame = false;
	static boolean[] fixedRandom = new boolean [35];
	
	@Override
	public void run() {
		Console c = new Console(500, 600, 36, "Tetris", this);
		c.autoRefreshOff();
		
		img[0] = new Image("2.png");
		img[1] = new Image("1.png");
		img[2] = new Image("3.png");
		img[3] = new Image("4.png");
		img[4] = new Image("5.png");    
		img[5] = new Image("6.png"); 
		img[6] = new Image("7.png");
		img[7] = new Image("start.png");
		img[8] = new Image("Design V1.png");
		img[9] = new Image("ending.png");
		font[0] = new Image("number0.png");
		font[1] = new Image("number1.png");
		font[2] = new Image("number2.png");
		font[3] = new Image("number3.png");
		font[4] = new Image("number4.png");
		font[5] = new Image("number5.png");
		font[6] = new Image("number6.png");
		font[7] = new Image("number7.png");
		font[8] = new Image("number8.png");
		font[9] = new Image("number9.png");
		MediaPlayer [] mediaPlayer = new MediaPlayer [5];
		mediaPlayer[0] = new MediaPlayer(new Media(new File("Background.mp3").toURI().toString()));
		mediaPlayer[1] = new MediaPlayer(new Media(new File("Recording.mp3").toURI().toString()));
		int highScore = 0;
		int count = 0;
		while (!c.isKeyDown("Space")) {
			if (count%20 <10 ) {
				c.clear();
				c.drawImage(img[7], 0, 0);
			}
			else{
				c.setFill(Color.WHITE);
				c.setFont(STYLESHEET_CASPIAN,30);
				c.fillText("Press the space bar to start", 80, 550);	
			}

			count++;
			c.refresh();
			c.sleep(50);

		}
		
		while (true) {
			board = new byte[24][10];
			byte currentType = 0;
			byte speed = 0;
			byte [][] holdPieceCoordinates = new byte[2][4];
			byte [][] holdPieceBoard = new byte[2][4];
			int  xShift = 150;
			byte holdColour = 0;
			int  yShift = 66;
			byte [] delay = new byte[3];
			byte constantSpeedChange = 32;
			byte normal = constantSpeedChange;
			boolean swappedAlready = false;
			boolean swap = false;
			byte tempType = 0;
			byte [][] tempArray = new byte[2][4];
			byte [][] coordinates3 = new byte [2][4];
			int score = 0;
			int totalLinesCleared = 0;
			int linesClearedCounter = 0;
			double speedMultiplier = 1.0;
			boolean firstBlock = true;
			boolean refres = true;
			randomTetromino();
			currentType = usingTetromino();
			randomTetromino();
			finishGame = false;
			while (finishGame == false) {
				mediaPlayer[0].play();
				if (refres == true) {
					refres = false;
					c.clear();
					c.drawImage(img[8], 0, 0);
					for (byte i = 2; i<board.length; i++) {
						for (byte i2 = 0; i2<board[1].length; i2++ ) {
							c.drawImage(img[blockForDraw(i,i2)-1], i2*20+xShift, i*20+yShift);
						}
					}
					for (byte i = 0; i<nextPieceBoard.length; i++) {
						for (byte i2 = 0; i2<nextPieceBoard[1].length; i2++ ) {
							if (nextPieceBoard[i][i2] == 0) {	
							}
							else {
								c.drawImage(img[6], i2*20+387, i*20+153);
							}

						}
					}
					for (byte i = 0; i<holdPieceBoard.length; i++) {
						for (byte i3 = 0; i3<holdPieceBoard[1].length; i3++ ) {
							if (holdPieceBoard[i][i3] == 0) {	
							}
							else {
								c.drawImage(img[holdColour-1], i3*20+32, i*20+153);
							}

						}
					}

					c.setFill(Color.BLACK);
					//c.setFill(Color.WHITE);
					c.setFont(STYLESHEET_MODENA,18);
					//c.fillText(String.valueOf(score), 240, 20);

					for (int i = String.valueOf(totalLinesCleared).length()-1; i>=0; i--) {
						c.drawImage(font[Character.getNumericValue(String.valueOf(totalLinesCleared).charAt(i))], 290-(String.valueOf(totalLinesCleared).length()-1-i)*11+(String.valueOf(totalLinesCleared).length())*11, 70);
					}
					for (int i = String.valueOf(score).length()-1; i>=0; i--) {
						c.drawImage(font[Character.getNumericValue(String.valueOf(score).charAt(i))], 20-(String.valueOf(score).length()-1-i)*11+(String.valueOf(score).length())*11, 300);
					}
					c.refresh();
				}





				if (c.isKeyDown("Right") && delay[2]>2) {

					boolean move = true;
					refres = true;

					label4:
						for (byte i = 0; i<4; i++) {
							if (coordinates[1][i]+1 == board[1].length) {
								move = false;
								break label4;
							}
							if (board[coordinates[0][i]][coordinates[1][i]+1] != 1 &&board[coordinates[0][i]][coordinates[1][i]+1] != 0) {
								move = false;
								break label4;
							}
						}
					if (move == true) {
						delay[2] = 0;

						movement(1,1);
					}
				}
				if (c.isKeyDown("Left") && delay[2]>2 ) {

					refres = true;
					boolean move = true;

					label3:
						for (byte i = 0; i<4; i++) {
							if (coordinates[1][i]-1 == -1) {
								move = false;
								break label3;
							}
							if (board[coordinates[0][i]][coordinates[1][i]-1] !=1 && board[coordinates[0][i]][coordinates[1][i]-1] !=0) {
								move = false;
								break label3;
							}
						}
					if (move == true ) {
						delay[2] = 0;

						movement(1,-1);
					}
				}
				if (c.isKeyDown("Down")) {
					constantSpeedChange = 2;
				}
				else {
					constantSpeedChange = normal;
				}

				if (c.isKeyDown("X")  && currentType!=6 && delay[1]>6) {
					delay[1] = 0;

					refres= true;
					rotation(-1);

				}
				if (c.isKeyDown("C")  && currentType!=6 && delay[1]>6) {
					delay[1] = 0;

					refres= true;
					rotation(1);

				}
				if (c.isKeyDown("Z")) {
					for (byte i = 0; i<4; i++){
						board[coordinates[0][i]][coordinates[1][i]] = 0;
					}
					if (swap == false) {
						swap = true;
						tempType = currentType;
						for (byte i = 0; i<4; i++){
							holdPieceCoordinates[0][i] = (byte) (tetrominos[currentType][0][i]+2);;
							holdPieceCoordinates[1][i] = tetrominos[currentType][1][i];
						}
						holdColour = colour;
						currentType = usingTetromino();
						randomTetromino();
						refres = true;
						swappedAlready = true;
					}
					else if (swappedAlready == false) {
						refres = true;
						for (byte i = 0; i<holdPieceBoard.length; i++) {
							for (byte i2 = 0; i2<holdPieceBoard[0].length; i2++) {
								holdPieceBoard[i][i2] = 0;
							}
						}
						swappedAlready = true;
						for (byte i = 0; i<4; i++){
							tempArray[0][i] = holdPieceCoordinates[0][i];
							tempArray[1][i] = holdPieceCoordinates[1][i];
						}
						for (byte i = 0; i<4; i++){
							holdPieceCoordinates[0][i] = (byte) (tetrominos[currentType][0][i]+2);;
							holdPieceCoordinates[1][i] = tetrominos[currentType][1][i];
							coordinates[0][i] = tempArray[0][i];
							coordinates[1][i] = tempArray[1][i];
						}
						byte tempColour = holdColour;
						byte temptype2 = currentType;
						holdColour = colour;
						colour = tempColour;
						currentType = tempType;
						tempType = temptype2;
						movement(0,0);

					}
					for (byte i = 0; i<4; i++) {
						holdPieceBoard[holdPieceCoordinates [0][i]-2][holdPieceCoordinates [1][i]-3] = 1;
					}
				}


				if (c.isKeyDown("Space") && delay[0]>6  ) {
					delay[0] = 0;
					refres = true;

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

					movement(0,counter);
					speed = constantSpeedChange;
				}
				if (speed%constantSpeedChange == 0) {

					if (place(coordinates) == true) {
						swappedAlready = false;
						for (byte i = 0; i<4; i++) {
							board[coordinates[0][i]][coordinates[1][i]] = colour;
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
									board[i][0] = -1;
								}


							}

						}
						boolean runthis = false;
						
						for (byte i2 = 0; i2<board[1].length; i2++) {
							runthis = false;
							for (byte i3 = 0; i3<board.length; i3++) {

								if (board[i3][0] !=-1){

								}
								if (board[i3][0] == -1 ){
									board[i3][i2] = -1;
									runthis = true;
								}

							}
							if (runthis == true) {	
								mediaPlayer[1].play();				
								for (byte i4 = 2; i4<board.length; i4++) {
									for (byte i5 = 0; i5<board[1].length; i5++ ) {
										c.drawImage(img[blockForDraw(i4,i5)-1], i5*20+xShift, i4*20+yShift);
									}

								}
								c.refresh();
								c.sleep(40);
							}
							
						}
						int push = 0;
						linesClearedCounter = 0;
						for (byte i2 = (byte) (board.length-1); i2>=0; i2--) {
							if (board[i2][0] == -1) {
								push++;
								linesClearedCounter++;
							}
							else {
								for (byte i3 = 0; i3<board[1].length; i3++) {
									board[i2+push][i3] = board[i2][i3];

								}
							}
						}
						mediaPlayer[1].stop();
						totalLinesCleared += linesClearedCounter;
						score += (100)*Math.pow(linesClearedCounter,2)*speedMultiplier;
						if (totalLinesCleared %10 == 0 && linesClearedCounter!=0) {
							constantSpeedChange= (byte) Math.round(constantSpeedChange/1.9);
							normal = constantSpeedChange;
							speedMultiplier = speedMultiplier * 1.8;
						}
						
						currentType = usingTetromino();
						randomTetromino();
					}
					else {
						movement(0,1);
					}
					refres = true;

				}
				if (firstBlock == true) {
					movement(0,-1);
					firstBlock = false;
				}

				speed++;

				for (byte i = 0; i<delay.length;i++) {
					if (delay[i]<8) {
						delay[i]++;
					}
				}
				c.sleep(32);
			}
			count = 0;
			for (byte i = 0; i<30; i++) {
				c.setFill(Color.BLUE);
				c.fillRect(0, i*20, 500, 10);
				c.sleep(20);
				c.refresh();
				c.setFill(Color.CYAN);
				c.fillRect(0, i*20+10, 500, 10);
				c.sleep(20);
				c.refresh();
			}
			c.sleep(1000);
			if (score>highScore) {
				highScore = score;
			}
			while (true) {
				if (count%10 <5 ) {
					c.clear();
					c.drawImage(img[9], 0, 0);
					c.setFill(Color.WHITE);
					c.setFont(STYLESHEET_CASPIAN,30);
					for (int i = String.valueOf(score).length()-1; i>=0; i--) {
						c.drawImage(font[Character.getNumericValue(String.valueOf(score).charAt(i))], 224-(String.valueOf(score).length()-1-i)*11+(String.valueOf(score).length())*11, 104);
					}
					for (int i = String.valueOf(highScore).length()-1; i>=0; i--) {
						c.drawImage(font[Character.getNumericValue(String.valueOf(highScore).charAt(i))], 224-(String.valueOf(highScore).length()-1-i)*11+(String.valueOf(highScore).length())*11, 51);
					}
					
				}
				else{
					c.fillText("Press the space bar to play again", 42, 500);
					c.fillText("Press the escape key to exit", 42, 550);
				}
				count++;
				
				if (c.isKeyDown("Space")) {
					break;
				}
				else if (c.isKeyDown("Esc")) {
					System.exit(0);
				}
				
				c.refresh();
				c.sleep(100);
			}

		}
		
	}

	public static void main(String[] args) {

		launch(args);
	}
	public static void rotation (int num) {
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
			if (tempY>=board.length || tempY<0 || tempX>=board[0].length || tempX<0) {
				change = false;
			}
			if (change != false && board[tempY][tempX] > 1) {
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
		nextPieceBoard = new byte [2][4];

		byte counter = 0;
		for (byte i = 0; i<fixedRandom.length; i++) {
			if (fixedRandom[i] == false){
				counter++;
			}
		}
		if (counter>20) {
			for (byte i = 0; i<fixedRandom.length; i++) {
				fixedRandom[i] = false;
			}
		}
		do {
			type = (byte)(Math.random()*fixedRandom.length);
		}while (fixedRandom[type] == true);
		fixedRandom[type] = true;

		while (type>=7) {
			type = (byte) (type-7);
		}
		colour = (byte)(Math.random()*4+2);
		for (byte i = 0; i<4; i++) {
			nextPieceCoordinates [0][i] = (byte) (tetrominos[type][0][i]+2);
			nextPieceCoordinates [1][i] = tetrominos[type][1][i];

		}
		for (byte i = 0; i<4; i++) {
			nextPieceBoard[nextPieceCoordinates [0][i]-2][nextPieceCoordinates [1][i]-3] = 1;
		}
	}
	public static byte usingTetromino() {
		for (byte i = 0; i<4; i++) {
			coordinates[0][i] = nextPieceCoordinates [0][i];
			coordinates[1][i] = nextPieceCoordinates [1][i];
		}	
		boolean finish = false;
		for (byte i = 0; i<4; i++) {
			if (board[coordinates[0][i]][coordinates[1][i]] != 0) {
				finish = true;
			}
			board[coordinates[0][i]][coordinates[1][i]] = 1;
		}
		if (finish == true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			finishGame = true;
		}
		
		return type;
	}
	public static void movement(int axis, int amount) {

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
			else if (board[array[0][i]+1][array[1][i]] >1) {
				place = true;
			}

		}
		return place;
	}
	public static byte blockForDraw(byte i, byte i2) {
		byte block  = 0;

		if (board[i][i2] != 0 && board[i][i2] != 1 && board[i][i2] != 0 && board[i][i2] !=-1 ) {
			block = board[i][i2];
		}
		else if (board[i][i2] == 1) {
			block  = colour;
		}
		else if (board[i][i2] == -1) {
			block  = 6;
		}
		else {
			block  = 1;
		}
		return block ;
	}

}


