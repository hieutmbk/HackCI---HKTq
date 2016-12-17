/**
 * Created by minhh on 16/12/2016.
 */
public class Program {
    public static void main(String args[]){
        GameWindow gameWindow = new GameWindow();
        Thread thread = new Thread(gameWindow);
        thread.start();
    }
}
