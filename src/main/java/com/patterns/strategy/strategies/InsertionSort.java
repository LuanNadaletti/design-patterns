package com.patterns.strategy.strategies;

import java.util.Arrays;

/**
 *
 * @author Luan Nadaletti
 *
 */
public class InsertionSort implements SortStrategy {

    private int[] sortedArray;
    private int numberOfRepetitions;
    private long elapsedTime;

    @Override
    public void sort(int[] array) {
        long currentNanoTime = System.nanoTime();
        int n = array.length;

        for (int i = 0; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;

                numberOfRepetitions++;
            }

            array[j + 1] = key;
        }

        elapsedTime = System.nanoTime() - currentNanoTime;
        sortedArray = array.clone();
    }

    @Override
    public String getSortInfo() {
        return "Insertion Sort Info: \n" + "Sorted array: "
                + Arrays.toString(sortedArray) + "\n"
                + "Number of repetitions: " + numberOfRepetitions + "\n"
                + "Elapsed time: " + elapsedTime + " nanoseconds";
    }

}
