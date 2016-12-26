package Controllers;

import javafx.scene.input.KeyEvent;

/**
 * Created by QuanLA on 12/17/2016.
 */
public class KeySetting {
    private int keyFire;
    private int keyLeft;
    private int keyRight;

    public KeySetting(int keyLeft, int keyRight, int keyFire) {
        this.keyLeft = keyLeft;
        this.keyRight = keyRight;
        this.keyFire = keyFire;
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
