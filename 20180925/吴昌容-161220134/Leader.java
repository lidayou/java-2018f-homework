package creature;

import environment.Battlefield;
import environment.Formation;

import java.util.Vector;

public class Leader extends Creature{
    Vector strategies;
    int nowPtr;
    String name;

    public Leader(String argName, String argSign) {
        strategies = new Vector(2);
        nowPtr = 0;
        name = argName;
        sign = argSign;
    }

    public void addFormation(Formation fm) {
        strategies.add(fm);
    }
    public void embattle(Battlefield world, Creature[] kids) {
        nowPtr = (nowPtr + 1) % strategies.size();
        Formation fm = (Formation) strategies.get(nowPtr);

        move(world, fm.getLeaderPos()[0], fm.getLeaderPos()[1]);

        for (int i = 0; i < kids.length; ++i) {
            int[] loc = fm.getCoord(i);
            kids[i].move(world, loc[0], loc[1]);
        }
    }
}
