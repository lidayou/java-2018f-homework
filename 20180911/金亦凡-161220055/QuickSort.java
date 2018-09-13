package com.example.quicksort;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        System.out.println("请输入数组大小：");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println("请输入" + n + "个数字：");
        int[] list = new int[n];
        for(int i = 0; i < n; i++)
            list[i] = input.nextInt();
        Arrays.sort(list);
        for(int i = 0; i < n; i++)
            System.out.print(list[i] + " ");
    }
}
