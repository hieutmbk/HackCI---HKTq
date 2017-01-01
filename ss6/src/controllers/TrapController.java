package controllers;

import Models.Model;
import controllers.managers.BodyManager;
import controllers.managers.TreeManager;
import utils.Utils;
import views.BaseView;
import views.View;

/**
 * Created by QuanLA on 1/1/2017.
 */
public class TrapController extends Controller implements Body, BaseController{
    public TrapController(Model model, BaseView view) {
        super(model, view);
        BodyManager.instance.register(this);
    }

    public void run() {
        super.run();
        model.move(0, 2);
    }

    public static TrapController create(int x, int y) {
        return new TrapController(
                new Model(x, y, 30, 30),
                new View(Utils.loadImage("resources/Stone.png")) {
                }
        );
    }

    @Override
    public void onContact(Body other) {
        if(other instanceof NinjaController){
            this.getModel().setAlive(false);
            TreeManager.instance.setStop(1);
        }
    }
}
