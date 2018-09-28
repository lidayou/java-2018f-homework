package njuics.java2018;

class CalabashBrother{
    private String name;
    private String color;
    private int pos;
    void initialize(String newName, String newColor){
        name = newName;
        color = newColor;
    }
    void rePos(int newPos){
        pos = newPos;
    }
    void setPos(int newPos){
        System.out.print(name + ", " + pos + "->" + newPos + " ");
        pos = newPos;
    }
    void numberOffByName(){
        System.out.print(name + " ");
    }
    void numberOffByColor(){
        System.out.print(color + " ");
    }
}

class CalabashQueue {
    private final static int NUM = 7;
    private CalabashBrother[] brothers;
    //ArrayList<Integer> line;
    private int[] line;
    CalabashQueue() {
        brothers = new CalabashBrother[NUM];
        line = new int[NUM];
        for (int i = 0; i < NUM; i++) {
            CalabashBrother bro = new CalabashBrother();
            brothers[i] = bro;
            switch (i) {
                case 0:
                    brothers[i].initialize("老大", "红色");
                    break;
                case 1:
                    brothers[i].initialize("老二", "橙色");
                    break;
                case 2:
                    brothers[i].initialize("老三", "黄色");
                    break;
                case 3:
                    brothers[i].initialize("老四", "绿色");
                    break;
                case 4:
                    brothers[i].initialize("老五", "青色");
                    break;
                case 5:
                    brothers[i].initialize("老六", "蓝色");
                    break;
                case 6:
                    brothers[i].initialize("老七", "紫色");
                    break;
            }
            line[i] = -1;
        }
        //random();
    }
    private boolean contains(int num) {
        for (int i = 0; i < NUM; i++) {
            if (line[i] == num)
                return true;
        }
        return false;
    }
    void random() {
        for (int i = 0; i < NUM; i++)
            line[i] = -1;
        for (int i = 0; i < NUM; i++) {
            int num = (int) (Math.random() * 7);
            if (contains(num))
                i--;
            else {
                line[i] = num;
                brothers[num].rePos(i);
            }
        }
        System.out.print("Random line up: ");
        for (int i = 0; i < NUM; i++)
            System.out.print(line[i] + " ");
        System.out.println();
    }
    void bubbleSort() {
        for (int i = 0; i < NUM - 1; i++){
            for (int j = 0; j < NUM - i - 1; j++){
                if (line[j] > line[j + 1]) {
                    brothers[line[j]].setPos(j + 1);
                    brothers[line[j + 1]].setPos(j);
                    System.out.println();
                    int temp = line[j];
                    line[j] = line[j + 1];
                    line[j + 1] = temp;
                }
            }
        }
        numberOffByName();
    }
    void binaryInsertSort(){
        for (int i = 0; i < NUM; i++){
            int temp = line[i];
            int left = 0, right = i - 1, mid = 0;
            while (left <= right){
                mid = (left + right) / 2;
                if (temp < line[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            for (int j = i - 1 ; j >= left; j--){
                brothers[line[j]].setPos(j + 1);
                line[j + 1] = line[j];
            }
            if (left != i){
                brothers[temp].setPos(left);
                System.out.println();
                line[left] = temp;
            }
        }
        numberOffByColor();
    }
    private void numberOffByName(){
        System.out.print("Number off: ");
        for (int i = 0; i < NUM; i++)
            brothers[line[i]].numberOffByName();
        System.out.println();
    }
    private void numberOffByColor(){
        System.out.print("Number off: ");
        for (int i = 0; i < NUM; i++)
            brothers[line[i]].numberOffByColor();
        System.out.println();
    }
}

public class CalabashBrotherSort {
    public static void main(String[] args) {
        CalabashQueue q = new CalabashQueue();
        q.random();
        q.bubbleSort();
        q.random();
        q.binaryInsertSort();
        return;
    }
}
