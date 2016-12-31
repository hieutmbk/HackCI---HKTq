package controllers;

import Models.Model;
import controllers.enemies.BulletEnemyController;
import controllers.enemies.EnemyController;
import controllers.managers.BodyManager;
import views.Animation;
import views.BaseView;
import views.View;
import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by minhh on 17/12/2016.
 */
public class NinjaController extends  Controller implements Body {
    private KeySetting keySetting;
    private Vector<DartsController> dartsControllers;

    public Vector<DartsController> getDartsControllers() {
        return dartsControllers;
    }

    public void setDartsControllers() {
        this.dartsControllers = new Vector<>();
    }

    private int inTree1 = 0;
    private int live = 3;

    public void setLive(int live) {
        this.live = live;
    }

    private int count;
    public static int point = 0;
    public static final NinjaController instance = NinjaController.creatNinja(200, 550,
            new KeySetting(KeyEvent.VK_F, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_UP, KeyEvent.VK_DOWN));
    public int getLive() {
        return live;
    }

    private NinjaController(Model model, BaseView view, KeySetting keySetting) {
        super(model, view);
        BodyManager.instance.register(this);
        this.keySetting = keySetting;
        this.dartsControllers = new Vector<>();
    }
    private static NinjaController creatNinja(int x, int y, KeySetting keySetting){
        Vector<BufferedImage> bufferedImageVector = new Vector<>();
        bufferedImageVector.add(Utils.loadImage("resources/ninjarun1.png"));
        bufferedImageVector.add(Utils.loadImage("resources/ninjarun2.png"));

        NinjaController ninjaController = new NinjaController(
                new Model(x,y,100,60),
                new Animation(bufferedImageVector), keySetting);
        return ninjaController;
    }
    public void run(){
        super.run();

        for(DartsController dartsController : this.dartsControllers){
            dartsController.run();
        }
        Iterator<DartsController> iterator = this.dartsControllers.iterator();
        while(iterator.hasNext()){
            DartsController dartsController = iterator.next();
            if(!dartsController.getModel().isAlive()) iterator.remove();
        }
        if(getModel().isAlive() == false) {
            count++;
            if (live >= 1 && count > 80) {
                count = 0;
                this.getModel().setAlive(true);
                BodyManager.instance.register(this);
            }
        }
        else if(getModel().isAlive()){
            count ++;
            if(count % 58 == 0){
                point++;
            }
        }
    }


    public void draw(Graphics g){
        if(getModel().isAlive()) super.draw(g);

        for(DartsController dartsController : this.dartsControllers){
            dartsController.draw(g);
        }
    }
    public void keyPressed(KeyEvent e){
        Vector<BufferedImage> bufferedImageVector = new Vector<>();
        bufferedImageVector.add(Utils.loadImage("resources/ninjarun01.png"));
        bufferedImageVector.add(Utils.loadImage("resources/ninjarun02.png"));

        Vector<BufferedImage> bufferedImageVector1 = new Vector<>();
        bufferedImageVector1.add(Utils.loadImage("resources/ninjarun1.png"));
        bufferedImageVector1.add(Utils.loadImage("resources/ninjarun2.png"));

        if(keySetting != null && this.getModel().isAlive()){
            int keyCode = e.getKeyCode();
                if(keyCode==keySetting.getKeyFire()){
                    DartsController dartsController = new DartsController(new Model(this.model.getX()+ 45, this.model.getY()-50, 8, 35 ), new View(Utils.loadImage("resources/darts.png")));
                    this.dartsControllers.add(dartsController);
                }
                if(keyCode==keySetting.getKeyRight()){
                    if(this.inTree1==0) {
                        this.getView().setBufferedImages(bufferedImageVector);
                        this.getModel().setX(200 + 130);
                        this.inTree1 = 1;
                    }
                    else if (this.inTree1==1) {
                        this.getView().setBufferedImages(bufferedImageVector1);
                        this.getModel().setX(510);
                        this.inTree1 = 2;
                    }
                    else if(this.inTree1==2){
                        this.getView().setBufferedImages(bufferedImageVector);
                        this.getModel().setX(640);
                        this.inTree1 = 3;
                    }
                }
                if(keyCode==keySetting.getKeyLeft()){
                    if(this.inTree1==1) {
                        this.getView().setBufferedImages(bufferedImageVector1);
                        this.getModel().setX(200);
                        this.inTree1 = 0;
                    }
                    else if(this.inTree1==2){
                        this.getView().setBufferedImages(bufferedImageVector);
                        this.getModel().setX(330);
                        this.inTree1 = 1;
                    }
                    else if(this.inTree1==3){
                        this.getView().setBufferedImages(bufferedImageVector1);
                        this.getModel().setX(510);
                        this.inTree1 = 2;
                    }
                }
                if(keyCode==keySetting.getKeyUp()){
                    this.getModel().move(0,-5);
                }
                if (keyCode==keySetting.getKeyDown()){
                    this.getModel().move(0,7);
                }
        }
    }




    @Override
    public void onContact(Body other) {
        if(other instanceof BulletEnemyController||other instanceof EnemyController){
            live--;
            this.getModel().setAlive(false);
        }
    }
}
