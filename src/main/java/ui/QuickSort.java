package ui;

import static ui.UI.array;

class QuickSort {
    protected static void start() {
        Utils.prepareForSorting("Quick Sort");
        new algorithms.QuickSort(array).sort();
        Utils.sleepALittle(1000);
    }
}
