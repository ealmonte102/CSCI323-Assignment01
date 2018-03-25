package com.alev.sorter;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

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
        int cost = insertionSorter.sort();
        System.out.printf("Cost: %d%n" +
                "Array: %s%n", cost, Arrays.toString(insertionSorter.getArray()));
        assertArrayEquals(a, new int[]{6, 7, 8, 9});
    }

    @Test
    public void insertSort_Sorted_StillSortedInAscendingOrder() {
        int[] a = {1, 2, 3};
        insertionSorter.setArray(a);
        int cost = insertionSorter.sort();
        System.out.printf("Cost: %d%n" +
                "Array: %s%n", cost, Arrays.toString(insertionSorter.getArray()));
        assertArrayEquals(a, new int[]{1, 2, 3});
    }
}