package Managers;

import Controllers.Controller;

import java.awt.*;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Vector;

/**
 * Created by QuanLA on 12/17/2016.
 */
public class ControllerManager {
    protected Vector<Controller> tree1;

    public ControllerManager() {
        this.tree1 = new Vector<>();

    }

    public void run(){
        for(Controller controller : this.tree1){
            controller.run();
        }
        Iterator<Controller> iterator = this.tree1.iterator();
        while(iterator.hasNext()){
            Controller controller = iterator.next();
            if(!controller.getModel().isAlive() ){
                iterator.remove();
            }
        }
    }

    public void draw(Graphics g){
        for(Controller controller : this.tree1){
            controller.draw(g);
        }
    }

    public void removeRoad(Controller controller){
        this.tree1.remove(controller);
    }

    public void addRoad(Controller controller){
        this.tree1.add(controller);
    }



}
