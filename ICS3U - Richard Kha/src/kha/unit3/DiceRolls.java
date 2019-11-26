package kha.unit3;
/**
 * 
 * 
 * @author Richard Kha
 *
 */
public class DiceRolls {
	/**
	 * 
	 * This is the entry point to the program
	 */
	public static void main(String[] args) {
		//declaring and assigning variables
		int[] numberOfRolls = new int[11];
		int dice1 = 0;
		int dice2 = 0;
		int total = 0;
		
		//loop to perform opperations 1000 times 
		for (int a = 0; a<1000; a++) {
			
			//generating two random numbers and then added them together
			dice1 = (int)(Math.random()*6+1);
			dice2 = (int)(Math.random()*6+1);
			total = dice1+dice2;
			
			//counting occurances of each number from 2 to 12
			numberOfRolls[total-2] ++;
		}
		//displaying the results from the operations in a neat table-like fashion
		System.out.println("Total\t Number of Rolls");
		for (int i = 0; i<11; i++) {
			System.out.println(i+2+"\t "+numberOfRolls[i]);
		}

	}

}