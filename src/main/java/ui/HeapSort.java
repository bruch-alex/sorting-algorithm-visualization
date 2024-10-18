package ui;

import static ui.UI.array;

public class HeapSort {
    public static void start(){
        Utils.prepareForSorting("Heap Sort");
        algorithms.HeapSort algo =  new algorithms.HeapSort(array);
        algo.sort();
        Utils.sleepALittle(2000);
        algo.clearScreenAndPrintStatistics("Heap Sort");
        Utils.sleepALittle(4000);
    }
}
