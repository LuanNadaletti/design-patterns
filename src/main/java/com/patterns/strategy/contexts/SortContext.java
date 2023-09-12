package com.patterns.strategy.contexts;

import com.patterns.strategy.strategies.BubbleSort;
import com.patterns.strategy.strategies.InsertionSort;
import com.patterns.strategy.strategies.SelectionSort;
import com.patterns.strategy.strategies.SortStrategy;

/**
 * The <code>SortContext</code> class acts as a context for sorting integer
 * arrays using different sorting strategies. It allows clients to set and
 * change the sorting strategy dynamically and perform sorting operations.
 *
 * @author Luan Nadaletti
 */
public class SortContext {

    private SortStrategy sortStrategy;

    /**
     * Sorts the given integer array using the currently set sorting strategy.
     *
     * @param array the integer array to be sorted.
     */
    public void sort(int[] array) {
        if (sortStrategy == null) {
            throw new IllegalStateException(
                    "Nenhuma estratégia de ordenação definida.");
        }

        sortStrategy.sort(array);
    }

    /**
     * Sets the sorting strategy based on the provided strategy name.
     *
     * @param strategyName the name of the sorting strategy to be set.
     * @throws IllegalArgumentException if an unknown strategy name is provided.
     */
    public void setSortStrategy(String strategyName) {
        if (strategyName.equalsIgnoreCase("bubble sort")) {
            sortStrategy = new BubbleSort();
        } else if (strategyName.equalsIgnoreCase("insertion sort")) {
            sortStrategy = new InsertionSort();
        } else if (strategyName.equalsIgnoreCase("selection sort")) {
            sortStrategy = new SelectionSort();
        } else {
            throw new IllegalArgumentException(
                    "Estratégia de ordenação desconhecida: " + strategyName);
        }
    }

    public SortStrategy getSortStrategy() {
        return sortStrategy;
    }

}
