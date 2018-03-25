package com.alev.sorter;

public class InsertionSorter extends Sorter{

    public InsertionSorter() {
        super();
    }

    public InsertionSorter(int[] array) {
        super(array);
    }

    public int sort() {
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
        return count;
    }
}
