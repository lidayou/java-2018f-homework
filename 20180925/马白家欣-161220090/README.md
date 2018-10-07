# 迭代2(2018.10.07)

## 新增功能

1. CartoonCharacter的显示变成了图形显示
2. 保留迭代1“功能2”，可通过改变public class BattleField中的GRAPHICAL_DISPLAY变量选择是否进行图形化显示，非图形化显示只用于debug

## 其它说明

1.   *.jar文件直接运行可看到程序运行效果

2.   尚未解决：每进行一轮显示，窗口会发生一次闪烁

# 迭代1(2018.09.27)

## 注意

1. 如果需要在命令行运行，需要加上参数 -ea，用来启用assert，当然如果你希望一些能发现重要错误的assert无效的话以此使得程序能不受中断持续运行，那么可以不添加这个参数
2. 蛇精代表字母是s，蝎子精代表字母是S，并且他们的底色都是灰色，区别仅在大小写

## 一些功能

1. 正义阵营和邪恶阵营的阵型不会彼此交叠，也不会越过边界
2. 使用了ANSI转义字符，因而不同的CartoonCharacter具有不同的底色

## 类及相关说明

#### CartoonCharacter相关

```Java
public class CartoonCharacter //用来描述某个卡通角色的具体情况，包含toString方法的重载来实现ANSI转义字符打印
```

```Java
public enum CartoonCharacterInfo //用来记录CartoonCharacter的具体信息的枚举类，包含了label、ANSIColorPrefix等成员，可在toString方法下形成直接可输出的ANSI转移字符串
```

#### CartoonCharacter在BattleField上的移动相关

```Java
public class BattleCoordinator //主类，用来控制战局的推进（生成随机位置、生成随机阵型、生成新阵型）
```

```Java
public class BattleField //控制整个战场，具体来说，包含一个BattleFieldLattice类型数组，并调用BattleFieldLattice的方法来操作具体的每个战场格的行为
```

```Java
public class BattleFieldLattice //记录一个位于本方格的CartoonCharacter和当前坐标
```

```Java
public enum Formation //枚举类，枚举出各种阵型以及阵型所占的尺寸，包含一些static方法用来改变BattleField上的CartoonCharacter分布
```

#### 其它

```Java
public class Position //记录一个坐标，由(row, col)组成，用途广泛
```

## 其它说明

1. 对“请选择合适位置将老爷爷和蛇精放置于空间中，为各自一方加油助威”的要求真的不能完全的理解，所以目前的实现是，老爷爷和蛇精虽然不在阵中，但是位于阵型旁边的确定位置