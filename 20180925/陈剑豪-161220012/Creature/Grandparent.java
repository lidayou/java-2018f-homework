public class Grandparent{/**创建人：陈剑豪 创建时间：2018.10.2*/
    int row;
    int column;
    static final String name="爷爷";
    public static void reportName()
    {
        System.out.print(name+"  ");
    }
    public void standOnMap(int i,int j)
    {
        row=i;
        column=j;
        Space.space[i][j]=1;
    }

}
