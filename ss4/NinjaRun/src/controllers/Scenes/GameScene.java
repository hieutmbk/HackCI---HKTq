package controllers.Scenes;

import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by laptopTCC on 12/31/2016.
 */
public abstract class GameScene {
    //public void replace(GameScene gameScene,boolean addToStack);
    protected SceneListener sceneListener;

    public void setSceneListener(SceneListener sceneListener) {
        this.sceneListener = sceneListener;
    }

    public abstract void run();
    public void draw(Graphics g){};
    public void keyPress(KeyEvent e){};

    public void mouseClicked(MouseEvent e) {
    };

}
