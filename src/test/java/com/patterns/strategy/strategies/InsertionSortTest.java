package com.patterns.strategy.strategies;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Luan Nadaletti
 *
 */
public class InsertionSortTest {

    private InsertionSort insertionSort;

    @BeforeEach
    void setup() {
        insertionSort = new InsertionSort();
    }

    @Test
    void testSort() {
        int[] unsortedArray = {
                9, 3, 4, 6, 1, 2, 5, 8, 7 };
        int[] expectedArray = {
                1, 2, 3, 4, 5, 6, 7, 8, 9 };

        insertionSort.sort(unsortedArray);
        assertArrayEquals(unsortedArray, expectedArray);
    }

    @Test
    void testSortEmptyArray() {
        int[] emptyArray = {};
        int[] expectedArray = {};

        insertionSort.sort(emptyArray);
        assertArrayEquals(emptyArray, expectedArray);
    }

    @Test
    void testSortSingleElementArray() {
        int[] singleElementArray = {
                42 };
        int[] expectedSortedArray = {
                42 };

        insertionSort.sort(singleElementArray);
        assertArrayEquals(expectedSortedArray, singleElementArray);
    }

    @Test
    void testSortDescendingOrder() {
        int[] descendingArray = {
                9, 7, 5, 3, 1 };
        int[] expectedSortedArray = {
                1, 3, 5, 7, 9 };

        insertionSort.sort(descendingArray);
        assertArrayEquals(expectedSortedArray, descendingArray);
    }

    @Test
    void testSortAlreadySorted() {
        int[] sortedArray = {
                1, 2, 3, 4, 5 };
        int[] expectedSortedArray = {
                1, 2, 3, 4, 5 };

        insertionSort.sort(sortedArray);
        assertArrayEquals(expectedSortedArray, sortedArray);
    }

    @Test
    void testSortDuplicateValues() {
        int[] duplicateArray = {
                3, 2, 3, 1, 2, 1 };
        int[] expectedSortedArray = {
                1, 1, 2, 2, 3, 3 };

        insertionSort.sort(duplicateArray);
        assertArrayEquals(expectedSortedArray, duplicateArray);
    }

}
