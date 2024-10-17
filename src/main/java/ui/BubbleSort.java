package ui;

import static ui.UI.array;

class BubbleSort {
    protected static void start() {
        Utils.prepareForSorting("Bubble Sort");
        algorithms.BubbleSort algo =  new algorithms.BubbleSort(array);
        algo.sort();
        Utils.sleepALittle(2000);
        algo.printStatistics("Bubble Sort");
        Utils.sleepALittle(4000);
    }
}
