import java.util.*;
public class Heroes {
    private CalabashBrother[] calabashBrothers = new CalabashBrother[7];
    private GrandFather grandFather;
    public Heroes() {
        for(int i = 0;i < 7; i++) {
            calabashBrothers[i] = new CalabashBrother(i);
        }
        grandFather = new GrandFather();
    }
    /*shuffle randomly*/
    public void shuffle() {
        Random rand = new Random() ;
        for(int i = 0;i < 6;i++) {
            int selectPosition = rand.nextInt(7 - i);
            CalabashBrother temp = calabashBrothers[selectPosition];
            calabashBrothers[selectPosition] = calabashBrothers[6 - i];
            calabashBrothers[6 - i] = temp;
        }
    }
    public void lineUp(Battlefield battlefield) {
        shuffle();
        System.out.print("葫芦娃初始状态：");
        for(CalabashBrother x:calabashBrothers){
            System.out.print(x.getColor().getName()+" ");
        }
        System.out.println("\n准备列队");
        Mysort.myBubbleSort(calabashBrothers);
        Block[][] field = battlefield.getBattlefield();
        for(int i = 0;i < 7;i++) {
            field[i+1][17].creatureEnter(calabashBrothers[i],AttributeofBlock.CALA);
            calabashBrothers[i].setPosition(i+1,17);
        }
        Random rand = new Random();
        int temp_x = 3+rand.nextInt(4);

        field[temp_x][19].creatureEnter(grandFather, AttributeofBlock.GRANDFATHER);
        grandFather.setPosition(9,temp_x);
    }

/*
    public static void main(String[] args) {
        Battlefield battlefield = new Battlefield();
        Heroes heroes = new Heroes();
        heroes.lineUp(battlefield);
        battlefield.print();
    }
*/
}

class Mysort {
    /*Swap two elements*/
    private static void swap(CalabashBrother[] brothers, int index1, int index2) {
        //System.out.println();
        CalabashBrother temp = brothers[index1];
        brothers[index1] = brothers[index2];
        brothers[index2] = temp;
    }

    /*bubble sort based on ranking*/
    public static void myBubbleSort(CalabashBrother[] brothers) {
        for(int i = 0;i < 6;i++) {
            for(int j = 0;j < 6-i;j++) {
                if(brothers[j].getColor().ordinal() > brothers[j+1].getColor().ordinal())
                    swap(brothers,j,j+1);
            }
        }
    }
}
