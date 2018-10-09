#需求分析

在二维空间中放置数种不同的生物体，并基于不同的阵型，对成群的生物体进行列阵、排序，输出结果。

#思路（文件划分）

###单个生物体类 Creature

存放生物体的共同基本信息，如名称、坐标、字符表示、存在情况等。其子类为：

- CalabashBrother，比其他生物体多一个序号变量，用数字1-7表示
- GrandFather，用数字0表示
- ScorpionMonster，用$表示
- SnakeMonster，用S表示
- SmallMonster，用o表示

其主要方法为：

- set，置exist为true并赋值到生物体的坐标，但此时并不在棋盘上放置该生物

###多个生物体类 Creatrues

对生物群整体进行排序和站队。其子类为：

- CalabashBrothers，包含hw2中的乱序、排序等方法
- Monsters

其主要方法为：

- set/reset，根据阵型放置已有生物群/重置生物群

###棋盘类 Board

在二维空间中放置生物体。其主要方法为：

- set & reset，基于给定坐标放置/重置生物体
- test，检查指定坐标是否有生物存在

###阵型类 Formation

检查阵型的合理性及按阵型放置生物群。其子类为：

- Snake
- Goose
- Yoke
- Crane

其主要方法为：

- test，检查阵型中每个生物体是否都可以放置
- set，基于阵型放置生物体群

###主类 FormationSolve

创建各类的对象并进行整体调度。

#面向对象的理念体现

- 生物类、生物群类和阵型类均利用了继承机制，其变量均定义为protected，在保留父类的基本性质下，可以自由地增添修改新的变量和方法，为以后扩展留下空间。
- 生物群类的默认构造函数为空，在每个子类内具体实现。
> 原因是父类保护变量Creature数组没有具现化，既不知道长度也不知道每一位是哪个生物，而子类的构造函数带一个number参数。如在CalabashBrothers子类中，实现为7个CalabashBrother类；在Monsters子类中，实现为1个ScorpionMonster类和number-1个SmallMonster类。

- 阵型类中，将阵型的几何性质封装到方法内部，使得测试方法只需要知道初始点坐标和生物数量，即可判断对应的阵型是否可以放置。
- 棋盘类中，每一个点初始化为父类生物，不具体实现只将exist置为false。