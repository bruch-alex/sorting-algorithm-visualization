package algorithms;

import ui.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class QuickSort extends SortingAlgorithm {

    public QuickSort(ArrayList<Integer> array) {
        super(array);
    }

    @Override
    public void sort() {
        int SLEEP_DURATION = 30;

        Set<Integer> sortedIndices = new HashSet<>();
        quickSort(0, array.size() - 1, sortedIndices, SLEEP_DURATION);
        Utils.displayVerticalArray(array, -1, -1, sortedIndices);
    }

    void quickSort(int start, int end, Set<Integer> sortedIndices, int sleepDuration) {
        if (start < end) {
            // pi is the partition return index of pivot
            int pi = partition(start, end, sortedIndices, sleepDuration);

            // Recursion calls for smaller elements
            // and greater or equals elements
            quickSort(start, pi - 1, sortedIndices, sleepDuration);
            quickSort(pi + 1, end, sortedIndices, sleepDuration);
        }
    }

    // Partition function
    int partition(int start, int end, Set<Integer> sortedIndices, int sleepDuration) {
        int pivot = array.get(end);

        // Index of smaller element and indicates
        // the right position of pivot found so far
        int pIndex = start;

        for (int i = start; i <= end - 1; i++) {
            Utils.displayVerticalArray(array, i, end, sortedIndices);
            if (array.get(i) <= pivot) {
                Utils.swapHighlighted(array, pIndex, i, sortedIndices, sleepDuration);
                pIndex++;
            }
        }

        // Traverse arr[start..end] and move all smaller
        // elements to the left side. Elements from start to
        // i are smaller after every iteration

        // Move pivot after smaller elements and
        // return its position
        Utils.swapHighlighted(array, pIndex, end, sortedIndices, sleepDuration); // Move pivot to correct position
        sortedIndices.add(pIndex);
        return pIndex;
    }

}
