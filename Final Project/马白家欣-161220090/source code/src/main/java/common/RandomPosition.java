package common;

import being.Being;
import being.Evil;
import being.Justice;
import gui.Controller;
import position.Position;

import java.util.Random;

/**
 * @Description
 * @Author LUCUS BAI
 * @Date 2018/12/12
 */
public class RandomPosition {

    public static synchronized Position randomPosition(Being being) {
        Random random = new Random();
        int row = random.nextInt(Controller.FIELD_HEIGHT);
        int col = -1;
        if (being instanceof Evil) {
            col = random.nextInt(Controller.FIELD_WIDTH / 2) + Controller.FIELD_WIDTH / 2;
        }
        else if(being instanceof Justice) {
            col = random.nextInt(Controller.FIELD_WIDTH / 2);
        }
        else {
            assert false;
        }
        return new Position(row, col);
    }
}
