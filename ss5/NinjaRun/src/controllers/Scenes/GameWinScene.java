package controllers.Scenes;

import utils.Utils;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by laptopTCC on 1/1/2017.
 */
public class GameWinScene extends GameOverScene {
    Image gameWin = Utils.loadImage("resources/gameover-sheet1.png");
    @Override
    public void run() {

    }

    @Override
    public void update(Graphics g) {
        Font font = new Font("Bauhaus 93", Font.BOLD, 40);
        g.setFont(font);
        g.setColor(Color.ORANGE);
        g.drawImage(gameWin,0,0,920, 720, null);
        //g.drawString("You Win!",200,400);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.sceneListener.replaceScene(new MenuScene(),false);
        reset();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }
}