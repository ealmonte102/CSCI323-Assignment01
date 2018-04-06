package com.alev.csci323.assignment1.sorter;

public class RadixSorter extends Sorter {
    public static final String TYPE = "Radix Sort";
    public static final int BASE_10_RADIX = 10;
    private int max = 0;

    public RadixSorter() {
        super(TYPE);
    }

    @Override
    public void setArray(int[] array) {
        super.setArray(array);
        for (int currentNum : array) {
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
        int[] sortedArray = new int[array.length];
        int[] tallyArray = new int[BASE_10_RADIX];
        int count = 0;
        for (int anArray1 : array) {
            tallyArray[(anArray1 / currentPlaceValue) % BASE_10_RADIX]++;
        }

        for (int i = 1; i < tallyArray.length; ++i) {
            tallyArray[i] += tallyArray[i - 1];
        }

        for (int i = array.length - 1; i >= 0; --i) {
            sortedArray[tallyArray[(array[i] / currentPlaceValue) % BASE_10_RADIX] - 1] = array[i];
            tallyArray[(array[i] / currentPlaceValue) % BASE_10_RADIX]--;
            ++count;
        }
        array = sortedArray;
        return count;
    }
}
