package Models;

/**
 * Created by ToanTV on 1/1/2017.
 */
public class Character {
    private static int hp;
    private static int live;
    private static int point;
    private static int maxCombo;
    private static int combo;

    public static int getCombo() {
        return combo;
    }

    public static void setCombo(int combo) {
        Character.combo = combo;
    }

    public static int getHp() {
        return hp;
    }

    public static void setHp(int hp) {
        Character.hp = hp;
    }

    public static int getLive() {
        return live;
    }

    public static void setLive(int live) {
        Character.live = live;
    }

    public static int getPoint() {
        return point;
    }

    public static void setPoint(int point) {
        Character.point = point;
    }

    public static int getMaxCombo() {
        return maxCombo;
    }

    public static void setMaxCombo(int maxCombo) {
        Character.maxCombo = maxCombo;
    }
}
