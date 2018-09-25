package ljy.Cucurbit;

public class Charactors {
    public String typename;
    public int positionX,positionY;
    public char testview;
    public boolean alive=true;
    public void moveto(int x,int y)
    {
        positionX=x;
        positionY=y;
    }
    public void StandStill()
    {
        BattleField.field[positionY][positionX]=testview;
    }
}
class Rank{
    static public String[] MonsterClass=new String[]{"小喽啰","蝎子精","蛇精","青蛇精"};
    static public String[] HumanClass=new String[]{"百姓","葫芦娃","爷爷"};
    static public int find(String str, boolean human)
    {
        int index=0;
        if(human) {
            for (; index < HumanClass.length; index++)
                if (str.equals(HumanClass[index]))
                    return index;
            return -1;
        }
        else
        {
            for (; index < MonsterClass.length; index++)
                if (str.equals(MonsterClass[index]))
                    return index;
            return -1;
        }
    }

}

enum CucurbitBoys{
    RedBro, OrangeBro, YellowBro, GreenBro, BlueBro, IndigoBro, VioletBro;
    static protected String[] names={"老大","老二","老三","老四","老五","老六","老七"};
    static protected String[] colors={"红色","橙色","黄色","绿色","青色","蓝色","紫色"};
    public String getName(){ return names[ordinal()]; }
    public String getColor(){ return colors[ordinal()]; }
}

class Grandpa extends Charactors
{
    Grandpa()
    {
        positionX=0;
        positionY=BattleField.height-1;
        typename="爷爷";
        testview='Y';
    }
}

class CucurbitBoy extends Charactors
{
    //按照排行顺序存放葫芦娃的姓名和颜色
    static protected int nextid=0;     //每个葫芦娃都是唯一的，nextid用来记录下一个未出生的葫芦娃排行
    private CucurbitBoys id;            //每个葫芦娃拥有自己的id，描述他在兄弟中的排行
    CucurbitBoy() throws Exception {
        //每个葫芦娃只能出生一次，并且最多有七个
        if(CucurbitBoy.nextid>=7)
        {
            throw new Exception("葫芦娃只有七个！");
        }
        //为葫芦娃分配排行
        this.id=CucurbitBoys.values()[CucurbitBoy.nextid];
        CucurbitBoy.nextid++;
        typename=id.getName();
        testview='H';
    }
    //返回自己的颜色
    public String tellColor(){ return id.getColor(); }
    //返回自己的排行
    public int getID(){ return id.ordinal(); }
}

class Roro extends Charactors
{
    public int number;
    private formations curFMT=null;
    public Roro(){
        typename="小喽啰";
        testview='R';
    }
    public void resort(String type, int mx, int my, formations FMT)
    {
        if(Rank.find(typename,false)>Rank.find(type,false))
            return;
        curFMT=FMT;
//        System.out.println(curFMT.rightDistance);
        int npX=mx+curFMT.RelativePosition[number][0];
        int npY=my+curFMT.RelativePosition[number][1];
        moveto(npX, npY);
    }
}

class Scorpion extends Charactors
{
    private int curFMT=-1;
    private formations[] learnedFormations=new formations[]{new Fengshi(), new Yanyue()};
    public Roro[] troops=new Roro[18];
    public Scorpion()
    {
        typename="蝎子精";
        testview='X';
        for(int i=0;i<troops.length;i++) {
            troops[i]=new Roro();
            troops[i].number = i;
        }
        changeFMT();
    }

    @Override
    public void StandStill()
    {
        super.StandStill();
        for(int i=0;i<troops.length;i++)
            if(troops[i].alive)
                troops[i].StandStill();
    }

    public void changeFMT()
    {
        curFMT=(curFMT+1)%learnedFormations.length;
        positionX=BattleField.width-learnedFormations[curFMT].rightDistance-1;
        positionY=BattleField.height/2;
        for(int i=0;i<troops.length;i++) {
            troops[i].resort(typename,positionX,positionY,learnedFormations[curFMT]);
        }
    }
}

class Snake extends Charactors
{
    public Snake()
    {
        positionX=BattleField.width-1;
        positionY=0;
        typename="蛇精";
        testview='S';
    }
}