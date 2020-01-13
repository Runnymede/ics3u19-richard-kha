package kha.testing;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class Time3 extends TimerTask{
	public static int y = 0;
	public void run() {
		ASCII.a = new int[5][7];
		ASCII.a[ASCII.coordinates[0][0]][ASCII.coordinates[0][1]] = 1;
		ASCII.coordinates[0][0] +=1;
		ASCII.s();
	}

}
public class ASCII implements KeyListener {
	static int [][] coordinates = new int [4][2];
	static int [][]a = new int[5][7];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Timer timer = new Timer();
		TimerTask task = new Time3();
		timer.schedule(task, 100, 1000);
		
		coordinates[0][0] = 3;
		coordinates[0][1] = 3;

	}
	public static void s() {
		
		for (int t = 0; t<7; t++) {
			for (int i = 0; i<a.length; i++) {
				System.out.print(a[i][t]);
			}
			System.out.println();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
