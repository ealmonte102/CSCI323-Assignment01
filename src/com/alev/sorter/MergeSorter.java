package com.alev.sorter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MergeSorter<T extends Comparable<T>> extends Sorter<T> {
    public static final String TYPE = "Merge Sort";

    public MergeSorter() {
        super(TYPE);
    }

    public MergeSorter(List<T> array) {
        super(TYPE, array);
    }

    public int sort() {
        return sort(0, array.size() - 1);
    }

    public int sort(int l, int r) {
        AtomicInteger count = new AtomicInteger(0);
        mergeSortHelper(l, r, count);
        return count.get();
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
        int firstHalfCapacity = q - l + 1;
        int secondHalfCapacity = r - q;
        List<T> firstHalf = new ArrayList<>(firstHalfCapacity);
        List<T> secondHalf = new ArrayList<>(firstHalfCapacity);
        for (int i = 0; i < firstHalfCapacity; ++i) {
            firstHalf.add(array.get(l + i));
        }
        for (int i = 0; i < secondHalfCapacity; ++i) {
            secondHalf.add(array.get(q + i + 1));
        }
        for(int k = l, i = 0, j = 0; k <= r; ++k) {
            counter.set(counter.get() + 1);
            if (j == secondHalfCapacity || (i < firstHalfCapacity && firstHalf.get(i).compareTo(secondHalf.get(j)) <= 0)) {
                array.set(k, firstHalf.get(i));
                ++i;
            } else {
                array.set(k, secondHalf.get(j));
                ++j;
            }
        }
    }
}
