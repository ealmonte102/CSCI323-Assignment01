package com.alev.sorter;

import java.util.List;

public class InsertionSorter<T extends Comparable<T>> extends Sorter<T> {
    public static final String TYPE = "Insertion Sort";

    public InsertionSorter() {
        super(TYPE);
    }

    public InsertionSorter(List<T> array) {
        super(TYPE, array);
    }

    public int sort() {
        int count = 0;
        for (int j = 1; j < array.size(); ++j) {
            int i = j - 1;
            T key = array.get(j);
            T currentElement = array.get(i);
            while (i >= 0 && currentElement.compareTo(key) > 0) {
                array.set(i + 1, currentElement);
                ++count;
                --i;
                if (i >= 0) {
                    currentElement = array.get(i);
                }
            }
            array.set(i + 1, key);
        }
        return count;
    }
}
