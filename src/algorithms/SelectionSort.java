package algorithms;

import ui.Utils;

import java.util.ArrayList;

public class SelectionSort extends AlgorithmSort {

    public SelectionSort(ArrayList<Integer> array) {
        super(array);
    }

    @Override
    public void sort() {

        if (array.isEmpty()) {
            System.out.println("Array is empty, nothing to sort.");
            return;
        }

        int n = array.size();
        for (int i = 0; i < n - 1; i++) {
            int currentMin = i;

            for (int j = i + 1; j < n; j++) {
                if (array.get(j) < array.get(currentMin)) {
                    currentMin = j;
                }
            }

            if (currentMin != i) {
                int temp = array.get(i);
                array.set(i, array.get(currentMin));
                array.set(currentMin, temp);
            }

            Utils.printArray(array);
        }
    }
}
