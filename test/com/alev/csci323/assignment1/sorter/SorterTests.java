package com.alev.csci323.assignment1.sorter;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public abstract class SorterTests {
    protected Sorter sorter;

    @Test
    public void sort_ReverselySorted_SortedInAscendingOrder() {
        int[] inputArray = {4, 3, 2, 1};
        int[] expectedArray = {1, 2, 3, 4};
        sorter.setArray(inputArray);
        sorter.sort();
        assertArrayEquals(expectedArray, sorter.getArray());
    }

    @Test
    public void sort_Sorted_StillSortedInAscendingOrder() {
        int[] inputArray = {1, 2, 3, 4};
        int[] expectedArray = {1, 2, 3, 4};
        sorter.setArray(inputArray);
        sorter.sort();
        assertArrayEquals(expectedArray, sorter.getArray());
    }

    @Test
    public void sort_randomIntegers_sortedInAscendingOrder() {
        int[] inputArray = {3, 8, 6, 9, 2, 7, 1, 5, 4};
        int[] expectedArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        sorter.setArray(inputArray);
        sorter.sort();
        assertArrayEquals(expectedArray, sorter.getArray());
    }
}