package ui;

import static ui.UI.reader;

class Menu {
    protected static void printOptions() {
        Utils.clearScreen();
        Utils.printInCenter("AWESOME algorithm visualization app", "=");
        System.out.println();
        Utils.printInCenter("Press ENTER to adjust text to the size of the window", " ");
        System.out.println();
        Utils.printInCenter("Select an option", "*");
        System.out.println();
        Utils.printInCenter("(1) Run Bubble Sort");
        Utils.printInCenter("(2) Run Insertion Sort");
        Utils.printInCenter("(3) Run Quick Sort");
        Utils.printInCenter("(4) Run Selection Sort");
        Utils.printInCenter("(5) Run Heap Sort");
        Utils.printInCenter("(a) Run all");
        Utils.printInCenter("(e) exit");
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
            case "":
                break;
            case "exit":
            case "e":
                System.exit(0);
            default:
                System.err.println("Wrong input");
                Utils.sleepALittle(2000);
                break;
        }
    }
}
