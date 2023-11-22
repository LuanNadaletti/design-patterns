package com.patterns.strategy.strategies;

import java.util.Arrays;

/**
 * The <code>SelectionSort</code> class implements the {@link SortStrategy}
 * interface to provide a selection sort algorithm for sorting integer arrays.
 * It also collects information about the sorting process.
 *
 * @author Luan Nadaletti
 */
public class SelectionSort implements SortStrategy {

    private int[] sortedArray;
    private int numberOfRepetitions;
    private long elapsedTime;

    /**
     * Sorts the given integer array using the selection sort algorithm.
     *
     * @param array the integer array to be sorted.
     */
    @Override
    public void sort(int[] array) {
        long currentNanoTime = System.nanoTime();

        int n = array.length;
        int min, num;
        for (int i = 0; i < n; i++) {
            min = i;
            for (int j = i; j < n; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }

                numberOfRepetitions++;
            }

            num = array[i];
            array[i] = array[min];
            array[min] = num;
        }

        elapsedTime = System.nanoTime() - currentNanoTime;
        sortedArray = array.clone();
    }

    /**
     * Gets information about the selection sort process, including the sorted
     * array, the number of repetitions, and the elapsed time.
     *
     * @return a string containing information about the selection sort process.
     */
    @Override
    public String getSortInfo() {
        return "Selection Sort Info: \n" + "Sorted array: " + Arrays.toString(sortedArray) + "\n"
                + "Number of repetitions: " + numberOfRepetitions + "\n" + "Elapsed time: " + elapsedTime
                + " nanoseconds";
    }
}
