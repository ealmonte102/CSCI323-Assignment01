package com.alev.sorter;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class QuickSorterTests {
    private QuickSorter<Integer> quickSorter;

    @Before
    public void setUp() {
        quickSorter = new QuickSorter<>();
    }

    @Test
    public void setArray() {
        List<Integer> a = Arrays.asList(9, 8, 7, 6);
        quickSorter.setArray(a);
        assertTrue(a.equals(quickSorter.getArray()));
    }

    @Test
    public void quickSort_ReverselySorted_SortedInAscendingOrder() {
        List<Integer> a = Arrays.asList(4, 2, 9, 5, 3, 1, 10, 6);
        quickSorter.setArray(a);
        quickSorter.sort();
        assertTrue(Arrays.asList(1, 2, 3, 4, 5, 6, 9, 10).equals(quickSorter.array));
    }

    @Test
    public void quickSort_Sorted_StillSortedInAscendingOrder() {
        List<Integer> a = Arrays.asList(1, 2, 3, 4, 5);
        quickSorter.setArray(a);
        quickSorter.sort();
        assertTrue(Arrays.asList(1, 2, 3, 4, 5).equals(quickSorter.array));
    }
}
