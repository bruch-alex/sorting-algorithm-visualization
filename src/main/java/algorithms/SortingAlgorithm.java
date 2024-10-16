package algorithms;

import java.util.ArrayList;

public abstract class SortingAlgorithm {
    protected ArrayList<Integer> array;

    public SortingAlgorithm(ArrayList<Integer> array) {
        if (array == null) {
            throw new IllegalArgumentException("Array can't be empty.");
        }
        this.array = array;
    }

    public abstract void sort();

}
