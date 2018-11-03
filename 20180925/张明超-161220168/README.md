# 说明
## 上版本代码缺陷分析
1.Formation类 仅有将所有的阵法用数组形式存储在该类中，而阵法应该可以扩展
2.EnemyGroup将蝎子精和小喽啰放在一块进行处理
3.没有考虑非生物的存在，没有Creature没有从Being类继承
4.未使用RTTI,添加额外的判断，来识别葫芦娃一方与蛇精一方
## 本版本类图
1.beings和calabashGroup
![Image text](https://raw.githubusercontent.com/cockroach20168/java-2018f-homework/master/20180925/%E5%BC%A0%E6%98%8E%E8%B6%85-161220168/img/modified1.png)
2.一系列阵型
![Image text]()
##