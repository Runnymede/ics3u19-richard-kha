package kha.unit3;

public class DiceRolls {

	public static void main(String[] args) {
		int[] numberOfRolls = new int[11];
		for (int a = 0; a<1000; a++) {
			int dice1 = (int)(Math.random()*6+1);
			int dice2 = (int)(Math.random()*6+1);
			int total = dice1+dice2;
			numberOfRolls[total-2] ++;
		}
		System.out.println("Total\t Number of Rolls");
		for (int i = 0; i<11; i++) {
			System.out.println(i+2+"\t "+numberOfRolls[i]);
		}

	}

}
