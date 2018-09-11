package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Sort {

    public final int TestTimes = 100;
    public final int ArrayMaxSize = 10000;
    public final int NumberRange = (1 << 31) - 1;
    int[] intArray = new int[ArrayMaxSize];

    public static void main(String[] args) {

        Sort sort = new Sort();

        int wrongCount = 0;

        for (int i = 0; i < sort.TestTimes; i++) {
            wrongCount += sort.randomTest(i);
        }

        System.out.println(wrongCount + " wrong cases!");
    }

    public int randomTest(int testNumber) {
        Random rand = new Random();
        int[] standardSortedArray = new int[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = rand.nextInt(NumberRange);
            standardSortedArray[i] = intArray[i];
        }

        Arrays.sort(standardSortedArray);
        sortArray();

        int wrongCount = 0;

        if (Arrays.equals(intArray, standardSortedArray) == true) {
            //System.out.println("Right！");
        } else {
            System.out.println("Wrong！Test number is : " + testNumber);
            wrongCount++;
        }

        return wrongCount;
    }

    public void sortArray()
    {
        //insert sort
        for(int i = 1; i < intArray.length; i++)
        {
            for(int j = i - 1; j >= 0; j--)
            {
                if(intArray[j + 1] < intArray[j])
                {
                    int temp = intArray[j + 1];
                    intArray[j + 1] = intArray[j];
                    intArray[j] = temp;
                }
            }
        }
    }
}
