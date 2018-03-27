package com.alev.sorter;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class CountingSorterTest {
    private CountingSorter countingSorter;

    @Before
    public void setUp() {
        countingSorter = new CountingSorter();
    }

    @Test
    public void sort_randomOrder_InAscendingOrder() {
        int array[] = {4, 9, 2, 10, 3, 12, 1, 6};
        countingSorter.setArray(array);
        int count = countingSorter.sort();
        int[] sortedArray = countingSorter.getArray();
        System.out.println("Array: " + Arrays.toString(sortedArray));
        System.out.println("Cost: " + count);
        assertArrayEquals(new int[]{1, 2, 3, 4, 6, 9, 10, 12}, sortedArray);
    }
}