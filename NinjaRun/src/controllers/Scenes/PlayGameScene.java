package controllers.Scenes;

import controllers.BaseController;
import controllers.NinjaController;
import controllers.managers.BodyManager;
import controllers.managers.ControllerManager;
import controllers.managers.EnemyControllerManager;
import controllers.managers.TreeManager;
import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Vector;

/**
 * Created by QuanLA on 12/31/2016.
 */
public class PlayGameScene extends GameScene {
    Vector<BaseController> baseControllers;
    Image background;
    TreeManager treeManager;

    public PlayGameScene(){
        treeManager = new TreeManager();
        baseControllers = new Vector<>();
        baseControllers.add(NinjaController.instance);
        baseControllers.add(treeManager);
        baseControllers.add(new EnemyControllerManager());
        baseControllers.add(ControllerManager.bulletEnemy);
        baseControllers.add(BodyManager.instance);
        background = Utils.loadImage("resources/sky-sheet1.png");
        treeManager.spawn();
    }

    @Override
    public void update(Graphics g) {
        g.drawImage(background, 0, 0, 920, 720, null);
        for (BaseController baseController : this.baseControllers) {
            baseController.draw(g);
        }
        Font font = new Font("Bauhaus 93", Font.BOLD, 40);
        g.setFont(font);
        g.setColor(Color.ORANGE);
        g.drawString(String.valueOf("Point : " + NinjaController.instance.point), 20, 100);

    }

    @Override
    public void run() {
        for(BaseController baseController : this.baseControllers){
            baseController.run();
        }
        if(NinjaController.instance.getLive()<1){
            this.sceneListener.replaceScene(new GameOverScene(), true);
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        NinjaController.instance.keyPressed(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("ddd");

    }
}
