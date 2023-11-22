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
        int[] unsortedArray = { 5, 2, 9, 1, 5, 6 };
        int[] expectedSortedArray = { 1, 2, 5, 5, 6, 9 };

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
        int[] singleElementArray = { 42 };
        int[] expectedSortedArray = { 42 };

        bubbleSort.sort(singleElementArray);
        assertArrayEquals(expectedSortedArray, singleElementArray);
    }

    @Test
    void testSortDescendingOrder() {
        int[] descendingArray = { 9, 7, 5, 3, 1 };
        int[] expectedSortedArray = { 1, 3, 5, 7, 9 };

        bubbleSort.sort(descendingArray);
        assertArrayEquals(expectedSortedArray, descendingArray);
    }

    @Test
    void testSortAlreadySorted() {
        int[] sortedArray = { 1, 2, 3, 4, 5 };
        int[] expectedSortedArray = { 1, 2, 3, 4, 5 };

        bubbleSort.sort(sortedArray);
        assertArrayEquals(expectedSortedArray, sortedArray);
    }

    @Test
    void testSortDuplicateValues() {
        int[] duplicateArray = { 3, 2, 3, 1, 2, 1 };
        int[] expectedSortedArray = { 1, 1, 2, 2, 3, 3 };

        bubbleSort.sort(duplicateArray);
        assertArrayEquals(expectedSortedArray, duplicateArray);
    }
}