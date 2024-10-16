package algorithms;

import ui.Utils;

import java.util.ArrayList;

public class BubbleSort extends AlgorithmSort {
    public BubbleSort(ArrayList<Integer> array) {
       super(array);
    }

    @Override
    public void sort() {
        int n = array.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array.get(j) > array.get(j + 1)) {
                    int temp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, temp);
                    Utils.printArray(array);
                }
            }
        }
    }

}
