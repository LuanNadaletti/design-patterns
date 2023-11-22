package com.patterns.strategy.strategies;

import java.util.Arrays;

/**
 * The <code>BubbleSort</code> class implements the {@link SortStrategy}
 * interface to provide a bubble sort algorithm for sorting integer arrays. It
 * also collects information about the sorting process.
 *
 * @author Luan Nadaletti
 */
public class BubbleSort implements SortStrategy {

    private int[] sortedArray;
    private int numberOfRepetitions;
    private long elapsedTime;

    /**
     * Sorts the given integer array using the bubble sort algorithm.
     *
     * @param array the integer array to be sorted.
     */
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

    /**
     * Gets information about the bubble sort process, including the sorted array,
     * the number of repetitions, and the elapsed time.
     *
     * @return a string containing information about the bubble sort process.
     */
    @Override
    public String getSortInfo() {
        return "Bubble Sort Info: \n" + "Sorted array: " + Arrays.toString(sortedArray) + "\n"
                + "Number of repetitions: " + numberOfRepetitions + "\n" + "Elapsed time: " + elapsedTime
                + " nanoseconds";
    }
}
