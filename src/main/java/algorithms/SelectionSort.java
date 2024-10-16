package algorithms;

import ui.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SelectionSort extends AlgorithmSort {

    public SelectionSort(ArrayList<Integer> array) {
        super(array);
    }

    @Override
    public void sort() {
        int SLEEP_DURATION = 25;

        if (array.isEmpty()) {
            System.out.println("Array is empty, nothing to sort.");
            return;
        }

        int n = array.size();
        Set<Integer> sortedIndices = new HashSet<>();

        for (int i = 0; i < n - 1; i++) {
            int currentMin = i;

            for (int j = i + 1; j < n; j++) {
                // Visualize the comparison
                Utils.displayVerticalArray(array, i, j, sortedIndices);

                if (array.get(j) < array.get(currentMin)) {
                    currentMin = j;
                }
            }

            // Swap and visualize the result of the selection for this iteration
            if (currentMin != i) {
                Utils.swapHighlighted(array, i, currentMin, sortedIndices, SLEEP_DURATION);
            }

            // Mark the current position as sorted
            sortedIndices.add(i);
        }

        // Ensure all elements are marked as sorted for the final display
        for (int i = 0; i < n; i++) {
            sortedIndices.add(i);
        }

        // Final visualization with all elements highlighted in green
        Utils.displayVerticalArray(array, -1, -1, sortedIndices);
    }
}

