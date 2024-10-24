package algorithms;

import java.util.ArrayList;
import java.util.Set;

public class QuickSort extends SortingAlgorithm {

    public QuickSort(ArrayList<Integer> array) {
        super(array);
    }

    @Override
    public void sort() {
        int SLEEP_DURATION = 25;
        quickSort(0, array.size() - 1, sortedIndices, SLEEP_DURATION);
        printArray( -1, -1);
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
            printArray(i, end);
            comparisonCount++;
            if (array.get(i) <= pivot) {
                swapHighlighted(pIndex, i, sleepDuration);
                swapCount++;
                pIndex++;
            }
        }

        swapHighlighted( pIndex, end, sleepDuration);
        swapCount++;
        sortedIndices.add(pIndex);
        sortedIndices.add(start);
        sortedIndices.add(end);
        return pIndex;
    }

}
