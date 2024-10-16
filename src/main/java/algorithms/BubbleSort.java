package algorithms;

import ui.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BubbleSort extends AlgorithmSort {
    public BubbleSort(ArrayList<Integer> array) {
        super(array);
    }


    @Override
    public void sort() {
        int SLEEP_DURATION = 5;

        if (array.isEmpty()) {
            System.out.println("Array is empty, nothing to sort.");
            return;
        }

        int n = array.size();
        Set<Integer> sortedIndices = new HashSet<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Visualize the comparison
                Utils.displayVerticalArray(array, j, j + 1, sortedIndices);

                if (array.get(j) > array.get(j + 1)) {
                    // Swap and visualize the result of the selection for this iteration
                    Utils.swapHighlighted(array, j, j + 1, sortedIndices, SLEEP_DURATION);
                }
            }
            // Mark the current position as sorted
            sortedIndices.add(n - i - 1);
        }

        // Final visualization with all elements highlighted in green
        Utils.displayVerticalArray(array, -1, -1, sortedIndices);
    }
}
