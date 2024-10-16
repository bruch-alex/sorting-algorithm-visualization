package algorithms;

import ui.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class InsertionSort extends AlgorithmSort {

    public InsertionSort(ArrayList<Integer> array) {
        super(array);
    }

    @Override
    public void sort() {
        int SLEEP_DURATION = 10;
        Set<Integer> sortedIndices = new HashSet<>();

        if (array.isEmpty()) {
            System.out.println("Array is empty, nothing to sort.");
            return;
        }

        int n = array.size();
        for (int i = 1; i < n; i++) {
            int key = array.get(i);
            int j = i - 1;

            // Highlight the initial key element before shifting
            highlightInsertion(array, i, -1, -1, sortedIndices, SLEEP_DURATION);

            // Shift elements to the right and highlight each shift
            while (j >= 0 && array.get(j) > key) {
                array.set(j + 1, array.get(j));
                highlightInsertion(array, i, j, j + 1, sortedIndices, SLEEP_DURATION);
                j = j - 1;
            }

            // Place the key in the correct position
            array.set(j + 1, key);
            highlightInsertion(array, -1, j + 1, j + 1, sortedIndices, SLEEP_DURATION);

            // Mark the element as sorted
            sortedIndices.add(i);
        }

        // Mark all elements as sorted for the final display
        Utils.displayVerticalArray(array, -1, -1, sortedIndices);
    }

    static void highlightInsertion(ArrayList<Integer> arrayList, int keyIndex, int shiftIndex, int targetIndex, Set<Integer> sortedIndices, int sleepDuration) {
        final String RESET = "\033[0m";
        final String YELLOW = "\033[33m"; // Key element
        final String RED = "\033[31m";    // Shifted elements
        final String BLUE = "\033[34m";   // Target position
        final String GREEN = "\033[32m";  // Sorted elements

        StringBuilder output = new StringBuilder();
        int maxHeight = Utils.findMax(arrayList);

        for (int row = maxHeight; row > 0; row--) {
            output.append("\033[2K"); // Clear the whole line

            for (int col = 0; col < arrayList.size(); col++) {
                int element = arrayList.get(col);

                if (element >= row) {
                    if (sortedIndices.contains(col)) {
                        output.append(GREEN).append("#").append(RESET);
                    } else if (col == keyIndex) {
                        output.append(YELLOW).append("#").append(RESET);
                    } else if (col == shiftIndex) {
                        output.append(RED).append("#").append(RESET);
                    } else if (col == targetIndex) {
                        output.append(BLUE).append("#").append(RESET);
                    } else {
                        output.append("#");
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
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
