package ui;

import static ui.UI.array;

class SelectionSort {
    protected static void start() {
        Utils.prepareForSorting("Selection Sort");
        algorithms.SelectionSort algo = new algorithms.SelectionSort(array);
        algo.sort();
        Utils.sleepALittle(2000);
        algo.printStatistics("Selection Sort");
        Utils.sleepALittle(2000);
    }
}
