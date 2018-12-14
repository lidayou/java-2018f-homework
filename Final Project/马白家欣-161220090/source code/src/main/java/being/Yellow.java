package being;

import common.RandomPosition;

/**
 * @Description 黄葫芦boy
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */

public class Yellow extends CalabashBrothers {
    public Yellow() {
        super(RandomPosition.randomPosition(new Justice()),"Y", 1, 30, 9, 8000, 90, 0, 10, 0);
    }
}
