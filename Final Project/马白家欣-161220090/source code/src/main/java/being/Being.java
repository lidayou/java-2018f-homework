package being;

import battle.BattleFieldLattice;
import javafx.scene.canvas.Canvas;
import position.Position;

import java.util.List;
import java.util.concurrent.locks.Lock;

import static being.CartoonCharacter.EMPTY_LABEL;

/**
 * @Description 为了便于拓展，或许以后会加入非CartoonCharacter的类
 * @Author LUCUS BAI
 * @Date 2018/10/23
 */
public class Being {
    private Position nowPosition;
    private String label;

    private int movingRange;
    private int speed;
    private int attackSpeed;

    private int hp;
    private int remainedHp;
    private int attack;
    private int recover;
    private int dodgeRate;
    private int absorptionRate;

    public Being() {
        this.label = EMPTY_LABEL;
        this.movingRange = -1;
        this.speed = -1;
        this.attackSpeed = -1;
        this.hp = 0;
        this.remainedHp = hp;
        this.attack = -1;
        this.recover = -1;
        this.dodgeRate = -1;
        this.absorptionRate = -1;
    }

    public Being(Position nowPosition, String label, int movingRange, int speed, int attackSpeed,
                 int hp, int attack, int recover, int dodgeRate, int absorptionRate) {
        this.nowPosition = nowPosition;
        this.label = label;
        this.movingRange = movingRange;
        this.speed = speed;
        this.attackSpeed = attackSpeed;
        this.hp = hp;
        this.remainedHp = hp;
        this.attack = attack;
        this.recover = recover;
        this.dodgeRate = dodgeRate;
        this.absorptionRate = absorptionRate;
    }

    public Position getNowPosition() {
        return nowPosition;
    }

    public void setNowPosition(Position nowPosition) {
        this.nowPosition = nowPosition;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getMovingRange() {
        return movingRange;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public int getRemainedHp() {
        return remainedHp;
    }

    public void setRemainedHp(int remainedHp) {
        this.remainedHp = remainedHp;
    }

    public int getRemainedHpRate() {
        return (100 * this.remainedHp)/this.hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getRecover() {
        return recover;
    }

    public int getDodgeRate() {
        return dodgeRate;
    }

    public int getAbsorptionRate() {
        return absorptionRate;
    }

    public void hpDecrease(int hp) {
        if(this.remainedHp - hp >= 0) {
            this.remainedHp -= hp;
        }
        else {
            this.remainedHp = 0;
        }
    }

    public void hpIncrease(int hp) {
        if(this.remainedHp + hp <= this.hp) {
            this.remainedHp += hp;
        }
        else {
            this.remainedHp = this.hp;
        }

    }

    public synchronized void move(List<BattleFieldLattice> battleFieldLatticeList) {
        assert false : "move() must be overridden！";
    }

    public synchronized void attack(Canvas mainCanvas, List<BattleFieldLattice> battleFieldLatticeList, Lock lock) {
        assert false : "attack() must be overridden！";
    }

    public synchronized void hurt(Being hurtFrom, List<BattleFieldLattice> battleFieldLatticeList) {
        assert false : "hurt() must be overridden！";
    }

    public synchronized boolean isDead(List<BattleFieldLattice> battleFieldLatticeList) {
        assert false : "isDead() must be overridden！";
        return false;
    }

    public synchronized boolean isOver(List<BattleFieldLattice> battleFieldLatticeList) {
        assert false : "isOver() must be overridden！";
        return false;
    }

}
