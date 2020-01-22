package kha.culminating;
import java.io.File;
import hsafx.Console;
import hsafx.ConsoleView;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
/**
 * <br>Tetris.java
 * <br>This program allows the user to play a game of Tetris.
 * <br>This game is played with the arrow keys, the space bar, and the z, x, c keys.
 * <br>January 21, 2020
 *@author Richard Kha
 */

public class Tetris extends ConsoleView {
	/**
	 * This is the entry point to the program
	 * 
	 */

	//Declaring static variables and objects for use in all methods and in main program
	static byte [][] coordinates = new byte [2][4];
	static byte [][] board;
	static byte [][] nextPieceCoordinates = new byte[2][4];
	static byte [][] nextPieceBoard= new byte[2][4];
	static byte type = 0;
	static byte colour = 0;
	static boolean finishGame;
	static boolean[] fixedRandom = new boolean [28];

	//This 3 dimensional array contains all the coordinates for the 7 tetrominos
	static byte [][][] tetrominos = {{{0,0,0,1},{5,4,6,5}},{{0,0,0,0},{5,4,6,3}},{{1,1,0,0},{5,4,5,6}},{{0,0,1,1},{5,4,5,6}},{{0,0,0,1},{5,4,6,6}},{{0,1,0,0},{5,4,4,6}},{{0,0,1,1},{4,5,5,4}}};


	@Override
	public void run() {

		//Declaring and assigning objects and variables
		Console c = new Console(500, 600, 36, "Tetris", this);
		c.autoRefreshOff();
		Image[] img = new Image[10];
		Image[] font = new Image[10];
		MediaPlayer [] mediaPlayer = new MediaPlayer [10];
		int highScore = 0;
		int time = 0;

		//Placing images into array "img"
		img[0] = new Image("/kha/culminating/Grid.png");
		img[1] = new Image("/kha/culminating/BlueSquare.png");
		img[2] = new Image("/kha/culminating/YellowSquare.png");
		img[3] = new Image("/kha/culminating/RedSquare.png");
		img[4] = new Image("/kha/culminating/GreenSquare.png");    
		img[5] = new Image("/kha/culminating/LineClearSquare.png"); 
		img[6] = new Image("/kha/culminating/GreySquare.png");
		img[7] = new Image("/kha/culminating/StartSquare.png");
		img[8] = new Image("/kha/culminating/MainScreen.png");
		img[9] = new Image("/kha/culminating/EndScreen.png");

		//These images being placed into "font" are numbers, since the font courier is not available in console
		font[0] = new Image("/kha/culminating/Number0.png");
		font[1] = new Image("/kha/culminating/Number1.png");
		font[2] = new Image("/kha/culminating/Number2.png");
		font[3] = new Image("/kha/culminating/Number3.png");
		font[4] = new Image("/kha/culminating/Number4.png");
		font[5] = new Image("/kha/culminating/Number5.png");
		font[6] = new Image("/kha/culminating/Number6.png");
		font[7] = new Image("/kha/culminating/Number7.png");
		font[8] = new Image("/kha/culminating/Number8.png");
		font[9] = new Image("/kha/culminating/Number9.png");

		//Placing mp3s into array "mediaPlayer"
		mediaPlayer[0] = new MediaPlayer(new Media(new File("src/kha/culminating/BackgroundMusic.mp3").toURI().toString()));
		mediaPlayer[1] = new MediaPlayer(new Media(new File("src/kha/culminating/LineClear.mp3").toURI().toString()));
		mediaPlayer[2] = new MediaPlayer(new Media(new File("src/kha/culminating/Spin.mp3").toURI().toString()));
		mediaPlayer[3] = new MediaPlayer(new Media(new File("src/kha/culminating/Lose.mp3").toURI().toString()));
		mediaPlayer[4] = new MediaPlayer(new Media(new File("src/kha/culminating/Swap.mp3").toURI().toString()));
		mediaPlayer[5] = new MediaPlayer(new Media(new File("src/kha/culminating/HardDrop.mp3").toURI().toString()));
		mediaPlayer[6] = new MediaPlayer(new Media(new File("src/kha/culminating/Ending.mp3").toURI().toString()));
		mediaPlayer[7] = new MediaPlayer(new Media(new File("src/kha/culminating/Introduction.mp3").toURI().toString()));
		mediaPlayer[8] = new MediaPlayer(new Media(new File("src/kha/culminating/BackgroundMusicSpeed.mp3").toURI().toString()));
		mediaPlayer[9]= new MediaPlayer(new Media(new File("src/kha/culminating/Place.mp3").toURI().toString()));

		//Setting the volume of each mp3
		mediaPlayer[0].setVolume(0.4);
		mediaPlayer[1].setVolume(0.5);
		mediaPlayer[2].setVolume(0.3);
		mediaPlayer[3].setVolume(0.5);
		mediaPlayer[4].setVolume(0.5);
		mediaPlayer[5].setVolume(0.3);
		mediaPlayer[6].setVolume(0.8);
		mediaPlayer[7].setVolume(0.4);
		mediaPlayer[8].setVolume(0.4);
		mediaPlayer[9].setVolume(0.7);

		//Making curtain mp3s repeat when called upon to play
		mediaPlayer[0].setCycleCount(Integer.MAX_VALUE);
		mediaPlayer[8].setCycleCount(Integer.MAX_VALUE);
		mediaPlayer[2].setCycleCount(Integer.MAX_VALUE);
		mediaPlayer[7].setCycleCount(Integer.MAX_VALUE);
		mediaPlayer[6].setCycleCount(Integer.MAX_VALUE);

		//Plays the introduction audio
		mediaPlayer[7].setAutoPlay(true);

		//This while loop displays the title screen with a flashing message at the bottom
		while (!c.isKeyDown("Space")) {

			//Time is a counter which goes from 1 - 20, then resets
			if (time>20) {
				time-=20;
			}

			//This allows for a blinking message
			if (time <10 ) {

				//Drawing background image
				c.clear();
				c.drawImage(img[7], 0, 0);
			}
			else{

				//Drawing text at bottom
				c.setFill(Color.WHITE);
				c.setFont(STYLESHEET_CASPIAN,30);
				c.fillText("Press the space bar to start", 80, 550);	
			}

			time++;

			//Refresh screen and delay
			c.refresh();
			c.sleep(50);

		}

		//Ends the introduction audio
		mediaPlayer[7].stop();


		//This while loop allows for the game to be played multiple times in one session
		while (true) {

			/*
			MediaPlayer[6] is the ending theme, this line of code stops playing
			the ending theme when the user inputs that they want to play again
			 */
			mediaPlayer[6].stop();

			//Transition animation from start screen into game
			for (byte i = 29; i>=0; i--) {	
				c.setFill(Color.AQUA);
				c.fillRect(0, i*20+10, 500, 10);
				c.sleep(20);	
				c.refresh();		
				c.setFill(Color.WHITE);
				c.fillRect(0, i*20, 500, 10);
				c.sleep(20);
				c.refresh();
			}
			c.sleep(500);

			/*
			Declaring objects and assigning them, as well as emptying
			previously used objects
			 */
			board = new byte[24][10];
			byte currentType = 0;
			byte time2 = 0;
			byte [][] holdPieceCoordinates = new byte[2][4];
			byte [][] holdPieceBoard = new byte[2][4];
			int  xShift = 150;
			byte holdColour = 0;
			int  yShift = 66;
			byte [] delay = new byte[3];
			byte constantSpeedChange = 32;
			byte normal = constantSpeedChange;
			boolean swappedAlready = false;
			boolean holding = false;
			byte tempType = 0;
			byte [][] tempArray = new byte[2][4];
			byte [][] coordinates3 = new byte [2][4];
			int score = 0;
			int totalLinesCleared = 0;
			int linesClearedCounter = 0;
			double speedMultiplier = 1.0;
			boolean firstBlock = true;
			boolean refresh = true;
			finishGame = false;

			/*
			This block of code generates the first two tetrominos and assigns variable "currentType" with the 
			current type of tetromino piece being used
			 */
			randomTetromino();
			currentType = usingTetromino();
			randomTetromino();

			//Plays the main background music 
			mediaPlayer[0].play();

			//Main game loop, repeats every 32 milliseconds
			while (finishGame == false) {

				//This boolean changes when fast audio should be played
				boolean fastAudio= false;

				/*
				This loop checks for pieces in the upper region of the board, and plays 
				a faster version of the original background music if this condition is true
				 */
				for (byte i = 0; i<10; i++) {
					for (byte i2 = 0; i2<board[1].length;i2++) {
						if (board[i][i2] >1) {
							fastAudio = true;			
							//This if statement prevents these methods from being invoked if the music is already playing
							if (mediaPlayer[8].getStatus() != MediaPlayer.Status.PLAYING) {
								mediaPlayer[0].stop();
								mediaPlayer[8].play();
							}
						}

					}
				}

				//This if statement plays the original audio if the condition is no longer true (pieces in the upper region of the board)
				if (fastAudio == false) {
					mediaPlayer[8].stop();
					mediaPlayer[0].play();
				}

				//This if statement refreshes the screen when variable refresh equals true
				if (refresh == true) {

					//Changes state of variable "refresh" to prevent unnecessary refreshes
					refresh = false;


					c.clear();
					c.drawImage(img[8], 0, 0);

					//Draws the main board (center of screen)
					for (byte i = 2; i<board.length; i++) {
						for (byte i2 = 0; i2<board[1].length; i2++ ) {
							c.drawImage(img[blockForDraw(i,i2)-1], i2*20+xShift, i*20+yShift);
						}
					}

					//Draws the next piece to the right of the main board
					for (byte i = 0; i<nextPieceBoard.length; i++) {
						for (byte i2 = 0; i2<nextPieceBoard[1].length; i2++ ) {
							if (nextPieceBoard[i][i2] == 0) {	
							}
							else {
								c.drawImage(img[6], i2*20+387, i*20+153);
							}

						}
					}

					//Draws the held piece to the left of the main board
					for (byte i = 0; i<holdPieceBoard.length; i++) {
						for (byte i3 = 0; i3<holdPieceBoard[1].length; i3++ ) {
							if (holdPieceBoard[i][i3] == 0) {	
							}
							else {
								c.drawImage(img[holdColour-1], i3*20+32, i*20+153);
							}

						}
					}

					/*
					 * Draws the total lines the user has cleared on top of the main board with the courier font.
					 * Font is generated through image array "font" and uses a formula to draw additional digits to the left of the original digit's position
					 * 
					 */
					for (int i = String.valueOf(totalLinesCleared).length()-1; i>=0; i--) {
						c.drawImage(font[Character.getNumericValue(String.valueOf(totalLinesCleared).charAt(i))], 290-(String.valueOf(totalLinesCleared).length()-1-i)*11+(String.valueOf(totalLinesCleared).length())*11, 70);
					}

					/*
					 * Draws the score of the user to the middle left of the main board with the courier font.
					 * Font is generated through image array "font" and uses a formula to draw additional digits to the left of the original digit's position
					 * 
					 */
					for (int i = String.valueOf(score).length()-1; i>=0; i--) {
						c.drawImage(font[Character.getNumericValue(String.valueOf(score).charAt(i))], 20-(String.valueOf(score).length()-1-i)*11+(String.valueOf(score).length())*11, 300);
					}
					c.refresh();
				}



				//If both movement keys are pressed, nothing happens
				if (c.isKeyDown("Right")&&c.isKeyDown("Left")) {

				}
				/*
				Movement right, delay makes the user have greater control of the tetromino they control 
				(the tetromino they control moves slower with the delay)
				 */
				else if (c.isKeyDown("Right")&& delay[2]>2  ) {

					//This boolean changes when the block should not move
					boolean move = true;

					/*
					This loop checks if any of the blocks making up the tetromino they control 
					will be out of bounds or will overlap a block not connected to the tetromino
					if shifted 1 unit to the right
					 */
					for (byte i = 0; i<4; i++) {
						if (coordinates[1][i]+1 == board[1].length) {
							move = false;
							break;
						}
						if (board[coordinates[0][i]][coordinates[1][i]+1] > 1) {
							move = false;
							break;
						}
					}
					
					//Performs movement, resets the delay, and sets refresh to true, when the condition is met
					if (move == true) {
						movement(1,1);
						refresh = true;
						delay[2] = 0;
					}
				}
				/*
				Movement left, delay makes the user have greater control of the tetromino they control 
				(the tetromino they control moves slower with the delay)
				 */
				else if (c.isKeyDown("Left")&& delay[2]>2  ) {

					//This boolean changes when the block should not move
					boolean move = true;

					/*
					This loop checks if any of the blocks making up the tetromino they control 
					will be out of bounds or will overlap a block not connected to the tetromino
					if shifted 1 unit to the left
					 */
						for (byte i = 0; i<4; i++) {
							if (coordinates[1][i]-1 == -1) {
								move = false;
								break;
							}
							if (board[coordinates[0][i]][coordinates[1][i]-1] >1) {
								move = false;
								break;
							}
						}
						//performs movement, resets the delay, and sets refresh to true, when the condition is met
					if (move == true ) {
						delay[2] = 0;
						refresh = true;
						movement(1,-1);
					}
				}
				/*
				 * Swaps the current piece with the piece being held, if there is no piece
				 * in held, the current piece is stored in held and the next piece becomes the current piece.
				 * The piece cannot be swapped twice in a row (if you swap a piece, you now must place your
				 * swapped piece before being able to swap again)
				 */
				if (c.isKeyDown("Z")) {
					
					//This if statement is invoked when there is no piece being held
					if (holding == false) {
						
						//Holding being false is a one time occurrence each play through
						holding = true;
						
						//Playing audio
						mediaPlayer[4].stop();
						mediaPlayer[4].play();
						
						//Removing current piece from board
						for (byte i = 0; i<4; i++){
							board[coordinates[0][i]][coordinates[1][i]] = 0;
						}
						
						//TempType holds the number correlated to the tetromino
						tempType = currentType;
						
						//Putting the current tetromino into the hold array
						for (byte i = 0; i<4; i++){
							holdPieceCoordinates[0][i] = (byte) (tetrominos[currentType][0][i]+2);;
							holdPieceCoordinates[1][i] = tetrominos[currentType][1][i];
						}
						
						//Storing the current tetromino's colour into the hold variable
						holdColour = colour;
						
						//Putting the next tetromino into the current tetromino and assigning the tetromino's type to "currentType"
						currentType = usingTetromino();
						
						//Generating a random tetromino
						randomTetromino();
						
						//Screen will refresh next loop
						refresh = true;
						
						//Preventing the user from being able to swap 2 times in a row
						swappedAlready = true;
					}
					else if (swappedAlready == false) {
						
						//playing audio
						mediaPlayer[4].stop();
						mediaPlayer[4].play();
						
						//Removing current piece from board
						for (byte i = 0; i<4; i++){
							board[coordinates[0][i]][coordinates[1][i]] = 0;
						}
						
						//emptying array "holdPieceBoard"
						for (byte i = 0; i<holdPieceBoard.length; i++) {
							for (byte i2 = 0; i2<holdPieceBoard[0].length; i2++) {
								holdPieceBoard[i][i2] = 0;
							}
						}
						
						//putting the coordinates of the held piece into "tempArray"
						for (byte i = 0; i<4; i++){
							tempArray[0][i] = holdPieceCoordinates[0][i];
							tempArray[1][i] = holdPieceCoordinates[1][i];
						}
						
						/*
						Putting the current type of tetromino into the hold array and putting the
						coordinates of the held object into the coordinates of the current object
						*/
						for (byte i = 0; i<4; i++){
							holdPieceCoordinates[0][i] = (byte) (tetrominos[currentType][0][i]+2);;
							holdPieceCoordinates[1][i] = tetrominos[currentType][1][i];
							coordinates[0][i] = tempArray[0][i];
							coordinates[1][i] = tempArray[1][i];
						}
						//Swapping the types of the tetrominos and the colours of the tetrominos
						byte tempColour = holdColour;
						byte temptype2 = currentType;
						holdColour = colour;
						colour = tempColour;
						currentType = tempType;
						tempType = temptype2;
						
						/*
						By invoking movement without putting units for the block to move,
						you can put the coordinates of the current object into the board
						*/
						movement(0,0);
						
						//Screen will refresh next loop
						refresh = true;
						
						//Preventing the user from being able to swap 2 times in a row
						swappedAlready = true;
					}
					
					//Placing the holdPieceCoordinates into the holdPieceBoard
					for (byte i = 0; i<4; i++) {
						holdPieceBoard[holdPieceCoordinates [0][i]-2][holdPieceCoordinates [1][i]-3] = 1;
					}
				}
				
				//Makes the piece move faster down when down key is pressed
				if (c.isKeyDown("Down")) {
					constantSpeedChange = 1;
					
					//Rewarding user for using this key
					if (time2%4 == 0) {
						score+=speedMultiplier*1;
					}
					
					/*
					Creating a delay when key is used to place pieces to prevent accidental movement 
					(when placing a block, a new block is created at the top instantly, and reacting to this instant change of position is very difficult)
					*/
					if (place(coordinates) == true) {
						c.sleep(200);
					}
				}
				else {
					//Changing the time2 back to normal when the key is not pressed
					constantSpeedChange = normal;
				}

				/*
				Rotating block counterclockwise, delay makes the user have greater control of the tetromino they control 
				(the tetromino they control rotates slower with the delay)
				*/
				if (c.isKeyDown("X")  && currentType!=6 && delay[1]>4) {
					
					/*
					If a rotation is sucessful, reset the delay, play the audio, 
					and assign true to refresh so screen will refresh next loop
					*/
					if (rotation(-1)) {
						delay[1] = 0;
						mediaPlayer[2].play();
						refresh= true;
					}

				}
				else if (delay[1]==3){
					//Stop the audio when the key is not being pressed
					mediaPlayer[2].stop();
				}
				/*
				Rotating block clockwise, delay makes the user have greater control of the tetromino they control 
				(the tetromino they control rotates slower with the delay)
				*/
				if (c.isKeyDown("C")  && currentType!=6 && delay[1]>4) {
					
					/*
					If a rotation is successful, reset the delay, play the audio, 
					and assign true to refresh so screen will refresh next loop
					*/
					if (rotation(1)) {
						delay[1] = 0;
						refresh= true;
						mediaPlayer[2].play();

					}

				}
				else  if (delay[1]==3){
					//Stop the audio when the key is not being pressed
					mediaPlayer[2].stop();
				}

				
				boolean down = false;
				
				
				//Places the block to the furthermost position at the bottom, delay makes sure that the user doesn't accidentally place multiple tetrominos 
				if (c.isKeyDown("Space") && delay[0]>6  ) {
					
					//Play audio
					mediaPlayer[5].stop();
					mediaPlayer[5].play();
					
					//Reset delay
					delay[0] = 0;
					
					//Set refresh to true so screen will refresh next loop
					refresh = true;

					byte counter = 0;
					
					//Putting current coordinates of tetromino into temporary array
					for (byte i = 0; i<4; i++) {
						coordinates3[0][i] = coordinates [0][i];
						coordinates3[1][i] = coordinates [1][i];
					}
					
					//Counting how far the piece can be placed downward without overlapping already filled board positions
					while (place(coordinates3) == false) {
						counter++;
						for (byte i = 0; i<4; i++) {
							coordinates3[0][i]++;
						}
					}
					
					//Rewarding user for using this game mechanic
					score += counter*speedMultiplier;
					
					//Moving tetromino with counter to furthermost position at bottom
					movement(0,counter);
					
					//Making sure the piece is instantly locked 
					down = true;
				}
				
				/*
				This if checks for line clears every few loops (this exact amount is indicated by ConstantSpeedChange).
				This allows for the user to move the piece when it touches the bottom for a few milliseconds, rather than locking the piece from user control instantly.
				The variable down is affected only by the user entering a key press of the space bar, and this allows for the piece to lock instantly when the space bar is pressed.
				*/
				if (time2%constantSpeedChange == 0 || down == true) {
					
					//If the tetromino can no longer move down, this if statement is entered 
					if (place(coordinates) == true) {
						
						//A different sound is played when the piece is placed by soft dropping, or naturally
						if (down != true) {
							mediaPlayer[9].stop();
							mediaPlayer[9].play();
						}
						
						//Placing the tetromino, with it's respective colour
						for (byte i = 0; i<4; i++) {
							board[coordinates[0][i]][coordinates[1][i]] = colour;
						}

						//Checking for line clears across the entire board with variable "counter"
						for (byte i = 0; i<board.length; i++) {
							byte counter = 0;
							for (byte i2 = 0; i2<board[1].length; i2++) {
								if (board[i][i2] != 0) {
									counter++;
								}
							}
							//If a row is filled, replace the row's first value with -1
							if (counter == board[1].length) {
								for (byte i2 = 0; i2<board[1].length; i2++) {
									board[i][0] = -1;
								}


							}

						}
						
						boolean clear = false;
						
						//This loop finds the rows which need to be cleared, and displays an animation across those rows
						for (byte i2 = 0; i2<board[1].length; i2++) {
							clear = false;
							for (byte i3 = 0; i3<board.length; i3++) {
								
								//Placing -1 into the rest of the row which needs to be cleared
								if (board[i3][0] == -1 ){
									board[i3][i2] = -1;
									clear = true;
								}

							}
							//Refreshing the board every 40 milliseconds to create an animated effect
							if (clear == true) {
								
								//Playing sound
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
						
						//Clearing the lines which are filled and pushing the lines above downward
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
						
						//Formulas to calculate scores and speed after line clear
						totalLinesCleared += linesClearedCounter;
						score += (100)*Math.pow(linesClearedCounter,2)*speedMultiplier;
						int number = totalLinesCleared/10;
						constantSpeedChange= (byte) Math.round(32/Math.pow(1.5,number));
						normal = constantSpeedChange;
						speedMultiplier = 1.0 * Math.pow(1.8,number);
						
						//Changing the tetromino and generating a new tetromino
						currentType = usingTetromino();
						randomTetromino();
						
						//Stopping audio 
						mediaPlayer[1].stop();
						
						//Tetrominos can now be swapped again
						swappedAlready = false;
					}
					else {
						
						//move tetromino down by 1 unit
						movement(0,1);
					}
					refresh = true;

				}
				
				//the first block will move when program is ran since 0 modulus any number will yield 0, so move first block back up by 1 unit
				if (firstBlock == true) {
					movement(0,-1);
					firstBlock = false;
				}

				//increase time
				time2++;

				//increase all delays by 1
				for (byte i = 0; i<delay.length;i++) {
					if (delay[i]<7) {
						delay[i]++;
					}
				}

				//Sleep thread by 32 miliseconds
				c.sleep(32);

			}
			
			c.sleep(64);
			
			
			//Display board and piece which lead to loss
			for (byte i = 2; i<board.length; i++) {
				for (byte i2 = 0; i2<board[1].length; i2++ ) {
					if (board[i][i2] == 1) {
						c.drawImage(img[6], i2*20+xShift, i*20+yShift);
					}
					else {
						c.drawImage(img[blockForDraw(i,i2)-1], i2*20+xShift, i*20+yShift);
					}
				}
			}
			c.refresh();
			
			//Play sound and stop music 
			mediaPlayer[8].stop();
			mediaPlayer[3].play();
			
			//Delay
			c.sleep(2000);

			time = 0;
			
			//Animation
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
			
			//Delay
			c.sleep(1000);
			
			//Stop sound
			mediaPlayer[3].stop();
			
			//Change highScore is score is greater
			if (score>highScore) {
				highScore = score;
			}

			//Play ending music
			mediaPlayer[6].play();
			
			//Play ending screen with flashing text
			while (true) {
				
				//Time is now a counter which goes from 1 - 10, then resets
				if (time>10) {
					time-=10;
				}
				
				if (time <5 ) {
					c.clear();
					c.drawImage(img[9], 0, 0);
					c.setFill(Color.WHITE);
					c.setFont(STYLESHEET_CASPIAN,30);
					
					/*
					 * Draws the total lines the user has cleared on top of the main board with the courier font.
					 * Font is generated through image array "font" and uses a formula to draw additional digits to the left of the original digit's position
					 * 
					 */
					for (int i = String.valueOf(score).length()-1; i>=0; i--) {
						c.drawImage(font[Character.getNumericValue(String.valueOf(score).charAt(i))], 224-(String.valueOf(score).length()-1-i)*11+(String.valueOf(score).length())*11, 104);
					}
					/*
					 * Draws the score of the user to the middle left of the main board with the courier font.
					 * Font is generated through image array "font" and uses a formula to draw additional digits to the left of the original digit's position
					 * 
					 */
					for (int i = String.valueOf(highScore).length()-1; i>=0; i--) {
						c.drawImage(font[Character.getNumericValue(String.valueOf(highScore).charAt(i))], 224-(String.valueOf(highScore).length()-1-i)*11+(String.valueOf(highScore).length())*11, 51);
					}

				}
				else{
					//Flashing text
					c.fillText("Press the space bar to play again", 42, 500);
					c.fillText("Press the escape key to exit", 42, 550);
				}
				
				time++;
				
				//Press space bar to play again
				if (c.isKeyDown("Space")) {

					break;
				}
				
				//Press escape key to end program
				else if (c.isKeyDown("Esc")) {
					System.exit(0);
				}

				//refresh screen and delay
				c.refresh();
				c.sleep(100);
			}

		}

	}

	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * This method rotate the tetromino that the user is in control of
	 * @param num - direction to rotate, positive equals clockwise, negative counterclockwise
	 * @return change - boolean which indicates if rotation was sucessful
	 */
	public static boolean rotation (int num) {
		boolean change = true;
		byte [][] coordinates2 = new byte [2][4];
		
		//Rotates each piece around a center piece
		for (byte i = 1; i<4; i++) {
			byte tempX = 0;
			byte tempY = 0;

			//Formula for rotation
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
			
			//Array "coordinates2" contains the tetromino's possible new location
			coordinates2[1][i] = tempX;
			coordinates2[0][i] = tempY;	
			
			//if any block in the tetromino is out of bounds or overlaps another block in the array, do not change the location of the tetromino
			if (tempY>=board.length || tempY<0 || tempX>=board[0].length || tempX<0) {
				change = false;
			}
			if (change != false && board[tempY][tempX] > 1) {
				change = false;
			}

		}
		//changes tetromino location
		if (change == true) {
			//clearing old location from board
			for (byte i = 0; i<4; i++) {
				
				board[coordinates[0][i]][coordinates[1][i]] = 0;

			}
			//putting new coordinates in array "coordinates"
			for (byte i = 1; i<4; i++){
				coordinates[0][i] = coordinates2[0][i];

				coordinates[1][i] = coordinates2[1][i];
			}
			//putting coordinates into board
			for (byte i = 0; i<4; i++) {
				board[coordinates[0][i]][coordinates[1][i]] = 1;
			}
		}
		//returns a boolean indicating if the change was sucessful
		return change;

	}
	/**
	 * Generates random tetromino and puts coordinates into array "nextPieceCoordinates"
	 * Randomness of tetromino is weighed, if you get a piece once, you have a less likely chance of getting it again
	 */
	public static void randomTetromino() {
		
		nextPieceBoard = new byte [2][4];

		//formulas for making weighed randomness, however, randomness is not guaranteed
		byte counter = 0;
		for (byte i = 0; i<fixedRandom.length; i++) {
			if (fixedRandom[i] == false){
				counter++;
			}
		}
		if (counter>15) {
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
		
		//putting coordinates of tetromino into nextPieceCoordinates
		for (byte i = 0; i<4; i++) {
			nextPieceCoordinates [0][i] = (byte) (tetrominos[type][0][i]+2);
			nextPieceCoordinates [1][i] = tetrominos[type][1][i];

		}
		//puting coordinates of nextPieceCoordinates into nextPieceBoard
		for (byte i = 0; i<4; i++) {
			nextPieceBoard[nextPieceCoordinates [0][i]-2][nextPieceCoordinates [1][i]-3] = 1;
		}
	}
	/**
	 * This method puts the next piece coordinates into current coordinates
	 * 
	 */
	public static byte usingTetromino() {
		//Putting nextPieceCoordinates into current coordinates
		for (byte i = 0; i<4; i++) {
			coordinates[0][i] = nextPieceCoordinates [0][i];
			coordinates[1][i] = nextPieceCoordinates [1][i];
		}	
		boolean finish = false;
		
		//puts the coordinates into the board and checks if the game is lost
		for (byte i = 0; i<4; i++) {
			//when the blocks overlap the blocks on the board, the game is lost
			if (board[coordinates[0][i]][coordinates[1][i]] != 0) {
				finish = true;
			}
			board[coordinates[0][i]][coordinates[1][i]] = 1;
		}
		//finishGame is true when game is lost
		if (finish == true) {
			finishGame = true;
		}

		return type;
	}
	/**
	 * Moves the tetromino
	 * @param axis - axis in which the tetromino is moving, 1 is x axis, 0 is y axis
	 * @param amount
	 */
	public static void movement(int axis, int amount) {
		//removing current coordinates from board
		for (byte i = 0; i<4; i++) {
			board[coordinates[0][i]][coordinates[1][i]] = 0;
		}
		//changing coordinates
		for (byte i = 0; i<4; i++) {
			coordinates[axis][i]+=amount;
		}
		//putting new coordinates on board
		for (byte i = 0; i<4; i++) {
			board[coordinates[0][i]][coordinates[1][i]] = 1;
		}

	}
	/**
	 * Checks if a tetromino should be placed
	 * @param array of coordinates of the tetromino
	 * @return a boolean on whether the tetromino should be placed
	 */
	public static boolean place(byte[][] array) {
		boolean place = false;
		
		//checks if there are blocks under the tetromino or if the tetromino is at the bottom of the board
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
	/**
	 * This method finds out what kind of block to draw at certain coordinates in the board 
	 * @param i - row coordinate 
	 * @param i2 - column coordinate
	 * @return what kind of block should be drawn
	 */
	public static byte blockForDraw(byte i, byte i2) {
		byte block  = 0;
		
		//generates number based on number in board
		if (board[i][i2] >1) {
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


