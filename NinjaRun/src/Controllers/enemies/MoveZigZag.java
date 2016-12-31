package controllers.enemies;

/**
 * Created by ToanTV on 12/28/2016.
 */
public class MoveZigZag implements MoveBehavior{
    public MoveZigZag(){

    }
    @Override
    public void doMove(EnemyController enemyController) {
        if(enemyController.getModel().getX() == 266 || enemyController.getModel().getX() == 330){
            enemyController.dx = 1;
            enemyController.dy = 2;
        }
        else if(enemyController.getModel().getX()== 570 || enemyController.getModel().getX() == 640){
            enemyController.dx = -1;
            enemyController.dy = 2;
        }
        enemyController.getModel().move(enemyController.dx, enemyController.dy);
    }
}
