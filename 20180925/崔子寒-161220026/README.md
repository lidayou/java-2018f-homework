## 0.11月22日 更新说明
1. 使用了JavaFx框架替代了原有的Swing框架，在IDEA + Scene Builder的环境下，更新了GUI的实现和设计。
2. 添加了和用户的交互，用户通过按钮来控制阵型的变动。具体效果如下：
![image](https://github.com/czhnju161220026/image/blob/master/res3v4.png?raw=true)
<br>
3. 上传了jar包，在Java 10 以下的版本可能无法正常运行。<br>
## 1.设计思路
1. GUI的设计：GUI应该提供和用户的交互，因此需要一个**GameController**类，这个类接受用户的操作（例如点击某个按钮），并调用相关的函数进行处理。GUI窗口在**Main**类中被展示。窗口的设计借助了GUI设计工具**Scene Builder**，窗口的风格通过加载.CSS文件来设定。
2. 出场的人物：出场的人物包括七个葫芦娃，爷爷，小怪，蝎子精，蛇精。它们有一个共同的抽象基类**Creature**。具有公共的属性position指示所在战场中的位置，image属性储存自己的图像素材，同时分别具有各自不同的属性，例如葫芦娃具有颜色属性，蛇精和爷爷具有cheer方法。
3. 阵型的设计：接口**FormationProvider**定义了一个阵型类应该具有**provideFormation**方法，返回一个坐标数组。所有的阵型类都继承自这个接口。
4. 战场的设计：首先需要一个Block类代表单位的空间，Block可以绑定一个生物和解除绑定，来模拟生物进入和离开的过程。战场内部有一个Block矩阵，代表战场的二维空间。可以通过遍历矩阵的方式给出战场的信息。
5. 阵营的设计：**Heros**和**BadGuys**类是战斗中的两大阵营，分别由若干葫芦娃和若干怪物组成，这两大阵营都具有变换阵型的方法。<br>

## 2.模块说明
这次更新依然采用包管理的形式进行管理。
1. guiApp包：guiApp包包含了**GameController**和**Main**两个类，负责和用户进行交互，类视图如下：
![image](https://github.com/czhnju161220026/image/blob/master/Gui.jpg?raw=true)
<br>
**GameController**中定义了三个Handler，分别处理开始按钮，变换阵形按钮，和游戏结束按钮的点击事件。还有方法displayBattlefield和clearBattlefield用来展示和清空战场。<br>
**Main**中的start函数设置场景并进行展示。

2. Creatures包： Creatures包包含了抽象类Creature以及其若干派生类。定义了所有的出场人物，类视图如下：

## 3.实现说明
## 4.面向对象的思想