package controllers.enemies;

import Models.Model;
import controllers.Body;
import controllers.Controller;
import controllers.NinjaController;
import controllers.managers.BodyManager;
import utils.Utils;
import views.Animation;
import views.BaseView;
import views.View;

import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * Created by ToanTV on 12/27/2016.
 */
public class EnemyController extends Controller implements Body {
    protected MoveBehavior moveBehavior;
    protected ShootBehavior shootBehavior;
    public int dx;
    public int dy;
    private int timeCount = 201;
    public EnemyController(Model model, BaseView view, MoveBehavior moveBehavior, ShootBehavior shootBehavior) {
        super(model, view);
        BodyManager.instance.register(this);
        this.moveBehavior = moveBehavior;
        this.shootBehavior = shootBehavior;
    }
    public static EnemyController createEnemy(int x, int y, TypeEnemy type){
        Vector<BufferedImage> bufferedImages = new Vector<>();
        bufferedImages.add(Utils.loadImage("resources/enemy_plane_white_1.png"));
        bufferedImages.add(Utils.loadImage("resources/enemy_plane_white_2.png"));
        bufferedImages.add(Utils.loadImage("resources/enemy_plane_white_3.png"));
        Vector<BufferedImage> images = new Vector<>();
        images.add(Utils.loadImage("resources/enemy_plane_yellow_1.png"));
        images.add(Utils.loadImage("resources/enemy_plane_yellow_2.png"));
        images.add(Utils.loadImage("resources/enemy_plane_yellow_3.png"));
        switch (type){
            case WHITE:return new EnemyController(
                    new Model(x , y, 32, 32),
                    new Animation(bufferedImages),
                    new MoveDownBehavior(),
                    new ShootDownBehavior()
            );
            case SPEED: return new EnemyController(
                    new Model(x,y,32,29),
                    new View(Utils.loadImage("resources/plane1.png")),
                    new MoveDownMaxSpeed(),
                    null
            );
            case ZZ: return new EnemyController(
                    new Model(x,y,32,32),
                    new Animation(images),
                    new MoveZigZag(),
                    new ShootOnTarget()
            );
            default:return null;
        }
    }
    public void run(){
        if(moveBehavior != null){
            moveBehavior.doMove(this);
        }
        if(this.getModel().getY() >= 800){
            this.getModel().setAlive(false);
        }
        timeCount++;
        if(timeCount > 200){
            shoot();
            timeCount =0;
        }
    }
    private void shoot() {

        if (shootBehavior != null ){
            shootBehavior.doShoot(this);
        }
    }
    @Override
    public void onContact(Body other) {
        if(other instanceof NinjaController){

        }
    }
}
