package algorithms;

import java.util.ArrayList;

public class SelectionSort extends SortingAlgorithm {

    public SelectionSort(ArrayList<Integer> array) {
        super(array);
    }

    @Override
    public void sort() {
        int SLEEP_DURATION = 50;
        int n = array.size();

        for (int i = 0; i < n - 1; i++) {
            int currentMin = i;

            for (int j = i + 1; j < n; j++) {
                // Visualize the comparison
                printArray(i, j);
                comparisonCount++;

                if (array.get(j) < array.get(currentMin)) {
                    currentMin = j;
                }
            }

            // Swap and visualize the result of the selection for this iteration
            if (currentMin != i) {
                swapHighlighted(i, currentMin, SLEEP_DURATION);
                swapCount++;
            }

            // Mark the current position as sorted
            sortedIndices.add(i);
        }

        // Ensure all elements are marked as sorted for the final display
        for (int i = 0; i < n; i++) {
            sortedIndices.add(i);
        }

        // Final visualization with all elements highlighted in green
        printArray(-1, -1);
    }
}

