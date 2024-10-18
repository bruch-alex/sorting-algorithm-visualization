package ui;

import static ui.UI.reader;

class Menu {
    protected static void printOptions() {
        Utils.clearScreen();
        Utils.printInCenter("AWESOME algorithm visualization app", "=");
        System.out.println("Select an option" +
                "\n" +
                "(1)\tRun Bubble Sort" +
                "\n(2)\tRun Insertion Sort" +
                "\n(3)\tRun Quick Sort" +
                "\n(4)\tRun Selection Sort" +
                "\n(5)\tHeap Sort" +
                "\n(a)\tRun all" +
                "\n(e)\texit");
    }

    protected static void handleOptions() {
        switch (reader.readLine().trim().toLowerCase()) {
            case "1":
                BubbleSort.start();
                break;
            case "2":
                InsertionSort.start();
                break;
            case "3":
                QuickSort.start();
                break;
            case "4":
                SelectionSort.start();
                break;
            case "5":
                HeapSort.start();
                break;
            case "a":
            case "all":
                StartAllOption.start();
                break;
            case "exit":
            case "e":
                System.exit(0);
            default:
                System.err.println("Wrong input");
                break;
        }
    }
}
