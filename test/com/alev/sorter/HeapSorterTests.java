package com.alev.sorter;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class HeapSorterTests {
    HeapSorter heapSorter;

    @Before
    public void setUp() {
        heapSorter = new HeapSorter();
    }

    @Test
    public void setArray() {
        int[] a = { 9, 8, 7, 6 };
        heapSorter.setArray(a);
        assertArrayEquals(a, heapSorter.getArray());
    }

    @Test
    public void maxHeapify_violatesMaxHeapOrder_InMaxHeapOrder() {
        int[] a = { 1, 8, 7, 3, 4, 8, 3 };
        heapSorter.setArray(a);
        heapSorter.maxHeapify();
        System.out.println(Arrays.toString(heapSorter.getArray()));
        assertArrayEquals(a, new int[]{8, 4, 7, 3, 1, 8, 3});
    }

    @Test
    public void heapSort_reverselySorted_inAscendingSortedOrder() {
        int[] a = { 9, 8, 7, 6, 5, 4};
        heapSorter.setArray(a);
        int cost = heapSorter.sort();
        System.out.println("Array: " + Arrays.toString(heapSorter.getArray()));
        System.out.println("Cost: " + cost);
        assertArrayEquals(a, new int[]{4, 5, 6, 7, 8, 9});
    }
}
/*
   1
 4   7
3 8 9 3


*/