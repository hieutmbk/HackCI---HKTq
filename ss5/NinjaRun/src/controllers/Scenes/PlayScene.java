package controllers.Scenes;

import Models.Character;
import Models.Model;
import controllers.BaseController;
import controllers.NinjaController;
import controllers.managers.*;
import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Vector;

/**
 * Created by laptopTCC on 12/31/2016.
 */
public class PlayScene extends GameScene {

    Vector<BaseController> baseControllers;
    Image background;
    TreeManager treeManager;

    public PlayScene(){
        treeManager = new TreeManager();
        baseControllers = new Vector<>();
        baseControllers.add(GiftControllerManager.instance);
        baseControllers.add(NinjaController.instance);
        baseControllers.add(treeManager);
        baseControllers.add(EnemyControllerManager.instance);
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
        g.drawString(String.valueOf("Point : " + Character.getPoint()), 20, 100);
        g.drawString(String.valueOf("HP : " + Character.getHp()), 20, 150);
        g.drawString(String.valueOf("COMBO : " + Character.getMaxCombo()) ,20,200);
        g.setColor(Color.red);
        g.drawString(String.valueOf("Combo x " + Character.getCombo()),350,700);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        NinjaController.instance.keyPressed(e);
        if(e.getKeyCode() == KeyEvent.VK_P){
            Model.onGame = !Model.onGame;
        }
    }

    @Override
    public void run() {
        for(BaseController baseController : this.baseControllers){
            baseController.run();
        }
        if(Character.getLive()<1){
            this.sceneListener.replaceScene(new GameOverScene(), true);
            Character.setPoint(0);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("ddd");

    }}
