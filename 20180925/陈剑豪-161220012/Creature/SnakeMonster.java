public class SnakeMonster {/**创建人：陈剑豪 创建时间：2018.10.2*/
    private static final String name="蛇精";
    private int row;
    private int column;
    public static void reportName()
    {
        System.out.print(name+"  ");
    }
    public void standOnMap(int i,int j)
    {
        row=i;
        column=j;
        Space.space[i][j]=9;
        //System.out.println("蛇精"+" "+row+" "+column);
    }

}
