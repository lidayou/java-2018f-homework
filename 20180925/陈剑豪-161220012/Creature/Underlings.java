public class Underlings {/**创建人：陈剑豪 创建时间：2018.10.2*/
    final static String name="喽啰";
    static int number=0;
    int row;
    int column;
    public Underlings()
    {
        number++;
    }
    public static void Number()
    {
        System.out.println(number);
    }
    public static void reportName()
    {
        System.out.print(name+"  ");
    }
    public void standOnMap(int i,int j)
    {
        row=i;
        column=j;
        Space.space[i][j]=11;
    }

}
