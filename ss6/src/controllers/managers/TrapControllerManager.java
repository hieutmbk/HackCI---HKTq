package controllers.managers;

import controllers.BaseController;
import controllers.TrapController;
import controllers.enemies.EnemyController;

import java.util.Random;

/**
 * Created by QuanLA on 1/1/2017.
 */
public class TrapControllerManager extends ControllerManager implements BaseController {
    int time = 0;
    public static final TrapControllerManager instance = new TrapControllerManager();

    public void run(){
        super.run();
        time++;
        if (time == 500) {
            spawn();
            time = 0;
        }
    }


    public void spawn(){
        Random rd = new Random();
        int rand = rd.nextInt(3);
        TrapController trapController = null;
        switch (rand){
            case 0:
                trapController = TrapController.create(EnemyController.X1+40,0);
                break;
            case  1:
                trapController = TrapController.create(EnemyController.X2-30,0);
                break;
            case  2:
                trapController = TrapController.create(EnemyController.X3+40,0);
                break;
            case  3:
                trapController = TrapController.create(EnemyController.X4-30,0);
                break;
        }
        this.controllers.add(trapController);
    }
}
