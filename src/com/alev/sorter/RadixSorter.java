package com.alev.sorter;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RadixSorter extends Sorter<Integer> {
    public static final String TYPE = "Radix Sort";
    public static final int BASE_10_RADIX = 10;
    private int max = 0;

    public RadixSorter() {
        super(TYPE);
    }

    @Override
    public void setArray(List<Integer> array) {
        super.setArray(array);
        for (Integer currentNum : array) {
            if (max < currentNum) {
                max = currentNum;
            }
        }
    }

    @Override
    public int sort() {
        int count = 0;
        int currentPlaceValue = 1;
        int tempMax = max;
        while (tempMax > 0) {
            count += countSort(currentPlaceValue);
            tempMax /= BASE_10_RADIX;
            currentPlaceValue *= BASE_10_RADIX;
        }
        return count;
    }

    private int countSort(int currentPlaceValue) {
        List<Integer> sortedArray = new ArrayList<>(Collections.nCopies(array.size(), 0));
        int[] tallyArray = new int[BASE_10_RADIX];
        int count = 0;
        for (int anArray1 : array) {
            tallyArray[(anArray1 / currentPlaceValue) % BASE_10_RADIX]++;
        }

        for (int i = 1; i < tallyArray.length; ++i) {
            tallyArray[i] += tallyArray[i - 1];
        }

        for (int i = array.size() - 1; i >= 0; --i) {
            int currentElement = array.get(i);
            sortedArray.set(tallyArray[(currentElement / currentPlaceValue) % BASE_10_RADIX] - 1, currentElement);
            tallyArray[(currentElement / currentPlaceValue) % BASE_10_RADIX]--;
            ++count;
        }
        array = sortedArray;
        return count;
    }
}
