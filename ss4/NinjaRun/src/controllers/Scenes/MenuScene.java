package controllers.Scenes;

import utils.Utils;

import javax.rmi.CORBA.Util;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by laptopTCC on 12/31/2016.
 */
public class MenuScene extends GameScene {
    @Override
    public void run() {

    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.setFont(new Font("Time and Roman", Font.BOLD, 40));
        g.drawString("Press any key to play", 250, 300);
    }

    @Override
    public void keyPress(KeyEvent e) {
        this.sceneListener.replaceScene(
                new PlayScene(),
                true
        );
    }

    public void mouseClicked(MouseEvent e) {};
}
