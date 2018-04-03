package com.alev.sorter;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class QuickSorter<T extends Comparable<T>> extends Sorter<T> {
    public static final String TYPE = "Quick Sort";

    public QuickSorter() {
        super(TYPE);
    }

    public QuickSorter(List<T> array) {
        super(TYPE, array);
    }

    @Override
    public int sort() {
        AtomicInteger counter = new AtomicInteger(0);
        sort(0, array.size() - 1, counter);
        return counter.get();
    }

    private void sort(int start, int end, AtomicInteger counter) {
        if (start < end) {
            int pivot = createPartition(start, end, counter);
            sort(start, pivot - 1, counter);
            sort(pivot + 1, end, counter);
        }
    }

    private int createPartition(int start, int end, AtomicInteger counter) {
        T pivot = array.get(end);
        int i = start - 1;
        for (int j = start; j < end; ++j) {
            counter.set(counter.get() + 1);
            T currentElement = array.get(j);
            if (currentElement.compareTo(pivot) <= 0) {
                ++i;
                T temp = array.get(i);
                array.set(i, currentElement);
                array.set(j, temp);
            }
        }
        T temp = array.get(i + 1);
        array.set(i + 1, pivot);
        array.set(end, temp);
        return i + 1;
    }
}
