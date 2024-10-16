package ui;

import algorithms.BubbleSort;
import algorithms.InsertionSort;
import algorithms.QuickSort;
import algorithms.SelectionSort;
import io.github.shuoros.jterminal.JTerminal;
import org.jline.reader.LineReader;
import org.jline.terminal.Terminal;

import java.util.ArrayList;

public class UI {
    private static ArrayList<Integer> array;
    public static Terminal terminal;
    private static LineReader reader;

    public UI(Terminal terminal, LineReader reader) {
        UI.terminal = terminal;
        UI.reader = reader;
        array = new ArrayList<>();
    }

    public void start() {
        while (true) {
            printMenuOptions();
            handleMenuOptions();
        }
    }

    private void printMenuOptions() {
        JTerminal.clear();
        Utils.printInCenter("AWESOME algorithm visualization app", "=");
        JTerminal.println("""
                \n
                Select sorting algorithm. Enter number of an algorithm or 'all' to run all algorithms\
                \n1 - Bubble sort\
                \n2 - Insertion sort\
                \n3 - Quick sort\
                \n4 - Selection sort\
                \nall - all one after other\
                \nexit""");
    }

    private void handleMenuOptions() {
        switch (reader.readLine().trim().toLowerCase()) {
            case "1" -> startBubbleSort();
            case "2" -> startInsertionSort();
            case "3" -> startQuickSort();
            case "4" -> startSelectionSort();
            case "a", "all" -> {
                startBubbleSort();
                startInsertionSort();
                startQuickSort();
                startSelectionSort();
            }
            case "exit" -> System.exit(0);
            default -> JTerminal.println("""
                    Wrong input. Valid options:\
                    \n1-4 - algorithms;\
                    \na, all - all algorithms\
                    \nexit - exit""");
        }
    }

    private void startBubbleSort() {
        Utils.clearArrayAndFillRandomly(array, terminal.getWidth(), terminal.getHeight());
        JTerminal.clear();
        Utils.printInCenter("Bubble sort", "=");
        new BubbleSort(array).sort();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private void startInsertionSort() {
        Utils.clearArrayAndFillRandomly(array, terminal.getWidth(), terminal.getHeight());
        JTerminal.clear();
        Utils.printInCenter("Insertion sort", "=");
        new InsertionSort(array).sort();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private void startQuickSort() {
        Utils.clearArrayAndFillRandomly(array, terminal.getWidth(), terminal.getHeight());
        JTerminal.clear();
        Utils.printInCenter("Quick sort", "=");
        new QuickSort(array).sort();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private void startSelectionSort() {
        Utils.clearArrayAndFillRandomly(array, terminal.getWidth(), terminal.getHeight());
        JTerminal.clear();
        Utils.printInCenter("Selection Sort", "=");
        new SelectionSort(array).sort();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }


}
