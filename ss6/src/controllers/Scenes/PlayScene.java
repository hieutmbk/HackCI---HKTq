package controllers.Scenes;

import Models.Character;
import Models.Model;
import controllers.BaseController;
import controllers.NinjaController;
import controllers.managers.*;
import utils.Utils;

import javax.sound.sampled.BooleanControl;
import javax.sound.sampled.Clip;
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
    Clip clip;
    long time;
    int count;
    public PlayScene(){
        baseControllers = new Vector<>();
        baseControllers.add(GiftControllerManager.instance);
        baseControllers.add(NinjaController.instance);
        baseControllers.add(TreeManager.instance);
        baseControllers.add(EnemyControllerManager.instance);
        baseControllers.add(ControllerManager.bulletEnemy);
        baseControllers.add(BodyManager.instance);
        baseControllers.add(TrapControllerManager.instance);
        background = Utils.loadImage("resources/sky-sheet1.png");
        TreeManager.instance.spawn();
        clip = Utils.playSound("resources/musictheme.wav",true);
    }

    @Override
    public void update(Graphics g) {
        g.drawImage(background, 0, 0, 920, 720, null);
        for (BaseController baseController : this.baseControllers) {
            baseController.draw(g);
        }
        Font font = new Font("Bauhaus 93", Font.BOLD, 20);
        g.setFont(font);
        g.setColor(Color.ORANGE);
        g.drawString(String.valueOf("Point : " + Character.getPoint()), 20, 100);
        g.drawString(String.valueOf("HP : " + Character.getHp()), 20, 150);
        g.drawString(String.valueOf("MaxCOMBO : " + Character.getMaxCombo()) ,20,250);
        g.drawString(String.valueOf("Mana : ") ,20,200);
        g.setColor(Color.red);
        g.drawString(String.valueOf("Combo x " + Character.getCombo()),350,700);
        g.setColor(Color.blue);
        g.fillRect(90,185,20*Character.getMana(),20);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        NinjaController.instance.keyPressed(e);
        if(e.getKeyCode() == KeyEvent.VK_P){
            Model.onGame = !Model.onGame;
            if(!Model.onGame){
                time = clip.getMicrosecondPosition();
                clip.stop();
            }
            else{
                clip.setMicrosecondPosition(time);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_W){
            this.sceneListener.replaceScene(new GameWinScene(),true);
            clip.stop();
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            Model.mute = !Model.mute;
            BooleanControl muteControl;
            muteControl = (BooleanControl) clip.getControl(BooleanControl.Type.MUTE);
            if(Model.mute){
                muteControl.setValue(true);
            }
            else{
                muteControl.setValue(false);
            }

        }
    }

    @Override
    public void run() {
        count++;
        for(BaseController baseController : this.baseControllers){
            baseController.run();
        }
        if(count >= 1000 && Model.SPEED <10){
            Model.SPEED++;
            count = 0;
        }
        if(Character.getLive()<1){
            this.sceneListener.replaceScene(new GameOverScene(), true);

        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("ddd");

    }}
