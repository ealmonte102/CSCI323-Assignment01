package com.alev.csci323.assignment1;

import com.alev.csci323.assignment1.file.SimpleCSVWriterTest;
import com.alev.csci323.assignment1.file.SimpleRetrieverTest;
import com.alev.csci323.assignment1.file.SimpleSortedListWriter;
import com.alev.csci323.assignment1.sorter.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        InsertionSorterTests.class,
        HeapSorterTests.class,
        MergeSorterTests.class,
        QuickSorterTests.class,
        CountingSorterTests.class,
        RadixSorterTests.class,
        BucketSorterTests.class,
        SorterTypeTests.class,
        SimpleCSVWriterTest.class,
        SimpleRetrieverTest.class,
        SimpleSortedListWriter.class
})
public final class AllTestsSuite {
}
