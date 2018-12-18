package multithread;

import battle.BattleFieldLattice;
import battle.BattleResult;
import being.*;
import gui.Controller;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.io.*;
import java.util.List;
import java.util.concurrent.locks.Lock;

/**
 * @Description
 * @Author LUCUS BAI
 * @Date 2018/12/12
 */
public class BattleMainLoop implements Runnable{

    private Lock lock;
    private Canvas mainCanvas;
    private List<BattleFieldLattice> battleFieldLatticeList;
    private boolean isBattle;
    private File outfile;
    private BufferedReader infile;
    private static final String FILE_PATH = "." + File.separator + "output.txt";
    private static final int LOW_LEVEL_DEMON_COUNT = 10;
    private static final int LOOP_SUPER_ATTACK_MAINTAIN = 20;


    public BattleMainLoop(Canvas mainCanvas, List<BattleFieldLattice> battleFieldLatticeList, Lock lock, boolean isBattle) {
        this.mainCanvas = mainCanvas;
        this.battleFieldLatticeList = battleFieldLatticeList;
        this.lock = lock;
        this.outfile = new File(FILE_PATH);

        this.isBattle = isBattle;
    }

    @Override
    public synchronized void run() {
        if(this.isBattle) {
            battle();
        }
        else {
            recurrent();
        }
    }

    private void battle() {
        new Thread(new CartoonCharacterLoop(mainCanvas, new Red(), battleFieldLatticeList, lock)).start();
        new Thread(new CartoonCharacterLoop(mainCanvas, new Orange(), battleFieldLatticeList, lock)).start();
        new Thread(new CartoonCharacterLoop(mainCanvas, new Yellow(), battleFieldLatticeList, lock)).start();
        new Thread(new CartoonCharacterLoop(mainCanvas, new Green(), battleFieldLatticeList, lock)).start();
        new Thread(new CartoonCharacterLoop(mainCanvas, new Cyan(), battleFieldLatticeList, lock)).start();
        new Thread(new CartoonCharacterLoop(mainCanvas, new Blue(), battleFieldLatticeList, lock)).start();
        new Thread(new CartoonCharacterLoop(mainCanvas, new Purple(), battleFieldLatticeList, lock)).start();
        new Thread(new CartoonCharacterLoop(mainCanvas, new Grandfather(), battleFieldLatticeList, lock)).start();
        new Thread(new CartoonCharacterLoop(mainCanvas, new Scorpion(), battleFieldLatticeList, lock)).start();
        new Thread(new CartoonCharacterLoop(mainCanvas, new Snake(), battleFieldLatticeList, lock)).start();
        for(int i = 0; i < LOW_LEVEL_DEMON_COUNT; i++) {
            new Thread(new CartoonCharacterLoop(mainCanvas, new LowLevelDemon(), battleFieldLatticeList, lock)).start();
        }

        /*文件操作*/
        if(outfile.exists()) {
            if(!outfile.delete()) {
                assert false;
                return;
            }
        }
        try {
            if(!outfile.createNewFile()) {
                assert false;
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileWriter fw;
        try {
            fw = new FileWriter(outfile,true);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        BufferedWriter bw = new BufferedWriter(fw);

        Thread.yield();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true) {
            lock.lock();
            try {
                bw.write(battleFieldLatticeListToString());

                Being superAttackBeing = this.superAttackDetect();
                if(superAttackBeing != null) {

                    for(int i = 0; i < LOOP_SUPER_ATTACK_MAINTAIN; i++) {
                        Controller.displayBattleField(this.mainCanvas, this.battleFieldLatticeList);
                        Controller.displaySuperAttack(mainCanvas, superAttackBeing, (double) i / LOOP_SUPER_ATTACK_MAINTAIN);
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    for(int i = LOOP_SUPER_ATTACK_MAINTAIN; i >= 0; i--) {
                        Controller.displayBattleField(this.mainCanvas, this.battleFieldLatticeList);
                        Controller.displaySuperAttack(mainCanvas, superAttackBeing, (double) i / LOOP_SUPER_ATTACK_MAINTAIN);
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

                Controller.displayBattleField(this.mainCanvas, this.battleFieldLatticeList);

                if(this.winner() == BattleResult.CALABASH_BROTHERS) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Controller.displayResults(this.mainCanvas, BattleResult.CALABASH_BROTHERS);
                    break;
                }
                else if(this.winner() == BattleResult.DEMON) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Controller.displayResults(this.mainCanvas, BattleResult.DEMON);
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            } finally {
                lock.unlock();
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void recurrent() {
        if(!outfile.exists()) {
            return;
        }
        try {
            infile = new BufferedReader(new FileReader(FILE_PATH));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String contentLine;
        try {
            contentLine = infile.readLine();
            int lineCount = 0;
            while (contentLine != null) {
                if(lineCount >= Controller.FIELD_WIDTH * Controller.FIELD_HEIGHT) {
                    Controller.displayBattleField(mainCanvas, battleFieldLatticeList);
                    lineCount = 0;
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                this.battleFieldLatticeList.set(lineCount, stringToBattleFieldLattice(contentLine));
                contentLine = infile.readLine();
                lineCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Controller.displayBattleField(mainCanvas, battleFieldLatticeList);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(this.winner() == BattleResult.CALABASH_BROTHERS) {
            Controller.displayResults(this.mainCanvas, BattleResult.CALABASH_BROTHERS);
        }
        else if(this.winner() == BattleResult.DEMON) {
            Controller.displayResults(this.mainCanvas, BattleResult.DEMON);
        }


    }

    private Being superAttackDetect() {
        for (BattleFieldLattice aBattleFieldLatticeList : this.battleFieldLatticeList) {
            if (aBattleFieldLatticeList.getBeing().getLabel().equals("+") &&
              !((Bullet) aBattleFieldLatticeList.getBeing()).isChecked()) {
                ((Bullet) aBattleFieldLatticeList.getBeing()).setChecked(true);
                return ((Bullet) aBattleFieldLatticeList.getBeing()).getBeing();
            }
        }
        return null;
    }

    private BattleResult winner() {
        Evil evil = new Evil();
        if(evil.isOver(this.battleFieldLatticeList)) {
            return BattleResult.DEMON;
        }

        Justice justice = new Justice();
        if(justice.isOver(this.battleFieldLatticeList)) {
            return BattleResult.CALABASH_BROTHERS;
        }

        return BattleResult.RUNNING;
    }

    /*战场方格List转化为可保存的String*/
    private String battleFieldLatticeListToString() {
        StringBuilder resultString = new StringBuilder();
        for(int i = 0; i < battleFieldLatticeList.size(); i++) {
            Being being = battleFieldLatticeList.get(i).getBeing();
            resultString.append(being.getLabel()).append(being.getRemainedHp()).append(System.lineSeparator());
        }
        return resultString.toString();
    }

    /*String转化为战场方格和其中的对象信息*/
    private BattleFieldLattice stringToBattleFieldLattice(String string) {
        String label = string.substring(0, 1);
        int hp = Integer.parseInt(string.substring(1));
        if (label.equals("*")) {
            return new BattleFieldLattice(new Bullet(new Being(), false));
        } else if (label.equals("+")) {
            return new BattleFieldLattice(new Bullet(new Being(), true));
        } else if (label.equals("R")) {
            Being being = new Red();
            being.setRemainedHp(hp);
            return new BattleFieldLattice(being);
        } else if (label.equals("O")) {
            Being being = new Orange();
            being.setRemainedHp(hp);
            return new BattleFieldLattice(being);
        } else if (label.equals("Y")) {
            Being being = new Yellow();
            being.setRemainedHp(hp);
            return new BattleFieldLattice(being);
        } else if (label.equals("G")) {
            Being being = new Green();
            being.setRemainedHp(hp);
            return new BattleFieldLattice(being);
        } else if (label.equals("C")) {
            Being being = new Cyan();
            being.setRemainedHp(hp);
            return new BattleFieldLattice(being);
        } else if (label.equals("B")) {
            Being being = new Blue();
            being.setRemainedHp(hp);
            return new BattleFieldLattice(being);
        } else if (label.equals("P")) {
            Being being = new Purple();
            being.setRemainedHp(hp);
            return new BattleFieldLattice(being);
        } else if (label.equals("g")) {
            Being being = new Grandfather();
            being.setRemainedHp(hp);
            return new BattleFieldLattice(being);
        } else if (label.equals("S")) {
            Being being = new Scorpion();
            being.setRemainedHp(hp);
            return new BattleFieldLattice(being);
        } else if (label.equals("s")) {
            Being being = new Snake();
            being.setRemainedHp(hp);
            return new BattleFieldLattice(being);
        } else if (label.equals("L")) {
            Being being = new LowLevelDemon();
            being.setRemainedHp(hp);
            return new BattleFieldLattice(being);
        } else if (label.equals("X")) {
            return new BattleFieldLattice(new Gravestone());
        } else if (label.equals(CartoonCharacter.EMPTY_LABEL)) {
            return new BattleFieldLattice();
        } else {
            assert false;
            return null;
        }
    }
}
