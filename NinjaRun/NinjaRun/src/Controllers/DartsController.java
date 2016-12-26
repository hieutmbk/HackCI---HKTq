package Controllers;

import Managers.BodyManager;
import Models.Model;
import Views.BaseView;

/**
 * Created by QuanLA on 12/17/2016.
 */
public class DartsController extends Controller implements Body{
    public DartsController(Model model, BaseView view) {
        super(model, view);
        BodyManager.instance.register(this);
    }

    public void run(){
        super.run();
        this.model.move(0, -5);
    }

    @Override
    public void onContact(Body other) {
        if(other instanceof TreeController){
            System.out.println("clgt");
            this.getModel().setAlive(false);
        }
    }
}
