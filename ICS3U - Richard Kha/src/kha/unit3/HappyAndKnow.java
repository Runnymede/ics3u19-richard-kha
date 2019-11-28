package kha.unit3;
/**
 * <br>HappyAndKnow.java
 * <br>This program prints out 10 verses of the children's song and randomizes the actions in each verse
 * <br>November 28, 2019
 * @author Richard Kha
 *
 */
public class HappyAndKnow {
	/**
	 * 
	 * This is the entry point to the program
	 */
	public static void main(String[] args) {
		//declaring array and assigning all the possibities for the children's song
		String[] array = {"clap your hands","stomp your feet","tap your toes","pat your head","punch the air","stick out your tongue","hit the floor","dance around","step around","clack your teeth"};

		//prints out 10 verses of the song, each with randomized actions
		for(int i = 0; i<10; i++) {
			int random = (int)(Math.random()*10);
			System.out.println("If you're happy and you know it "+array[random]+".");
			System.out.println("If you're happy and you know it "+array[random]+".");
			System.out.println("If you're happy and you know it and you really want to show it.");
			System.out.println("If you're happy and you know it "+array[random]+".");
			System.out.println();
		}
	}

}