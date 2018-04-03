package com.alev.sorter;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class BucketSorterTest {
    private BucketSorter buckerSorter;

    @Before
    public void setUp() {
        this.buckerSorter = new BucketSorter();
    }

    @Test
    public void setArray() {
    }

    @Test
    public void sort() {
        List<Integer> array = Arrays.asList(1, 9, 2, 0, 5, 10, 12, 42, 23);
        buckerSorter.setArray(array);
        buckerSorter.sort();
        assertTrue(Arrays.asList(0, 1, 2, 5, 9, 10, 12, 23, 42).equals(buckerSorter.array));
    }
}