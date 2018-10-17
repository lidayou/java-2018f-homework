public class test {/**创建人：陈剑豪 创建时间：2018.10.6*/
    public static void main(String[] args)
    {
        Space map=new Space(20);
        CalabashBrothers[] brothers=CalabashBrothers.birth();// 初始乱序产生
        CalabashBrothersSort.sortByName(brothers);// 有序排队
        map.singlelineBattleArray(brothers,6,5);//将葫芦娃排成长蛇阵

        ScorpionMonster scorpionMonster=new ScorpionMonster();
        Underlings[] underlings=new Underlings[6];
        for(int i=0;i<6;i++)
        {
            underlings[i]=new Underlings();
        }

        map.craneBattleArray(scorpionMonster,underlings,9,12);// 将蝎子和小喽啰排成鹤翼阵

        Grandparent grandparent=new Grandparent();
        map.putOnGrandparent(grandparent,9,2);// 将爷爷放在地图上

        SnakeMonster snakeMonster=new SnakeMonster();
        map.putOnSnakeMonster(snakeMonster,9,18);// 将蛇精放在地图上

        map.display();// 展示地图上站位情况

        map.remove();// 重置地图

        map.singlelineBattleArray(brothers,6,5);//将葫芦娃排成长蛇阵
        map.wildgooseBattleArray(scorpionMonster,underlings,12,10);// 将蝎子和小喽啰排成雁行阵
        map.putOnGrandparent(grandparent,1,1);// 将爷爷放进地图中
        map.putOnSnakeMonster(snakeMonster, 1,18);//  将蛇精放进地图中
        map.display();
    }

}
