package common;

import being.Being;
import being.Evil;
import being.Justice;
import gui.Controller;
import javafx.geometry.Pos;
import position.Position;

import java.util.Collection;
import java.util.Random;


/**
 * @Description
 * @Author LUCUS BAI
 * @Date 2018/12/12
 */

enum Direction {
    UP(0), DOWN(1), LEFT(2), RIGHT(3);
    private int value;
    Direction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

public class BeingMove {

    public static synchronized Position beingMove(Position position, Being being) {
        Position newPosition = new Position(-1, -1);
        do {
            Random random = new Random();
            int range = random.nextInt(being.getMovingRange()) + 1;
            int direction = random.nextInt(Direction.values().length);
            if (direction == Direction.UP.getValue()) {
                newPosition = new Position(Position.move(position, -1 * range, 0));
            } else if (direction == Direction.DOWN.getValue()) {
                newPosition = new Position(Position.move(position, range, 0));
            } else if (direction == Direction.LEFT.getValue()) {
                newPosition = new Position(Position.move(position, 0, -1 * range));
            } else if (direction == Direction.RIGHT.getValue()) {
                newPosition = new Position(Position.move(position, 0, range));
            } else {
                assert false;
            }
        } while (!(
                ((being instanceof Evil && newPosition.getCol() >= Controller.FIELD_WIDTH/2 && newPosition.getCol() < Controller.FIELD_WIDTH)
                || (being instanceof Justice && newPosition.getCol() >= 0 && newPosition.getCol() < Controller.FIELD_WIDTH/2))
                && (newPosition.getRow() >= 0 && newPosition.getRow() < Controller.FIELD_HEIGHT)));

        return newPosition;
    }
}
