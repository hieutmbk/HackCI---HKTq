package views;

import Models.Model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * Created by QuanLA on 12/24/2016.
 */
public class Animation implements BaseView {
    private Vector<BufferedImage> bufferedImages;
    private int count = 0;
    private int imageCount = 0;
    private boolean animationReachEnd = false;

    public Animation(Vector<BufferedImage> bufferedImages) {
        this.bufferedImages = bufferedImages;
    }

    public boolean isAnimationReachEnd() {
        return animationReachEnd;
    }

    public void setBufferedImages(Vector<BufferedImage> bufferedImages) {
        this.bufferedImages = bufferedImages;
    }


    @Override
    public void draw(Graphics g, Model model) {
        BufferedImage bufferedImage = bufferedImages.get(imageCount);
        g.drawImage(bufferedImage, model.getX(), model.getY(),
                model.getWidth(), model.getHeight(),
                null);
        count++;
        if(count > 10) {
            imageCount++;
            count = 0;
            if (imageCount > bufferedImages.size() - 1) {
                imageCount = 0;
                animationReachEnd = true;
            }
        }

    }

    @Override
    public void setImage(BufferedImage image) {

    }
}
