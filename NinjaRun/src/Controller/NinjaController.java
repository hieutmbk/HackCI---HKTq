package Controller;

import Models.Model;
import View.View;
import utils.Utils;

import java.awt.event.KeyEvent;

/**
 * Created by minhh on 17/12/2016.
 */
public class NinjaController extends  Controller {
    private static final int JUMPSPEED = -30;
    public boolean jumped = false;

    public NinjaController(Model model, View view) {
        super(model, view);
    }
    //Design parttern : Factory
    public static NinjaController creatNinja(int x,int y){
        NinjaController ninjaController = new NinjaController(
                new Model(x,y,70,50),
                new View(Utils.loadImage("resources/box-sheet0.png")));
        //System.out.println("TAO NINJIA");
        return ninjaController;
    }
    public void run(){
        
    }
    public void jump(){
        if(jumped == false){
            this.model.move(0,JUMPSPEED);
            jumped = true;
        }

    }
}
