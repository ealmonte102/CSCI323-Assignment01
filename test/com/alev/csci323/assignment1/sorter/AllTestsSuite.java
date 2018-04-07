package com.alev.csci323.assignment1.sorter;

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
})
public final class AllTestsSuite {
}
