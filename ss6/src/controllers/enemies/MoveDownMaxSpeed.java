package controllers.enemies;

import Models.Model;

/**
 * Created by ToanTV on 12/28/2016.
 */
public class MoveDownMaxSpeed implements MoveBehavior {
    @Override
    public void doMove(EnemyController enemyController) {
        enemyController.getModel().move(0,Model.SPEED+4);
    }
}
