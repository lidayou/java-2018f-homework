package com.homework2;

public class CalabashBrothersSort {

    public static void main(String[] args) {

        CalabashBrothersSort calabashBrothersSort = new CalabashBrothersSort();
        calabashBrothersSort.bubbleSortCalabashBrothers();
        calabashBrothersSort.binaryInsertSortCalabashBrothers();
    }

    private void bubbleSortCalabashBrothers() {
        System.out.println("It's Bubble sort");
        CalabashBrothers calabashBrothers = new CalabashBrothers();
        System.out.print("Before sorted: ");
        calabashBrothers.printAllCalabashBoys();
        for (int i = CalabashBrothers.MAX_CALABASH_BROTHERS_COUNT - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (calabashBrothers.compareCalabashBoy(j, j + 1) > 0) {
                    calabashBrothers.swapCalabashBoy(j, j + 1);
                }
            }
        }
        System.out.print("After sorted: ");
        calabashBrothers.printAllCalabashBoys();
        System.out.println();
    }

    private void binaryInsertSortCalabashBrothers() {
        System.out.println("It's Binary Insert sort");
        CalabashBrothers calabashBrothers = new CalabashBrothers();
        System.out.print("Before sorted: ");
        calabashBrothers.printAllCalabashBoys();
        for (int i = 1; i < CalabashBrothers.MAX_CALABASH_BROTHERS_COUNT; i++) {
            int highPosition = i;
            int lowPosition = 0;
            int midPosition = (highPosition + lowPosition) / 2;
            while (highPosition >= lowPosition) {
                midPosition = (highPosition + lowPosition) / 2;
                if (calabashBrothers.compareCalabashBoy(midPosition, i) > 0) {
                    highPosition = midPosition - 1;
                } else {
                    lowPosition = midPosition + 1;
                }
            }

            for (int j = i - 1; j >= lowPosition; j--) {
                calabashBrothers.swapCalabashBoy(j, j + 1);
            }
        }
        System.out.print("After sorted: ");
        calabashBrothers.printAllCalabashBoys();
        System.out.println();
    }

}