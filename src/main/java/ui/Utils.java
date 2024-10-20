package ui;


import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

import static ui.UI.array;
import static ui.UI.terminal;

public abstract class Utils {

    public static int findMax(ArrayList<Integer> array) {
        int max = 0;
        for (var element : array) {
            if (element > max) max = element;
        }
        return max;
    }

    public static void swapHighlighted(ArrayList<Integer> arr, int currentIndex, int targetIndex, Set<Integer> sortedIndices, int sleepDuration) {
        displayVerticalArray(arr, currentIndex, targetIndex, sortedIndices);
        sleepALittle(sleepDuration);

        // Perform the swap
        int temp = arr.get(currentIndex);
        arr.set(currentIndex, arr.get(targetIndex));
        arr.set(targetIndex, temp);

        displayVerticalArray(arr, currentIndex, targetIndex, sortedIndices);
        sleepALittle(sleepDuration);
    }


    public static void displayVerticalArray(ArrayList<Integer> arrayList, int currentIndex, int targetIndex, Set<Integer> sortedIndices) {
        final String RESET = "\033[0m";
        final String RED = "\033[31m"; // comparison element
        final String BLUE = "\033[34m"; // target element
        final String GREEN = "\033[32m"; // sorted elements
        StringBuilder output = new StringBuilder();

        int maxHeight = findMax(arrayList);

        for (int row = maxHeight; row > 0; row--) {
            // is used to clear the current line before printing new content for improving animation smoothness
            output.append("\033[2K"); // Clear the whole line
            for (int col = 0; col < arrayList.size(); col++) {
                int element = arrayList.get(col);
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
        //printInCenter(output.toString(), " ");
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
     * Overload displayVerticalArray method to print initial unsorted array in white
     *
     * @param arrayList array to print
     */
    public static void displayVerticalArray(ArrayList<Integer> arrayList) {
        StringBuilder output = new StringBuilder();

        int maxHeight = findMax(arrayList);

        for (int row = maxHeight; row > 0; row--) {
            output.append("\033[2K"); // Clear the whole line
            for (int element : arrayList) {
                if (element >= row) output.append("◼");
                else output.append(" ");
            }
            output.append("\n");
        }
        System.out.print(output);
        System.out.print("\033[" + maxHeight + "F"); // Move cursor up to the top
    }

    public static void clearArrayAndFillRandomly(ArrayList<Integer> array, int width, int height) {
        Random r = new Random();
        array.clear();
        for (int i = 0; i < width - 1; i++) {
            array.add(r.nextInt(height - 1) + 1);
        }
    }

    public static void printInCenter(String line, String symbolForFill) {
        int width = UI.terminal.getWidth();
        int padding = ((width - line.length()) / 2);
        System.out.println(symbolForFill.repeat(Math.max(0, padding)) + line + symbolForFill.repeat(Math.max(0, padding)));
    }

    /**
     * Preparing to print a sorting animation and show unsorted array for 3 seconds
     *
     * @param algorithm Name of algorithm that will be printed at the top of the screen
     */
    public static void prepareForSorting(String algorithm) {
        clearArrayAndFillRandomly(array, terminal.getWidth(), terminal.getHeight());
        clearScreen();
        printInCenter(algorithm, "=");
        displayVerticalArray(array);
        sleepALittle(3000);
    }

    /**
     * We use Thread.sleep() a lot, so let's extract it to the nice method
     *
     * @param sleepDuration duration of sleep in millis
     */
    public static void sleepALittle(int sleepDuration) {
        try {
            Thread.sleep(sleepDuration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}