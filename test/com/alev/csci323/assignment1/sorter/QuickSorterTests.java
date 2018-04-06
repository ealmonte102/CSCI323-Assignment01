package com.alev.csci323.assignment1.sorter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class QuickSorterTests {
    private QuickSorter quickSorter;

    @Before
    public void setUp() {
        quickSorter = new QuickSorter();
    }

    @Test
    public void sort_ReverselySorted_SortedInAscendingOrder() {
        int[] inputArray = {3, 2, 1};
        int[] expectedArray = {1, 2, 3};
        quickSorter.setArray(inputArray);
        quickSorter.sort();
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    public void sort_Sorted_StillSortedInAscendingOrder() {
        int[] inputArray = {1, 2, 3};
        int[] expectedArray = {1, 2, 3};
        quickSorter.setArray(inputArray);
        quickSorter.sort();
        assertArrayEquals(expectedArray, inputArray);
    }
}
