package controllers.managers;

import controllers.Controller;
import controllers.TreeController;

/**
 * Created by QuanLA on 12/17/2016.
 */
public class TreeManager extends ControllerManager {

    public void run(){
        super.run();
        for(Controller controller:this.controllers){
            if(controller.getModel().getY() >= 800){
                controller.getModel().setY(-100);
            }
        }

    }
    public void spawn(){
        int y=0;
        for(int i= 0;i<9;i++){
            TreeController treeController1 = TreeController.createE(300,y,30,100,"resources/box-sheet0.png");
            TreeController treeController2 = TreeController.createE(610,y,30,100,"resources/box-sheet0.png");
            y+=100;
            this.controllers.add(treeController1);
            this.controllers.add(treeController2);
        }
    }
}
