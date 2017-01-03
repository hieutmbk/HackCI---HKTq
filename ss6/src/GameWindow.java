import Models.Model;
import controllers.KeySetting;
import controllers.NinjaController;
import controllers.Scenes.GameOverScene;
import controllers.Scenes.GameScene;
import controllers.Scenes.MenuScene;
import controllers.Scenes.SceneListener;
import controllers.enemies.BulletEnemyController;
import controllers.managers.BodyManager;
import controllers.managers.ControllerManager;
import controllers.managers.EnemyControllerManager;
import controllers.managers.TreeManager;
import utils.Utils;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Stack;


/**
 * Created by minhh on 16/12/2016.
 */
public class GameWindow extends Frame implements  Runnable, SceneListener {
    GameScene currentScene;
    Stack<GameScene> gameSceneStack;

    BufferedImage backBuffer;

    public GameWindow() throws IOException {

        gameSceneStack = new Stack<>();
        this.replaceScene(new MenuScene(), false);

        setVisible(true);
        setSize(920,720);
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
                currentScene.keyPressed(e);
            }
            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentScene.mouseClicked(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    @Override
    public void update(Graphics g) {
        Graphics backBufferGraphics = backBuffer.getGraphics();
        currentScene.update(backBufferGraphics);


        g.drawImage(backBuffer, 0, 0, 920, 720, null);


    }

    public void replaceScene(GameScene newScene, boolean addToBackStack){
        if(addToBackStack && currentScene != null){
            gameSceneStack.push(currentScene);
        }
        currentScene = newScene;
        currentScene.setSceneListener(this);
    }

    public void back(){
        if(!gameSceneStack.isEmpty()){
            currentScene = gameSceneStack.pop();
        }
    }

    @Override
    public void run() {


        while (true) {
            System.out.print("");
            if(Model.onGame) {
                try {
                    this.repaint();
                    Thread.sleep(17);
                    currentScene.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
