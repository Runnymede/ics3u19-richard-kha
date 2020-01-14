package kha.testing;


import hsafx.*;
import javafx.scene.paint.Color;

/**
 * Test of animation, etc.
 *
 * @author Sam Scott, Mohawk College
 */
public class Test2 extends ConsoleView {

    @Override
    public void run() {
        Console c = new Console(600, 300, 20, "hsafx console", this);

        double x = 0;
        double y = 0;
        double w = Math.random() * 100 + 100;
        double h = Math.random() * 100 + 100;
        c.println("Press any key to go!");
        c.getChar();
        c.setBackground(Color.RED);
        c.setFill(Color.GREEN);
        c.setFont("Trebuchet", 30);
        c.autoRefreshOff();
        while (true) {
            c.clear();
            c.setLineWidth(20);
            c.setStroke(Color.WHITE);
            c.fillRect(x, y, w, h);
            c.fillText("HI THERE!", 0, 100);
            c.refresh();
            x += 5;
            c.sleep(1000 / 60);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
