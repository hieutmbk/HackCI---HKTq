package views;

import Models.Model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * Created by QuanLA on 12/24/2016.
 */
public interface BaseView {
    void draw(Graphics g, Model model);
    void setImage(BufferedImage image);
    void setBufferedImages(Vector<BufferedImage> bufferedImages);
}
