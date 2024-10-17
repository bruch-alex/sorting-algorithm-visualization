package ui;

import static ui.UI.array;

class SelectionSort {
    protected static void start() {
        Utils.prepareForSorting("Selection Sort");
        new algorithms.InsertionSort(array).sort();
        Utils.sleepALittle(1000);
    }
}
