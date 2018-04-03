package com.alev.sorter;

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
        BucketSorterTest.class,})
public final class AllTestsSuite {
}
