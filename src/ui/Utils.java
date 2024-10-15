package ui;

import java.util.ArrayList;

public abstract class Utils {
    // change to ### view
    public static void printArray(ArrayList<Integer> arrayList) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        arrayList.forEach(s -> System.out.print(s + "\t"));
        System.out.println();
    }

    // fillArrayRandomlyMethod (between 1 and 100 for example)
}