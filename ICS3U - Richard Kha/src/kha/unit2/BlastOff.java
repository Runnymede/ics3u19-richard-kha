package kha.unit2;
/**
 * <br>BlastOff.java
 * <br>This program counts down from 10 to 1, then prints "Blast off"
 * <br>The printing of each number is delayed by 1000 milliseconds, or 1 second
 * <br>November 11, 2019
 *@author Richard Kha
 */
public class BlastOff {
	/**
	 * This is the entry point to the program
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException  {

		//loop to print out numbers from 10 to 1
		for (int time = 10; time>0; time--) {
			System.out.println(time);

			//delay the printing of each number by 1 second
			Thread.sleep(1000);
		}
		System.out.println("Blast off");

	}

}
