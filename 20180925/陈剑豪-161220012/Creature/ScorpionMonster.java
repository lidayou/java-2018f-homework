public class ScorpionMonster {
    static final String name="蝎子";
    int row;
    int column;
    public static void reportName()
    {
        System.out.print(name+"  ");
    }
    public void standOnMap(int i,int j)
    {
        row=i;
        column=j;
        Space.space[i][j]=10;
    }
}
