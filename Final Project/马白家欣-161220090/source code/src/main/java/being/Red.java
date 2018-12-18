package being;

import common.RandomPosition;

/**
 * @Description 红葫芦boy
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */

public class Red extends CalabashBrothers {
    public Red() {
        super(RandomPosition.randomPosition(new Justice()),"R", 4, 20, 12, 2000, 800, 0, 5, 0);
    }
}
