package Creatures;

public class Snake extends Creature implements Cheer {
    public void outputInfo() {
        System.out.print("蛇精");
    }

    public void cheer(){}

    public String toString() {
        return "蛇精";
    }

    public String getImagePath() {
        return "src/ResourceFiles/snake.jpg";
    }
}
