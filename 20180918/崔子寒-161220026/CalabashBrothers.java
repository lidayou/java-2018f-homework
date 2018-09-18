import java.util.*;

enum Color{RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, PURPLE}

class CalabashBrother {
    private int ranking;
    private Color color;
    static  String[] name = {"老大","老二","老三","老四","老五","老六","老七"};
    CalabashBrother(int ranking){
        this.ranking = ranking;
        this.color = Color.values()[ranking];
    }
    public int getRanking() {
        return this.ranking;
    }

    public Color getColor() {
        return this.color;
    }

    public void report(int src, int dest) {
        System.out.print(name[ranking]+": "+src+"->"+dest+" ");
    }
}

class MySort {
    private static void swap(CalabashBrother[] brothers, int index1, int index2) {
        brothers[index1].report(index1,index2);
        brothers[index2].report(index2,index1);
        System.out.println();
        CalabashBrother temp = brothers[index1];
        brothers[index1] = brothers[index2];
        brothers[index2] = temp;
    }
    private static int searchInsertPosition(CalabashBrother[] brothers, int index) {
        int begin = 0, end = index-1;
        while(begin < end){
            int mid = begin / 2 + end / 2;
            if(brothers[mid].getColor().ordinal() > brothers[index].getColor().ordinal())
                end = mid;
            else
                begin = mid + 1;
        }
        return begin;
    }
    public static void myBubbleSort(CalabashBrother[] brothers) {
        for(int i = 0;i < 6;i++) {
            for(int j = 0;j < 6-i;j++) {
                if(brothers[j].getRanking() > brothers[j+1].getRanking())
                    swap(brothers,j,j+1);
            }
        }
    }
    public static void myBinarySort(CalabashBrother[] brothers) {
        for(int i = 1;i < 7;i++) {
            int targetPosition = searchInsertPosition(brothers, i);
            if(brothers[i].getColor().ordinal() < brothers[targetPosition].getColor().ordinal()) {
                int j = i;
                while(j > targetPosition){
                    swap(brothers, j, j-1);
                    j--;
                }
                if(brothers[j].getColor().ordinal() < brothers[targetPosition].getColor().ordinal())
                    swap(brothers, j, targetPosition);
            }
        }
    }
}

public class CalabashBrothers {
    private static CalabashBrother[] brothers;
    CalabashBrothers() {
        brothers = new CalabashBrother[7];
        for(int i = 0;i < 7;i++) {
            brothers[i] = new CalabashBrother(i);
        }
    }

     public void shuffle() {
        Random rand = new Random() ;
        for(int i = 0;i < 6;i++) {
            int selectPosition = rand.nextInt(7 - i);
            CalabashBrother temp = brothers[selectPosition];
            brothers[selectPosition] = brothers[6 - i];
            brothers[6 - i] = temp;
        }
    }
    public void showBrothers() {
        for(CalabashBrother x:brothers) {
            System.out.print(CalabashBrother.name[x.getRanking()] + "(" + x.getColor() + ") ");
        }
        System.out.println();
    }
    public void bubbleSortByRanking() {
        System.out.println("按照排行进行冒泡排序：");
        MySort.myBubbleSort(brothers);
    }

    public void binarySortByColor() {
        System.out.println("按照颜色进行二分排序：");
        MySort.myBinarySort(brothers);
    }
}

