import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Sorter {
    private int[] array;

    public Sorter(int[] array) {
        this.array = array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array.clone();
    }

    public void insertionSort() {
        System.out.println("Insertion Sort");
        int count = 0;
        for(int j = 1; j < array.length; ++j) {
            int key = array[j];
            int i = j - 1;
            while(i >= 0 && array[i] > key) {
                array[i + 1] = array[i];
                ++count;
                --i;
            }
            array[i + 1] = key;
        }
        System.out.println("Count: " + count);
        System.out.println("Sorted Array: " + Arrays.toString(array));
    }

    public void mergeSort(int l, int r) {
        AtomicInteger count = new AtomicInteger(0);
        mergeSortHelper(l, r, count);
        System.out.println("Count: " + count);
    }

    private void mergeSortHelper(int l, int r, AtomicInteger counter) {
        if(l < r) {
            int q = (l + r) / 2;
            mergeSortHelper(l, q, counter);
            mergeSortHelper(q + 1, r, counter);
            merge(l,q,r, counter);
        }
    }

    private void merge(int l, int q, int r, AtomicInteger counter) {
        int[] firstHalf = new int[(q-l) + 2];
        int[] secondHalf = new int[r-q + 1];
        for(int i = 0; i < firstHalf.length - 1; ++i) {
            firstHalf[i] = array[l + i];
        }
        for(int i = 0; i < secondHalf.length - 1; ++i) {
            secondHalf[i] = array[q + i + 1];
        }
        firstHalf[firstHalf.length - 1] = Integer.MAX_VALUE;
        secondHalf[secondHalf.length - 1] = Integer.MAX_VALUE;

        for(int k = l, i = 0, j = 0; k <= r; ++k) {
            counter.set(counter.get() + 1);
            if(firstHalf[i] <= secondHalf[j]) {
                array[k] = firstHalf[i];
                ++i;
            } else {
                array[k] = secondHalf[j];
                ++j;
            }
        }


        System.out.println("Array: " + Arrays.toString(array) + '\n');

    }

    public void heapSort() {

    }

    public void quickSort() {

    }
}
