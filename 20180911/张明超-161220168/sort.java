import java.util.Arrays;
public class sort {
    //快速排序找spilit point
    private static int Partition(int[] Array, int Start, int End){
        int Pivot = Array[End];
        int i = Start - 1;
        for (int j = Start; j <= End - 1; j++){
            if(Array[j] < Pivot){
                i = i + 1;
                int temp = Array[i];
                Array[i] = Array[j];
                Array[j] = temp;
            }
        }
        int temp = Array[i+1];
        Array[i+1] = Array[End];
        Array[End] = temp;
        return i + 1;
    }
    //快速排序
    private static void QuickSort(int[] Array, int Start, int End){
        if(Start < End){
            int SpilitPoint = Partition(Array, Start, End);
            QuickSort(Array, Start, SpilitPoint-1);
            QuickSort(Array, SpilitPoint+1, End);
        }
    }
    //打印数组，空格分隔，结尾换行
    private static void Print(int[] Array){
        for(int i = 0; i < Array.length; i++){
            System.out.print(Array[i]);
            System.out.print(' ');
        }
        System.out.print('\n');
    }
    public static void main(String[] args) {
        int Numbers[] = {3,12,4,5,10,2,11,1,15,7,14,8,13,9,0,6};
        QuickSort(Numbers,0,Numbers.length-1);
        Print(Numbers);
    }
}
