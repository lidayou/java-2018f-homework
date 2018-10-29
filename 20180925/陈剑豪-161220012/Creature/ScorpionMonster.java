package Creature;
import BattleField.*;
/**
 * @ Author     ：cjh
 * @ Description：蝎子精
 */
public class ScorpionMonster extends Creature {
    public ScorpionMonster()
    {
        name="蝎子";
    }
    @Override
    public void standOnMap(int i,int j)
    {
        row=i;
        column=j;
        Space.space[i][j]=Existance.scorpion;
    }
}
