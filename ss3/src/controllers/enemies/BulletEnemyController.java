package controllers.enemies;

import Models.Model;
import controllers.Body;
import controllers.Controller;
import controllers.managers.BodyManager;
import utils.Utils;
import views.BaseView;
import views.View;

/**
 * Created by ToanTV on 12/28/2016.
 */
public class BulletEnemyController extends Controller implements Body{
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    public int dx;
    public int dy;
    protected ShootBehavior shootBehavior;
    public BulletEnemyController(Model model, BaseView view) {
        super(model, view);
        BodyManager.instance.register(this);
    }
    public void run(){
        this.getModel().move(dx,dy);
    }

    public static BulletEnemyController create(int x, int y){
        Model enemyBulletModel = new Model(x, y, WIDTH, HEIGHT);
        View enemyBulletView = new View(Utils.loadImage("resources/bullet-round.png"));
        BulletEnemyController bulletEnemyController = new BulletEnemyController(
                enemyBulletModel,
                enemyBulletView
        );
        return bulletEnemyController;
    }

    @Override
    public void onContact(Body other) {

    }
}
