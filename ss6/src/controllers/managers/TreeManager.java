package controllers.managers;

import controllers.BaseController;
import controllers.Controller;
import controllers.TreeController;

/**
 * Created by QuanLA on 12/17/2016.
 */
public class TreeManager extends ControllerManager implements BaseController {
    int stop = 0;
    int time = 0;

    public static final TreeManager instance = new TreeManager();
    public void run(){
        if(stop==1){
            time++;
            if(time > 50){
                stop=0;
                time=0;
            }
        }
        if(stop==0) {
            super.run();
            for (Controller controller : this.controllers1) {
                if (controller.getModel().getY() >= 800) {
                    controller.getModel().setY(-95);
                }
            }
        }

    }
    public void spawn(){
        int y=0;
        for(int i= 0;i<9;i++){
            TreeController treeController1 = TreeController.createE(300,y,30,100,"resources/box-sheet0.png");
            TreeController treeController2 = TreeController.createE(610,y,30,100,"resources/box-sheet0.png");
            y+=100;
            this.controllers1.add(treeController1);
            this.controllers1.add(treeController2);
        }
    }

    public int getStop() {
        return stop;
    }

    public void setStop(int stop) {
        this.stop = stop;
    }
}
