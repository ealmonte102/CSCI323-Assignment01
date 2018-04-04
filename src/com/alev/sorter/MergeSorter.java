package com.alev.sorter;

import java.util.concurrent.atomic.AtomicInteger;

public class MergeSorter extends Sorter {
    public static final String TYPE = "Merge Sort";

    public MergeSorter() {
        super(TYPE);
    }

    public int sort() {
        return sort(0, array.length - 1);
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
    }

}
