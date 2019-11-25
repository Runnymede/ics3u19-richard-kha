package kha.unit3;

import java.util.Scanner;

public class GuessingVegetables {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Boolean win = false;
		String[] array = {"Artichokes","Asparagus","Beets","Broccoli","Brussels Sprouts","Carrots","Cauliflower","Corn","Eggplant","Fennel","Green Beans","Leeks","Peas","Potatoes","Spinach","Squash","Zucchini","Turnips","Kale","Cabbage"};
		int counter = 0;
		System.out.println("Hi, let's play a guessing game. Think of a vegetable and press a key when you are ready.");
		sc.nextLine();
		for(int i = 0; i<array.length; i++) {
			int random = 0;
			do {
				random = (int) (Math.random()*20);
			}while (array[random] == "0");
			System.out.println("Is it "+array[random]);
			counter++;
			String answer = sc.next();
			if(answer.equalsIgnoreCase("yes")) {
				System.out.println("\nI win!!!");
				System.out.println("It took me "+counter+" tries to get it right");
				win = true;
				break;
			}
			array[random] = "0";
		}
		if(win!=true) {
			System.out.println("I surrender");
		}

	}

}






