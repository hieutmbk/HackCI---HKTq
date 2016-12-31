package controllers.Scenes;

import controllers.NinjaController;
import controllers.managers.ControllerManager;
import controllers.managers.EnemyControllerManager;
import controllers.managers.TreeManager;
import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by laptopTCC on 12/31/2016.
 */
public class PlayScene extends GameScene {

    Image background;
    NinjaController ninjaController;
    TreeManager treeManager;
    EnemyControllerManager enemyControllerManager;

    public PlayScene(){
        treeManager = new TreeManager();
        enemyControllerManager = EnemyControllerManager.instance;
        treeManager.spawn();
        ninjaController = NinjaController.instance;
        background = Utils.loadImage("resources/sky-sheet1.png");
    }

    @Override
    public void run() {
        ninjaController.run();
        treeManager.run();
        enemyControllerManager.run();
        if(!NinjaController.instance.getModel().isAlive()){
            this.sceneListener.replaceScene(
                    new GameOverScene(),
                    true
            );
        }
    }

    @Override
    public void draw(Graphics g) {
        if(ninjaController.getLive() > 0) {g.drawString(String.valueOf("Point : "+ NinjaController.instance.point),20,100);
            Font font = new Font("Bauhaus 93",Font.BOLD,40);
            g.setFont(font);
            g.setColor(Color.ORANGE);
            g.drawImage(background, 0, 0, 920, 720, null);
            ninjaController.draw(g);
            treeManager.draw(g);
            enemyControllerManager.draw(g);
            ControllerManager.bulletEnemy.draw(g);
        }
        else {
            g.setFont(new Font("Algerian", Font.BOLD, 50));
            g.setColor(Color.RED);
            g.drawString("Game Over", 300, 400);}
    }

    @Override
    public void keyPress(KeyEvent e) {
        ninjaController.keyPressed(e);
    }

    public void mouseClicked(MouseEvent e) {};
}
