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
        int SLEEP_DURATION = 25;
        Set<Integer> sortedIndices = new HashSet<>();
        quickSort(0, array.size() - 1, sortedIndices, SLEEP_DURATION);
        Utils.displayVerticalArray(array, -1, -1, sortedIndices);
    }

    void quickSort(int start, int end, Set<Integer> sortedIndices, int sleepDuration) {
        if (start < end) {
            int pi = partition(start, end, sortedIndices, sleepDuration);
            quickSort(start, pi - 1, sortedIndices, sleepDuration);
            quickSort(pi + 1, end, sortedIndices, sleepDuration);
        }
    }

    int partition(int start, int end, Set<Integer> sortedIndices, int sleepDuration) {
        int pivot = array.get(end);
        int pIndex = start;

        for (int i = start; i <= end - 1; i++) {
            Utils.displayVerticalArray(array, i, end, sortedIndices);
            comparisonCount++;
            if (array.get(i) <= pivot) {
                Utils.swapHighlighted(array, pIndex, i, sortedIndices, sleepDuration);
                swapCount++;
                pIndex++;
            }
        }

        Utils.swapHighlighted(array, pIndex, end, sortedIndices, sleepDuration);
        swapCount++;
        sortedIndices.add(pIndex);
        sortedIndices.add(start);
        sortedIndices.add(end);
        return pIndex;
    }

}
