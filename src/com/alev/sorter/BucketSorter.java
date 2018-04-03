package com.alev.sorter;

public class BucketSorter extends Sorter {
    public static final String TYPE = "Bucket Sort";
    private int min;
    private int max;
    private BucketList[] buckets;

    public BucketSorter() {
        super(TYPE);
    }

    @Override
    public int sort() {
        if (array.length == 0) {
            return 0;
        }
        for (int element : array) {
            double normalizedNumber = (double) (element - min) / (max + 1);
            buckets[(int) (array.length * normalizedNumber)].insert(normalizedNumber);
        }
        int currentPos = 0;
        for (int i = 0; i < array.length; ++i) {
            BucketList bucketToSort = buckets[i];
            bucketToSort.sort();
            double[] sortedBucket = bucketToSort.toArray();
            for (double normalizedElement : sortedBucket) {
                array[currentPos++] = (int) (normalizedElement * (max + 1) + min + .5);
            }
        }
        return 0;
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
