package controllers.Scenes;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by QuanLA on 12/31/2016.
 */
public class MenuScene extends GameScene {
    @Override
    public void update(Graphics g) {
        g.setFont(new Font("Time New Roman", Font.BOLD, 40));
        g.setColor(Color.RED);
        g.drawString("Press any key to play", 250, 300);
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
