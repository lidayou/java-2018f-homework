# 说明
## 上版本代码缺陷分析
1.Formation类 仅有将所有的阵法用数组形式存储在该类中，而阵法应该可以扩展
2.EnemyGroup将蝎子精和小喽啰放在一块进行处理
3.没有考虑非生物的存在，没有Creature没有从Being类继承
4.未使用RTTI,添加额外的判断，来识别葫芦娃一方与蛇精一方
## 本版本类图
1.beings包和calabashGroup和CalabashCompare类
![Image text](https://raw.githubusercontent.com/cockroach20168/java-2018f-homework/master/20180925/%E5%BC%A0%E6%98%8E%E8%B6%85-161220168/img/modified2.png)
2.formations包
![Image text](https://raw.githubusercontent.com/cockroach20168/java-2018f-homework/master/20180925/%E5%BC%A0%E6%98%8E%E8%B6%85-161220168/img/modified3.png)
## 类说明
### beings包
类名 | 描述 | 父类      
--------|--------|---------
Beings|存在（某种存在）具有位置属性|Object
Creature|生物（后续可能添加血量等属性）|Beings
NonCreature|非生物|Beings
JustParty|正义方|Creature
EvilParty|邪恶方|Creature
CalabashBrother|葫芦娃，具有独有的Color属性|JustParty
Grandfather|老爷爷，实现Cheer接口|JustParty
LittleMonster|小喽啰|EvilParty
Scorpion|蝎子精（作为大boss应该后续应该有区别于小怪之处）|EvilParty
Snake|蛇精，实现Cheer接口|EvilParty

### formation包
类名 | 描述 | 父类      
--------|--------|---------
Battlefield|由Being类型二维数组构成，存储该位置上的物体（生物或非生物）|Object
Formation|阵型由cheerPoint和阵型的点组成|Object
FormationType|enum类，记录所有阵型名|Object
BowandArrow|锋矢|Formation
CraneWing|鹤翼|Formation
CrescentMoon|偃月|Formation
FishSquama|鱼鳞|Formation
GeeseFlyShape|燕行|Formation
LongSnake|长蛇|Formation
SquareCircle|方円|Formation
XShape|冲轭|Formation

### CalabashGroup类，CalabashCompare类与World类
类名 | 描述 | 父类      
--------|--------|---------
CalabashGroup|由ArrayList<CalabashBrother>组成，具有shuffle和sort方法|Object
CalabashCompare|实现Comparator<CalabashBrother>接口|Object
World|main函数所在，负责创建所有的对象|Object

## 改进
1.使用ArrayList<CalabashBrother>来构建CalabashGroup类，通过实现Comparator 接口来完成排序，符合