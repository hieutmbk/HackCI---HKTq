package controllers.Scenes;

import controllers.Controller;
import controllers.NinjaController;
import controllers.managers.BodyManager;
import controllers.managers.ControllerManager;
import controllers.managers.EnemyControllerManager;
import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Vector;

/**
 * Created by laptopTCC on 12/31/2016.
 */
public class GameOverScene extends GameScene {
    Image gameOver = Utils.loadImage("resources/gameover-sheet0.png");
    Image restart = Utils.loadImage("resources/btnrestart-sheet0.png");
    MouseEvent e;
    Rectangle recRestart ;
    @Override
    public void run() {
       recRestart = new Rectangle(450,300,150,150);
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(gameOver,0, 0, 920, 720, null);
        //g.fillRect(450,300,150,50);
        g.drawImage(restart,450,300,150,150, null);
    }

    public boolean checkMouse(MouseEvent e) {
       if(recRestart.contains(e.getX(),e.getY())){
           return true;
       }
       return  false;
    }

    public void reset(){
        ControllerManager.bulletEnemy.removeAll();
        BodyManager.instance.removeAll();
        EnemyControllerManager.instance.removeAll();
        BodyManager.instance.register(NinjaController.instance);
        NinjaController.instance.getModel().setAlive(true);
        NinjaController.instance.setDartsControllers();
        NinjaController.instance.setLive(3);
    }
    public void mouseClicked(MouseEvent e){
        if(checkMouse(e)){
            this.sceneListener.back();
            reset();
        }
    }

}
