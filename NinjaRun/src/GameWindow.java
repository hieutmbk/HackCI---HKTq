import Models.Model;
import controllers.KeySetting;
import controllers.NinjaController;
import controllers.enemies.BulletEnemyController;
import controllers.managers.BodyManager;
import controllers.managers.ControllerManager;
import controllers.managers.EnemyControllerManager;
import controllers.managers.TreeManager;
import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.IOException;


/**
 * Created by minhh on 16/12/2016.
 */
public class GameWindow extends Frame implements  Runnable {
    Image background;
    NinjaController ninjaController;
    TreeManager treeManager;
    BufferedImage backBuffer;
    EnemyControllerManager enemyControllerManager;
    public GameWindow() throws IOException {
        treeManager = new TreeManager();
        enemyControllerManager = new EnemyControllerManager();
        treeManager.spawn();
        ninjaController = NinjaController.instance;
        setVisible(true);
        setSize(920,720);
        background = Utils.loadImage("resources/sky-sheet1.png");
        backBuffer = new BufferedImage(920,720,BufferedImage.TYPE_INT_ARGB);
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                ninjaController.keyPressed(e);
            }
            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    @Override
    public void update(Graphics g) {
        if(ninjaController.getLive() > 0) {
            Graphics backBufferGraphics = backBuffer.getGraphics();
            backBufferGraphics.drawImage(background, 0, 0, 920, 720, null);
            ninjaController.draw(backBufferGraphics);
            treeManager.draw(backBufferGraphics);
            enemyControllerManager.draw(backBufferGraphics);
            ControllerManager.bulletEnemy.draw(backBufferGraphics);

            Font font = new Font("Bauhaus 93",Font.BOLD,40);
            backBufferGraphics.setFont(font);
            backBufferGraphics.setColor(Color.ORANGE);
            backBufferGraphics.drawString(String.valueOf("Point : "+NinjaController.instance.point),20,100);

            g.drawImage(backBuffer, 0, 0, 920, 720, null);
        }
        else{
            g.setFont(new Font("Algerian", Font.BOLD, 50));
            g.setColor(Color.RED);
            g.drawString("Game Over", 300, 400);
        }


    }

    @Override
    public void run() {
        while (true) {

            try {
                this.repaint();
                Thread.sleep(17);
                ninjaController.run();
                treeManager.run();
                enemyControllerManager.run();
                ControllerManager.bulletEnemy.run();
                BodyManager.instance.checkContact();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
