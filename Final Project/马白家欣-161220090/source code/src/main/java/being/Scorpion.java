package being;

import common.RandomPosition;

/**
 * @Description 蝎子精
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */

public class Scorpion extends Evil implements Fighting{

    public Scorpion() {
        super(RandomPosition.randomPosition(new Evil()),"S", 1, 30, 11, 2400, 450, 0, 5, 0);
    }

    public void fighting() {
        assert false;
    }

}
