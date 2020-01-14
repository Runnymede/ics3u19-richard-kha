package kha.testing;


import hsafx.*;

/**
 * Input test.
 *
 * @author Sam Scott, Mohawk College
 */
public class Test3 extends ConsoleView {

    @Override
    public void run() {
        Console c = new Console(600, 300, 20, "hsafx console", this);

        c.print("Enter a double: ");
        double d = c.nextDouble();
        d = d / (d * d);

        c.print(d, 10, 2);
        c.sleep(1000);
        c.quit();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
