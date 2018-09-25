import java.util.ArrayList;
import java.util.Collections;

public class CalabashBrotherFamily {
    static private final int NUM = 7;
    private ArrayList<CalabashBrother> brotherList = new ArrayList<>(7);
    public CalabashBrotherFamily() {
        for(int i = 0; i < NUM; i++){
            brotherList.add(new CalabashBrother(ColorOfCalabashBrother.values()[i], RankOfCalabashBrother.values()[i]));
        }
    }

    public void shuffle(){
        Collections.shuffle(brotherList);
    }

    public void sortByColor(){
        // bubble sort algorithm

        for(int i = 0; i < NUM -1 ; i++){
            for(int j = 0; j < NUM - 1 - i; j++){
                if(brotherList.get(j).getColor().ordinal() > brotherList.get(j+1).getColor().ordinal()){
                    swapPosition(j, j+1);
                }
            }
        }
    }
    private void quickSort(int left, int right){
        if(left >= right)
            return;

        // partition
        int pivot = right;
        int i=left, j = left;
        while(j < pivot){
            if(brotherList.get(j).getRank().ordinal() < brotherList.get(pivot).getRank().ordinal()){
                swapPosition(i, j);
                i++;
            }
            j++;
        }

        if(i != pivot){
            swapPosition(i, pivot);
        }

        pivot = i;
        quickSort(left, pivot-1);
        quickSort(pivot+1, right);
    }

    public void sortByRank(){
        // quick sort algorithm
        quickSort(0, NUM-1);

    }
    public void printRank(){
        for(int i = 0; i < NUM; i++) {
            System.out.print(brotherList.get(i).getRank());
            System.out.print("\t");
        }
        System.out.println();
    }
    public void printColor(){
        for(int i = 0; i < NUM; i++) {
            System.out.print(brotherList.get(i).getColor());
            System.out.print("\t");
        }
        System.out.println();
    }
    private void swapPosition(int i, int j){
        System.out.printf("%s Brother: %d -> %d\n", brotherList.get(i).getRank().toString(),i,j);
        System.out.printf("%s Brother: %d -> %d\n", brotherList.get(j).getRank().toString(),j,i);
        Collections.swap(brotherList, i, j);
    }
    public static void main(String[] args) {
        CalabashBrotherFamily calabashBrothers = new CalabashBrotherFamily();

        calabashBrothers.shuffle();
        System.out.print("shuffled:");
        calabashBrothers.printRank();
        calabashBrothers.sortByRank();
        System.out.print("sorted by rank:");
        calabashBrothers.printRank();

        calabashBrothers.shuffle();
        System.out.print("shuffled:");
        calabashBrothers.printColor();
        calabashBrothers.sortByColor();
        System.out.print("sorted by color:");
        calabashBrothers.printColor();
    }

}
