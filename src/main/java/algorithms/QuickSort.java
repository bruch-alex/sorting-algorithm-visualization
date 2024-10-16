package algorithms;

import ui.Utils;

import java.util.ArrayList;

public class QuickSort extends AlgorithmSort {

    public QuickSort(ArrayList<Integer> array) {
        super(array);
    }

    @Override
    public void sort() {
        quickSort(0, array.size() - 1);
    }

    void quickSort(int start, int end) {
        if (start < end) {
            // pi is the partition return index of pivot
            int pi = partition(start, end);

            // Recursion calls for smaller elements
            // and greater or equals elements
            quickSort(start, pi - 1);
            quickSort(pi + 1, end);
        }
    }

    // Partition function
    int partition(int start, int end) {
        int pivot = array.get(end);

        // Index of smaller element and indicates
        // the right position of pivot found so far
        int pIndex = start;

        for (int i = start; i <= end - 1; i++) {
            if (array.get(i) <= pivot) {
                Utils.swap(array, pIndex, end);
                pIndex++;
            }
        }

        // Traverse arr[start..end] and move all smaller
        // elements to the left side. Elements from start to
        // i are smaller after every iteration

        // Move pivot after smaller elements and
        // return its position
        Utils.swap(array, pIndex, end);
        return pIndex;
    }


}
