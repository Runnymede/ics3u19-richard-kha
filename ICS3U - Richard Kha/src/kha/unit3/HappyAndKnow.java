package kha.unit3;

public class HappyAndKnow {

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
