import Controller.NinjaController;
import javafx.scene.layout.BackgroundImage;
import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;

/**
 * Created by minhh on 16/12/2016.
 */
public class GameWindow extends Frame implements  Runnable {
    Image background,imagebox;
    BufferedImage backBuffer;
    NinjaController ninjaController;

    public GameWindow(){
        setVisible(true);
        setSize(920,720);
        background = Utils.loadImage("resources/sky-sheet1.png");
        backBuffer = new BufferedImage(920,720,BufferedImage.TYPE_INT_ARGB);
        ninjaController = NinjaController.creatNinja(460,360);
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
                if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    ninjaController.jump();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    @Override
    public void update(Graphics g) {
        Graphics backBufferGraphics = backBuffer.getGraphics();
        backBufferGraphics.drawImage(background,0,0,920,720,null);
        ninjaController.draw(backBufferGraphics);
        g.drawImage(backBuffer,0,0,920,720,null);

    }

    @Override
    public void run() {

        while (true){

            try {
                this.repaint();
                Thread.sleep(17);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
