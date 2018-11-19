package Creatures;

public class Grandfather extends Creature implements Cheer {
    public void outputInfo() {
        System.out.print("爷爷");
    }

    public void cheer(){}
    public String toString() {
        return "爷爷";
    }
    public int getIconIndex() {
        return 10;
    }
}
