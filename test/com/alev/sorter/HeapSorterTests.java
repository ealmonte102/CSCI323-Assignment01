package com.alev.sorter;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class HeapSorterTests {
    private HeapSorter<Integer> heapSorter;

    @Before
    public void setUp() {
        heapSorter = new HeapSorter<>();
    }

    @Test
    public void setArray() {
        List<Integer> a = Arrays.asList(9, 8, 7, 6);
        heapSorter.setArray(a);
        assertTrue(a.equals(heapSorter.getArray()));
    }

    @Test
    public void maxHeapify_violatesMaxHeapOrder_InMaxHeapOrder() {
        List<Integer> a = Arrays.asList(1, 8, 7, 3, 4, 8, 3, 9, 2, 1, 3, 10, 14, 11);
        heapSorter.setArray(a);
        heapSorter.maxHeapify();
        assertTrue(Arrays.asList(14, 9, 11, 8, 4, 10, 3, 3, 2, 1, 3, 7, 8, 1).equals(heapSorter.array));
    }

    @Test
    public void heapSort_reverselySorted_inAscendingSortedOrder() {
        List<Integer> a = Arrays.asList(9, 8, 7, 6, 5, 4);
        heapSorter.setArray(a);
        heapSorter.sort();
        assertTrue(Arrays.asList(4, 5, 6, 7, 8, 9).equals(heapSorter.array));
    }

    @Test
    public void heapSort_randomOrder_inAscendingSortedOrder() {
        List<Integer> a = Arrays.asList(1, 9, 4, 13, 3, 4);
        heapSorter.setArray(a);
        heapSorter.sort();
        assertTrue(Arrays.asList(1, 3, 4, 4, 9, 13).equals(heapSorter.array));
    }
}
/*
   1
 4   7
3 8 9 3


*/