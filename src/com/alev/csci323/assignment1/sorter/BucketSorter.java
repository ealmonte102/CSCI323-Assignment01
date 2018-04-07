package com.alev.csci323.assignment1.sorter;

public class BucketSorter extends Sorter {
    private int min;
    private int max;
    private BucketList[] buckets;

    public BucketSorter() {
        super(Type.BUCKET_SORT);
    }

    @Override
    public int sort() {
        int count = 0;
        for (int element : array) {
            double normalizedNumber = (double) (element - min) / (max + 1);
            buckets[(int) (array.length * normalizedNumber)].insert(normalizedNumber);
        }
        int currentPos = 0;
        for (int i = 0; i < array.length; ++i) {
            BucketList bucketToSort = buckets[i];
            count += bucketToSort.sort();
            double[] sortedBucket = bucketToSort.toArray();
            for (double normalizedElement : sortedBucket) {
                array[currentPos++] = (int) (normalizedElement * (max + 1) + min + .5);
            }
        }
        return count;
    }

    @Override
    public void setArray(int[] array) {
        super.setArray(array);
        buckets = new BucketList[array.length];
        if (array.length > 0) {
            min = array[0];
            max = array[0];
        }
        for (int i = 0; i < array.length; ++i) {
            min = array[i] < min ? array[i] : min;
            max = array[i] > max ? array[i] : max;
            buckets[i] = new BucketList();
        }
    }
}
