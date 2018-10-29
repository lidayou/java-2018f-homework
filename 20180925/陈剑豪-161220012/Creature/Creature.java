package Creature;
/**
 * @ Author     ：cjh
 * @ Description：生物基类
 */
public class Creature {
    protected int row;//生物在地图上的横坐标
    protected int column;//生物在地图上的纵坐标
    protected static String name;//生物的名字
    public static void reportName(){System.out.print(name+"  ");}//生物报自己的名字
    public void standOnMap(int i,int j){}//生物站上地图
}
