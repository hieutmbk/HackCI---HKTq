package controllers.managers;

import controllers.BaseController;
import controllers.enemies.EnemyController;
import controllers.gifts.GiftController;
import views.BaseView;

import java.util.Random;

/**
 * Created by QuanLA on 1/1/2017.
 */
public class GiftControllerManager extends ControllerManager implements BaseController{
    int counter;
    public static final GiftControllerManager instance = new GiftControllerManager();
    @Override
    public void run() {
        super.run();
        counter++;
        if (counter == 300) {
            spawn();
            counter = 0;
        }
    }

    private void spawn() {
        Random rd = new Random();
        int rand = rd.nextInt(3);
        GiftController giftController = null;
        switch (rand){
            case 0:
                giftController = GiftController.create(EnemyController.X1,0);
                break;
            case  1:
                giftController = GiftController.create(EnemyController.X2,0);
                break;
            case  2:
                giftController = GiftController.create(EnemyController.X3,0);
                break;
            case  3:
                giftController = GiftController.create(EnemyController.X4,0);
                break;
        }
        this.controllers.add(giftController);
    }
}
