package algorithms;
import java.util.ArrayList;

public abstract class AlgorithmSort {
    protected ArrayList<Integer> array;

    public AlgorithmSort(ArrayList<Integer> array ){
        if(array == null){
            throw new IllegalArgumentException("Array can't be empty.");
        }
        this.array = array;
    }

    public abstract void sort();

}
