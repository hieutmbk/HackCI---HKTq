package views;

import Models.Model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * Created by minhh on 17/12/2016.
 */
public class View implements BaseView {
    private BufferedImage image;

    public View(BufferedImage image) {
        this.image = image;
    }
    public void draw(Graphics g, Model model){
        g.drawImage(image,model.getX(),model.getY(),model.getWidth(),model.getHeight(),null);
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    @Override
    public void setBufferedImages(Vector<BufferedImage> bufferedImages) {

    }
}
