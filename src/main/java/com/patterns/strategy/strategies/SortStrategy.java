package com.patterns.strategy.strategies;

/**
 * The <code>SortStrategy</code> interface defines the contract for implementing
 * different sorting strategies. Classes that implement this interface must
 * provide implementations for the <code>sort</code> method to sort an integer
 * array and the <code>getSortInfo</code> method to provide information about
 * the sorting process.
 *
 * @author Luan Nadaletti
 */
public interface SortStrategy {

    /**
     * Sorts the given integer array using a specific sorting algorithm.
     *
     * @param array the integer array to be sorted.
     */
    void sort(int[] array);

    /**
     * Gets information about the sorting process, such as the name of the
     * sorting algorithm and any additional details.
     *
     * @return a string containing information about the sorting process.
     */
    String getSortInfo();

}
