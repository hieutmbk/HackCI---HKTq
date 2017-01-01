package controllers.gifts;

import Models.Character;
import Models.Model;
import controllers.BaseController;
import controllers.Body;
import controllers.Controller;
import controllers.NinjaController;
import controllers.managers.BodyManager;
import utils.Utils;
import views.BaseView;
import views.View;

import java.util.ConcurrentModificationException;

/**
 * Created by QuanLA on 1/1/2017.
 */
public class GiftController extends Controller implements Body, BaseController {
    public GiftController(Model model, BaseView view) {
        super(model, view);
        BodyManager.instance.register(this);
    }
    public void run() {
        super.run();
        model.move(0, 1);
    }

    public static GiftController create(int x, int y) {
        return new GiftController(
                new Model(x, y, 20, 20),
                new View(Utils.loadImage("resources/gift.png")) {
                }
        );
    }
    @Override
    public void onContact(Body other) {
        if(other instanceof NinjaController){
            if(Character.getHp() <5) {
                Character.setHp(Character.getHp()+1);
            }
            this.getModel().setAlive(false);
        }
    }
}
