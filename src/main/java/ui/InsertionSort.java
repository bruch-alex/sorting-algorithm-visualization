package ui;

import static ui.UI.array;

class InsertionSort {
    protected static void start() {
        Utils.prepareForSorting("Insertion sort");
        algorithms.InsertionSort algo = new algorithms.InsertionSort(array);
        algo.sort();
        Utils.sleepALittle(2000);
        algo.printStatistics("Insertion Sort");
        Utils.sleepALittle(2000);
    }
}