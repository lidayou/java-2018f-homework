package Creatures;

public class Monster extends Creature {
    public void outputInfo() {
        System.out.print("小怪");
    }
    public String toString() {
        return "小怪";
    }

    public String getImagePath() {
        return "src/ResourceFiles/monster.png";
    }
}
