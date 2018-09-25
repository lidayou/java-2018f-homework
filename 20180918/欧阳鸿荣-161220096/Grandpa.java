package calabashBrothers;

import java.util.Random;

/**
 * @ Author     ：Young
 * @ Description：葫芦娃爷爷
 */

public class Grandpa {

    private CalabashBrothers[] boys;
    private int boysNumber;

    public Grandpa() {
        this.findCalabashBrothers();
    }

    private void findCalabashBrothers() {
        this.boysNumber = 7;
        this.boys = new CalabashBrothers[this.boysNumber];
        for (int i = 0; i < boys.length; i++) {
            boys[i] = CalabashBrothers.values()[i];
        }
    }

    private void swapBoys(int i, int j) {
        CalabashBrothers tmp = boys[i];
        boys[i] = boys[j];
        boys[j] = tmp;
    }

    private void swapBoysWithReport(int i, int j) {
        System.out.println(boys[i].getName() + ":" + i + "->" + j);
        System.out.println(boys[j].getName() + ":" + j + "->" + i);
        CalabashBrothers tmp = boys[i];
        boys[i] = boys[j];
        boys[j] = tmp;
    }

    public void disruptQueue() {
        Random rand = new Random();
        int randTimes = rand.nextInt(100) + 50;
        int m;
        int n;
        for (int i = 0; i < randTimes; i++) {
            m = rand.nextInt(7);
            n = rand.nextInt(7);
//            System.out.println("swap"+boys[m].getName()+boys[n].getName());
            swapBoys(m, n);
        }
    }

    public void boysReportDetails() {
        for (int i = 0; i < boysNumber; i++) {
            System.out.println("我是" + i + "号,我的名字叫" + boys[i].getName() + ",我的颜色是" + boys[i].getColor());
        }
    }

    public void boysReportNames() {
        for (CalabashBrothers b : boys) {
            System.out.print(b.getName() + ",");
        }
        System.out.println();
    }

    public void boysReportColors() {
        for (CalabashBrothers b : boys) {
            System.out.print(b.getColor() + ",");
        }
        System.out.println();
    }


    public void calabashBrothersBubbleSort() {
        for (int i = 0; i < boysNumber; i++) {
            for (int j = 0; j < boysNumber - 1 - i; j++) {
                if (boys[j].getRank() > boys[j + 1].getRank()) {
                    swapBoysWithReport(j, j + 1);
                }
            }
        }
    }

    public void calabashBrothersBinarySort() {
        for (int i = 0; i < boysNumber; i++) {
            int left = 0;
            int right = i - 1;
            int mid = (left + right) / 2;

            while (left <= right) {
                if (boys[i].getRank() < boys[mid].getRank()) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                mid = (left + right) / 2;
            }

            for (int j = i; j > left; j--) {
                swapBoysWithReport(j, j - 1);
            }


        }
    }

    public void testBubbleSort() {
        Random rand = new Random();
        int testTimes = rand.nextInt(20) + 10;
        for (int i = 0; i < testTimes; i++) {
            this.disruptQueue();
            this.calabashBrothersBubbleSort();
            for (int j = 0; j < boysNumber; j++) {
                if (boys[j].getRank() != j) {
                    System.out.println("----------------------经过" + testTimes + "次测试冒泡排序测试失败");
                    System.exit(-1);
                }
            }
        }
        System.out.println("----------------------经过" + testTimes + "次测试冒泡排序测试成功");
    }

    public void testBinarySort() {
        Random rand = new Random();
        int testTimes = rand.nextInt(20) + 10;
        for (int i = 0; i < testTimes; i++) {
            this.disruptQueue();
            this.calabashBrothersBinarySort();
            for (int j = 0; j < boysNumber; j++) {
                if (boys[j].getRank() != j) {
                    System.out.println("----------------------经过" + testTimes + "次测试二分排序测试失败");
                    System.exit(-1);
                }
            }
        }
        System.out.println("----------------------经过" + testTimes + "次测试二分排序测试成功");
    }


}
