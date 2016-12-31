package controllers;

import Models.Model;
import controllers.enemies.BulletEnemyController;
import controllers.enemies.EnemyController;
import controllers.managers.BodyManager;
import views.Animation;
import views.BaseView;
import views.View;
import utils.Utils;

import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by minhh on 17/12/2016.
 */
public class NinjaController extends  Controller implements Body, BaseController {
    private KeySetting keySetting;
    private Vector<DartsController> dartsControllers;
    private int hp;

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

    private int count=0;
    private int count1=0;
    private int point = 0;
    public static final NinjaController instance = NinjaController.creatNinja(200, 550,
            new KeySetting(KeyEvent.VK_F, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT));
    public int getLive() {
        return live;
    }

    private NinjaController(Model model, BaseView view, KeySetting keySetting) {
        super(model, view);
        this.hp = 5;
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
                hp = 5;
            }
        }
        else if(getModel().isAlive()){
            count1 ++;
            if(count1 % 58 == 0){
                point++;
                count1 = 0;
            }
        }
    }


    public void draw(Graphics g){
        if(getModel().isAlive()) super.draw(g);

        for(DartsController dartsController : this.dartsControllers){
            dartsController.draw(g);
        }
        g.setFont(new Font("Bauhaus 93", Font.BOLD, 30));
        g.setColor(Color.YELLOW);
        g.drawString(String.valueOf(this.getLive()), 830, 85);
        g.drawImage(Utils.loadImage("resources/ninja06.png"), 850, 60, 40, 40, null);

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

        }
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public void onContact(Body other) {
        if(other instanceof BulletEnemyController||other instanceof EnemyController){
            hp--;
            if(hp==0) {
                live--;
                this.getModel().setAlive(false);
                hp=5;
            }
        }
    }
}
