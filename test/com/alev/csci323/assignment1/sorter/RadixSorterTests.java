package com.alev.csci323.assignment1.sorter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class RadixSorterTests {
    private RadixSorter radixSorter;

    @Before
    public void setUp() {
        radixSorter = new RadixSorter();
    }

    @Test
    public void sort_randomIntegers_sortedInAscendingOrder() {
        int[] inputArray = {35, 24, 53, 42, 11, 50, 2, 1, 9, 8};
        int[] expectedArray = new int[]{1, 2, 8, 9, 11, 24, 35, 42, 50, 53};
        radixSorter.setArray(inputArray);
        radixSorter.sort();
        assertArrayEquals(expectedArray, radixSorter.getArray());
    }
}