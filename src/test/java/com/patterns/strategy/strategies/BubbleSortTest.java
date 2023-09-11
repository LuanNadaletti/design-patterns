package com.patterns.strategy.strategies;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The <code>BubbleSortTest</code> class is a JUnit test class for testing the
 * {@link BubbleSort} implementation of the {@link SortStrategy} interface.
 *
 * @author Luan Nadaletti
 */
public class BubbleSortTest {

    private BubbleSort bubbleSort;

    @BeforeEach
    void setUp() {
        bubbleSort = new BubbleSort();
    }

    @Test
    void testSort() {
        int[] unsortedArray = {
                5, 2, 9, 1, 5, 6 };
        int[] expectedSortedArray = {
                1, 2, 5, 5, 6, 9 };

        bubbleSort.sort(unsortedArray);
        assertArrayEquals(expectedSortedArray, unsortedArray);
    }

    @Test
    void testSortEmptyArray() {
        int[] emptyArray = {};
        int[] expectedSortedArray = {};

        bubbleSort.sort(emptyArray);
        assertArrayEquals(expectedSortedArray, emptyArray);
    }

    @Test
    void testSortSingleElementArray() {
        int[] singleElementArray = {
                42 };
        int[] expectedSortedArray = {
                42 };

        bubbleSort.sort(singleElementArray);
        assertArrayEquals(expectedSortedArray, singleElementArray);
    }

}