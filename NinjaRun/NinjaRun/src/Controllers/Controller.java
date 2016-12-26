package Controllers;

import Models.Model;
import Views.BaseView;
import Views.View;

import java.awt.*;

/**
 * Created by minhh on 17/12/2016.
 */
public class Controller {
    protected BaseView view;
    protected Model model;

    public Controller(Model model, BaseView view) {
        this.view = view;
        this.model = model;
    }

    public void run(){
    }

    public void draw(Graphics g){
        view.draw(g, model);
    }

    public BaseView getView() {
        return view;
    }

    public void setView(BaseView view) {
        this.view = view;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
