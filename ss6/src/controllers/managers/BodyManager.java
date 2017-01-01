package controllers.managers;

import controllers.BaseController;
import controllers.Body;
import Models.Model;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by ToanTV on 12/27/2016.
 */
public class BodyManager implements BaseController {
    private Vector<Body> bodies;

    public Vector<Body> getBodies() {
        return bodies;
    }

    public static final BodyManager instance = new BodyManager();

    private BodyManager(){
        bodies = new Vector<>();
    }

    public void register(Body body){
        this.bodies.add(body);
    }
    public void run() {

        for(int i = 0; i < bodies.size() -  1; i++){
            for(int j = i+1; j < bodies.size(); j++){
                Body bodyi = bodies.get(i);
                Body bodyj = bodies.get(j);

                Model modeli = bodyi.getModel();
                Model modelj = bodyj.getModel();

                if(modeli.intersects(modelj)){
                    bodyi.onContact(bodyj);
                    bodyj.onContact(bodyi);
                }
            }
        }
        Iterator<Body> iterator = this.bodies.iterator();
        while(iterator.hasNext()){
            Body body = iterator.next();
            if(!body.getModel().isAlive() || body.getModel().getY() > 920) iterator.remove();
        }
    }
    public void removeAll(){
        this.bodies = new Vector<>();
    }

    @Override
    public void draw(Graphics g) {

    }

}
