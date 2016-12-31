package controllers;

/**
 * Created by QuanLA on 12/17/2016.
 */
public class KeySetting {
    private int keyFire;
    private int keyLeft;
    private int keyRight;

    public KeySetting(int keyFire, int keyLeft, int keyRight) {
        this.keyFire = keyFire;
        this.keyLeft = keyLeft;
        this.keyRight = keyRight;
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

}
