package com.alev.csci323.assignment1.sorter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class HeapSorterTests extends SorterTests {
    @Before
    public void setUp() {
        sorter = new HeapSorter();
    }

    @Test
    public void maxHeapify_violatesMaxHeapOrder_InMaxHeapOrder() {
        HeapSorter heapSorter = (HeapSorter) sorter;
        int[] a = {1, 8, 7, 3, 4, 8, 3, 9, 2, 1, 3, 10, 14, 11};
        heapSorter.setArray(a);
        heapSorter.maxHeapify();
        assertArrayEquals(a, new int[]{14, 9, 11, 8, 4, 10, 3, 3, 2, 1, 3, 7, 8, 1});
    }

}