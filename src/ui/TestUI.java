package ui;

import algorithms.BubbleSort;

import java.util.ArrayList;
import java.util.List;


public class TestUI {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(
                5, 2, 1, 7, 9, 12, 15, 10
        ));

        BubbleSort bubbleSort = new BubbleSort(list);

        bubbleSort.sort();

        Utils.printArray(list);
    }



}
