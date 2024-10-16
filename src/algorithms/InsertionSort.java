package algorithms;

import ui.Utils;

import java.util.ArrayList;

public class InsertionSort extends AlgorithmSort {

    public InsertionSort(ArrayList<Integer> array) {
        super(array);
    }

    @Override
    public void sort() {

        if (array.isEmpty()) {
            System.out.println("Array is empty, nothing to sort.");
            return;
        }
        int n = array.size();
        for (int i = 1; i < n; i++) {
            int key = array.get(i);
            int j = i - 1;

            while (j >= 0 && array.get(j) > key) {
                array.set(j + 1, array.get(j));
                j = j - 1;
            }
            array.set(j + 1, key);

            Utils.printArray(array);
        }
    }
}
