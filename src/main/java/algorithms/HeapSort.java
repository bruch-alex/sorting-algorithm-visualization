package algorithms;

import ui.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class HeapSort extends AlgorithmSort {
    private int comparisonCount = 0;
    private int swapCount = 0;

    public HeapSort(ArrayList<Integer> array) {
        super(array);
    }

    @Override
    public void sort() {
        int n = array.size();
        Set<Integer> sortedIndices = new HashSet<>();
        int SLEEP_DURATION = 40;

        // Build the max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(n, i, sortedIndices, SLEEP_DURATION);
        }

        // Extract elements one by one from the heap
        for (int i = n - 1; i > 0; i--) {
            // Swap current root to end
            Utils.swapHighlighted(array, 0, i, sortedIndices, SLEEP_DURATION * 2);
            swapCount++;
            sortedIndices.add(i); // Mark as sorted
            heapify(i, 0, sortedIndices, SLEEP_DURATION); // Heapify the reduced heap
        }
        // Mark the last element as sorted
        sortedIndices.add(0);

        Utils.displayVerticalArray(array, -1, -1, sortedIndices);

        clearScreen();
        printStatistics();
    }

    private void heapify(int n, int i, Set<Integer> sortedIndices, int sleepDuration) {
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
            Utils.swapHighlighted(array, i, largest, sortedIndices, sleepDuration); // Swap and highlight
            swapCount++;
            heapify(n, largest, sortedIndices, sleepDuration); // Recursively heapify the affected subtree
        }
    }

    private void printStatistics() {
        System.out.println("\n========= Heap Sort Statistics: =========");
        System.out.printf("+--------------------+--------------------+%n");
        System.out.printf("| Metric             | Value              |%n");
        System.out.printf("+--------------------+--------------------+%n");
        System.out.printf("| Array Size         | %-18d |%n", array.size());
        System.out.printf("| Total Comparisons  | %-18d |%n", comparisonCount);
        System.out.printf("| Total Swaps/Shifts | %-18d |%n", swapCount);
        System.out.printf("+--------------------+--------------------+%n");
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
