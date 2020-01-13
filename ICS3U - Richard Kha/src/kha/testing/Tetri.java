package kha.testing;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;




import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



class Time2 extends TimerTask{
	public static int y = 0;
	public void run() {
		y++;
		Tetri.re();
	}

}
public class Tetri extends Canvas implements KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 486018688539765497L;

	static Canvas canvas = new Tetri();
	static int x = 0;
	public static void main(String[] args) {
		JFrame frame = new JFrame("Why");
		Timer timer = new Timer();
		TimerTask task = new Time2();
		timer.schedule(task, 100, 1000);
		canvas.setSize(1600, 900);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);
		
	}
	public static void re() {
		canvas.repaint();
	}
	public void paint(Graphics g) {

		int b = Time2.y*100;

		g.fillRect(100+x, b, 200, 200);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A) {
			x-=100;
		}
		if(e.getKeyCode() == KeyEvent.VK_D) {
			x+=100;
		}
		
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

