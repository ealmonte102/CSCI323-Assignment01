package com.alev.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountingSorter extends Sorter<Integer> {
    public static final String TYPE = "Counting Sort";

    public CountingSorter() {
        super(TYPE);
    }

    @Override
    public int sort() {
        int count = 0;
        int max = array.get(0);
        for (int i = 1; i < array.size(); ++i) {
            int currentElement = array.get(i);
            max = max < currentElement ? currentElement : max;
        }
        List<Integer> sortedArray = new ArrayList<>(Collections.nCopies(array.size(), 0));
        int[] tallyCounter = new int[max + 1];

        for (int number : array) {
            tallyCounter[number]++;
        }

        for (int i = 1; i < tallyCounter.length; ++i) {
            tallyCounter[i] = tallyCounter[i] + tallyCounter[i - 1];
        }

        for (int i = array.size() - 1; i >= 0; --i) {
            int currentElement = array.get(i);
            sortedArray.set(tallyCounter[currentElement] - 1, currentElement);
            count++;
        }
        this.array = sortedArray;
        return count;
    }
}
