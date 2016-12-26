package utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by minhh on 16/12/2016.
 */
public class Utils {
    public static BufferedImage loadImage(String url){
        try {
            BufferedImage image = ImageIO.read(new File(url));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
            return  null;
        }
    }
}
