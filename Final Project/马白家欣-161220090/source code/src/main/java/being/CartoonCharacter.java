package being;

import battle.BattleFieldLattice;
import common.BeingMove;
import common.Posibility;
import gui.Controller;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import multithread.BulletLoop;
import position.Position;

import java.util.List;
import java.util.concurrent.locks.Lock;

/**
 * @Description 卡通人物（而不是卡通字符）
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */

public class CartoonCharacter extends Being {

    public static final String EMPTY_LABEL = "V";

    public CartoonCharacter() {
        super();
    }

    public CartoonCharacter(Position nowPosition, String label, int movingRange, int speed, int attackSpeed,
                            int hp, int attack, int recover, int dodgeRate, int absorptionRate) {
        super(nowPosition, label, movingRange, speed, attackSpeed, hp, attack, recover, dodgeRate, absorptionRate);
    }

    @Override
    public synchronized void move(List<BattleFieldLattice> battleFieldLatticeList) {
        Position newPosition = BeingMove.beingMove(this.getNowPosition(), this);
        if(battleFieldLatticeList.get(newPosition.toInt()).getBeing().getLabel().equals(EMPTY_LABEL)) {
            battleFieldLatticeList.set(getNowPosition().toInt(), new BattleFieldLattice());
            battleFieldLatticeList.set(newPosition.toInt(), new BattleFieldLattice(this));
            this.setNowPosition(newPosition);
        }
    }

    @Override
    public synchronized void attack(Canvas mainCanvas, List<BattleFieldLattice> battleFieldLatticeList, Lock lock) {
        new Thread(new BulletLoop(mainCanvas, new Bullet(this), battleFieldLatticeList, lock)).start();
    }

    @Override
    public synchronized void hurt(Being hurtFrom, List<BattleFieldLattice> battleFieldLatticeList) {
        /*恢复*/
        if((this instanceof Evil && hurtFrom instanceof Evil)
        || (this instanceof Justice && hurtFrom instanceof Justice)){
            this.hpIncrease(hurtFrom.getRecover());
            return;
        }

        /*避闪*/
        if(Posibility.percentage(this.getDodgeRate())) {
           return;
        }

        /*吸收伤害*/
        if(Posibility.percentage(this.getAbsorptionRate())) {
            this.hpIncrease(hurtFrom.getAttack());
        }
        else {
            this.hpDecrease(hurtFrom.getAttack());
        }
    }

    public synchronized boolean isDead(List<BattleFieldLattice> battleFieldLatticeList) {
        if(this.getRemainedHpRate() == 0) {
            battleFieldLatticeList.set(this.getNowPosition().toInt(), new BattleFieldLattice(new Gravestone()));
            return true;
        }
        else {
            return false;
        }
    }

    public synchronized boolean isOver(List<BattleFieldLattice> battleFieldLatticeList) {
        int beingCount = 0;
        if(this instanceof Evil) {
            for(int row = 0; row < Controller.FIELD_HEIGHT; row++) {
                for (int col = 0; col < Controller.FIELD_WIDTH / 2; col++) {
                    if (!battleFieldLatticeList.get((new Position(row, col)).toInt()).getBeing().getLabel().equals(EMPTY_LABEL)
                     && !battleFieldLatticeList.get((new Position(row, col)).toInt()).getBeing().getLabel().equals("*")
                     && !battleFieldLatticeList.get((new Position(row, col)).toInt()).getBeing().getLabel().equals("X")) {
                        return false;
                    }
                    if (!battleFieldLatticeList.get((new Position(row, col)).toInt()).getBeing().getLabel().equals(EMPTY_LABEL)) {
                        beingCount++;
                    }
                }
            }
            if(beingCount == 0) {
                return false;
            }
            else {
                return true;
            }
        }
        else if(this instanceof Justice) {
            for(int row = 0; row < Controller.FIELD_HEIGHT; row++) {
                for (int col = Controller.FIELD_WIDTH / 2; col < Controller.FIELD_WIDTH; col++) {
                    if (!battleFieldLatticeList.get((new Position(row, col)).toInt()).getBeing().getLabel().equals(EMPTY_LABEL)
                            && !battleFieldLatticeList.get((new Position(row, col)).toInt()).getBeing().getLabel().equals("*")
                            && !battleFieldLatticeList.get((new Position(row, col)).toInt()).getBeing().getLabel().equals("X")) {
                        return false;
                    }
                    if (!battleFieldLatticeList.get((new Position(row, col)).toInt()).getBeing().getLabel().equals(EMPTY_LABEL)) {
                        beingCount++;
                    }
                }
            }
            if(beingCount == 0) {
                return false;
            }
            else {
                return true;
            }
        }
        else {
            assert false;
        }
        return false;
    }
}
