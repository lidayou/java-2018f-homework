package creature;

import environment.Battlefield;
import environment.Formation;

import java.util.ArrayList;
import java.util.Vector;

enum LeaderEnum {
    grandpa("爷爷", "$"),
    snake("蛇精", "&");

    private String name;
    private String sign;

    LeaderEnum(String argName, String argSign) {
        name = argName;
        sign = argSign;
    }

    public String getName() {
        return name;
    }
    public String getSign() {
        return sign;
    }
}

public class Leader extends Creature {
    ArrayList<Formation> strategies;
    int nowPtr;
    LeaderEnum id;

    public Leader(String argName) {
        strategies = new ArrayList<>(2);
        nowPtr = 0;

        for (int i = 0; i < LeaderEnum.values().length; ++i) {
            if (LeaderEnum.values()[i].getName().equals(argName)) {
                id = LeaderEnum.values()[i];
                sign = id.getSign();
                return;
            }
        }
        id = null;
        sign = "!";
        System.out.println("Cannot find Leader:" + argName);
    }

    public void addFormation(Formation fm) {
        strategies.add(fm);
    }
    public void embattle(Battlefield world, Creature[] kids) {
        nowPtr = (nowPtr + 1) % strategies.size();
        Formation fm = strategies.get(nowPtr);

        move(world, fm.getLeaderPos()[0], fm.getLeaderPos()[1]);

        for (int i = 0; i < kids.length; ++i) {
            int[] loc = fm.getCoord(i);
            kids[i].move(world, loc[0], loc[1]);
        }
    }
}
