package com.alev.csci323.assignment1.sorter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class InsertionSorterTests {
    private InsertionSorter insertionSorter;

    @Before
    public void setUp() {
        insertionSorter = new InsertionSorter();
    }

    @Test
    public void setArray() {
        int[] a = { 9, 8, 7, 6 };
        insertionSorter.setArray(a);
        assertArrayEquals(a, insertionSorter.getArray());
    }

    @Test
    public void insertionSort_ReverselySorted_SortedInAscendingOrder() {
        int[] a = {9, 8, 7, 6};
        insertionSorter.setArray(a);
        insertionSorter.sort();
        assertArrayEquals(a, new int[]{6, 7, 8, 9});
    }

    @Test
    public void insertSort_Sorted_StillSortedInAscendingOrder() {
        int[] a = {1, 2, 3};
        insertionSorter.setArray(a);
        insertionSorter.sort();
        assertArrayEquals(a, new int[]{1, 2, 3});
    }
}