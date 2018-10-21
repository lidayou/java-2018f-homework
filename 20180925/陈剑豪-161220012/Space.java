
public class Space {/**创建人：陈剑豪 创建时间：2018.10.2*/
    static int[][] space;
    int sizeofspace;
    public Space(int n)
    {
        sizeofspace=n;
        space=new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {

                if(i==0||j==0||i==n-1||j==n-1)
                {
                    space[i][j]=-1;// -1代表边界
                }
                else
                space[i][j]=0;
                              // 0代表没有站生物
                              // 1代表站了爷爷
                              // 2,3,4,5,6,7,8代表站了大娃、二娃、三娃、四娃、五娃、六娃、七娃
                              // 9代表站了蛇精
                              // 10代表站了蝎子精
                              // 11代表站了小喽啰
            }
        }
    }
    public void singlelineBattleArray(CalabashBrothers[] brothers,int row,int column)//一字长蛇阵
    {
        for(int i=row;i<row+7;i++)
        {
            brothers[i-row].standOnMap(i,column);
        }
    }
    public void craneBattleArray(ScorpionMonster scorpionMonster,Underlings[] underlings,int row,int column)// 鹤翼阵
    {
        scorpionMonster.standOnMap(row,column);
        //System.out.println(underlings.length/2);
        for(int k=0;k<(underlings.length/2);k++)
        {
            underlings[k*2].standOnMap(row-k-1,column+k+1);
            underlings[k*2+1].standOnMap(row+k+1,column+k+1);
            //System.out.println(k);
        }
    }
    public void wildgooseBattleArray(ScorpionMonster scorpionMonster,Underlings[] underlings,int row,int column)// 雁行阵
    {
        scorpionMonster.standOnMap(row,column);
        for(int k=0;k<underlings.length;k++)
        {
            underlings[k].standOnMap(row-k-1,column+k+1);
            //System.out.println(k);
        }
    }
    public void putOnGrandparent(Grandparent grandparent,int row,int column)// 摆放爷爷
    {
        grandparent.standOnMap(row,column);
    }

    public void putOnSnakeMonster(SnakeMonster snakeMonster,int row,int column)// 摆放蛇精
    {
        snakeMonster.standOnMap(row,column);
    }

    public void remove()
    {
        for(int i=1;i<sizeofspace-1;i++)
        {
            for(int j=1;j<sizeofspace-1;j++)
            {
                space[i][j]=0;
            }
        }
    }

    public void display()
    {
        for(int i=0;i<sizeofspace;i++)
        {
            for(int j=0;j<sizeofspace;j++)
            {
                switch(space[i][j]) {
                    case -1:
                        System.out.print("******");
                        break;
                    case 0:
                        System.out.print("      ");
                        break;
                    case 1:
                        Grandparent.reportName();
                        break;
                    case 2:
                        CalabashBrothers.BigBrother.reportName();
                        break;
                    case 3:
                        CalabashBrothers.SecondBrother.reportName();
                        break;
                    case 4:
                        CalabashBrothers.ThirdBrother.reportName();
                        break;
                    case 5:
                        CalabashBrothers.FourthBrother.reportName();
                        break;
                    case 6:
                        CalabashBrothers.FifthBrother.reportName();
                        break;
                    case 7:
                        CalabashBrothers.SixthBrother.reportName();
                        break;
                    case 8:
                        CalabashBrothers.SeventhBrother.reportName();
                        break;
                    case 9:
                        SnakeMonster.reportName();
                        break;
                    case 10:
                        ScorpionMonster.reportName();
                        break;
                    case 11:
                        Underlings.reportName();
                        break;
                }
            }
            System.out.println();
        }
    }
}
