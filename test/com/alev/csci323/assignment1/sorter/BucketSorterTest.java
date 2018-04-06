package com.alev.csci323.assignment1.sorter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BucketSorterTest {
    private BucketSorter buckerSorter;

    @Before
    public void setUp() {
        this.buckerSorter = new BucketSorter();
    }

    @Test
    public void sort() {
        int[] array = new int[]{1, 9, 2, 0, 5, 10, 12, 42, 23};
        buckerSorter.setArray(array);
        buckerSorter.sort();
        Assert.assertArrayEquals(new int[]{0, 1, 2, 5, 9, 10, 12, 23, 42}, buckerSorter.getArray());
    }
}