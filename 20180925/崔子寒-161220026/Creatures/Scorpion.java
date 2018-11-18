package Creatures;
public class Scorpion extends Creature{
    public void outputInfo() {
        System.out.print("蝎子");
    }
    public String toString() {
        return "蝎子";
    }
    public String getImagePath() {
        return "src/ResourceFiles/scorpion.png";
    }
}
