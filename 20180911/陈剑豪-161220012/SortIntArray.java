package com.company;

public class SortIntArray {
    public static void sort(int Array[]){//默认从小到大排序
        for(int i=0;i<Array.length;i++)
        {
            for(int j=i+1;j<Array.length;j++)
            {
                if(Array[i]>Array[j])
                {
                    int temp=0;
                    temp=Array[j];
                    Array[j]=Array[i];
                    Array[i]=temp;
                }
            }
        }
    }
    public static void main(String[] args)
    {
        int Array[]={67,9889,123,234,1,6,9,-4,0,43};//随便初始化一个数组
        SortIntArray A=new SortIntArray();
        A.sort(Array);
        for(int i=0;i<Array.length;i++)
        {
            System.out.println(Array[i]);
        }
    }
}
