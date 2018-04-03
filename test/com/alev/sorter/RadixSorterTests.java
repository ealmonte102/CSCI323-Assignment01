package com.alev.sorter;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class RadixSorterTests {
    private RadixSorter radixSorter;

    @Before
    public void setUp() {
        radixSorter = new RadixSorter();
    }

    @Test
    public void sort() {
        List a = Arrays.asList(35, 24, 53, 42, 11, 50, 2, 1, 9, 8);
        radixSorter.setArray(a);
        radixSorter.sort();
        assertTrue(Arrays.asList(1, 2, 8, 9, 11, 24, 35, 42, 50, 53).equals(radixSorter.array));
    }
}