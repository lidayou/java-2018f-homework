import java.util.*;



public class GourdBrothers {
    /*
    private enum Color {
        RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE;
    }
    */
    private int rank;
    private String name, color;
    public GourdBrothers(int rank) {
        this.rank = rank;
        switch(rank) {
            case (0):
                name = new String("老大");
                color = new String("赤");
                break;
            case (1):
                name = new String("老二");
                color = new String("橙");
                break;
            case (2):
                name = new String("老三");
                color = new String("黄");
                break;
            case (3):
                name = new String("老四");
                color = new String("绿");
                break;
            case (4):
                name = new String("老五");
                color = new String("青");
                break;
            case (5):
                name = new String("老六");
                color = new String("蓝");
                break;
            case (6):
                name = new String("老七");
                color = new String("紫");
                break;
            default:
                name = null;
                color = null;
                break;
        }
    }
    public int getRank(){
        return this.rank;
    }
    private void report(int src, int dst){
        System.out.println(this.name + ": " + src + "->" + dst);
    }
    public static void bubbleSort(ArrayList <GourdBrothers> gourdBrothersList) {
        int size = gourdBrothersList.size();
        for(int i = 0; i < size - 1; i++){
            for(int j = i + 1; j < size; j++){
                if(gourdBrothersList.get(i).getRank() > gourdBrothersList.get(j).getRank()){
                    //report
                    gourdBrothersList.get(i).report(i, j);
                    gourdBrothersList.get(j).report(j, i);
                    //swap
                    GourdBrothers temp = gourdBrothersList.get(i);
                    gourdBrothersList.set(i,gourdBrothersList.get(j));
                    gourdBrothersList.set(j,temp);
                    //displayInRank(gourdBrothersList);
                }
            }
        }
    }
    public static void merge(ArrayList <GourdBrothers> list1, int left, int mid, int right) {
        ArrayList<GourdBrothers> list2 = new ArrayList<>(right - left + 1);
        //copy list1 to list2, not reference
        list2.addAll(list1);
        int s1 = left, s2 = mid + 1, t = left;
        while (s1 <= mid && s2 <= right) {
            if (list2.get(s1).getRank() <= list2.get(s2).getRank()) {
                //report
                list2.get(s1).report(s1, t);
                //insert
                list1.set(t, list2.get(s1));
                s1++;
            } else {
                //report
                list2.get(s2).report(s2, t);
                //insert
                list1.set(t, list2.get(s2));
                s2++;
            }
            t++;
        }

        while(s1 <= mid) {
            //report
            list2.get(s1).report(s1, t);
            //insert
            list1.set(t, list2.get(s1));
            t++;
            s1++;
        }
        while(s2<=right) {
            //report
            list2.get(s2).report(s2, t);
            //insert
            list1.set(t, list2.get(s2));
            t++;
            s2++;
        }
    }
    public static void mergeSort(ArrayList <GourdBrothers> A, int left, int right){
        if(left >= right)   return;
        int mid =  (left+right) / 2;
        mergeSort(A, left, mid);
        mergeSort(A,mid + 1,right);
        merge(A, left, mid, right);
    }
    //randomize the order in gourdBrothersList
    public static void randomize(ArrayList <GourdBrothers> gourdBrothersList) {
        Random r = new Random();
        final int trials = 100;
        int ra, rb;
        //Trials = 100
        for(int i = 0; i < trials; i++) {
            ra = r.nextInt(6);
            rb = r.nextInt(6);
            //swap gourdBrothersList[ra] and gourdBrothersList[rb]
            GourdBrothers temp = gourdBrothersList.get(ra);
            gourdBrothersList.set(ra, gourdBrothersList.get(rb));
            gourdBrothersList.set(rb, temp);
        }
    }
    //print in rank
    public static void displayInRank(ArrayList <GourdBrothers> gourdBrothersList) {
        for(GourdBrothers i: gourdBrothersList) {
            System.out.println(i.name);
        }
    }

    //print in color
    public static void displayInColor(ArrayList <GourdBrothers> gourdBrothersList) {
        for(GourdBrothers i: gourdBrothersList) {
            System.out.println(i.color);
        }
    }

    public static void main(String[] args) {
        ArrayList <GourdBrothers> gourdBrothersList = new ArrayList <>(7);
        for(int i = 0; i < 7; i++) {
            gourdBrothersList.add(new GourdBrothers(i));
        }

        //stage 1
        randomize(gourdBrothersList);
        bubbleSort(gourdBrothersList);
        displayInRank(gourdBrothersList);
        //stage 2
        randomize(gourdBrothersList);
        mergeSort(gourdBrothersList, 0, gourdBrothersList.size() - 1);
        displayInColor(gourdBrothersList);
    }

}