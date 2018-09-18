package ljy.Cucurbit;
enum CucurbitBoys{
    RedBro, OrangeBro, YellowBro, GreenBro, BlueBro, IndigoBro, VioletBro
}

public class CucurbitBoy {
    static protected String[] names={"老大","老二","老三","老四","老五","老六","老七"};
    static protected String[] colors={"红色","橙色","黄色","绿色","青色","蓝色","紫色"};
    static protected int nextid=0;
    private CucurbitBoys id;
    CucurbitBoy() throws Exception {
        if(CucurbitBoy.nextid>=7)
        {
            throw new Exception("葫芦娃只有七个！");
        }
        this.id=CucurbitBoys.values()[CucurbitBoy.nextid];
        CucurbitBoy.nextid++;
    }
    public String tellColor()
    {
        return CucurbitBoy.colors[this.id.ordinal()];
    }
    public String tellName()
    {
        return CucurbitBoy.names[this.id.ordinal()];
    }
    public int getID(){ return id.ordinal(); }
}