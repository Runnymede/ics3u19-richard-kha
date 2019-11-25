package kha.unit3;

public class HappyAndKnow {

	public static void main(String[] args) {
		String[] array = {"clap your hands","stomp your feet","tap your toes","pat your head","punch the air","stick out your tongue","hit the floor","dance around","step around","clack your teeth"};

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
