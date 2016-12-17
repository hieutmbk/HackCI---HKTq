package Controller;

import Models.Model;
import View.View;

import java.awt.*;

/**
 * Created by minhh on 17/12/2016.
 */
public class Controller {
    protected View view;
    protected Model model;

    public Controller(Model model,View view) {
        this.view = view;
        this.model = model;
    }

    public void run(){
    }

    public void draw(Graphics g){
        view.draw(g,model);
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
