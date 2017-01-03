package controllers.enemies;

import Models.Model;
import controllers.managers.ControllerManager;

/**
 * Created by ToanTV on 12/28/2016.
 */
public class ShootDownBehavior implements ShootBehavior {
    @Override
    public void doShoot(EnemyController enemyController) {
        int x = enemyController.getModel().getMidX();
        int y = enemyController.getModel().getBottom();
        BulletEnemyController bulletEnemyController = BulletEnemyController.create(x, y);
        bulletEnemyController.dx = 0;
        bulletEnemyController.dy = Model.SPEED + 4;
        ControllerManager.bulletEnemy.add(bulletEnemyController);

    }
}
