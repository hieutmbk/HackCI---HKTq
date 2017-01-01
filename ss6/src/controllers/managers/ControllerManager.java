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

    protected Vector<Controller> controllers1;

    public ControllerManager() {
        this.controllers = new Vector<>();
        this.controllers1 = new Vector<>();

    }
    public static final ControllerManager bulletEnemy = new ControllerManager();
    public void run(){
        for(Controller controller : this.controllers){
            controller.run();
        }
        for(Controller controller : this.controllers1){
            controller.run();
        }
        Iterator<Controller> iterator = this.controllers.iterator();
        while(iterator.hasNext()){
            Controller controller = iterator.next();
            if(!controller.getModel().isAlive() || controller.getModel().getY()>920){
                iterator.remove();
            }
        }
    }

    public void draw(Graphics g){
        for(Controller controller : this.controllers){
            controller.draw(g);
        }
        for (Controller controller : this.controllers1){
            controller.draw(g);
        }
    }


    public void add(Controller controller){
        this.controllers.add(controller);
    }

    public void addTree(Controller controller){this.controllers1.add(controller);}
    public void removeAll(){
        this.controllers = new Vector<>();
        this.controllers1 = new Vector<>();

    }


}
