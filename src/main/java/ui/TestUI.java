package ui;

import algorithms.BubbleSort;

import java.util.ArrayList;
import java.util.List;

public class TestUI {
    public static void start() {

        ArrayList<Integer> list = new ArrayList<>(List.of(
                10, 17, 9, 19, 15, 7, 6, 4, 7, 6,
                            6, 20, 17, 6, 5, 8, 8, 5, 17, 18,
                            16, 17, 10, 1, 18, 4, 6, 20, 9, 14,
                            7, 4, 15, 7, 6, 2, 15, 15, 3, 1, 9,
                            2, 19, 8, 16, 14, 19, 5, 20, 9
        ));
        BubbleSort bubbleSort = new BubbleSort(list);

        bubbleSort.sort();

        Utils.printArray(list);
    }


}
