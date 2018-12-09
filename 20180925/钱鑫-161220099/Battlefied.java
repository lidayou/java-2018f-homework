package qx;

public class Battlefied {
    private int N;
    private boolean isbeing[][];
    private String creaturename[][];
    public Battlefied(int n)
    {
        N=n;
        isbeing=new boolean[n][n];
        creaturename=new String[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                isbeing[i][j]=false;
                creaturename[i][j]=null;
            }
        }
    }
    public int getSize()
    {
        return N;
    }
    public void set(int x,int y,String name)
    {
        if(x<0||y<0||x>N-1||y>N-1)
        {
            System.out.print("超出了战场范围！\n");
        }
        else if(isbeing[x][y])
        {
            System.out.print("战场上该位置已有生物！\n");
        }
        else
        {
            isbeing[x][y]=true;
            creaturename[x][y]=name;
        }
    }
    public void print()
    {
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(isbeing[i][j])
                {
                    System.out.print(creaturename[i][j]);
                }
                else {
                    System.out.print("    ");
                }
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
