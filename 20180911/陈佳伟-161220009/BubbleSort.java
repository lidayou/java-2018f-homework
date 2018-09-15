package Homework;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int Number = scanner.nextInt();
        int[] Array = new int[Number];
        for(int i = 0; i < Number; i++){
            Array[i] = scanner.nextInt();
        }
        scanner.close();
        for(int i = 0; i < Number; i++){
            for(int j = Number-1; j > i; j--){
                if(Array[j]<Array[j-1]){
                    int Temp = Array[j];
                    Array[j] = Array[j-1];
                    Array[j-1] = Temp;
                }
            }
        }
        System.out.println(Arrays.toString(Array));
    }
}
