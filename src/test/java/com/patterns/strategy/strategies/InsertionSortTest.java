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

}
