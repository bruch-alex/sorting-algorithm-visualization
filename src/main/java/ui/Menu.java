package ui;

import io.github.shuoros.jterminal.JTerminal;

import static ui.UI.reader;

class Menu {
    protected static void printOptions() {
        JTerminal.clear();
        Utils.printInCenter("AWESOME algorithm visualization app", "=");
        JTerminal.println("""
                \nSelect an option:\
                \n\
                \n(1)\tRun Bubble sort\
                \n(2)\tRun Insertion sort\
                \n(3)\tRun Quick sort\
                \n(4)\tRun Selection sort\
                \n(a)\tRun all\
                \n(e)\texit""");
    }

    protected static void handleOptions() {
        switch (reader.readLine().trim().toLowerCase()) {
            case "1" -> BubbleSort.start();
            case "2" -> InsertionSort.start();
            case "3" -> QuickSort.start();
            case "4" -> SelectionSort.start();
            case "a", "all" -> StartAllOption.start();
            case "exit", "e" -> System.exit(0);
            default -> JTerminal.println("Wrong input");
        }
    }
}
