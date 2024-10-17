package algorithms;

import ui.Utils;

import java.util.ArrayList;

public abstract class SortingAlgorithm {
    protected ArrayList<Integer> array;
    protected int comparisonCount;
    protected int swapCount;

    public SortingAlgorithm(ArrayList<Integer> array) {
        if (array == null) {
            throw new IllegalArgumentException("Array can't be empty.");
        }
        this.array = array;
    }

    public abstract void sort();


    public void printStatistics(String algorithmName) {
        clearScreen();
        Utils.printInCenter("========= " + algorithmName + " Statistics: =========", " ");

        String header = "+--------------------+--------------------+";
        String metrics = "| Metric             | Value              |";
        String separator = "+--------------------+--------------------+";
        String arraySize = String.format("| %-18s | %-18d |", "Array Size", array.size());
        String comparisons = String.format("| %-18s | %-18d |", "Total Comparisons", comparisonCount);
        String swaps = String.format("| %-18s | %-18d |", "Total Swaps/Shifts", swapCount);

        Utils.printInCenter(header, " ");
        Utils.printInCenter(metrics, " ");
        Utils.printInCenter(separator, " ");
        Utils.printInCenter(arraySize, " ");
        Utils.printInCenter(comparisons, " ");
        Utils.printInCenter(swaps, " ");
        Utils.printInCenter(separator, " ");
    }


    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
