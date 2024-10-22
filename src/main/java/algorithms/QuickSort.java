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
        int SLEEP_DURATION = 10;
        Set<Integer> sortedIndices = new HashSet<>();
        Thread t = NewQuickSortThread(0, array.size() - 1, sortedIndices, SLEEP_DURATION);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Utils.displayVerticalArray(array, -1, -1, sortedIndices);
    }

    Thread NewQuickSortThread(int start, int end, Set<Integer> sortedIndices, int sleepDuration) {
        return new Thread(() -> {
            if (start < end) {
                int pi = partition(start, end, sortedIndices, sleepDuration);
                Thread left = NewQuickSortThread(start, pi - 1, sortedIndices, sleepDuration);
                Thread right = NewQuickSortThread(pi + 1, end, sortedIndices, sleepDuration);

                left.start();
                right.start();

                try {
                    left.join();
                    right.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    int partition(int start, int end, Set<Integer> sortedIndices, int sleepDuration) {
        int pivotValue = array.get(end);
        int partitionIndex = start;

        for (int i = start; i < end; i++) {
            Utils.displayVerticalArray(array, i, end, sortedIndices);
            if (array.get(i) <= pivotValue) {
                Utils.swapHighlighted(array, partitionIndex, i, sortedIndices, sleepDuration);
                swapCount++;
                partitionIndex++;
                if (array.get(i) == pivotValue) sortedIndices.add(i);
            }

            comparisonCount++;
        }

        Utils.swapHighlighted(array, partitionIndex, end, sortedIndices, sleepDuration);
        swapCount++;
        sortedIndices.add(partitionIndex);
        if (start == end - 1) {
            sortedIndices.add(start);
            sortedIndices.add(end);
        }

        //sortedIndices.add(start);
        //sortedIndices.add(end);
        return partitionIndex;
    }

}
