# hw3 girls und panzer

## 前言
这次的更新我是从对solid原则的检查开始的，看了下srp原则没啥问题，然后在对ocp原则的检查中发现所有人物有关的类都没有构造函数这个比较大的问题，于是添加了构造函数。
再者，发现所有类当中的变量都基本没有加上private，protected等限制，于是添加上。然后又觉得说oral gray和别的stggc的成员有一个有没有颜色上的区别，所以又把stggc_student和seggc_teammember做了区别，让后者继承前者。
然后突然觉得自己的整个结构都有问题，于是重新写了一下。

## package & class
