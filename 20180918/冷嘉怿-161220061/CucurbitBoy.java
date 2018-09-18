package ljy.Cucurbit;
enum CucurbitBoys{
    RedBro, OrangeBro, YellowBro, GreenBro, BlueBro, IndigoBro, VioletBro
}

public class CucurbitBoy {
    static protected String[] names={"老大","老二","老三","老四","老五","老六","老七"};
    static protected String[] colors={"红色","橙色","黄色","绿色","青色","蓝色","紫色"};
    private CucurbitBoys id;
    public void tellColor()
    {
        System.out.print(CucurbitBoy.colors[this.id.ordinal()]);
    }
    public void tellName()
    {
        System.out.print(CucurbitBoy.names[this.id.ordinal()]);
    }
}