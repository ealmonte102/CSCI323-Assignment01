package com.alev.sorter;

public class CountingSorter extends Sorter {
    public static final String TYPE = "Counting Sort";

    public CountingSorter() {
        super(TYPE);
    }

    @Override
    public int sort() {
        int count = 0;
        int max = array[0];
        for (int i = 1; i < array.length; ++i) {
            max = max < array[i] ? array[i] : max;
        }
        int[] sortedArray = new int[array.length];
        int[] tallyCounter = new int[max + 1];

        for (int number : array) {
            tallyCounter[number]++;
        }

        for (int i = 1; i < tallyCounter.length; ++i) {
            tallyCounter[i] = tallyCounter[i] + tallyCounter[i - 1];
        }

        for (int i = array.length - 1; i >= 0; --i) {
            sortedArray[tallyCounter[array[i]] - 1] = array[i];
            count++;
        }
        this.array = sortedArray;
        return count;
    }
}
