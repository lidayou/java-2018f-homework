package being;

import common.RandomPosition;
import position.Position;

/**
 * @Description 爷爷
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */

public class Grandfather extends Justice implements CheerUp {

    public Grandfather() {
        super(RandomPosition.randomPosition(new Justice()), "g", 1, 20, 14, 300, 90, 150, 0, 0);
    }

    public void cheerUp() {
        assert false;
    }
}
