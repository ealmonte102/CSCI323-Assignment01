package com.alev.sorter;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CountingSorterTests {
    private CountingSorter countingSorter;

    @Before
    public void setUp() {
        countingSorter = new CountingSorter();
    }

    @Test
    public void sort_randomOrder_InAscendingOrder() {
        List<Integer> array = Arrays.asList(4, 9, 2, 10, 3, 12, 1, 6);
        countingSorter.setArray(array);
        countingSorter.sort();
        assertTrue(Arrays.asList(1, 2, 3, 4, 6, 9, 10, 12).equals(countingSorter.array));
    }
}