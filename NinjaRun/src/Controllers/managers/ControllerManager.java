package controllers.managers;

import controllers.BaseController;
import controllers.Controller;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by QuanLA on 12/17/2016.
 */
public class ControllerManager implements BaseController {
    protected Vector<Controller> controllers;

    public ControllerManager() {
        this.controllers = new Vector<>();

    }
    public static final ControllerManager bulletEnemy = new ControllerManager();
    public void run(){
        for(Controller controller : this.controllers){
            controller.run();
        }
        Iterator<Controller> iterator = this.controllers.iterator();
        while(iterator.hasNext()){
            Controller controller = iterator.next();
            if(!controller.getModel().isAlive() ){
                iterator.remove();
            }
        }
    }

    public void draw(Graphics g){
        for(Controller controller : this.controllers){
            controller.draw(g);
        }
    }

    public void remove(Controller controller){
        this.controllers.remove(controller);
    }

    public void add(Controller controller){
        this.controllers.add(controller);
    }



}
