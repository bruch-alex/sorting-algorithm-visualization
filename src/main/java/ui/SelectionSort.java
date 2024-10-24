package ui;

import static ui.UI.array;

class SelectionSort {
    protected static void start() {
        Utils.prepareForSorting("Selection Sort");
        algorithms.SelectionSort algo = new algorithms.SelectionSort(array);
        algo.printArray();
        Utils.sleepALittle(2000);
        algo.sort();
        Utils.sleepALittle(2000);
        algo.clearScreenAndPrintStatistics("Selection Sort");
        Utils.sleepALittle(6000);
    }
}
