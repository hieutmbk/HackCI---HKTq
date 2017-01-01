package controllers.enemies;

import controllers.NinjaController;
import controllers.managers.ControllerManager;

/**
 * Created by ToanTV on 12/28/2016.
 */
public class ShootOnTarget implements ShootBehavior {
    private final int SPEED = 5;
    private boolean fire = true;
    @Override
    public void doShoot(EnemyController enemyController) {
        if(fire) {
            int x = enemyController.getModel().getMidX();
            int y = enemyController.getModel().getBottom();

            NinjaController ninjaController = NinjaController.instance;
            int dx = ninjaController.getModel().getX() - enemyController.getModel().getX();
            int dy = ninjaController.getModel().getY() - enemyController.getModel().getY();
            double length = Math.sqrt(dx * dx + dy * dy);
            double steps = length / (double) SPEED;

        /*
        *
        *           e
        *
        *
        *       p
        * */

            BulletEnemyController bulletEnemyController =
                    BulletEnemyController.create(x, y);
            bulletEnemyController.dx = dx / (int) steps;
            bulletEnemyController.dy = dy / (int) steps;
            ControllerManager.bulletEnemy.add(bulletEnemyController);
            fire = false;
        }
    }
}
