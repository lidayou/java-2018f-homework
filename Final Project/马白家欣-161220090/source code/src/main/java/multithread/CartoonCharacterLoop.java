package multithread;

import battle.BattleFieldLattice;
import being.Being;
import being.Justice;
import gui.Controller;
import javafx.scene.canvas.Canvas;
import position.Position;

import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;

import static gui.Controller.FIELD_WIDTH;

/**
 * @Description
 * @Author LUCUS BAI
 * @Date 2018/12/12
 */
public class CartoonCharacterLoop implements Runnable {

    private static Random random = new Random();
    private Canvas mainCanvas;
    private Lock lock;
    private Being being;
    private List<BattleFieldLattice> battleFieldLatticeList;

    static final int LOOP_DURATION = 1800;
//    static final int LOOP_DURATION = 0;
    private static final int LOOP_SUPER_ATTACK = 15;
//    static final int LOOP_SUPER_ATTACK_MAINTAIN = 100;

    public CartoonCharacterLoop(Canvas mainCanvas, Being being, List<BattleFieldLattice> battleFieldLatticeList, Lock lock) {
        this.mainCanvas = mainCanvas;
        this.being = being;
        this.battleFieldLatticeList = battleFieldLatticeList;
        this.lock = lock;
    }

    @Override
    public synchronized void run() {
        int moveLoopCount = 0;
        int attackLoopCount = 0;
        int attackCount = 0;
        while (true) {
            moveLoopCount++;
            attackLoopCount++;
            lock.lock();
            try {
                if(being.isDead(this.battleFieldLatticeList) || being.isOver(this.battleFieldLatticeList)) {
                    break;
                }
            } finally {
                lock.unlock();
            }

            if(moveLoopCount >= LOOP_DURATION / this.being.getSpeed()) {
                lock.lock();
                try {
                    being.move(this.battleFieldLatticeList);
                } finally {
                    lock.unlock();
                }
                moveLoopCount = 0;
//                lock.lock();
//                try {
//                    Controller.displayBattleField(this.mainCanvas, this.battleFieldLatticeList);
//                } finally {
//                    lock.unlock();
//                }

            }
            if(attackLoopCount >= LOOP_DURATION / this.being.getAttackSpeed()) {
                lock.lock();
                try {
                    attackCount++;
                    if(attackCount >= LOOP_SUPER_ATTACK && this.being instanceof Justice) {
                        being.attack(mainCanvas, this.battleFieldLatticeList, this.lock, true);
                        attackCount = 0;
                    }
                    else {
                        being.attack(mainCanvas, this.battleFieldLatticeList, this.lock, false);
                    }

                }finally {
                    lock.unlock();
                }
                attackLoopCount = 0;
            }

            try {
                Thread.sleep(random.nextInt(20) + 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
