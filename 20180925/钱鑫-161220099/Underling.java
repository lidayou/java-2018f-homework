package qx;

public class Underling {
    public Monsters[] underlings;
    public Underling()
    {
        underlings=new Monsters[20];
        underlings[0]=new Monsters(-1,-1,"蝎精");
        for(int i=1;i<20;i++)
        {
            underlings[i]=new Monsters(-1,-1,"喽啰");
        }
    }
}
