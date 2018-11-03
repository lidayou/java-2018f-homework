# 第三次作业

## 更新
1. 将每个类单独放在一个文件中，而不是将多个类先写在一个文件里，使代码结构更清晰
2. 由于不需要Unit实例，而是用其他生物类继承此类，因此将Unit改为抽象类，并将getName改为抽象方法，以供子类重写
3. 新增leader接口，提供cheer方法
4. 新增Camp类、Formation类
5. 删除Player类中除main方法以外的方法，并将其移动到BattleField类和Formation类中

## 设计思想
1. BattleField类构建了战场，其成员包含了Cell类，即战场上的每个格子，格子记录了在其上的Unit。BattleField类还提供了setUnit方法，能将一个Unit对象放置在战场上。
2. Unit类是一个 **抽象类**，因为它作为基类，而且并不需要Unit实例。Grandpa、Scorpion、Snake、Monster、CalaBashBrother这五个类继承基类Unit，并包含自己的独特的属性。所有的单位都有自己的名字，并且知道自己所处的位置坐标。设计继承关系的好处在于不仅能使得对象之间的关系更加清晰，还能为其他类中的方法提供统一的调用参数，避免了相同方法不同参数类型的重载。
3. Grandpa、Snake作为leader，可以为其他对象加油，因此有一个leader接口，用于规范leader对象的行为，即可以cheer。
4. 由于涉及到阵营的阵型变换，因此创建了Camp类和Formation类，Camp类存储了该阵营的成员（用Unit类型的Arraylist）和leader。Formation类则针对Camp类提供了不同阵型变换的方法。

## 用到的机制及好处
 - 封装：此程序封装了9个类，好处在于能隐藏内部实现，提高代码的安全性，也使得代码便于理解
 - 继承：Grandpa、Scorpion、Snake、Monster、CalaBashBrother继承了父类Unit，提高了代码的复用性和可维护性，使类与类之间产生关系，便于理解，也能大大减少代码的冗余程度
 - 多态：Unit的子类重写了父类的方法，在编译器进行动态绑定后，可根据对象类型来调用不同子类的方法，提高可扩充性和可维护性

## 后续思考
1. 由于Camp类中的成员是以Unit类型存储的，因此，这个类只能用于为阵型变换提供方便（一种阵型只需要写一个方法），涉及到调用5个子类自己的方法时，不能直接用Camp类。
2. 5类生物大致分为两种，一种是能cheer的leader（2类），另一种是能战斗的soldier（3类），后续应该提供两种接口以统一方法，但在调用时不能将这些子类放在Unit类型的容器中。