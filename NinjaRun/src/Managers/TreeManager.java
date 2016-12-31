package Managers;

import Controllers.TreeController;

/**
 * Created by QuanLA on 12/17/2016.
 */
public class TreeManager extends ControllerManager {

    private int timeCounter = 0;
    public void run(){
        super.run();
        timeCounter++;
        if(timeCounter > 46){
            spawn(300, -200, 30, 100, "resources/box-sheet0.png");
            spawn(610, -200, 30, 100, "resources/box-sheet0.png");
            timeCounter = 0;
        }

    }

    public void spawn(int x, int y, int w, int h, String url){
        TreeController treeController = TreeController.createE(x, y, w, h, url);
        this.tree1.add(treeController);
    }
}
