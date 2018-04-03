package com.alev.sorter;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class MergeSorterTests {

    private MergeSorter<Integer> mergeSorter;

    @Before
    public void setUp() {
        mergeSorter = new MergeSorter<>();
    }

    @Test
    public void setArray() {
        List<Integer> a = Arrays.asList(9, 8, 7, 6);
        mergeSorter.setArray(a);
        assertTrue(a.equals(mergeSorter.getArray()));
    }

    @Test
    public void mergeSort_ReverselySorted_SortedInAscendingOrder() {
        List<Integer> a = Arrays.asList(4, 3, 2, 1);
        mergeSorter.setArray(a);
        mergeSorter.sort();
        assertTrue(Arrays.asList(1, 2, 3, 4).equals(mergeSorter.array));
    }

    @Test
    public void mergeSort_Sorted_StillSortedInAscendingOrder() {
        List<Integer> a = Arrays.asList(6, 7, 8, 9, 10, 11, 12, 13);
        mergeSorter.setArray(a);
        mergeSorter.sort(0, a.size() - 1);
        assertTrue(Arrays.asList(6, 7, 8, 9, 10, 11, 12, 13).equals(mergeSorter.array));
    }

}
