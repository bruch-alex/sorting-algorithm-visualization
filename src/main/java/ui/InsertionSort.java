package ui;

import static ui.UI.array;

class InsertionSort {
    protected static void start() {
        Utils.prepareForSorting("Insertion sort");
        new algorithms.InsertionSort(array).sort();
        Utils.sleepALittle(1000);
    }
}
