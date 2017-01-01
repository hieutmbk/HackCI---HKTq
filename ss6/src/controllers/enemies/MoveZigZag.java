package controllers.enemies;

/**
 * Created by ToanTV on 12/28/2016.
 */
public class MoveZigZag implements MoveBehavior{
   private int count;
    @Override
    public void doMove(EnemyController enemyController) {
        count++;
        if(count == 100) {
            if (enemyController.getModel().getX() == EnemyController.X1) {
                enemyController.getModel().setX(EnemyController.X2);
            } else if (enemyController.getModel().getX() == EnemyController.X2) {
                enemyController.getModel().setX(EnemyController.X1);
            } else if (enemyController.getModel().getX() == EnemyController.X3) {
                enemyController.getModel().setX(EnemyController.X4);
            } else if (enemyController.getModel().getX() == EnemyController.X4) {
                enemyController.getModel().setX(EnemyController.X3);
            }
            count = 0;
        }
        enemyController.getModel().move(0, 3);
    }
}
