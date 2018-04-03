package com.alev.sorter;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class InsertionSorterTests {
    private InsertionSorter<Integer> insertionSorter;

    @Before
    public void setUp() {
        insertionSorter = new InsertionSorter<>();
    }

    @Test
    public void setArray() {
        List<Integer> a = Arrays.asList(9, 8, 7, 6);
        insertionSorter.setArray(a);
        assertTrue(a.equals(insertionSorter.array));
    }

    @Test
    public void insertionSort_ReverselySorted_SortedInAscendingOrder() {
        List<Integer> a = Arrays.asList(9, 8, 7, 6);
        insertionSorter.setArray(a);
        insertionSorter.sort();
        assertTrue(Arrays.asList(6, 7, 8, 9).equals(insertionSorter.array));
    }

    @Test
    public void insertSort_Sorted_StillSortedInAscendingOrder() {
        List<Integer> a = Arrays.asList(1, 2, 3);
        insertionSorter.setArray(a);
        insertionSorter.sort();
        assertTrue(Arrays.asList(1, 2, 3).equals(insertionSorter.array));
    }
}