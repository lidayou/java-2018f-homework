import java.lang.reflect.Array;
import java.text.Normalizer;
import java.util.*;

public class Battle{
    public static void main(String[] args){
        Space battlefield = new Space(20,20);
        Manipulator god = new Manipulator();

        //create and place calabash brothers
        ArrayList<Creature> CalabashBrothers = new ArrayList<>();
        CalabashBrothers.add(new Calabash(CalabashRank.FIRST));
        CalabashBrothers.add(new Calabash(CalabashRank.SECOND));
        CalabashBrothers.add(new Calabash(CalabashRank.THIRD));
        CalabashBrothers.add(new Calabash(CalabashRank.FORTH));
        CalabashBrothers.add(new Calabash(CalabashRank.FIFTH));
        CalabashBrothers.add(new Calabash(CalabashRank.SIXTH));
        CalabashBrothers.add(new Calabash(CalabashRank.SEVENTH));
        god.placeFormation(battlefield,new SnakeFormation(CalabashBrothers.size()),CalabashBrothers,4,3);

        //create and place grandpa&snake
        GoodBoss grandpa = new GoodBoss('爷');
        BadBoss snake= new BadBoss('蛇');
        god.placeCharacter(battlefield,grandpa,7,1);
        god .placeCharacter(battlefield,snake,3,18);

        //create and place monsters
        ArrayList<Creature> ScorpionSquad = new ArrayList<>();
        ScorpionSquad.add(new Scorpion());
        for(int i=0;i<8;i++)
            ScorpionSquad.add(new LittleMonster());
        god.placeFormation(battlefield,new WingFormation(ScorpionSquad.size()),ScorpionSquad,5,10);
        battlefield.display();

        //changer the formation of monsters
        god.removeCharacter(battlefield,ScorpionSquad);
        ScorpionSquad.add(new LittleMonster());
        ScorpionSquad.add(new LittleMonster());
        god.placeFormation(battlefield,new GeeseFormation(ScorpionSquad.size()),ScorpionSquad,5,7);
        battlefield.display();
    }
}
