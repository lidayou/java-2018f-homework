package sort;

import java.util.Scanner;

public class Main {

    //冒泡排序法
    private static void mySort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n;
        System.out.println("请输入数组的大小:");
        n = in.nextInt();
        int[] a = new int[n];
        System.out.println("请输入"+ n + "个数组元素:");
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        mySort(a);

        System.out.println("排序后，数组结果为:");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

        in.close();
    }
}
