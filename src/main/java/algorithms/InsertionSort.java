package algorithms;

import ui.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class InsertionSort extends SortingAlgorithm {

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
            int sleepDuration = 40; // Dynamic delay for shifts and comparisons
            int highlightSortedElementDelay = 20; // Delay specifically for highlighting sorted elements


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
            printArray(-1, -1);
        }

        highlightEverything();
        printArray(-1, -1);
    }


    private void highlightElement(ArrayList<Integer> array, int index, String color, Set<Integer> sortedIndices, int sleepDuration) {
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

}


