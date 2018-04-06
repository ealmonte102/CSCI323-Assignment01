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
    public void setArray() {
        int[] a = { 9, 8, 7, 6 };
        quickSorter.setArray(a);
        assertArrayEquals(a, quickSorter.getArray());
    }

    @Test
    public void quickSort_ReverselySorted_SortedInAscendingOrder() {
        int[] a = {4, 2, 9, 5, 3, 1, 10 ,6};
        quickSorter.setArray(a);
        quickSorter.sort();
        assertArrayEquals(a, new int[]{1, 2, 3, 4, 5, 6, 9, 10});
    }

    @Test
    public void quickSort_Sorted_StillSortedInAscendingOrder() {
        int[] a = {1, 2, 3, 4, 5};
        quickSorter.setArray(a);
        quickSorter.sort();
        assertArrayEquals(a, new int[]{1, 2, 3, 4, 5});
    }
}
