package com.patterns.strategy.strategies;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Luan Nadaletti
 *
 */
public class BubbleSortTest {

    private BubbleSort bubbleSort;

    @BeforeEach
    public void setUp() {
        bubbleSort = new BubbleSort();
    }

    @Test
    public void testSort() {
        int[] unsortedArray = {
                5, 2, 9, 1, 5, 6 };
        int[] expectedSortedArray = {
                1, 2, 5, 5, 6, 9 };

        bubbleSort.sort(unsortedArray);
        assertArrayEquals(expectedSortedArray, unsortedArray);
    }

    @Test
    public void testSortEmptyArray() {
        int[] emptyArray = {};
        int[] expectedSortedArray = {};

        bubbleSort.sort(emptyArray);
        assertArrayEquals(expectedSortedArray, emptyArray);
    }

    @Test
    public void testSortSingleElementArray() {
        int[] singleElementArray = {
                42 };
        int[] expectedSortedArray = {
                42 };

        bubbleSort.sort(singleElementArray);
        assertArrayEquals(expectedSortedArray, singleElementArray);
    }

}