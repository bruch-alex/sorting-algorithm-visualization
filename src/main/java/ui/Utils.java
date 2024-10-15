package ui;

import io.github.shuoros.jterminal.JTerminal;

import java.util.ArrayList;

public abstract class Utils {
    // change to ### view
    public static void printArray(ArrayList<Integer> arrayList) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        JTerminal.clear();
        int line = findMax(arrayList);
        StringBuilder sb = new StringBuilder();
        while (line >= 0) {
            for (var element : arrayList) {
                if (element > line) JTerminal.print("#");
                else JTerminal.print(" ");
            }
            JTerminal.println("");
            line--;
        }

    }

    private static int findMax(ArrayList<Integer> array) {
        int max = 0;
        for (var element : array) {
            if (element > max) max = element;
        }
        return max;
    }

    // fillArrayRandomlyMethod (between 1 and 100 for example)
}