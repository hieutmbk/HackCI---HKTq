package controllers.Scenes;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by QuanLA on 1/1/2017.
 */
public class GameOverScene extends GameScene {
    @Override
    public void update(Graphics g) {

    }

    @Override
    public void run() {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.sceneListener.replaceScene(new PlayGameScene(), true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }
}
