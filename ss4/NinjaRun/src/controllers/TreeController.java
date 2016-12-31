package controllers;

import Models.Model;
import controllers.managers.BodyManager;
import views.BaseView;
import views.View;
import utils.Utils;

/**
 * Created by QuanLA on 12/17/2016.
 */
public class TreeController extends Controller{
    public TreeController(Model model, BaseView view) {
        super(model, view);
    }

    public void run(){
        super.run();
        this.model.move(0, 2);
    }

    public static TreeController createE(int x, int y, int w, int h, String url){
        TreeController treeController = new TreeController(
                new Model(x, y, w, h),
                new View(Utils.loadImage(url))
        );
        return treeController;
    }

}
