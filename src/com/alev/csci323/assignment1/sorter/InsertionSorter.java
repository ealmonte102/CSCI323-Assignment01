package com.alev.csci323.assignment1.sorter;

public class InsertionSorter extends Sorter{

    public InsertionSorter() {
        super(Type.INSERTION_SORT);
    }

    public int sort() {
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
