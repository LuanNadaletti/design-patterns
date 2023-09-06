package com.patterns.strategy.strategies;

import java.util.Arrays;

/**
 *
 * @author Luan Nadaletti
 *
 */
public class BubbleSort implements SortStrategy {

    private int[] sortedArray;
    private int numberOfRepetitions;
    private long elapsedTime;

    @Override
    public void sort(int[] array) {
        int n = array.length;
        long actualNanoTime = System.nanoTime();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                numberOfRepetitions++;
            }
        }

        elapsedTime = (System.nanoTime() - actualNanoTime);
        sortedArray = array.clone();
    }

    @Override
    public String getSortInfo() {
        return "Bubble Sort Info: \n" + "Sorted array: "
                + Arrays.toString(sortedArray) + "\n"
                + "Number of repetitions: " + numberOfRepetitions + "\n"
                + "Elapsed time: " + elapsedTime + " nanoseconds";
    }

}
