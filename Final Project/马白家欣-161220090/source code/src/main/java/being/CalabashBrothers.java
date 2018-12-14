package being;

import position.Position;

/**
 * @Description 葫芦兄弟，也是所有葫芦boys的父类
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */

public class CalabashBrothers extends Justice implements Fighting {

    CalabashBrothers(Position nowPosition, String label, int movingRange, int speed, int attackSpeed,
                     int hp, int attack, int recover, int dodgeRate, int absorptionRate) {
        super(nowPosition, label, movingRange, speed, attackSpeed, hp, attack, recover, dodgeRate, absorptionRate);
    }

    public void fighting() {
        assert false;
    }

}
