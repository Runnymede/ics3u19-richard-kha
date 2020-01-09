package kha.testing;

public class AdvancedMode {

	public static void main(String[] args) {
		
	}
	public static double[] mode(double[] array) {
		double [] mode = new double[array.length];
		int pointer = 0;
		int counter = 0;
		for (int i = 0; i<array.length; i++) {
			int tempCounter = 0;
			double tempMode = array[i];
			for (int i2 = 0; i2<array.length; i2++) {
				if (tempMode == array[i2]) {
					tempCounter++;
				}
			}
			if (tempCounter > counter) {
			mode = new double[array.length];
			pointer = 0;
			mode[pointer] = tempMode;
			counter = tempCounter;
			pointer++;
			}
			else if (tempCounter == counter) {
				//todo check for repetition of modes
				mode[pointer] = tempMode;
				pointer++;
			}
		}
		return mode;
	}
}
