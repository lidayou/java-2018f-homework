package being;

import common.RandomPosition;

/**
 * @Description 小怪
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */

public class LowLevelDemon extends Evil implements Fighting {

    public LowLevelDemon() {
        super(RandomPosition.randomPosition(new Evil()),"L", 1, 35,15, 1800, 220, 0, 6, 0);
    }

    public void fighting() {
        assert false;
    }

}
