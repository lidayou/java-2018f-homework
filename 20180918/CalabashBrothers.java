import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
// 葫芦娃颜色
enum Color{
    RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE
}

class Calabash{
    public Calabash(Color myColor, String myName, int place){
        this.name = myName;
        this.place = place;
        this.order = myColor.ordinal();
        this.selfColor = myColor;
    }
    public void toldColor(){
        System.out.println(selfColor);
    }
    public void toldName(){
        System.out.println(name);
    }
    public String getName() {
        return name;
    }
    public int getOrder() {
        return order;
    }
    public Color getSelfColor() {
        return selfColor;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    private String name;
    private int order;
    private int place;
    private Color selfColor;
}

abstract class GetKey{
    public abstract int key(Object input);
}

public class CalabashBrothers {
    private ArrayList brothers = new ArrayList();
    private void exchangePlace(int i, int j){
        System.out.print(((Calabash) brothers.get(i)).getName()+':'+ (i+1) + "->" + (j+1) + ' ');
        System.out.print(((Calabash) brothers.get(j)).getName()+':'+ (j+1) + "->" + (i+1) + ' ');
        Calabash temp = (Calabash) brothers.get(i);
        brothers.set(i, brothers.get(j));
        brothers.set(j, temp);
    }

    // 快速排序找spilit point
    public int partition(int start, int end, GetKey getKey) {
        int pivot = getKey.key(brothers.get(end));
        int i = start - 1;
        for (int j = start; j <= end - 1; j++) {
            if (getKey.key(brothers.get(j)) < pivot) {
                i = i + 1;
                if(i != j){
                    exchangePlace(i, j);
                }
            }
        }

        if(i+1 != end) {
            exchangePlace(i+1, end);
        }
        return i + 1;
    }
    // 快速排序
    public void quickSort(int start, int end, GetKey getKey) {
        if (start < end) {
            int spilitPoint = partition(start, end, getKey);
            quickSort(start, spilitPoint - 1, getKey);
            quickSort(spilitPoint + 1, end, getKey);
        }
    }
    // 冒泡排序
    public void bubbleSort(GetKey getKey){
        for(int i = 0; i < brothers.size(); i++){
            for(int j = 0; j < brothers.size()-i-1; j++){
                if(getKey.key(brothers.get(j)) > getKey.key(brothers.get(j+1))){
                    exchangePlace(j, j+1);
                }
            }
        }
        //System.out.println();
    }
    // 获取用于排序的属性的方法
    private class getAge extends GetKey{
        public int key(Object input){
            input = (Calabash)input;
            return ((Calabash) input).getOrder();
        }
    }
    private class getColor extends GetKey{
        public int key(Object input){
            input = (Calabash)input;
            return ((Calabash) input).getSelfColor().ordinal();
        }
    }
    // 初始化葫芦兄弟
    public CalabashBrothers(){
        brothers.add(new Calabash(Color.RED,"老大", 1));
        brothers.add(new Calabash(Color.CYAN,"老五", 2));
        brothers.add(new Calabash(Color.ORANGE,"老二", 3));
        brothers.add(new Calabash(Color.YELLOW,"老三", 4));
        brothers.add(new Calabash(Color.GREEN,"老四", 5));
        brothers.add(new Calabash(Color.BLUE,"老六", 6));
        brothers.add(new Calabash(Color.PURPLE,"老七", 7));
    }

    public void CalabashBubbleSort(){
        bubbleSort(new getAge());
        System.out.println();
        toldColor();
    }
    public void CalabashQuickSort(){
        quickSort(0, brothers.size()-1, new getColor());
        System.out.println();
        toldName();
    }
    public void toldColor(){
        for(int i = 0; i < brothers.size(); i++){
            Calabash temp = (Calabash)brothers.get(i);
            temp.toldColor();
        }
    }
    public void toldName(){
        for(int i = 0; i < brothers.size(); i++){
            Calabash temp = (Calabash)brothers.get(i);
            temp.toldName();
        }
    }
    public static void main(String[] args) {
        CalabashBrothers mybrothers = new CalabashBrothers();
        //System.out.println(mybrothers.brothers.toString());
        mybrothers.CalabashQuickSort();
        //System.out.println(mybrothers.brothers.toString());
        mybrothers.CalabashBubbleSort();
    }
}
