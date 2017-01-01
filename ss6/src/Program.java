import java.io.IOException;

/**
 * Created by minhh on 16/12/2016.
 */
public class Program {
    public static void main(String args[]){
        GameWindow gameWindow = null;
        try {
            gameWindow = new GameWindow();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread thread = new Thread(gameWindow);
        thread.start();
    }
}
