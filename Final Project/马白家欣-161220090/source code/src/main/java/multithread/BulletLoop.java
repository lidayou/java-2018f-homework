package multithread;

import battle.BattleFieldLattice;
import being.Being;
import being.Bullet;
import gui.Controller;
import javafx.scene.canvas.Canvas;
import position.Position;

import java.util.List;
import java.util.concurrent.locks.Lock;

import static multithread.CartoonCharacterLoop.LOOP_DURATION;

/**
 * @Description
 * @Author LUCUS BAI
 * @Date 2018/12/12
 */
public class BulletLoop implements Runnable {

    private Canvas mainCanvas;
    private Lock lock;
    private Bullet bullet;
    private List<BattleFieldLattice> battleFieldLatticeList;

    public BulletLoop(Canvas mainCanvas, Bullet bullet, List<BattleFieldLattice> battleFieldLatticeList, Lock lock) {
        this.mainCanvas = mainCanvas;
        this.bullet = bullet;
        this.battleFieldLatticeList = battleFieldLatticeList;
        this.lock = lock;
    }

    @Override
    public synchronized void run() {
        int loopCount = 0;
        while (true) {
            loopCount++;
            if (loopCount >= LOOP_DURATION / bullet.getSpeed()) {
                lock.lock();
                try {
                    bullet.move(this.battleFieldLatticeList);
                    if (Position.isExceedBoundary(bullet.getNowPosition())) {
                        break;
                    }
                } finally {
                    lock.unlock();
                }
//                    lock.lock();
//                    try {
//                        Controller.displayBattleField(this.mainCanvas, this.battleFieldLatticeList);
//                    } finally {
//                        lock.unlock();
//                    }

                loopCount = 0;
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
