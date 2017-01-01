package controllers.managers;

import controllers.BaseController;
import controllers.enemies.EnemyController;
import controllers.enemies.TypeEnemy;

import java.util.Random;
import java.util.Vector;

/**
 * Created by ToanTV on 12/27/2016.
 */
public class EnemyControllerManager extends ControllerManager implements BaseController{
    private int countEnemy;
    public static final EnemyControllerManager instance = new EnemyControllerManager();
    public void spawn(){
        Random rd = new Random();
        int x = rd.nextInt(4);
        int y = rd.nextInt(3);
        TypeEnemy typeEnemy = null;
        switch (y){
            case 0: typeEnemy = TypeEnemy.WHITE;
                break;
            case 1: typeEnemy = TypeEnemy.SPEED;
                break;
            case 2: typeEnemy = TypeEnemy.ZZ;
                break;
        }
        EnemyController enemyController = null;
        switch (x){
            case 0: {
                enemyController = EnemyController.createEnemy(EnemyController.X1, 0, typeEnemy);
                break;
            }
            case 1: {
                enemyController = EnemyController.createEnemy(EnemyController.X2, 0, typeEnemy);
                break;
            }
            case 2:{
                enemyController = EnemyController.createEnemy(EnemyController.X3, 0, typeEnemy);
                break;
            }
            case 3:{
                enemyController = EnemyController.createEnemy(EnemyController.X4, 0, typeEnemy);
            }
        };
        this.controllers.add(enemyController);
    }

    @Override
    public void run() {
        super.run();
        countEnemy++;
        if(countEnemy > 100) {
            spawn();
            countEnemy = 0;
        }
    }

    @Override
    public void removeAll() {
        super.removeAll();
        this.controllers = new Vector<>();
    }
}
