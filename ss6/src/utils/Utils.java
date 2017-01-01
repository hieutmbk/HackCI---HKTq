package utils;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
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

    public static Clip playSound(String audioUrl, boolean repeat) {

        File soundFile = new File(audioUrl);
        AudioInputStream audioIn;
        Clip clip;
        try {
            audioIn = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
            if(repeat) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            else {
                clip.loop(0);
            }

        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (LineUnavailableException e) {
            e.printStackTrace();
            return null;
        }
        return clip;
    }
    public static Vector<BufferedImage> loadSheet(String url, int width, int height, int imageCount, int border){
        BufferedImage image = Utils.loadImage("resources/explosion.png") ;
        Vector<BufferedImage> bufferedImages = new Vector<>();
        for(int i=0;i<imageCount;i++) {
            bufferedImages.add(image.getSubimage(width * i+border*(i+1), 1, width, height+border));
        }
        return bufferedImages;
    }
}
