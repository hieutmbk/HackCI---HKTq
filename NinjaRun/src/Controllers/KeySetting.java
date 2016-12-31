package controllers;

/**
 * Created by QuanLA on 12/17/2016.
 */
public class KeySetting {
    private int keyFire;
    private int keyLeft;
    private int keyRight;
    private int keyUp;
    private int keyDown;

    public KeySetting(int keyFire, int keyLeft, int keyRight, int keyUp, int keyDown) {
        this.keyFire = keyFire;
        this.keyLeft = keyLeft;
        this.keyRight = keyRight;
        this.keyUp = keyUp;
        this.keyDown = keyDown;
    }

    public int getKeyFire() {
        return keyFire;
    }

    public int getKeyLeft() {
        return keyLeft;
    }

    public int getKeyRight() {
        return keyRight;
    }

    public int getKeyUp() {
        return keyUp;
    }

    public int getKeyDown() {
        return keyDown;
    }
}
