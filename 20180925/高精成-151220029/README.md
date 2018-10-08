# 面向对象的设计思路
根据需要，我设计了五个对象：生物(Creature)、阵法(Formation)、战场(BattleField)、监视器(Monitor)和排序器(Sort).
# 生物(Creature)
葫芦娃(Calabash)、老爷爷(Grandfather)、蛇精(Snake)、蝎子精(Scorpion)和小喽啰(Underling)是继承生物类拓展而来的，生物类如下:
```java
public class Creature {
    //生物共有的属性
    protected boolean greatMan;
    protected String name;
    protected int x,y;
    protected char symbol;//继承之后的对象用不同的符号表示
    protected Color color;
}
```
**葫芦娃兄弟类，实例化七个葫芦娃**
```java
public class CalabashBrothers {
    private Calabash []calabashes;

    public Calabash[] getCalabashes() {
        return calabashes;
    }
    CalabashBrothers () {
        calabashes = new Calabash[7];
        for(int i=0;i<calabashes.length;i++){
            //初始化葫芦娃排队顺序为老五、老六、老七、老大、老二、老三、老四
            calabashes[i] = new Calabash((i+4)%7+1);
        }
    }
}
```
# 战场(BattleField)
用二维数组表示战场  
`private char[][] battleField;`  
定义了三个方法：  
**获取战场的二维数组**`public char[][] getBattleField()`  
**打印战场的现状**`public void printTheBattle()`  
**清扫战场**`public void cleanUpTheBattleFiled()`  
# 阵法(Formation)
实现的四个阵法:
**鹤翼阵**`public void setCraneShapeBattleArray (Creature cre,BattleField battle)`  
**雁行阵**`public void setGooseShapeBattleArray (Creature cre,BattleField battle)`  
**锋矢阵**`public void setFrontalSagittalBattleArray (Creature cre,BattleField battle)`  
**偃月阵**`public void setCrescentMoonShapeBattleArray (Creature cre,BattleField battle)`  
# 排序器(Sort)
排序器实现了一个简单的冒泡排序
# 监视器(Monitor)
**监视器类似于上帝的一个角色，创造整个战场世界**
**Main函数是整个函数的入口**
