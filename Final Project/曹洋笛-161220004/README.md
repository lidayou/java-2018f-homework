# World v4.0 版

- 当前版本
- 按照新的要求进行重构
- 目前实现的要求有：
  - N*M 的二维空间（GUICell cells\[]\[] in class GUIPanel）
  - 七个兄弟和老爷爷以某种阵型在左侧战队
  - 蛇精、蝎子精、小喽啰以某种阵型在右侧战队
  - 各生物体均实现为一个线程（新的类 class Entity）；线程同步机制解决多个生物同时杀死某个生物的问题（Entity 的所有实例任意两个都不能同时执行）
  - 按空格键时所有生物体线程执行 start()，向敌方前进
  - 当某个生物体于敌方相遇时，选取一个概率决定双方生死

- 下一阶段目标
  - 解决同阵营可能进入同一个“格子”导致重叠的问题
  - 增加 start() 向敌方前进的随机性
  - 使得最终只剩下一方阵营并判定胜利方
  - 使用 JavaFX 改写



## 类与包

- package world
  - class **Global**
  - class **Main**
  - class **CharWindow**
  - class **GUIWindow** extends JFrame
  - class **GUIPanel** extends JPanel
  - class **GUICell**
- package world.creatures
  - class **Creature**
  - class **Brothers** extends Creature
  - class **Elder** extends Creature
  - class **Monsters** extends Creature
  - class **Scorpion** extends Creature
  - class **Snake** extends Creature
- package world.entities
  - class **Entity** implements Runnable
- package world.formations
  - class **Formation**
  - class **HeYi** extends Formation
  - class **YanXing** extends Formation
  - class **ChongE** extends Formation
  - class **ChangShe** extends Formation
  - class **YuLin** extends Formation
  - class **FangYuan** extends Formation
  - class **YanYue** extends Formation
  - class **FengShi** extends Formation
- package world.util
  - enum **CreatureType**
  - enum **FormationType**
  - enum **GroupType**
  - class **Point**



## 详细说明

### （一）package world

#### 1. class Main

- main 函数 —— 世界的构建

```java
public final class Main {
	public static void main(String[] args) {
		CharWindow cWin = new CharWindow();
		new GUIWindow(cWin);
	}
}
```

#### 2. class CharWindow

- 里世界 —— 世界的基石

- 同时在终端使用字符显示整个世界以及人物符号

##### (1) 重要属性

```java
	/**	定义葫芦娃阵型对象 */
	public Formation broForm;
	/**	定义妖怪阵型对象 */
	public Formation monForm;
	/**	当前世界上的所有实体，每个都是生物+位置+线程，是一切行为的发起者 */
	public static Set<Entity> entities = new HashSet<>();
```

##### (2) 方法

```java
	/**	返回某位置pos上的实体（没有则返回null） */
	public static Entity getLiveEntityAt(Point pos) { ... }
	/**	根据当前阵型更新实体集合 */
	public void initEntities() { ... }
	/**	开启所有实体的线程：所有葫芦娃向右前进，所有妖怪向左前进 */
	public void start() {
		for (Entity en: entities) {
			en.start();
		}
	}
	/**	改变阵型的同时重置，位置初始化为默认位置 */
	public void changeFormation(FormationType type, GroupType ctype) { ... }
	/**	显示里世界 */
	public void showWorld() { ... }
```

#### 2. class GUIWindow

- 表世界 —— 世界的衍生
- 基于里世界，用图形化界面“包装”
- 相当于：菜单栏 + **GUIPanel**

```java
	/**	构造函数，以char世界为基础，产生GUI世界窗口 */
	public GUIWindow(CharWindow w) {
        ... // 设置标题，菜单栏，窗口大小和位置
		// 设置键盘项监听
		keyMonitor = new KeyMonitor();
        ...
		// 设置菜单项监听
		menuMonitor = new MenuMonitor();
        ...
		// 基于char世界，开始构建和绘制
		cWin = new CharWindow();
		pWin = new GUIPanel(cWin);
		this.add(pWin, BorderLayout.CENTER);
		this.setVisible(true);
		cWin.showWorld(); // 控制台打印世界
		pWin.paintWindow(); // 图形化显示世界
    }
```

#### 3. class GUIPanel

- 包括：背景图 + 所有实体的图像

```java
	/**	每个生物占据一个格子 */
	public GUICell[][] cells;
	/**	背景图片 */
	private JLabel ground;
	/**	擦除所有格子 */
	public void clearWindow() { ... }
	/**	绘制所有格子 */
	public void paintWindow() { ... }
```

#### 4. class GUICell

- 格子，世界地图上放置实体的位置单元

```java
	/**	Cell位置行列，从0开始 */
	private int cRow, cCol;
	/**	Cell图片标签，默认为none.png */
	public JLabel cellLabel;
	/**	为cellLabel设置新图片 */
	public void setImage(CreatureType t) { ... }
	public int x() { ... } // 格子的x坐标
	public int y() { ... } // 格子的y坐标
	public int width() { ... } // 格子的宽
	public int height() { ... } // 格子的长
```

#### 5. class Global

- 全局常量，变量和方法



### （二）package world.creatures

![CreatureUML](.\img_readme\CreatureUML.png)



### （三）package world.formations

#### 1. class Formation

- 重要属性以及方法的目的：记录阵型中人物的“点位置->人物类型”信息

```java
public abstract class Formation {
	/**	阵型内人物的(坐标, 实体)对集合 {@value} */
	public Map<Point, Creature> formMap;
    /**	设置属性值：阵型行数列数以及中心点位置 */
	protected void init(int r, int c, int cr, int cc) {
		formRowNum = r;
		formColNum = c;
		pFormCen = new Point(cr, cc);
	}
}
```



#### 2. class ... （其他）

- 把每个种类的阵型扩展到葫芦娃和妖怪均适用（阵型略有改动）

- 以鱼鳞阵为例：

```java
public final class YuLin extends Formation {
	public YuLin(GroupType ct) { // 阵营
		super(FormationType.YL); // 构建
		if (ct == GroupType.Bro) {
			init(5, 4, 2, 1); // 阵型图所占行列
			// 葫芦娃的位置
			formMap.put(new Point(2, 0), new Elder()); // 老爷爷
			formMap.put(new Point(0, 1), new Brothers(0));
			formMap.put(new Point(1, 1), new Brothers(1));
			formMap.put(new Point(2, 1), new Brothers(2));
			formMap.put(new Point(3, 1), new Brothers(3));
			formMap.put(new Point(4, 1), new Brothers(4));
			formMap.put(new Point(3, 2), new Brothers(5));
			formMap.put(new Point(2, 3), new Brothers(6));
		}
		else {
			init(7, 5, 3, 2); // 阵型图所占行列
			// 妖怪的位置
			formMap.put(new Point(0, 3), new Monsters());
			formMap.put(new Point(1, 2), new Monsters());
			formMap.put(new Point(2, 1), new Monsters());
			formMap.put(new Point(2, 3), new Monsters());
			formMap.put(new Point(3, 0), new Monsters());
			formMap.put(new Point(3, 2), new Scorpion()); // 蝎子精
			formMap.put(new Point(3, 4), new Snake()); // 蛇精
			formMap.put(new Point(4, 3), new Monsters());
			formMap.put(new Point(5, 2), new Monsters());
			formMap.put(new Point(6, 3), new Monsters());
		}
	}
}
```



### （四）package world.entities

#### class Entity

- 生物实体类，是本版本相对以前版本的最大改变
 - 生物 + 位置 + 线程（行为），世界的每个生物都有其对应的实体
 - 使用接口 Runnable
 - 部分代码：

```java
public class Entity implements Runnable {
	public enum EntityState {
		LIVE, // 活着
		DEAD, // 死了
		OUT; // 超出世界范围
	}
	private EntityState state; // 状态
	private Creature creature; // 生物
	private Point position; // 位置
	private Thread thread; // 线程
	/**	自己死亡 */
	public void die() {
		state = EntityState.DEAD;
	}
	/**	自己出界 */
	public void out() {
		state = EntityState.OUT;
	}
    ...
	/**	向右下移动Entity
	 *	限制Entity类的所有实例的访问
	 */
	public void move(Point d) {
		synchronized (this) {
			// 若本次移动目标位置在世界范围之内且本实体是LIVE的
			if ((state == EntityState.LIVE) && (Global.inWorld(position.mov(d)))) {
				Entity target = CharWindow.getLiveEntityAt(position.mov(d));
				if (target != null) { // 与另一个实体相遇了
					// 同阵营则暂时重叠，反正到target的线程之后可以错开
					if (target.creature().getGroup() == creature.getGroup()) {
						position.reset(position.mov(d));
					}
					else { // 敌人决生死
						if (Global.win(creature.getGroup())) {
							target.die();
							position.reset(position.mov(d));
						}
						else this.die();
					}
				}
				else // 前面是空地，正常前进
					position.reset(position.mov(d));
			}
			else { // 本次移动目标位置超出世界范围
				position.reset(position.mov(d));
				out();
			}
		}
	}
	@Override
	public void run() {
		if (creature.getGroup() == GroupType.Bro)
			move(new Point(0, 1));
		else move(new Point(0, -1));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**	创建线程 */
	public void start() {
    	  thread = new Thread(this);
    	  thread.start();
	   }
}
```



### （五）package world.util

- 常用工具和类型声明

#### 1. enum CreatureType

- 生物的最细类别划分

- 成员：**Bro1**, **Bro2**, **Bro3**, **Bro4**, **Bro5**, **Bro6**, **Bro7**, **Eld**, **Scorp**, **Mons**, **Snk**



#### 2. enum FormationType

- 阵型类型（共8种）
- 成员：**HY**("鹤翼阵"), **YX**("雁行阵"), **CE**("冲轭阵"), **CS**("长蛇阵"), **YL**("鱼鳞阵"), **FY**("方円阵"), **YY**("偃月阵"), **FS**("锋矢阵")



#### 3. enum GroupType

- 阵营类型（葫芦娃，妖怪）
- 成员：**Bro**("葫芦娃"), **Mon**("妖怪")



#### 4. Point

- 点类型
- 包含的属性有：行，列
- 包含的方法有：得到点坐标，重设点坐标，复制点，反向点，移动点等



## 演示

![4.0](img_readme/4.0.gif)

