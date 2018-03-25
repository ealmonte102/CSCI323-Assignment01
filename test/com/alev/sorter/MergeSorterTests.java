package com.alev.sorter;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

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
        int[] a = {9, 8, 7, 6};
        mergeSorter.setArray(a);
        int cost = mergeSorter.sort(0, a.length - 1);
        System.out.printf("Cost: %d%n" +
                "Array: %s%n", cost, Arrays.toString(mergeSorter.getArray()));
        assertArrayEquals(a, new int[]{6, 7, 8, 9});
    }

    @Test
    public void mergeSort_Sorted_StillSortedInAscendingOrder() {
        int[] a = {6, 7, 8, 9, 10, 11, 12, 13};
        mergeSorter.setArray(a);
        int cost = mergeSorter.sort(0, a.length - 1);
        System.out.printf("Cost: %d%n" +
                "Array: %s%n", cost, Arrays.toString(mergeSorter.getArray()));
        assertArrayEquals(a, new int[]{6, 7, 8, 9, 10, 11, 12, 13});
    }

}
