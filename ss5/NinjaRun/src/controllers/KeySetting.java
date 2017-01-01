package controllers;

/**
 * Created by QuanLA on 12/17/2016.
 */
public class KeySetting {
    private int keyFire;
    private int keyLeft;
    private int keyRight;
    private int keyShootFire;

    public KeySetting(int keyFire, int keyLeft, int keyRight, int keyShootFire) {
        this.keyFire = keyFire;
        this.keyLeft = keyLeft;
        this.keyRight = keyRight;
        this.keyShootFire = keyShootFire;
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

    public int getKeyShootFire() {
        return keyShootFire;
    }
}
