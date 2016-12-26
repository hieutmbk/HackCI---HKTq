package Controllers;

import Managers.BodyManager;
import Models.Model;
import Views.BaseView;
import Views.View;
import utils.Utils;

/**
 * Created by QuanLA on 12/17/2016.
 */
public class TreeController extends Controller implements Body{
    public TreeController(Model model, BaseView view) {
        super(model, view);
        BodyManager.instance.register(this);
    }

    public void run(){
        super.run();
        this.model.move(0, 2);
    }

    public static TreeController createE(int x, int y, int w, int h, String url){
        TreeController treeController = new TreeController(new Model(x, y, w, h), new View(Utils.loadImage(url)));
        return treeController;
    }

    @Override
    public void onContact(Body other) {

    }
}
