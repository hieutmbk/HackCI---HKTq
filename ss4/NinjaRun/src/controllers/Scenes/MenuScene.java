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
    public void update(Graphics g) {
        g.drawImage(Utils.loadImage("resources/menu.png"),0, 0, 920, 720, null);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.sceneListener.replaceScene(
                new PlayScene(),
                true
        );
    }

    public void mouseClicked(MouseEvent e) {};
}
