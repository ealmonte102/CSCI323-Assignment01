package com.alev.csci323.assignment1.sorter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class HeapSorterTests {
    HeapSorter heapSorter;

    @Before
    public void setUp() {
        heapSorter = new HeapSorter();
    }

    @Test
    public void maxHeapify_violatesMaxHeapOrder_InMaxHeapOrder() {
        int[] a = {1, 8, 7, 3, 4, 8, 3, 9, 2, 1, 3, 10, 14, 11};
        heapSorter.setArray(a);
        heapSorter.maxHeapify();
        assertArrayEquals(a, new int[]{14, 9, 11, 8, 4, 10, 3, 3, 2, 1, 3, 7, 8, 1});
    }

    @Test
    public void heapSort_reverselySorted_inAscendingSortedOrder() {
        int[] a = { 9, 8, 7, 6, 5, 4};
        heapSorter.setArray(a);
        heapSorter.sort();
        assertArrayEquals(a, new int[]{4, 5, 6, 7, 8, 9});
    }

    @Test
    public void heapSort_randomOrder_inAscendingSortedOrder() {
        int[] a = {1, 9, 4, 13, 3, 4};
        heapSorter.setArray(a);
        heapSorter.sort();
        assertArrayEquals(a, new int[]{1, 3, 4, 4, 9, 13});
    }
}
/*
   1
 4   7
3 8 9 3


*/