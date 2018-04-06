package com.alev.csci323.assignment1.sorter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MergeSorterTests {

    private MergeSorter mergeSorter;

    @Before
    public void setUp() {
        mergeSorter = new MergeSorter();
    }

    @Test
    public void setArray() {
        int[] a = { 9, 8, 7, 6 };
        mergeSorter.setArray(a);
        assertArrayEquals(a, mergeSorter.getArray());
    }

    @Test
    public void mergeSort_ReverselySorted_SortedInAscendingOrder() {
        int[] a = {4, 3, 2, 1};
        mergeSorter.setArray(a);
        mergeSorter.sort();
        assertArrayEquals(a, new int[]{1, 2, 3, 4});
    }

    @Test
    public void mergeSort_Sorted_StillSortedInAscendingOrder() {
        int[] a = {6, 7, 8, 9, 10, 11, 12, 13};
        mergeSorter.setArray(a);
        mergeSorter.sort(0, a.length - 1);
        assertArrayEquals(a, new int[]{6, 7, 8, 9, 10, 11, 12, 13});
    }

}
