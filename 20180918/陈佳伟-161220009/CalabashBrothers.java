package Homework;

import java.util.Scanner;

public class CalabashBrothers {
    enum Name{
        老大,老二,老三,老四,老五,老六,老七
    }
    enum Color{
        红色,橙色,黄色,绿色,青色,蓝色,紫色
    }
    private int[] line = new int[7];                            //代表葫芦兄弟队列顺序的数组
    private Name[] name = Name.values();
    private Color[] color = Color.values();                     //葫芦兄弟名字和颜色的枚举数组
    private static Scanner scanner= new Scanner(System.in);     //输入流

    private void getLine(){                                     //输入葫芦兄弟随机排序（按名字输入）
        for(int i = 0; i < 7; i++){
            String str = scanner.nextLine();
            for(Name n : Name.values()){
                if(n.toString().equals(str))
                    line[i] = n.ordinal();
            }
        }
    }
    
    private void countOff(int i, int j){
        System.out.print(name[line[i]].toString()+":"+ i +"->"+ j +"\n");
    }
                                                                        //葫芦娃换位报数

    private void quickSort(int[] array, int first, int last){           //快排
        if(first >= last)
            return ;
        int index = first, temp, flag = array[first];
        for(int i = first+1; i <= last; i++){
            if(array[i] < flag) {
                index++;
                if(index!=i) {
                    countOff(i, index);
                    temp = array[i];
                    array[i] = array[index];
                    array[index] = temp;
                }
            }
        }
        if(first!=index){
            countOff(first, index);
            array[first] = array[index];
            array[index] = flag;
        }
        quickSort(array, first, index-1);
        quickSort(array, index+1, last);
    }

    private void nameSort(){                                            //按葫芦兄弟的名字排序
        for(int i = 0; i < line.length; i++){
            for(int j = line.length-1; j > i; j--){
                if(line[j]<line[j-1]){
                    countOff(j, j-1);
                    int temp = line[j];
                    line[j] = line[j-1];
                    line[j-1] = temp;
                }
            }
        }
        for(int i = 0 ;i<this.line.length; i++){
            System.out.print(name[line[i]].toString()+":"+name[i].toString()+"\n");
        }
    }

    private void colorSort(){                                           //按葫芦兄弟的颜色排序
        quickSort(line, 0, line.length-1);
        for(int i: line){
            System.out.print(name[line[i]].toString()+":"+color[i].toString()+"\n");
        }
    }

    public static void main(String[] args){
        CalabashBrothers calabashBrothers = new CalabashBrothers();
        calabashBrothers.getLine();
        calabashBrothers.nameSort();
        calabashBrothers.getLine();
        calabashBrothers.colorSort();
        scanner.close();
    }
}



