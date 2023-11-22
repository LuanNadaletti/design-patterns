package com.patterns.strategy.strategies;

import java.util.Arrays;

/**
 * The <code>InsertionSort</code> class implements the {@link SortStrategy}
 * interface to provide an insertion sort algorithm for sorting integer arrays.
 * It also collects information about the sorting process.
 *
 * @author Luan Nadaletti
 */
public class InsertionSort implements SortStrategy {

    private int[] sortedArray;
    private int numberOfRepetitions;
    private long elapsedTime;

    /**
     * Sorts the given integer array using the insertion sort algorithm.
     *
     * @param array the integer array to be sorted.
     */
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

    /**
     * Gets information about the insertion sort process, including the sorted
     * array, the number of repetitions, and the elapsed time.
     *
     * @return a string containing information about the insertion sort process.
     */
    @Override
    public String getSortInfo() {
        return "Insertion Sort Info: \n" + "Sorted array: " + Arrays.toString(sortedArray) + "\n"
                + "Number of repetitions: " + numberOfRepetitions + "\n" + "Elapsed time: " + elapsedTime
                + " nanoseconds";
    }
}
