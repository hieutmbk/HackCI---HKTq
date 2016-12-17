package View;

import Models.Model;

import java.awt.*;

/**
 * Created by minhh on 17/12/2016.
 */
public class View {
    private Image image;

    public View(Image image) {
        this.image = image;
    }
    public void draw(Graphics g, Model model){
        g.drawImage(image,model.getX(),model.getY(),model.getWidth(),model.getHeight(),null);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
