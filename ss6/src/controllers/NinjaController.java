package controllers;

import Models.Character;
import Models.Model;
import controllers.enemies.BulletEnemyController;
import controllers.enemies.EnemyController;
import controllers.managers.BodyManager;
import controllers.managers.TreeManager;
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
    private int countDart;

    public int getCountDart() {
        return countDart;
    }

    public void setCountDart(int countDart) {
        this.countDart = countDart;
    }

    public void setDartsControllers() {
        this.dartsControllers = new Vector<>();
    }
    private int check =0;
    private int inTree1 = 0;
    private int count=0;
    private int count1=0;
    private int timeFire = 0;
    Vector<BufferedImage> bufferedImageVector = new Vector<>();
    Vector<BufferedImage> bufferedImageVector1 = new Vector<>();


    public static final NinjaController instance = NinjaController.creatNinja(200, 550,
            new KeySetting(KeyEvent.VK_F, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT,KeyEvent.VK_H));

    private NinjaController(Model model, BaseView view, KeySetting keySetting) {
        super(model, view);
        Character.setHp(5);
        Character.setLive(3);
        Character.setMana(0);
        BodyManager.instance.register(this);
        this.keySetting = keySetting;
        this.dartsControllers = new Vector<>();
        bufferedImageVector.add(Utils.loadImage("resources/Run01.png"));
        bufferedImageVector.add(Utils.loadImage("resources/Run02.png"));
        bufferedImageVector.add(Utils.loadImage("resources/Run03.png"));
        bufferedImageVector.add(Utils.loadImage("resources/Run04.png"));
        bufferedImageVector.add(Utils.loadImage("resources/Run05.png"));
        bufferedImageVector.add(Utils.loadImage("resources/Run06.png"));
        bufferedImageVector.add(Utils.loadImage("resources/Run07.png"));
        bufferedImageVector.add(Utils.loadImage("resources/Run08.png"));
        bufferedImageVector.add(Utils.loadImage("resources/Run09.png"));

        bufferedImageVector1.add(Utils.loadImage("resources/Run1.png"));
        bufferedImageVector1.add(Utils.loadImage("resources/Run2.png"));
        bufferedImageVector1.add(Utils.loadImage("resources/Run3.png"));
        bufferedImageVector1.add(Utils.loadImage("resources/Run4.png"));
        bufferedImageVector1.add(Utils.loadImage("resources/Run5.png"));
        bufferedImageVector1.add(Utils.loadImage("resources/Run6.png"));
        bufferedImageVector1.add(Utils.loadImage("resources/Run7.png"));
        bufferedImageVector1.add(Utils.loadImage("resources/Run8.png"));
        bufferedImageVector1.add(Utils.loadImage("resources/Run9.png"));
    }
    private static NinjaController creatNinja(int x, int y, KeySetting keySetting){
        Vector<BufferedImage> bufferedImageVector = new Vector<>();
        bufferedImageVector.add(Utils.loadImage("resources/Run1.png"));
        bufferedImageVector.add(Utils.loadImage("resources/Run2.png"));
        bufferedImageVector.add(Utils.loadImage("resources/Run3.png"));
        bufferedImageVector.add(Utils.loadImage("resources/Run4.png"));
        bufferedImageVector.add(Utils.loadImage("resources/Run5.png"));
        bufferedImageVector.add(Utils.loadImage("resources/Run6.png"));
        bufferedImageVector.add(Utils.loadImage("resources/Run7.png"));
        bufferedImageVector.add(Utils.loadImage("resources/Run8.png"));
        bufferedImageVector.add(Utils.loadImage("resources/Run9.png"));

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
            if (Character.getLive() >= 1 && count > 80) {
                count = 0;
                this.getModel().setAlive(true);
                BodyManager.instance.register(this);
                Character.setHp(5);
            }
        }
        else if(getModel().isAlive()){
            count1 ++;
            if(count1 % 58 == 0){
                Character.setPoint(Character.getPoint() + Character.getCombo()+1);
                count1 = 0;
            }
        }
        if(Character.getMaxCombo() < Character.getCombo()) {
            Character.setMaxCombo(Character.getCombo());
        }
    }


    public void draw(Graphics g){
        if(getModel().isAlive()) super.draw(g);

        for(DartsController dartsController : this.dartsControllers){
            dartsController.draw(g);
        }
        g.setFont(new Font("Bauhaus 93", Font.BOLD, 30));
        g.setColor(Color.YELLOW);
        g.drawString(String.valueOf(Character.getLive()), 830, 85);
        g.drawString(String.valueOf(countDart), 830, 135);
        g.drawImage(Utils.loadImage("resources/ninja06.png"), 850, 60, 40, 40, null);
        g.drawImage(Utils.loadImage("resources/darts.png"),860,100,20,40,null);
        if(this.check==1){
            timeFire++;
            g.drawImage(Utils.loadImage("resources/water.png"),NinjaController.instance.getModel().getX(), 0 , 100, NinjaController.instance.getModel().getY(), null );
            if(timeFire>20){
                check = 0;
                timeFire=0;
            }
        }
    }
    public void keyPressed(KeyEvent e){

        if(keySetting != null && this.getModel().isAlive()){
            int keyCode = e.getKeyCode();
            if(keyCode == keySetting.getKeyShootFire()){
                if(Character.getMana() == 5){
                    if(!Model.mute)
                        Utils.playSound("resources/Laser.wav", false);
                    check = 1;
                    Character.setMana(0);
                    for(int i =0; i<BodyManager.instance.getBodies().size(); i++){
                        if(BodyManager.instance.getBodies().get(i).getModel().getX() > NinjaController.instance.getModel().getX() && BodyManager.instance.getBodies().get(i).getModel().getX() < NinjaController.instance.getModel().getX() + 100 && BodyManager.instance.getBodies().get(i).getModel().getY() > 0&& BodyManager.instance.getBodies().get(i).getModel().getY() < NinjaController.instance.getModel().getY()){
                            if(BodyManager.instance.getBodies().get(i) instanceof EnemyController || BodyManager.instance.getBodies().get(i) instanceof BulletEnemyController){
                                BodyManager.instance.getBodies().get(i).getModel().setAlive(false);
                            }
                        }
                    }
                }
            }
                if(keyCode==keySetting.getKeyFire()){
                    if(countDart>0) {
                        DartsController dartsController = new DartsController(new Model(this.model.getX() + 45, this.model.getY() - 50, 8, 35), new View(Utils.loadImage("resources/darts.png")));
                        this.dartsControllers.add(dartsController);
                        if (!Model.mute) {
                            Utils.playSound("resources/Laser.wav", false);
                        }
                        countDart--;
                    }
                }
                if(keyCode==keySetting.getKeyRight()){
                    if(TreeManager.instance.getStop()==0) {
                        check = 0;
                        if (this.inTree1 == 0) {
                            this.getView().setBufferedImages(bufferedImageVector);
                            this.getModel().setX(200 + 130);
                            this.inTree1 = 1;
                        } else if (this.inTree1 == 1) {
                            this.getView().setBufferedImages(bufferedImageVector1);
                            this.getModel().setX(510);
                            this.inTree1 = 2;
                        } else if (this.inTree1 == 2) {
                            this.getView().setBufferedImages(bufferedImageVector);
                            this.getModel().setX(640);
                            this.inTree1 = 3;
                        }
                    }
                }
                if(keyCode==keySetting.getKeyLeft()){
                    if(TreeManager.instance.getStop()==0) {
                        check = 0;
                        if (this.inTree1 == 1) {
                            this.getView().setBufferedImages(bufferedImageVector1);
                            this.getModel().setX(200);
                            this.inTree1 = 0;
                        } else if (this.inTree1 == 2) {
                            this.getView().setBufferedImages(bufferedImageVector);
                            this.getModel().setX(330);
                            this.inTree1 = 1;
                        } else if (this.inTree1 == 3) {
                            this.getView().setBufferedImages(bufferedImageVector1);
                            this.getModel().setX(510);
                            this.inTree1 = 2;
                        }
                    }
                }

        }
    }

    @Override
    public void onContact(Body other) {
        if(other instanceof BulletEnemyController||other instanceof EnemyController){
            Character.setHp(Character.getHp()-1);
            Character.setCombo(0);
            if(Character.getHp()==0) {
                Character.setLive(Character.getLive() - 1);
                this.getModel().setAlive(false);
                Character.setHp(5);
            }
            if(other instanceof EnemyController){
                if(!Model.mute) {
                    Utils.playSound("resources/Explosion.wav", false);
                }
                if(Character.getMana()<5){
                    Character.setMana(Character.getMana()+1);
                    System.out.println(Character.getMana());
                }
            }
        }
    }
}
