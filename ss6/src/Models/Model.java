package Models;

import java.awt.*;

/**
 * Created by minhh on 17/12/2016.
 */
public class Model {
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean alive = true;
    public static boolean onGame = true;
    public static boolean mute = false;

    public Model(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.alive = true;
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Rectangle getRect() {
        return new Rectangle(x, y, width, height);
    }

    public boolean intersects(Model other) {
        Rectangle rect1 = this.getRect();
        Rectangle react2 = other.getRect();
        return rect1.intersects(react2);
    }

    public int getBottom() {
        return y + height;
    }

    public int getMidX() {
        return x + width/2;
    }
}
