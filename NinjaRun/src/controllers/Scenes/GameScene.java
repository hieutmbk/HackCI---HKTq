package controllers.Scenes;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by QuanLA on 12/31/2016.
 */
public abstract class GameScene {
    protected SceneListener sceneListener;

    public GameScene(){

    }

    public GameScene(SceneListener sceneListener) {
        this.sceneListener = sceneListener;
    }

    public void setSceneListener(SceneListener sceneListener) {
        this.sceneListener = sceneListener;
    }

    public abstract void update(Graphics g);
    public abstract void run();
    public abstract void keyPressed(KeyEvent e);
    public abstract void mouseClicked(MouseEvent e);
}
