package being;

import battle.BattleFieldLattice;
import common.BeingMove;
import gui.Controller;
import javafx.geometry.Pos;
import position.Position;

import java.util.List;

import static being.CartoonCharacter.EMPTY_LABEL;

/**
 * @Description
 * @Author LUCUS BAI
 * @Date 2018/12/11
 */
public class Bullet extends Being {

    Being being;

    public Bullet(Being being) {
        super();
        this.being = being;
        this.setLabel("*");
        this.setNowPosition(this.being.getNowPosition());
        this.setSpeed(50);
    }

    @Override
    public synchronized void move(List<BattleFieldLattice> battleFieldLatticeList) {
        Position newPosition = new Position(-1, -1);
        if (this.being instanceof Evil) {
            newPosition = Position.move(this.getNowPosition(), 0, -1);
        } else if (this.being instanceof Justice) {
            newPosition = Position.move(this.getNowPosition(), 0, 1);
        } else {
            assert false;
        }

        if (battleFieldLatticeList.get(this.getNowPosition().toInt()).getBeing().getLabel().equals(EMPTY_LABEL)
         || battleFieldLatticeList.get(this.getNowPosition().toInt()).getBeing().getLabel().equals("*")) {
            battleFieldLatticeList.set(getNowPosition().toInt(), new BattleFieldLattice());
        }
        if (Position.isExceedBoundary(newPosition) || this.cartoonCharacterDetect(battleFieldLatticeList)) {
            this.setNowPosition(new Position(-1, -1));
            return;
        }
        if (battleFieldLatticeList.get(newPosition.toInt()).getBeing().getLabel().equals(EMPTY_LABEL)) {
            battleFieldLatticeList.set(newPosition.toInt(), new BattleFieldLattice(this));
        }
        this.setNowPosition(newPosition);
    }

    public synchronized boolean cartoonCharacterDetect(List<BattleFieldLattice> battleFieldLatticeList) {
        if (battleFieldLatticeList.get(this.getNowPosition().toInt()).getBeing().getLabel().equals(EMPTY_LABEL)
        ||  battleFieldLatticeList.get(this.getNowPosition().toInt()).getBeing().getLabel().equals("X")) {
            return false;
        } else if (battleFieldLatticeList.get(this.getNowPosition().toInt()).getBeing().getLabel().equals("*")) {
            return false;
        } else {
            Being cartoonCharacter = battleFieldLatticeList.get(this.getNowPosition().toInt()).getBeing();
            cartoonCharacter.hurt(this.being, battleFieldLatticeList);
            if (cartoonCharacter instanceof Evil) {

                if (this.being instanceof Justice) {
                    return true;
                }
            } else if (cartoonCharacter instanceof Justice) {

                if (this.being instanceof Evil) {
                    return true;
                }
            } else {
                assert false;
            }
        }

        return false;

    }
}
