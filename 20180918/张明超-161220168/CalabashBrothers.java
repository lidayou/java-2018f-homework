import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
// 葫芦娃颜色
enum Color{
    RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE
}

class Calabash{
    public Calabash(Color myColor, String myName){
        this.name = myName;
        this.order = myColor.ordinal();
        this.selfColor = myColor;
    }
    public Calabash(Calabash toCopy){
        this.name = toCopy.name;
        this.order = toCopy.order;
        this.selfColor = toCopy.selfColor;
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
    private void movePlace(int i, int j){
        System.out.print(((Calabash) brothers.get(i)).getName()+':'+ (i+1) + "->" + (j+1) + ' ');
        brothers.set(j, brothers.get(i));
    }
    private void movePlace(Calabash temp, int i, int j){
        System.out.print(temp.getName()+':'+ (i+1) + "->" + (j+1) + ' ');
        brothers.set(j, temp);
    }
    // 快速排序找spilit point
    private int partition(int start, int end, GetKey getKey) {
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
    // 二分排序
    public void binarySort(GetKey getKey){
        for(int i = 0; i < brothers.size(); i++){
            Calabash temp = new Calabash((Calabash)brothers.get(i));
            int left = 0;
            int right = i-1;
            int middle = 0;
            while(left <= right){
                middle = (left + right)/2;
                if(getKey.key(temp) < getKey.key(brothers.get(middle))){
                    right = middle - 1;
                }
                else{
                    left = middle + 1;
                }
            }
            for(int j = i-1; j >= left; j--){
                movePlace(j, j+1);
            }
            if(i != left)
                movePlace(temp, i, left);
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
        brothers.add(new Calabash(Color.RED,"老大"));
        brothers.add(new Calabash(Color.PURPLE,"老七"));
        brothers.add(new Calabash(Color.CYAN,"老五"));
        brothers.add(new Calabash(Color.ORANGE,"老二"));
        brothers.add(new Calabash(Color.GREEN,"老四"));
        brothers.add(new Calabash(Color.YELLOW,"老三"));
        brothers.add(new Calabash(Color.BLUE,"老六"));
    }
    public void CalabashBubbleSort(){
        bubbleSort(new getAge());
        System.out.println();
        toldColor();
    }
    public void CalabashBinarySort(){
        binarySort(new getColor());
        System.out.println();
        toldName();
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
        mybrothers.CalabashBinarySort();
        //System.out.println(mybrothers.brothers.toString());
        mybrothers.CalabashBubbleSort();
    }
}
