package being;

import common.RandomPosition;

/**
 * @Description 蛇精
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */

public class Snake extends Evil implements CheerUp {

    public Snake() {
        super(RandomPosition.randomPosition(new Evil()),"s", 1, 69, 15, 2800, 200, 0, 35, 0);
    }

    public void cheerUp() {
        assert false;
    }
}
