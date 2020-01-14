package kha.testing;


import hsafx.*;
import javafx.scene.paint.Color;

/**
 * Test of print/println system
 *
 * @author Sam Scott, Mohawk College
 */
public class Test extends ConsoleView {

    @Override
    public void run() {
        Console c = new Console(600, 300, 12, "hsafx console", this);
        c.setBackground(Color.BLACK);
        c.clear();
        c.setFill(Color.LIGHTYELLOW);
        c.print("welfjdkslajfdklsjafkldsjfklsdjlk           hi there?");
        c.println("Did this work?");
        String x = c.nextLine();
        c.fillRect(100, 200, 100, 100);
        c.setFill(Color.YELLOW);
        for (int i = 0; i < 100; i++) {
            c.println(i + " You entered: " + x);
            c.sleep(200);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
