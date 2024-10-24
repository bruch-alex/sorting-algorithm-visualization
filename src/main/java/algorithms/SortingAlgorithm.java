package algorithms;

import ui.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static ui.Utils.findMax;
import static ui.Utils.sleepALittle;

public abstract class SortingAlgorithm {
    protected ArrayList<Integer> array;
    protected int comparisonCount;
    protected int swapCount;
    protected Set<Integer> sortedIndices;

    protected final String RESET = "\033[0m";
    protected final String RED = "\033[31m"; // comparison element
    protected final String BLUE = "\033[34m"; // target element
    protected final String GREEN = "\033[32m"; // sorted elements

    public SortingAlgorithm(ArrayList<Integer> array) {
        if (array == null) {
            throw new IllegalArgumentException("Array can't be empty.");
        }
        this.array = array;
        this.sortedIndices = new HashSet<>();
    }

    public abstract void sort();


    public void clearScreenAndPrintStatistics(String algorithmName) {
        Utils.clearScreen();
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

    protected void printArray(int currentIndex, int targetIndex) {
        StringBuilder output = new StringBuilder();
        int maxHeight = findMax(array);

        for (int row = maxHeight; row > 0; row--) {
            // is used to clear the current line before printing new content for improving animation smoothness
            output.append("\033[2K"); // Clear the whole line
            for (int col = 0; col < array.size(); col++) {
                int element = array.get(col);
                if (element >= row) {
                    if (sortedIndices.contains(col)) {
                        output.append(GREEN).append("◼").append(RESET);
                    } else if (col == currentIndex) {
                        output.append(RED).append("◼").append(RESET);
                    } else if (col == targetIndex) {
                        output.append(BLUE).append("◼").append(RESET);
                    } else {
                        output.append("◼");
                    }
                } else {
                    output.append(" ");
                }
            }
            output.append("\n");
        }
        System.out.print(output);

        /*
        Repositioning the cursor:
        - makes the visualization smoother;
        - reduces flicker;
        - improves performance by avoiding full-screen clearing.
         */
        System.out.print("\033[" + maxHeight + "F"); // Move cursor up to the top
    }

    /**
     *
     */
    public void printArray() {
        StringBuilder output = new StringBuilder();
        int maxHeight = findMax(array);

        for (int row = maxHeight; row > 0; row--) {
            output.append("\033[2K"); // Clear the whole line
            for (int element : this.array) {
                if (element >= row) output.append("◼");
                else output.append(" ");
            }
            output.append("\n");
        }
        System.out.print(output);
        System.out.print("\033[" + maxHeight + "F"); // Move cursor up to the top
    }

    protected void swapHighlighted(int currentIndex, int targetIndex, int sleepDuration) {
        printArray(currentIndex, targetIndex);
        sleepALittle(sleepDuration);

        // Perform the swap
        int temp = array.get(currentIndex);
        array.set(currentIndex, array.get(targetIndex));
        array.set(targetIndex, temp);

        printArray(currentIndex, targetIndex); // maybe change ?
        sleepALittle(sleepDuration);
    }

    protected void highlightEverything() {
        for (int i = 0; i < array.size(); i++) {
            sortedIndices.add(i);
        }
    }

}
