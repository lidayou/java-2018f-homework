# 作业三：葫芦娃 VS 妖怪

161220094  倪润涛

#### 一、相较于上次作业功能上的变化：

​         1、上下对峙变成了左右对峙

​         2、print输出变成了图形显示

#### 二、程序划分：

​        UML图：

​	生物类部分：

<div>
    <img src = "picture\2.png" width = 60%>
</div>



​	阵法类部分：

<div>
    <img src = "picture\1.png "width=100%>
</div>



#### 三、程序划分

Beings类：让双方“产生”，给予他们基本属性，姓名，能力(以后会用到能力，尚未实现)。

Formation：阵型类，里面保存着双方各自适合的阵型。

Battlefield：战场类，在这个类里，双方各自摆好阵型准备战斗，该类继承JFrame类

#### 四、程序效果

<div>
    <img src = "picture\3.png" width = 40%>
</div>



图形界面显示：

<div>
    <img src = "picture\4.png" width = 100%>
</div>



#### 五、细节描述

##### 葫芦娃初始乱序，排序后再进行排阵：

···

```java
public Calabash []calabashCreate()
{
    int []Rank = {0,3,2,5,1,6,4};
    Calabash []brothers = new Calabash[7];
    for(int i=0;i<7;i++) {
        brothers[i] = new Calabash(Rank[i]);
    }
    Sort(brothers);
    return brothers;
}
```

···

##### 从print到图形界面显示：

用一个二维字符数组记录下在每次对峙中葫芦娃和妖精各自的位置，将该二位字符数组作为参数传给战场函数，根据各自位置，加载出图片。

···

```java
void showBattlefield(char [][]field) {
    int count=1;
    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
```

···



#### 六、程序不足之处

有好些设想功能尚未实现，阵型也暂时只有四种。

双方阵型相对位置确定，没能做出一个交互式确定位置的排阵模式。

自己实现的界面部分存在一定问题，仍需改进