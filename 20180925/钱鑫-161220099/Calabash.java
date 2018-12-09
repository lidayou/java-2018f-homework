package qx;

public class Calabash extends Creature {
    private int rank;
    private String name;
    public Calabash(int x,int y,int rank,String name)
    {
        CreatureName="葫芦娃";
        this.x=x;
        this.y=y;
        this.rank=rank;
        this.name=name;
    }
    public int getRank(){return rank;}
    public String getName(){return name;}
}
