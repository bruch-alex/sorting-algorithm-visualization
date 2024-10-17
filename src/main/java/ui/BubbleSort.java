package ui;

import static ui.UI.array;

class BubbleSort {
    protected static void start() {
        Utils.prepareForSorting("Bubble Sort");
        new algorithms.BubbleSort(array).sort();
        Utils.sleepALittle(1000);
    }
}
