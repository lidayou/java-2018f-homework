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

    private void findCalabashBrothers(){
        this.boysNumber = 7;
        this.boys = new CalabashBrothers[this.boysNumber];
        for(int i=0;i<boys.length;i++){
            boys[i]=CalabashBrothers.values()[i];
        }
    }

    private void swapBoys(int i,int j){
        CalabashBrothers tmp = boys[i];
        boys[i]=boys[j];
        boys[j]=tmp;
    }

    private void swapBoysWithReport(int i,int j){
        System.out.println(boys[i].getName()+":"+i+"->"+j);
        System.out.println(boys[j].getName()+":"+j+"->"+i);
        CalabashBrothers tmp = boys[i];
        boys[i]=boys[j];
        boys[j]=tmp;
    }

    public void disruptQueue(){
        Random rand = new Random();
        int randTimes = rand.nextInt(100)+50;
        int m;
        int n;
        for (int i = 0; i < randTimes; i++) {
            m=rand.nextInt(7);
            n=rand.nextInt(7);
//            System.out.println("swap"+boys[m].getName()+boys[n].getName());
            swapBoys(m,n);
        }
    }

    public void boysReportDetails(){
        for(int i=0;i<boysNumber;i++){
            System.out.println("我是"+i+"号,我的名字叫"+boys[i].getName()+",我的颜色是"+boys[i].getColor());
        }
    }

    public void boysReportNames(){
        for(CalabashBrothers b:boys){
            System.out.print(b.getName()+",");
        }
    }

    public void boysReportColors(){
        for(CalabashBrothers b:boys){
            System.out.print(b.getColor()+",");
        }
    }


    public void calabashBrothersBubbleSort(){
        for (int i = 0; i < boysNumber; i++) {
            for (int j = 0; j < boysNumber - 1 - i; j++) {
                if (boys[j].getRank() > boys[j + 1].getRank()) {
                    swapBoysWithReport(j,j+1);
                }
            }
        }
    }

    public void calabashBrothersBinarysort(){
        this.calabashBrothersBubbleSort();
    }





}
