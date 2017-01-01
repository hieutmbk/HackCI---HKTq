package controllers.enemies;

/**
 * Created by ToanTV on 12/28/2016.
 */
public class MoveDownBehavior implements MoveBehavior {
    @Override
    public void doMove(EnemyController enemyController) {
        enemyController.getModel().move(0,3);
    }
}
