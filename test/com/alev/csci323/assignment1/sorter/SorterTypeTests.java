package com.alev.csci323.assignment1.sorter;

import org.junit.Assert;
import org.junit.Test;

public class SorterTypeTests {

    @Test
    public void toString_insertionSortEnum_stringInTitleCase() {
        Sorter.Type type = Sorter.Type.INSERTION_SORT;
        Assert.assertEquals("Insertion Sort", type.toString());
    }
}
