package ui;


import java.util.ArrayList;
import java.util.Random;

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


    public static void clearArrayAndFillRandomly(ArrayList<Integer> array, int width, int height) {
        Random r = new Random();
        array.clear();
        for (int i = 0; i < width; i++) {
            array.add(r.nextInt(height - 2) + 1);
        }
    }

    public static void printInCenter(String line, String symbolForFill) {
        int width = UI.terminal.getWidth();
        int padding = ((width - line.length()) / 2);
        System.out.println(symbolForFill.repeat(Math.max(0, padding)) + line + symbolForFill.repeat(Math.max(0, width - (padding + line.length()))));
    }

    public static void printInCenter(String line) {
        int width = UI.terminal.getWidth();
        int padding = ((width - line.length()) / 2);
        System.out.println(" ".repeat(Math.max(0, padding)) + line + " ".repeat(Math.max(0, width - (padding + line.length()))));
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