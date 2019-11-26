package kha.unit3;

import java.util.Scanner;
/**
 * 
 * 
 * @author Richard Kha
 *
 */
public class GuessingVegetables {
	/**
	 * 
	 * This is the entry point to the program
	 */
	public static void main(String[] args) {
		//declaration of objects and variables
		Scanner sc = new Scanner(System.in);
		Boolean win = false;
		String[] array = {"Artichokes","Asparagus","Beets","Broccoli","Brussels Sprouts","Carrots","Cauliflower","Corn","Eggplant","Fennel","Green Beans","Leeks","Peas","Potatoes","Spinach","Squash","Zucchini","Turnips","Kale","Cabbage"};
		int counter = 0;
		int random = 0;
		
		System.out.println("Hi, let's play a guessing game. Think of a vegetable and press a key when you are ready.");
		//waits till the user enters an input
		sc.nextLine();
		
		//loop counts from 0 to the length of array(String[]) 
		for(int i = 0; i<array.length; i++) {
			random = 0;
			
			/*
			Takes a random element from the array.
			If array has "0" as one of its elements, random number generator should roll again since "0" as the value
			of an element means that the element has already been tried.
			*/
			do {
				random = (int) (Math.random()*20);
			}while (array[random] == "0");
			System.out.println("Is it "+array[random]);
			
			//increases counter to count how many tries it takes for the computer to guess the vegatable right
			counter++;
			String answer = sc.next();
			
			if(answer.equalsIgnoreCase("yes")) {
				System.out.println("\nI win!!!");
				System.out.println("It took me "+counter+" tries to get it right");
				
				//prevents the lines of code if the computer loses from being reached
				win = true;
				break;
			}
			//fills position which was already guessed with "0" 
			array[random] = "0";
		}
		if(win!=true) {
			System.out.println("I surrender");
		}

	}

}




