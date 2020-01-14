package kha.testing;


import hsafx.*;

/**
 * Test of keyboard input routines for animations and games.
 *
 * @author Sam Scott, Mohawk College
 */
public class keytest extends ConsoleView {

    @Override
    public void run() {
        Console c = new Console(600, 300, 12, "Console Template", this);

        // ================= Your Code Starts Here
        c.autoRefreshOff();
        while (true) {
            c.clear();
            c.println(c.getKeyCode() + " " + c.getKeyChar());
            c.println(c.getLastKeyCode() + " " + c.getLastKeyChar());
            if (c.isKeyDown("Shift")) {
                c.println("+SHIFT");
            }
            c.refresh();
            c.sleep(100);
        }

        // ================= Your Code Ends Here
    }

    public static void main(String[] args) {
        launch(args);
    }
}
