package qx;

public class Monsters extends Creature{
    private String name;
    public Monsters(int x,int y,String name)
    {
        CreatureName="怪物";
        this.x=x;
        this.y=y;
        this.name=name;
    }
    public String getName(){return name;}
}
