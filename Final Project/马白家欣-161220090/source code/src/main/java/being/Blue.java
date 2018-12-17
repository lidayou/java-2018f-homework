package being;

import common.RandomPosition;
import position.Position;

import java.util.Random;

/**
 * @Description 蓝葫芦boy
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */
public class Blue extends CalabashBrothers {
    public Blue() {
        super(RandomPosition.randomPosition(new Justice()),"B", 1, 180, 30, 2200, 150, 0, 9, 0);
    }
}
