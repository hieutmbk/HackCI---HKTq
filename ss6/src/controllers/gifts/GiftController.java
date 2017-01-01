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
    int type;
    public GiftController(Model model, BaseView view, int type) {
        super(model, view);
        BodyManager.instance.register(this);
        this.type = type;
    }
    public void run() {
        super.run();
        model.move(0, 1);
    }

    public static GiftController create(int x, int y, TypeGift typeGift) {
        switch (typeGift) {
            case HP:
                return new GiftController(new Model(x, y, 20, 20), new View(Utils.loadImage("resources/gift.png")), 1);
            case MANA:
                return new GiftController(new Model(x, y, 20, 20), new View(Utils.loadImage("resources/mana.png")), 2);
        }
        return null;
    }

    @Override
    public void onContact(Body other) {
        if(other instanceof NinjaController){
            if(Character.getMana() <5 && this.type == 2) {
                Character.setMana(Character.getMana()+1);
            }
            if(Character.getHp() <5 && this.type == 1) {
                Character.setHp(Character.getHp()+1);
            }

            this.getModel().setAlive(false);
        }
    }
}
