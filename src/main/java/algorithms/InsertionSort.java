package algorithms;

import ui.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class InsertionSort extends SortingAlgorithm {
    private int comparisonCount = 0;
    private int swapCount = 0;

    public InsertionSort(ArrayList<Integer> array) {
        super(array);

    }

    @Override
    public void sort() {
        if (array.isEmpty()) {
            System.out.println("Array is empty, nothing to sort.");
            return;
        }

        Set<Integer> sortedIndices = new HashSet<>();
        int n = array.size();

        for (int i = 1; i < n; i++) {
            int sleepDuration = 10 + (i * 2); // Dynamic delay for shifts and comparisons
            int highlightSortedElementDelay = 10 + (i * 5); // Delay specifically for highlighting sorted elements


            int key = array.get(i);
            int j = i - 1;


            // Highlight the key element: = YELLOW =
            highlightElement(array, i, "\033[33m", sortedIndices, sleepDuration);

            // Shift elements in sorted portion to make space for key: = RED =
            while (j >= 0 && array.get(j) > key) {
                comparisonCount++;
                array.set(j + 1, array.get(j));
                highlightElement(array, j + 1, "\033[31m", sortedIndices, sleepDuration);
                j--;
            }

            // Show target position in: = BLUE =  before insertion
            highlightElement(array, j + 1, "\033[34m", sortedIndices, sleepDuration * 2);
            array.set(j + 1, key);
            swapCount++;

            // Delay and mark as sorted in: = GREEN =
            try {
                Thread.sleep(highlightSortedElementDelay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            sortedIndices.add(j + 1);
            Utils.displayVerticalArray(array, -1, -1, sortedIndices);
        }

        highlightEverything(sortedIndices);
        Utils.displayVerticalArray(array, -1, -1, sortedIndices);
        printStatistics();
    }


    private static void highlightElement(ArrayList<Integer> array, int index, String color, Set<Integer> sortedIndices, int sleepDuration) {
        final String RESET = "\033[0m";
        final String GREEN = "\033[32m";
        final String SQUARE = "◼";
        StringBuilder output = new StringBuilder();

        int maxHeight = Utils.findMax(array);
        for (int row = maxHeight; row > 0; row--) {
            output.append("\033[2K");
            for (int col = 0; col < array.size(); col++) {
                int element = array.get(col);
                if (element >= row) {
                    if (col == index) {
                        output.append(color).append(SQUARE).append(RESET); // Highlight element in specified color
                    } //else if (sortedIndices.contains(col)) {
                    //output.append(GREEN).append(SQUARE).append(RESET);
                    //    }
                    else {
                        output.append(SQUARE);
                    }
                } else {
                    output.append(" ");
                }
            }
            output.append("\n");
        }

        System.out.print(output.toString());
        System.out.print("\033[" + maxHeight + "F");

        try {
            Thread.sleep(sleepDuration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void highlightEverything(Set<Integer> sortedIndices){
        for (int i = 0; i < array.size(); i++) {
            sortedIndices.add(i);
        }
    }

    private void printStatistics() {
        System.out.println("\n===== Insertion Sort Statistics: =====");
        System.out.printf("+--------------------+--------------------+%n");
        System.out.printf("| Metric             | Value              |%n");
        System.out.printf("+--------------------+--------------------+%n");
        System.out.printf("| Array Size         | %-18d |%n", array.size());
        System.out.printf("| Total Comparisons  | %-18d |%n", comparisonCount);
        System.out.printf("| Total Swaps/Shifts | %-18d |%n", swapCount);
        System.out.printf("+--------------------+--------------------+%n");
    }
}


