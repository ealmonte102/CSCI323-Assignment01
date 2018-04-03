package com.alev.sorter;

import java.util.List;

public class BucketSorter extends Sorter<Integer> {
    public static final String TYPE = "Bucket Sort";
    private int min;
    private int max;
    private BucketList[] buckets;

    public BucketSorter() {
        super(TYPE);
    }

    @Override
    public int sort() {
        if (array.size() == 0) {
            return 0;
        }
        for (int element : array) {
            double normalizedNumber = (double) (element - min) / (max + 1);
            buckets[(int) (array.size() * normalizedNumber)].insert(normalizedNumber);
        }
        int currentPos = 0;
        for (int i = 0; i < array.size(); ++i) {
            BucketList bucketToSort = buckets[i];
            bucketToSort.sort();
            double[] sortedBucket = bucketToSort.toArray();
            for (double normalizedElement : sortedBucket) {
                array.set(currentPos++, (int) (normalizedElement * (max + 1) + min + .5));
            }
        }
        return 0;
    }

    @Override
    public void setArray(List<Integer> array) {
        super.setArray(array);
        buckets = new BucketList[array.size()];
        if (array.size() > 0) {
            min = array.get(0);
            max = min;
        }
        for (int i = 0; i < array.size(); ++i) {
            int currentElement = array.get(i);
            min = currentElement < min ? currentElement : min;
            max = currentElement > max ? currentElement : max;
            buckets[i] = new BucketList();
        }
    }
}
