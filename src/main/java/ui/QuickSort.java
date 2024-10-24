package ui;

import static ui.UI.array;

class QuickSort {
    protected static void start() {
        Utils.prepareForSorting("Quick Sort");
        algorithms.QuickSort algo = new algorithms.QuickSort(array);
        algo.printArray();
        Utils.sleepALittle(2000);
        algo.sort();
        Utils.sleepALittle(2000);
        algo.clearScreenAndPrintStatistics("Quick Sort");
        Utils.sleepALittle(6000);
    }
}
