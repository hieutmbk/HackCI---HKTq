package controllers.managers;

import controllers.BaseController;
import controllers.enemies.EnemyController;
import controllers.gifts.GiftController;
import controllers.gifts.TypeGift;

import java.util.Random;

/**
 * Created by QuanLA on 1/1/2017.
 */
public class GiftControllerManager extends ControllerManager implements BaseController{
    int counter;
    TypeGift typeGift;
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
    private int giftcount, X;
    private void spawn() {
        giftcount++;
        Random rd = new Random();
        int rand = rd.nextInt(3);
        switch (rand){
            case 0:
                X = EnemyController.X1;
                break;
            case  1:
                X = EnemyController.X2;
                break;
            case  2:
                X = EnemyController.X3;
                break;
            case  3:
                X = EnemyController.X4;
                break;
        }
        GiftController giftController = null;
        if(giftcount % 2 ==0){
            giftController = GiftController.create(X, 0 , TypeGift.HP);
        }
        else{
            giftController = GiftController.create(X, 0, TypeGift.MANA);
        }
        this.controllers.add(giftController);
    }
}
