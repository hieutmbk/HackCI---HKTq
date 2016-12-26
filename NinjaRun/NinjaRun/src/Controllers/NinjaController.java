package Controllers;

import Managers.BodyManager;
import Models.Model;
import Views.Animation;
import Views.BaseView;
import Views.View;
import utils.Utils;

import javax.rmi.CORBA.Util;
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
    private int inTree1 = 0;



    public NinjaController(Model model, BaseView view, KeySetting keySetting) {
        super(model, view);
        BodyManager.instance.register(this);
        this.keySetting = keySetting;
        this.dartsControllers = new Vector<>();
    }
    public static NinjaController creatNinja(int x, int y, KeySetting keySetting){
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
    }


    public void draw(Graphics g){
        super.draw(g);

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

        if(keySetting != null){
            int keyCode = e.getKeyCode();
                if(keyCode==keySetting.getKeyFire()){
                    DartsController dartsController = new DartsController(new Model(this.model.getX()+ 45, this.model.getY()-50, 8, 35), new View(Utils.loadImage("resources/darts.png")));
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


    @Override
    public void onContact(Body other) {

    }
}
