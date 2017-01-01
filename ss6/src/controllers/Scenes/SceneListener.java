package controllers.Scenes;

/**
 * Created by laptopTCC on 12/31/2016.
 */
public interface SceneListener {
    void replaceScene(GameScene newScene, boolean addToStack);
    void back();
}
