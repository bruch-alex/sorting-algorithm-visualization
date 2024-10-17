package algorithms;

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
        System.out.println("\n========= " + algorithmName + " Statistics: =========");
        System.out.printf("+--------------------+--------------------+%n");
        System.out.printf("| Metric             | Value              |%n");
        System.out.printf("+--------------------+--------------------+%n");
        System.out.printf("| Array Size         | %-18d |%n", array.size());
        System.out.printf("| Total Comparisons  | %-18d |%n", comparisonCount);
        System.out.printf("| Total Swaps/Shifts | %-18d |%n", swapCount);
        System.out.printf("+--------------------+--------------------+%n");
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
