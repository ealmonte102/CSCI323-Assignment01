package com.alev.sorter;

import java.util.concurrent.atomic.AtomicInteger;

public class QuickSorter extends Sorter {
    public static final String TYPE = "Quick Sort";

    public QuickSorter() {
        super(TYPE);
    }

    public QuickSorter(int[] array) {
        super(TYPE, array);
    }

    @Override
    public int sort() {
        AtomicInteger counter = new AtomicInteger(0);
        sort(0, array.length - 1, counter);
        return counter.get();
    }

    private void sort(int start, int end, AtomicInteger counter) {
        if(start < end) {
            int pivot = createPartition(start, end, counter);
            sort(start, pivot - 1, counter);
            sort(pivot + 1, end, counter);
        }
    }

    private int createPartition(int start, int end, AtomicInteger counter) {
        int pivot = array[end];
        int i = start - 1;
        for(int j = start; j < end; ++j) {
            counter.set(counter.get() + 1);
            if(array[j] <= pivot) {
                ++i;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[end];
        array[end] = temp;
        return i + 1;
    }
}
