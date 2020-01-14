package kha.testing;

import hsafx.*;
import javafx.scene.paint.Color;

import java.util.LinkedList;

/**
 * A sample game. May 24, 2018
 *
 * @author Sam Scott, Mohawk College
 */
public class Game extends ConsoleView {

    @Override
    public void run() {
        Console c = new Console(400, 300, 12, "HSA FX Console Template", this);

        // ================= Your Code Starts Here
        final int BULLET_SPACER = 20;
        boolean gameOver = false;
        LinkedList<Bullet> bullets = new LinkedList<>();
        int bulletCountDown = 0;
        c.autoRefreshOff();
        c.setBackground(Color.BLACK);

        Ship s = new Ship(280, 0, 400, 280, "green");
        AlienGrid grid = new AlienGrid(5, 10, 20, 50, 20, 380, 300);
        while (!gameOver && !grid.isGridEmpty()) {
            // draw
            c.clear();
            s.draw(c);
            grid.draw(c);
            c.setFill(Color.WHITE);
            c.setFont("Courier New", 12);
            c.fillText("Arrow Keys to Move, Spacebar to Fire.", 70, 30);
            bullets.stream().forEach((b) -> {
                b.draw(c);
            });
            c.refresh();

            // move bullets
            LinkedList<Bullet> toRemove = new LinkedList<>();
            for (Bullet b : bullets) {
                if (!b.move()) {
                    toRemove.add(b);
                } else if (b.getDirection() == -1 && grid.hit(b.getX(), b.getY())) {
                    toRemove.add(b);
                } else if (b.getDirection() == 1 && s.hit(b.getX(), b.getY())) {
                    gameOver = true;
                    System.out.println("hit");
                }
            }
            for (Bullet b : toRemove) {
                bullets.remove(b);
            }

            // move aliens
            grid.move();

            // alien fire
            Bullet b = grid.fire();
            if (b != null) {
                bullets.add(b);
            }

            // move ship
            if (c.isKeyDown("Left")) {
                s.moveLeft();
            }
            if (c.isKeyDown("Right")) {
                s.moveRight();
            }

            // ship fire
            if (bulletCountDown > 0) {
                bulletCountDown--;
            }
            if (c.isKeyDown("Space") && bulletCountDown == 0) {
                bullets.add(new Bullet(s.getX(), s.getY(), -5, 0, 300, s.getColor()));
                bulletCountDown = BULLET_SPACER;
            }

            // pause
            c.sleep(1000 / 60);
        }

        c.setFont("Courier New", 50);
//        c.setFill("rgba(255,255,255,0.8)");
        c.fillRect(0, 60, 400, 50);
        c.setFill(Color.RED);
        if (gameOver)
            c.fillText("GAME OVER", 50, 100);
        else    
            c.fillText("GOOD JOB!", 50, 100);
        c.refresh();
        // ================= Your Code Ends Here
    }

    // don't change anything below here
    public static void main(String[] args) {
        launch(args);
    }
}

class AlienGrid {

    private final String[] colors = {"red", "pink", "white", "lightblue", "royalblue", "white"};
    private static final double ALIEN_WIDTH = 20;
    private static final double SPACER = 10;
    private double x, y, xMove = 5;
    private static final double Y_MOVE = 10;
    private final int rows, cols;
    private int botrow, toprow, leftcol, rightcol;
    private final boolean[][] isAlienDead;
    private int aliensRemaining;
    private final int[] rowcounts, colcounts;
    private final double left, right, bottom;
    private int moveCount = 0;
    private int moveLevel = 50;

    AlienGrid(int rows, int cols, double x, double y, double left, double right, double bottom) {
        this.rows = rows;
        this.cols = cols;
        this.x = x;
        this.y = y;
        this.left = left;
        this.right = right;
        this.bottom = bottom;
        aliensRemaining = rows*cols;
        toprow = leftcol = 0;
        botrow = rows - 1;
        rightcol = cols - 1;
        isAlienDead = new boolean[rows][cols];
        rowcounts = new int[rows];
        for (int i = 0; i < rows; i++) {
            rowcounts[i] = cols;
        }
        colcounts = new int[cols];
        for (int i = 0; i < cols; i++) {
            colcounts[i] = rows;
        }
    }

    Bullet fire() {
        if (Math.random() * Math.min(Math.max(moveLevel, 8), 40) * 100 < 50) {
            int bcol;
            do {
                bcol = (int) (Math.random() * cols);
            } while (colcounts[bcol] <= 0);
            int brow = rows - 1;
            while (isAlienDead[brow][bcol]) {
                brow--;
            }
            return new Bullet(x + bcol * ALIEN_WIDTH + bcol * SPACER + ALIEN_WIDTH / 2,
                    y + brow * ALIEN_WIDTH + brow * SPACER + ALIEN_WIDTH / 2,
                    2, 0, bottom, colors[brow % colors.length]);
        }
        return null;
    }

    boolean isGridEmpty() {
        return aliensRemaining == 0;
    }
    void move() {
        moveCount++;
        if (moveCount >= moveLevel) {
            moveCount = 0;
            // y move?
            if (xMove > 0 && x + (rightcol + 1) * ALIEN_WIDTH + (rightcol + 1 - 1) * SPACER >= right
                    || xMove < 0 && x < left - (leftcol) * ALIEN_WIDTH - (leftcol) * SPACER) {
                y += Y_MOVE;
                xMove *= -1;
            } else {
                x += xMove;
            }
        }
    }

    boolean hit(double bx, double by) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (!isAlienDead[row][col]) {
                    double yloc = y + row * ALIEN_WIDTH + row * SPACER + ALIEN_WIDTH / 2;
                    double xloc = x + col * ALIEN_WIDTH + col * SPACER + ALIEN_WIDTH / 2;
                    if (Math.sqrt((yloc - by) * (yloc - by) + (xloc - bx) * (xloc - bx)) <= ALIEN_WIDTH / 2) {
                        System.out.println("hit " + row + " " + col);
                        isAlienDead[row][col] = true;
                        aliensRemaining--;
                        rowcounts[row]--;
                        colcounts[col]--;
                        moveLevel--;
                        if (xMove < 0) {
                            xMove -= 0.1;
                        } else {
                            xMove += 0.1;
                        }
                        resetgrid();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void resetgrid() {
        for (int r = 0; r < rows; r++) {
            if (rowcounts[r] > 0) {
                toprow = r;
                break;
            }
        }
        for (int r = rows - 1; r > 0; r--) {
            if (rowcounts[r] > 0) {
                botrow = r;
                break;
            }
        }
        for (int c = 0; c < cols; c++) {
            if (colcounts[c] > 0) {
                leftcol = c;
                break;
            }
        }
        for (int c = cols - 1; c > 0; c--) {
            if (colcounts[c] > 0) {
                rightcol = c;
                break;
            }
        }
        System.out.println(leftcol + " " + rightcol + " " + toprow + " " + botrow);
    }

    void draw(Console c) {
        for (int row = 0; row < rows; row++) {
//            c.setFill(colors[row % colors.length]);
            for (int col = 0; col < cols; col++) {
                if (!isAlienDead[row][col]) {
                    double yloc = y + row * ALIEN_WIDTH + row * SPACER;
                    double xloc = x + col * ALIEN_WIDTH + col * SPACER;
                    c.fillOval(xloc, yloc, ALIEN_WIDTH, ALIEN_WIDTH);
                }
            }
        }
    }

}

class Ship {

    private double x, y;
    private final double left, right, xspeed = 2.5;
    private final String color;

    Ship(double x, double left, double right, double y, String color) {
        this.x = x;
        this.y = y;
        this.left = left;
        this.right = right;
        this.color = color;
    }

    boolean hit(double hx, double hy) {
        return hy >= y + 7 && hy <= y + 11 && hx >= x - 18 && hx <= x + 19;
    }

    void position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    void moveLeft() {
        if (x - xspeed >= left + 20) {
            x -= xspeed;
        }
    }

    void moveRight() {
        if (x + xspeed <= right - 20) {
            x += xspeed;
        }
    }

    double getX() {
        return x;
    }

    double getY() {
        return y;
    }

    String getColor() {
        return color;
    }
    void draw(Console c) {
//        c.setFill(color);
        c.fillRect(x - 20, y + 5, 41, 10);
        c.fillRect(x - 5, y, 11, 5);
    }
}

class Bullet {

    private double x, y;
    private final double yspeed, top, bottom;
    private final String color;

    Bullet(double x, double y, double yspeed, double top, double bottom, String color) {
        this.x = x;
        this.y = y;
        this.yspeed = yspeed;
        this.top = top;
        this.bottom = bottom;
        this.color = color;
    }

    double getX() {
        return x;
    }

    double getY() {
        return y;
    }

    boolean move() {
        y += yspeed;
        return !(y > bottom || y < top);
    }

    int getDirection() {
        if (yspeed < 0) {
            return -1;
        }
        return 1;
    }

    void draw(Console c) {
        double[] xs = {x, x + 2, x - 2};
        double[] ys = {y, y + yspeed * -2, y + yspeed * -2};
//        c.setFill(color);
        c.fillPolygon(xs, ys, 3);
    }
}
