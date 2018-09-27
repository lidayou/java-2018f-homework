# 相关说明
## 思考
1. 关于场景中出现的所有人物如何实现：可以认为葫芦娃、蝎子精、小喽啰等各种生物都继承了一个基类**Creature**。分别具有各自的特殊属性：如葫芦娃的颜色，妖怪的种类等。
2. 每一个人物应该有一个属性表明他所在阵列中的位置(x,y),基类**Creature**会提供一个move方法，实现人物在战场中的移动。
3. 二维空间如何实现：定义一个类**Block**，用来表示单位空间。一个单位空间可以绑定一个生物。**Block**类提供enter方法和leave方法用来绑定和解除绑定。 二维空间使用**Battlefield**类，它的成员中有一个**Block**类的对象矩阵，标识这个二维空间，这里我定义的二维空间大小是10 x 20。
4. 阵型的实现：采用一个**Formation**类，它的成员利用二维数组的方式储存每个阵型，阵型的数据是静态的，不需要实例化对象就可以访问阵型数据。
5. 主类**Battle**类，用来完成战场和双方阵营的实例化，以及对战的过程。

## 设计
###1. 类的划分
(1) enum Color，enum MonsterCategory，为两个枚举类型，用来枚举葫芦娃的颜色属性和怪物的种类（喽啰，蝎子精，蛇精）。
(2) Creature类：各种出场人物的基类。派生类包括Calabashbrother, GrandFather, Monster。这里没有采用作业二中用枚举的方法实现葫芦娃，是考虑到需要进行类继承。
(3) Block类：表明一个单位空间，采用组合的方式，含有一个Creature的成员对象。
(4) Battlefield类：二维空间类，类内部有一个Block对象的矩阵。
(5) Heroes类：代表正义阵营。
(6) BadPeople类：代表邪恶阵营。
(7) Formation类：储存阵型。
(8) Battle类：main方法所在的类。


###2. 类方法的说明

(1) Creature及其派生类:
``` java  
/*输出自身信息，在派生类中被分别覆盖为所需要的方法*/
public void outputInfo(); 
/*移动至战场的指定位置*/
public void move(Battlefield battlefield, Position newPosition);
```
(2) Block:
``` java
/*绑定生物*/
 public boolean creatureEnter(Creature creature);
 /*生物离开*/
 public void creatureLeave(Creature creature);
 /*输出信息，直接调用所绑定生物的outputInfo()*/
 public void outputInfo();
```

(3) Battlefield:
``` java
/*给出二维空间*/
 public Block[][] getBattlefield();
 /*遍历二维空间，打印战场的实时情况*/
 public void print();
```

(4) Heroes:
``` java
/*置乱方法，用来生成乱序的葫芦娃队列*/
 public void shuffle();
 /*葫芦娃按序排队，进入战场*/
 public void lineUp(Battlefield battlefield);
```
(5) BadPeople:
```java
/*小怪，蛇精以及蝎子精变阵*/
 public void changeFormation(Battlefield battlefield, FormationName formationName)
```
(6) Battle:
``` java
public static void main(String[] args) throws InterruptedException{
        /*实例化战场，正义阵营和邪恶阵营*/
        Battlefield battlefield = new Battlefield();
        Heroes heroes = new Heroes();
        BadPeople badPeople = new BadPeople();
        /*正义阵营排队进入战场*/
        heroes.lineUp(battlefield);
        Thread.sleep(1000);
        /*邪恶阵营不断变阵*/
        for(FormationName x:FormationName.values()) {
            badPeople.changeFormation(battlefield, x);
            battlefield.print(); //输出战场信息
            Thread.sleep(1500);
        }
    }
```

(7) Formation:
这个类只存储静态的阵型信息，域是public final static的，信息可以直接取用，因此没有设置方法。




##面向对象的特性
1. 继承：CalabashBrother,GrandFahter,Monster继承了基类Creature
2. 组合：Battlefield的成员有Block对象的矩阵，Block的成员中有Creature及其派生类的对象。
3. 多态：在遍历空间，输出战场信息的时候，调用每个Creature对象的outputInfo方法，这些方法会动态绑定到具体的子类中的方法，运用了多态的思想。

这些设计思想提高了代码的复用效率，而且和现实世界比较类似，是以后的学习过程中应该多加运用，多多领悟的。

##运行效果

![image](https://github.com/czhnju161220026/image/blob/master/res3.png?raw=true)



