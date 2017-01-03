package controllers;

import Models.Character;
import Models.Model;
import controllers.enemies.EnemyController;
import controllers.managers.BodyManager;
import views.BaseView;

/**
 * Created by QuanLA on 12/17/2016.
 */
public class DartsController extends Controller implements Body, BaseController{
    public DartsController(Model model, BaseView view) {
        super(model, view);
        BodyManager.instance.register(this);
    }

    public void run(){
        super.run();
        this.model.move(0, -5);
        if(this.model.getY() < 0){
            this.getModel().setAlive(false);
        }
    }

    @Override
    public void onContact(Body other) {
        if(other instanceof EnemyController ){
            System.out.println("clgt");
            this.getModel().setAlive(false);
            Character.setPoint(Character.getPoint()+5);
        }
    }
}
