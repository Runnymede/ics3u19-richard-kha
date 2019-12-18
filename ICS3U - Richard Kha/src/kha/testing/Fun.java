package kha.testing;


public class Fun {

	public static void main(String[] args) {
		int input = 0;
		int counter;
		int amountOfOccurances = 0;
		int bestNumber = 0;
		int test = 0;
		while(test<200) {
			test++;
			input = test;
			counter =0;
			while (input!=1) {
				if(input%2 == 0) {
					input/=2;
				}
				else {
					input = input*3+1;
				}
				System.out.print(input+" ");
				counter++;
			}
			if (counter>amountOfOccurances) {
				amountOfOccurances = counter;
				bestNumber = test;
			}
			System.out.println();
		}
		System.out.println("the number with the most amount of operations performed: "+bestNumber +" Amount of occurances: "+ amountOfOccurances);
	}

}
