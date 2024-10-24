package algorithms;

import java.util.ArrayList;

public class HeapSort extends SortingAlgorithm {

    public HeapSort(ArrayList<Integer> array) {
        super(array);
    }

    @Override
    public void sort() {
        int n = array.size();
        int SLEEP_DURATION = 30;

        // Build the max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(n, i, SLEEP_DURATION);
        }

        // Extract elements one by one from the heap
        for (int i = n - 1; i > 0; i--) {
            // Swap current root to end
            swapHighlighted(0, i, SLEEP_DURATION * 2);
            swapCount++;
            sortedIndices.add(i); // Mark as sorted
            heapify(i, 0, SLEEP_DURATION); // Heapify the reduced heap
        }
        // Mark the last element as sorted
        sortedIndices.add(0);

        printArray(-1, -1);
    }

    private void heapify(int n, int i, int sleepDuration) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array.get(left) > array.get(largest)) {
            largest = left;
            comparisonCount++;
        }

        if (right < n && array.get(right) > array.get(largest)) {
            largest = right;
            comparisonCount++;
        }

        if (largest != i) {
            swapHighlighted(i, largest, sleepDuration); // Swap and highlight
            swapCount++;
            heapify(n, largest, sleepDuration); // Recursively heapify the affected subtree
        }
    }

}
